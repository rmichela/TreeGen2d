package tree2d;

import lsystem.IAction;
import lsystem.RunnerContext;

/**
 * Copyright 2012 Ryan Michela
 */
public class TreeJunction implements IAction{
    private double dAngle;
    private char forSymbol;

    public TreeJunction(double dAngle, char forSymbol) {
        this.dAngle = dAngle;
        this.forSymbol = forSymbol;
    }

    @Override
    public char forSymbol() {
        return forSymbol;
    }

    @Override
    public void execute(RunnerContext context) {
        double angle = context.getState().get("angle").doubleValue();
        context.getState().put("angle", angle + dAngle);
    }
}
