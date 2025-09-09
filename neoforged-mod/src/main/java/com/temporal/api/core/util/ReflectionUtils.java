package com.temporal.api.core.util;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.registry.factory.ObjectFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforgespi.language.ModFileScanData;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Type;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Set;
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

    @SuppressWarnings("unchecked")
    public static <P, T extends P> Set<T> getSubclassFamily(String modId, Class<?> rootClass, String packageName, Class<? extends P> parent) {
        return getPackageClasses(modId, rootClass, packageName)
                .stream()
                .filter(parent::isAssignableFrom)
                .filter(clazz -> !(clazz.isAnnotation() || clazz.isInterface() || clazz.isEnum() || Modifier.isAbstract(clazz.getModifiers())))
                .map(clazz -> {
                    try {
                        return clazz.getConstructor();
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(constructor -> {
                    try {
                        constructor.setAccessible(true);
                        return (T) constructor.newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toSet());
    }

    public static Set<Class<?>> getPackageClasses(String modId, Class<?> rootClass, String packageName) {
        return ModList.get()
                .getModFileById(modId)
                .getFile()
                .getScanResult()
                .getClasses()
                .stream()
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> forType(clazz, rootClass))
                .filter(clazz -> clazz.getName().startsWith(packageName))
                .collect(Collectors.toSet());
    }

    public static Set<Class<?>> getApiClasses() {
        return getApiClasses(clazz -> true);
    }

    public static Set<Class<?>> getApiClasses(Predicate<Class<?>> predicate) {
        return ModList.get()
                .getModFileById(ApiMod.MOD_ID)
                .getFile()
                .getScanResult()
                .getClasses()
                .stream()
                .map(ModFileScanData.ClassData::clazz)
                .map(clazz -> forType(clazz, ApiMod.class))
                .filter(predicate)
                .collect(Collectors.toSet());
    }
}
