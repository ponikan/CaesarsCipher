package ru.javarush.ponikan.caesarscipher.actions;

import ru.javarush.ponikan.caesarscipher.results.Result;

public interface Action {

    Result execute(String[] parameters);
}
