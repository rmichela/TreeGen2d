package tree2d;

import lsystem.IAction;
import lsystem.RunnerContext;

import java.awt.*;

/**
 * Copyright 2012 Ryan Michela
 */
public class TreeBranch implements IAction {
    private Graphics2D g;
    private Color c;
    private Stroke weight;
    private char forSymbol;
    private int length;

    public TreeBranch(Graphics g, Color c, int weight, char forSymbol) {
        this.g = (Graphics2D) g;
        this.c = c;
        this.weight = new BasicStroke(weight);
        length = 8*weight;
        this.forSymbol = forSymbol;
    }

    @Override
    public char forSymbol() {
        return forSymbol;
    }

    @Override
    public void execute(RunnerContext context) {
        int x = context.getState().get("startx").intValue();
        int y = context.getState().get("starty").intValue();

        double angle = context.getState().get("angle").doubleValue();

        int xx = (int)(length * Math.sin(angle) + x);
        int yy = (int)(length * Math.cos(angle) + y);

        g.setColor(c);
        g.setStroke(weight);
        g.drawLine(x, y, xx, yy);

        context.getState().put("startx", xx);
        context.getState().put("starty", yy);
    }
}
