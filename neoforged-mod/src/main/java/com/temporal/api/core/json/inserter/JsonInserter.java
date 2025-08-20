package com.temporal.api.core.json.inserter;

public interface JsonInserter<T, L> {
    void insert(T insertable, L location);
}
