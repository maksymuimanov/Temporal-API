package com.temporal.api.core.collection;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class SimplePair<L, R> implements Pair<L, R> {
    private L left;
    private R right;

    public SimplePair() {
    }

    public SimplePair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public L getLeft() {
        return this.left;
    }

    @Override
    public L setLeft(L left) {
        return this.left = left;
    }

    @Override
    public void mapLeft(Consumer<L> consumer) {
        consumer.accept(this.left);
    }

    @Override
    public R getRight() {
        return this.right;
    }

    @Override
    public R setRight(R right) {
        return this.right = right;
    }

    @Override
    public void mapRight(Consumer<R> consumer) {
        consumer.accept(this.right);
    }

    @Override
    public void map(BiConsumer<L, R> consumer) {
        consumer.accept(this.left, this.right);
    }
}
