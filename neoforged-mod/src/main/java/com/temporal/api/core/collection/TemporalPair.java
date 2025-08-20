package com.temporal.api.core.collection;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TemporalPair<L, R> implements Pair<L, R> {
    private final Pair<L, R> delegate;

    public TemporalPair() {
        this(new SimplePair<>());
    }

    public TemporalPair(L left, R right) {
        this(new SimplePair<>(left, right));
    }

    public TemporalPair(Pair<L, R> delegate) {
        this.delegate = delegate;
    }

    @Override
    public L getLeft() {
        L left = delegate.getLeft();
        this.setLeft(null);
        return left;
    }

    @Override
    public L setLeft(L left) {
        return delegate.setLeft(left);
    }

    @Override
    public void mapLeft(Consumer<L> consumer) {
        delegate.mapLeft(consumer);
    }

    @Override
    public R getRight() {
        R right = delegate.getRight();
        delegate.setRight(null);
        return right;
    }

    @Override
    public R setRight(R right) {
        return delegate.setRight(right);
    }

    @Override
    public void mapRight(Consumer<R> consumer) {
        delegate.mapRight(consumer);
    }

    @Override
    public void map(BiConsumer<L, R> consumer) {
        delegate.map(consumer);
    }
}
