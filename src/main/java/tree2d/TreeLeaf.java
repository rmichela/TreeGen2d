package tree2d;

import lsystem.IAction;
import lsystem.RunnerContext;

import java.awt.*;

/**
 * Copyright 2012 Ryan Michela
 */
public class TreeLeaf implements IAction {
    private char forSymbol;
    private Graphics2D g;

    public TreeLeaf(Graphics g, char forSymbol) {
        this.forSymbol = forSymbol;
        this.g = (Graphics2D)g;
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

        int xx = (int)(20 * Math.sin(angle) + x);
        int yy = (int)(20 * Math.cos(angle) + y);

        g.setColor(Color.GREEN);
        drawCircle(g, xx, yy, 20);
    }

    private void drawCircle(Graphics2D cg, int xCenter, int yCenter, int r) {
        cg.fillOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }
}
