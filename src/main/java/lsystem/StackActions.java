package lsystem;

/**
 * Copyright 2012 Ryan Michela
 */
public class StackActions {

    public static IAction saveState(char forSymbol) {
        return new PushStateStack(forSymbol);
    }

    public static IAction restoreState(char forSymbol) {
        return new PopStateStack(forSymbol);
    }

    private static class PushStateStack implements IAction {
        private char forSymbol;

        public PushStateStack(char forSymbol) {
            this.forSymbol = forSymbol;
        }

        @Override
        public char forSymbol() {
            return forSymbol;
        }

        @Override
        public void execute(RunnerContext context) {
            context.push();
        }
    }

    private static class PopStateStack implements IAction {
        private char forSymbol;

        public PopStateStack(char forSymbol) {
            this.forSymbol = forSymbol;
        }

        @Override
        public char forSymbol() {
            return forSymbol;
        }

        @Override
        public void execute(RunnerContext context) {
            context.pop();
        }
    }
}
