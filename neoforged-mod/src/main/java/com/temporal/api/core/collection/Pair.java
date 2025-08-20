package com.temporal.api.core.collection;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public interface Pair<L, R> {
    L getLeft();

    L setLeft(L left);

    void mapLeft(Consumer<L> consumer);

    R getRight();

    R setRight(R right);

    void mapRight(Consumer<R> consumer);

    void map(BiConsumer<L, R> consumer);
}
