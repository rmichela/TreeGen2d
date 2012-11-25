package lsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Copyright 2012 Ryan Michela
 */
public class RunnerContext {
    private final Stack<Map<String, Number>> stateStack = new Stack<Map<String, Number>>();
    private Map<String, Number> state = new HashMap<String, Number>();

    public Map<String, Number> currentState() {
        return state;
    }

    public void push() {
        Map<String, Number> pastState = new HashMap<String, Number>();
        pastState.putAll(state);
        stateStack.push(pastState);
    }

    public void pop() {
        state = stateStack.pop();
    }

    public int stackDepth() {
        return stateStack.size();
    }

    public Map<String, Number> getState() {
        return state;
    }
}
