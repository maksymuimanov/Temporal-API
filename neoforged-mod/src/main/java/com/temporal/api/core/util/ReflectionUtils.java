package com.temporal.api.core.util;

import com.temporal.api.core.engine.metadata.strategy.AnnotationStrategy;
import com.temporal.api.core.engine.registry.factory.ObjectFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Type;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static boolean isFactoryPresent(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (ObjectFactory.class.isAssignableFrom(declaredField.getType())) return true;
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
