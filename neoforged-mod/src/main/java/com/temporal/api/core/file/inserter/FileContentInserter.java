package com.temporal.api.core.file.inserter;

public interface FileContentInserter<T, L> {
    void insert(T insertable, L location);
}
