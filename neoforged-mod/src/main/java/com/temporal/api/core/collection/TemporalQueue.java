package com.temporal.api.core.collection;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.function.Consumer;

public class TemporalQueue<E> implements Queue<E> {
    private final Queue<E> delegate;
    private byte count;
    private final byte limit;

    public TemporalQueue() {
        this((byte) 1);
    }

    public TemporalQueue(byte limit) {
        this((byte) 0, limit);
    }

    public TemporalQueue(byte count, byte limit) {
        this(new ArrayDeque<>(), count, limit);
    }

    public TemporalQueue(Queue<E> delegate) {
        this(delegate, (byte) 1);
    }

    public TemporalQueue(Queue<E> delegate, byte limit) {
        this(delegate, (byte) 0, limit);
    }

    public TemporalQueue(Queue<E> delegate, byte count, byte limit) {
        this.delegate = delegate;
        this.count = count;
        this.limit = limit;
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public @NotNull Iterator<E> iterator() {
        return delegate.iterator();
    }

    @Override
    public @NotNull Object[] toArray() {
        return delegate.toArray();
    }

    @Override
    public @NotNull <T> T[] toArray(@NotNull T[] array) {
        return delegate.toArray(array);
    }

    @Override
    public boolean add(E element) {
        return delegate.add(element);
    }

    @Override
    public boolean remove(Object o) {
        return delegate.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> collection) {
        return delegate.containsAll(collection);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        return delegate.addAll(collection);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> collection) {
        return delegate.removeAll(collection);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> collection) {
        return delegate.retainAll(collection);
    }

    @Override
    public void clear() {
        delegate.clear();
    }

    @Override
    public boolean offer(E e) {
        return delegate.offer(e);
    }

    @Override
    public E remove() {
        return delegate.remove();
    }

    @Override
    public E poll() {
        return delegate.poll();
    }

    @Override
    @Deprecated
    public E element() {
        return delegate.element();
    }

    @Override
    @Deprecated
    public E peek() {
        return delegate.peek();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        delegate.forEach(action);
        count++;
        if (count == limit) {
            this.clear();
            count = 0;
        }
    }
}