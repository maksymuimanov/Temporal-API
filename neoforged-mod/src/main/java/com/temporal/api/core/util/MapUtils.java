package com.temporal.api.core.util;

import java.util.*;
import java.util.function.Function;

public final class MapUtils {
    private MapUtils() {
    }

    public static <K, V> void putToSetMap(Map<K, Set<V>> map, K key, V value) {
        boolean exists = map.containsKey(key);
        if (exists) {
            map.get(key).add(value);
        } else {
            Set<V> set = new HashSet<>();
            set.add(value);
            map.put(key, set);
        }
    }

    public static <K, V> void putToListMap(Map<K, List<V>> map, K key, V value) {
        boolean exists = map.containsKey(key);
        if (exists) {
            map.get(key).add(value);
        } else {
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    public static <K, V, VR> Map<K, VR> createMap(Map<K, V> source, Function<V, VR> valueMapper) {
        return createMap(source, key -> key, valueMapper);
    }

    public static <K, V, KR, VR> Map<KR, VR> createMap(Map<K, V> source, Function<K, KR> keyMapper, Function<V, VR> valueMapper) {
        HashMap<KR, VR> map = new HashMap<>();
        source.forEach((key, value) -> map.put(keyMapper.apply(key), valueMapper.apply(value)));
        return map;
    }
}
