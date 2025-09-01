package com.temporal.api.core.util;

import com.temporal.api.core.file.formatter.FileContentFormatter;
import com.temporal.api.core.file.formatter.StringFileContentFormatter;
import com.temporal.api.core.file.inserter.FileContentInserter;
import com.temporal.api.core.file.inserter.ResourceInserter;

import java.nio.file.Path;

public final class IOUtils {
    private IOUtils() {
    }

    public static void writeToFile(Path path, String format, Object... arguments) {
        FileContentFormatter<String> fileContentFormatter = new StringFileContentFormatter();
        String formatted = fileContentFormatter.format(format, arguments);
        FileContentInserter<String, Path> resourceInserter = new ResourceInserter();
        resourceInserter.insert(formatted, path);
    }
}
