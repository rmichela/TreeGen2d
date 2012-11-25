package lsystem;

/**
 * Copyright 2012 Ryan Michela
 */
public interface IAction {
    public char forSymbol();
    public void execute(RunnerContext context);
}
