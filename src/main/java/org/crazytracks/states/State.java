package org.crazytracks.states;

public abstract class State<T> {
    private final T model;

    protected State(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }
}