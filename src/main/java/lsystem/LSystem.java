package lsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2012 Ryan Michela
 */
public class LSystem {
    private final List<IProduction> productions = new ArrayList<IProduction>();
    private String axiom;
    private String alphabet;

    public LSystem(String axiom, String alphabet) {
        this.axiom = axiom;
        this.alphabet = alphabet;
    }

    public void addProduction(IProduction production) {
        productions.add(production);
    }

    public String generate(int generations) {
        if (generations < 1) {
            return axiom;
        }

        String currentGeneration = axiom;
        for (int i = 0; i < generations; i++) {
            currentGeneration = computeNextGeneration(currentGeneration);
        }

        return currentGeneration;
    }

    private String computeNextGeneration(String currentGeneration) {
        StringBuilder nextGeneration = new StringBuilder();

        for (int i = 0; i < currentGeneration.length(); i++) {
            char currentSymbol = currentGeneration.charAt(i);
            if (alphabet.contains(Character.toString(currentSymbol))) {
                nextGeneration.append(applyProductions(currentSymbol));
            } else {
                nextGeneration.append(currentSymbol);
            }
        }

        return nextGeneration.toString();
    }

    private String applyProductions(char symbol) {
        for (IProduction production : productions) {
            String result = production.apply(symbol);
            if (result != IProduction.NO_MATCH) {
                return result;
            }
        }
        return Character.toString(symbol);
    }
}
