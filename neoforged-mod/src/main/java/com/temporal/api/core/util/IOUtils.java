package com.temporal.api.core.util;

import com.temporal.api.core.engine.io.metadata.annotation.injection.Injected;
import com.temporal.api.core.engine.io.metadata.annotation.injection.RegisterFactory;
import com.temporal.api.core.engine.io.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.exception.ModInfoNotFoundException;
import com.temporal.api.core.json.formatter.JsonFormatter;
import com.temporal.api.core.json.formatter.StringJsonFormatter;
import com.temporal.api.core.json.inserter.JsonInserter;
import com.temporal.api.core.json.inserter.ResourceInserter;
import com.temporal.api.core.registry.factory.common.BlockFactory;
import com.temporal.api.core.registry.factory.common.ItemFactory;
import com.temporal.api.core.registry.factory.common.SoundEventFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Type;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class IOUtils {
    private IOUtils() {
    }

    public static Set<Class<?>> getAllClasses(String modId, Class<?> dependencyClass) {
        IModInfo mod = ModList.get()
                .getMods()
                .stream()
                .filter(modInfo -> modInfo.getModId().equals(modId))
                .findFirst()
                .orElseThrow(() -> new ModInfoNotFoundException("Mod Info Not Found: " + modId + " " + dependencyClass));
        return mod.getOwningFile()
                .getFile()
                .getScanResult()
                .getAnnotations()
                .stream()
                .filter(annotation -> annotation.annotationType().equals(Type.getType(Injected.class)))
                .map(ModFileScanData.AnnotationData::clazz)
                .map(clazz -> IOUtils.forType(clazz, dependencyClass))
                .sorted(IOUtils::compareModClasses)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static int compareModClasses(Class<?> c1, Class<?> c2) {
        if (c1.getDeclaredAnnotation(Injected.class).value()) {
            return -1;
        } else if (c2.getDeclaredAnnotation(Injected.class).value()) {
            return 1;
        } else {
            if (isFactoryPresent(c1)) {
                boolean isMainFactory = Arrays.stream(c1.getDeclaredFields())
                        .filter(field -> field.isAnnotationPresent(RegisterFactory.class))
                        .findAny()
                        .map(Field::getType)
                        .map(type -> ItemFactory.class.isAssignableFrom(type)
                                || BlockFactory.class.isAssignableFrom(type)
                                || SoundEventFactory.class.isAssignableFrom(type))
                        .orElseThrow();
                return isMainFactory ? -1 : 1;
            } else {
                return 0;
            }
        }
    }

    public static boolean isFactoryPresent(Class<?> clazz) {
        boolean annotationPresent = clazz.isAnnotationPresent(RegisterFactory.class);
        if (annotationPresent) return true;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (declaredField.isAnnotationPresent(RegisterFactory.class)) return true;
        }
        return false;
    }

    public static Class<?> forType(Type type, Class<?> dependencyClass) {
        return forName(type.getClassName(), dependencyClass);
    }

    public static Class<?> forName(String name, Class<?> dependencyClass) {
        try {
            return Class.forName(name, false, dependencyClass.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> @NotNull Stream<T> getStaticFieldTypeStream(Class<?> container, Predicate<Field> filteringPredicate, Function<Class<?>, T> mapper) {
        return Arrays.stream(container.getDeclaredFields())
                .filter(filteringPredicate)
                .map(Field::getType)
                .map(mapper);
    }

    public static <T> @NotNull Stream<T> getStaticFieldStream(Class<?> container, Predicate<Field> filteringPredicate, Function<Object, T> mapper) {
        return Arrays.stream(container.getDeclaredFields())
                .filter(filteringPredicate)
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        return field.get(null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(mapper);
    }

    public static void writeJson(Path path, String format, Object... arguments) {
        JsonFormatter<String> jsonFormatter = new StringJsonFormatter();
        String formatted = jsonFormatter.format(format, arguments);
        JsonInserter<String, Path> resourceInserter = new ResourceInserter();
        resourceInserter.insert(formatted, path);
    }

    public static <T, S extends AnnotationStrategy<T, ? extends Annotation>> Map<Class<? extends Annotation>, S> createAnnotationStrategyMap(Collection<S> strategies) {
        return strategies.stream()
                .distinct()
                .collect(Collectors.toMap(AnnotationStrategy::getAnnotationClass, strategy -> strategy));
    }


    @SuppressWarnings("unchecked")
    public static Holder<? extends Item> getItemHolder(Field field, Object object) throws Exception {
        if (field.get(object) instanceof DeferredBlock<?> deferredBlock) {
            return deferredBlock.asItem()
                    .getDefaultInstance()
                    .getItemHolder();
        } else {
            return (Holder<? extends Item>) field.get(object);
        }
    }
}
