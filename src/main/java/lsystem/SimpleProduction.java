package lsystem;

/**
 * Copyright 2012 Ryan Michela
 */
public class SimpleProduction implements IProduction {
    private char matching;
    private String replaceWith;

    public SimpleProduction(char matching, String replaceWith) {
        this.matching = matching;
        this.replaceWith = replaceWith;
    }

    @Override
    public String apply(char symbol) {
        if (matching == symbol) {
            return replaceWith;
        }
        return NO_MATCH;
    }
}
