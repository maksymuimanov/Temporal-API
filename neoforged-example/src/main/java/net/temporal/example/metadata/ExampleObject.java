package net.temporal.example.metadata;

import com.temporal.api.core.engine.metadata.annotation.injection.Injected;

@Injected
@ExampleAnnotation("Hello from Class")
public class ExampleObject {
    @ExampleAnnotation("Hello from Field")
    private String field;

    @ExampleAnnotation("Hello from Method")
    private void doSmth() {
    }
}
