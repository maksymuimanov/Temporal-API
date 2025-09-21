package com.temporal.api.core.util;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.registry.factory.ObjectFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.language.IModInfo;
import net.neoforged.neoforgespi.language.ModFileScanData;
import net.neoforged.neoforgespi.locating.IModFile;
import org.objectweb.asm.Type;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static <T> T createObject(Class<? extends T> clazz) {
        try {
            Constructor<? extends T> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getFieldObject(Field field, Object object) {
        try {
            return (T) field.get(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isFactoryPresent(Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (ObjectFactory.class.isAssignableFrom(declaredField.getType())) return true;
        }
        return false;
    }

    public static Class<?> forType(Type type, Class<?> rootClass) {
        return forName(type.getClassName(), rootClass);
    }

    public static Class<?> forName(String name, Class<?> rootClass) {
        try {
            return Class.forName(name, false, rootClass.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Stream<T> getStaticFieldTypeStream(Class<?> container, Predicate<Field> filteringPredicate, Function<Class<?>, T> mapper) {
        return Arrays.stream(container.getDeclaredFields())
                .filter(filteringPredicate)
                .map(Field::getType)
                .map(mapper);
    }

    public static <T> Stream<T> getStaticFieldStream(Class<?> container, Predicate<Field> filteringPredicate, Function<Object, T> mapper) {
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

    public static <T extends Annotation> Comparator<Class<?>> compareByAnnotationOverrideMethodPresence(Class<? extends T> annotation) {
        return (c1, c2) -> {
            try {
                T a1 = c1.getDeclaredAnnotation(annotation);
                T a2 = c2.getDeclaredAnnotation(annotation);
                String overrideMethodName = "override";
                Method method = annotation.getDeclaredMethod(overrideMethodName);
                boolean isA1Override = !method.getDefaultValue().equals(method.invoke(a1));
                boolean isA2Override = !method.getDefaultValue().equals(method.invoke(a2));
                if (isA1Override && isA2Override) {
                    return 0;
                } else if (isA1Override) {
                    return 1;
                } else if (isA2Override) {
                    return -1;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static Set<Class<?>> getApiDependentsClasses() {
        return ModList.get().getMods()
                .stream()
                .filter(iModInfo -> iModInfo.getDependencies()
                        .stream()
                        .anyMatch(modVersion -> modVersion.getModId().equals(ApiMod.MOD_ID)))
                .map(IModInfo::getOwningFile)
                .map(IModFileInfo::getFile)
                .map(IModFile::getScanResult)
                .map(ModFileScanData::getClasses)
                .flatMap(Collection::stream)
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> forType(clazz, ApiMod.class))
                .collect(Collectors.toSet());
    }

    public static Set<Class<?>> getApiClasses() {
        return ModList.get()
                .getModFileById(ApiMod.MOD_ID)
                .getFile()
                .getScanResult()
                .getClasses()
                .stream()
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> forType(clazz, ApiMod.class))
                .collect(Collectors.toSet());
    }
}
