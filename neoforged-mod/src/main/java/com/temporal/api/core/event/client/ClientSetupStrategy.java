package com.temporal.api.core.event.client;

import java.util.List;

public interface ClientSetupStrategy<T> {
    void execute(List<T> source);
}
