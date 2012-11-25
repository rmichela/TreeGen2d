package lsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Copyright 2012 Ryan Michela
 */
public class StochasticProduction implements IProduction {
    private Random rand;
    private char matches;
    private final List<IProduction> possibleProductions = new ArrayList<IProduction>();

    public StochasticProduction(Random rand, char matches) {
        this.rand = rand;
        this.matches = matches;
    }

    public void addProduction(int weight, String replaceWith) {
        IProduction production = new SimpleProduction(matches, replaceWith);
        for (int i = 0; i < weight; i++) {
            possibleProductions.add(production);
        }
    }

    @Override
    public String apply(char symbol) {
        if (possibleProductions.isEmpty()) {
            return NO_MATCH;
        }

        if (matches == symbol) {
            int i = rand.nextInt(possibleProductions.size());
            return possibleProductions.get(i).apply(symbol);
        }
        else return NO_MATCH;
    }
}
