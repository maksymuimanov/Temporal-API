package com.temporal.api.core.engine.io.context;

import com.temporal.api.core.engine.io.IOLayer;
import com.temporal.api.core.registry.factory.common.ObjectFactory;
import com.temporal.api.core.util.IOUtils;
import net.neoforged.bus.api.IEventBus;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;

public class ReflectiveFactoryRegistrar implements FactoryRegistrar {
    @Override
    public void registerFactories(IEventBus eventBus) {
        Map<ObjectFactory<?>, Field[]> factoryContainers = IOLayer.NEO_MOD.getClasses()
                .stream()
                .filter(IOUtils::isFactoryPresent)
                .map(Class::getDeclaredFields)
                .collect(Collectors.toMap(fields -> {
                        for (Field field : fields) {
                            Class<?> fieldType = field.getType();
                            if (ObjectFactory.class.isAssignableFrom(fieldType)) {
                                return (ObjectFactory<?>) InjectionPool.getFromInstance(fieldType);
                            }
                        }
                        return null;
                    }, fields -> {
                        Field[] otherFields = new Field[fields.length - 1];
                        for (int i = 1; i < fields.length; i++) {
                            Field field = fields[i];
                            otherFields[i - 1] = field;
                        }
                        return otherFields;
                    }
                ));
        factoryContainers.forEach((factory, fields) -> {
            try {
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.get(null);
                }
                factory.register(eventBus);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
