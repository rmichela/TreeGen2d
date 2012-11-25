package lsystem;

/**
 * Copyright 2012 Ryan Michela
 */
public interface IProduction {
    public String apply(char Symbol);
    public static final String NO_MATCH = "";
}
