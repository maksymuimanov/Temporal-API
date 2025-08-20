package com.temporal.api.core.util.other;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static Object[] mergeArrays(Object[]... arrays) {
        if (arrays == null || arrays.length == 0) return new Object[]{};
        return Arrays.stream(arrays)
                .flatMap(Arrays::stream)
                .toArray(Object[]::new);
    }

    public static <T> HolderSet<T> createHolderSetFromIds(List<String> ids, Function<String, T> mapper) {
        if (ids == null || ids.isEmpty()) return HolderSet.empty();
        return HolderSet.direct(ids.stream()
                .map(mapper)
                .map(Holder::direct)
                .toList());
    }

    public static <T> HolderSet.Direct<T> mergeHolderSets(Collection<? extends HolderSet<T>> sets) {
        List<Holder<T>> data = new ArrayList<>();
        for (HolderSet<T> set : sets) {
            set.forEach(data::add);
        }

        return HolderSet.direct(data);
    }

    public static <T> Collector<Holder<T>, ArrayList<Holder<T>>, HolderSet<T>> createHolderSetCollector() {
        return Collector.of(
                ArrayList::new,
                ArrayList::add,
                (r1, r2) -> {
                    r1.addAll(r2);
                    return r1;
                },
                HolderSet::direct);
    }
}
