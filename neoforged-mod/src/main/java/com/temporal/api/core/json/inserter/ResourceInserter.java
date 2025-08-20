package com.temporal.api.core.json.inserter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceInserter implements JsonInserter<String, Path> {
    private static final String RUN_DIRECTORY = System.getProperty("user.dir");
    private static final Path PROJECT_ROOT = Path.of(RUN_DIRECTORY).getParent();
    private static final String RESOURCES_DIRECTORY = "src/main/resources";
    private static final JsonInserter<String, Path> PATH_JSON_INSERTER = new PathInserter();

    @Override
    public void insert(String insertable, Path location) {
        try (var paths = Files.walk(PROJECT_ROOT)) {
            Path targetDirName = paths
                    .filter(Files::isDirectory)
                    .filter(path -> path.endsWith(RESOURCES_DIRECTORY))
                    .findAny()
                    .orElseThrow(() -> new IOException("src/main/resources not found"));
            PATH_JSON_INSERTER.insert(insertable, targetDirName.resolve(location));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
