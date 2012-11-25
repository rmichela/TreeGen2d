package tree2d;

import lsystem.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Copyright 2012 Ryan Michela
 */
public class TreePanel extends JPanel {
    private int seed;
    private int generations = 10;

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
        repaint();
    }

    public int getGenerations() {
        return generations;
    }

    public void setGenerations(int generations) {
        this.generations = generations;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        LSystem ls = basicTree();
        String pattern = ls.generate(generations);
        System.out.println(pattern);

        drawTree((Graphics2D)g, pattern);
    }

    private LSystem basicTree() {
        Random r = new Random(seed);
        LSystem ls = new LSystem("0", "01234");

        StochasticProduction leaves = new StochasticProduction(r, '0');
        leaves.addProduction(3, "0");
        leaves.addProduction(3, "10");
        leaves.addProduction(2, "1[L0][R0]");
        leaves.addProduction(2, "1[L0][0]");
        leaves.addProduction(2, "1[0][R0]");

        StochasticProduction twigs = new StochasticProduction(r, '1');
        //twigs.addProduction(3, "1");
        twigs.addProduction(4, "2");
        twigs.addProduction(2, "2[L0]");
        twigs.addProduction(2, "2[R0]");

        StochasticProduction branches = new StochasticProduction(r, '2');
        //branches.addProduction(3, "2");
        branches.addProduction(1, "3");

        StochasticProduction limbs = new StochasticProduction(r, '3');
        //limbs.addProduction(2, "3");
        limbs.addProduction(1, "4");

        ls.addProduction(leaves);
        ls.addProduction(twigs);
        ls.addProduction(branches);
        ls.addProduction(limbs);

        return ls;
    }

    private void drawTree(Graphics2D g, String pattern) {
        g.rotate(Math.PI, getWidth()/2, getHeight()/2);

        RunnerContext context = new RunnerContext();
        context.getState().put("startx", getWidth()/2);
        context.getState().put("starty", 0);
        context.getState().put("angle", 0);
        LSystemRunner treeDrawRunner = new LSystemRunner(pattern, context);
        treeDrawRunner.addAction(new TreeLeaf(g, '0'));
        treeDrawRunner.addAction(new TreeBranch(g, Color.DARK_GRAY, 2, '1'));
        treeDrawRunner.addAction(new TreeBranch(g, Color.DARK_GRAY, 4, '2'));
        treeDrawRunner.addAction(new TreeBranch(g, Color.DARK_GRAY, 6, '3'));
        treeDrawRunner.addAction(new TreeBranch(g, Color.DARK_GRAY, 8, '4'));
        treeDrawRunner.addAction(StackActions.saveState('['));
        treeDrawRunner.addAction(new TreeJunction(-Math.PI/4, 'R'));
        treeDrawRunner.addAction(StackActions.restoreState(']'));
        treeDrawRunner.addAction(new TreeJunction(Math.PI/4, 'L'));
        treeDrawRunner.execute();
    }
}
