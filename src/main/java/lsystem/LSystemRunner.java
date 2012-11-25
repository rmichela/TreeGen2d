package lsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright 2012 Ryan Michela
 */
public class LSystemRunner {
    private String pattern;
    private final Map<Character, List<IAction>> actionMap;
    private RunnerContext context;

    public LSystemRunner(String pattern) {
        this(pattern, new RunnerContext());
    }

    public LSystemRunner(String pattern, RunnerContext context) {
        this.pattern = pattern;
        actionMap = new HashMap<Character, List<IAction>>();
        this.context = context;
    }

    public void addAction(IAction action) {
        if (!actionMap.containsKey(action.forSymbol())) {
            actionMap.put(action.forSymbol(), new ArrayList<IAction>());
        }
        actionMap.get(action.forSymbol()).add(action);
    }

    public void execute() {
        for (char symbol : pattern.toCharArray()) {
            List<IAction> actions = actionMap.get(symbol);
            if (actions != null) {
                for(IAction action : actions) {
                    action.execute(context);
                }
            }
        }
    }
}
