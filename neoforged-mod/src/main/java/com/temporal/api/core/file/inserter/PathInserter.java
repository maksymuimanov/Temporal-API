package com.temporal.api.core.file.inserter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathInserter implements FileContentInserter<String, Path> {
    @Override
    public void insert(String insertable, Path location) {
        try {
            Path normalizedPath = location.toAbsolutePath().normalize();
            if (Files.exists(normalizedPath)) Files.delete(normalizedPath);
            Files.createDirectories(normalizedPath.getParent());
            Files.createFile(normalizedPath);
            Files.writeString(normalizedPath, insertable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
