package com.temporal.api.core.compat;

import com.temporal.api.ApiMod;
import com.temporal.api.core.engine.event.handler.EventHandler;
import net.neoforged.fml.ModList;

import java.util.ArrayList;
import java.util.List;

public class SimpleDependencyProcessBuilder extends AbstractDependencyProcessBuilder<SimpleDependencyProcessBuilder> {
    protected SimpleDependencyProcessBuilder(List<String> dependencyIds) {
        super(dependencyIds);
    }

    public static SimpleDependencyProcessBuilder create(String dependencyId, String... additionalDependencyIds) {
        List<String> ids = new ArrayList<>(additionalDependencyIds.length + 1);
        ids.add(dependencyId);
        ids.addAll(List.of(additionalDependencyIds));
        return new SimpleDependencyProcessBuilder(ids);
    }

    @Override
    public SimpleDependencyProcessBuilder addProcess(EventHandler eventHandler) {
        return this.addProcess((DependencyFunction) eventHandler::handle);
    }

    @Override
    public SimpleDependencyProcessBuilder addProcess(DependencyFunction callback) {
        for (String dependencyId : this.getDependencyIds()) {
            if (!ModList.get().isLoaded(dependencyId)) {
                ApiMod.LOGGER.warn("Dependency: \"{}\" is not found, so dependency process won't be added to callbacks: {}", dependencyId, callback.toString());
                return this;
            }
        }

        this.addCallback(callback);
        return this;
    }

    @Override
    public SimpleDependencyProcessBuilder startNext(String dependencyId, String... additionalDependencyIds) {
        this.build();
        return create(dependencyId, additionalDependencyIds);
    }

    @Override
    public void build() {
        this.getCallbacks().forEach(DependencyFunction::execute);
    }
}
