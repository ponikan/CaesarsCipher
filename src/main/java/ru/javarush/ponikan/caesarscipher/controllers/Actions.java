package ru.javarush.ponikan.caesarscipher.controllers;

import ru.javarush.ponikan.caesarscipher.actions.Action;
import ru.javarush.ponikan.caesarscipher.actions.Decoder;
import ru.javarush.ponikan.caesarscipher.actions.Encoder;
import ru.javarush.ponikan.caesarscipher.ecxeptions.AppException;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String actionName){
        try{
            Actions value = Actions.valueOf(actionName.toUpperCase());
            Action action = value.action;
            return action;
        }catch (IllegalArgumentException e){
            throw new AppException("not found" + actionName, e);
        }

    }

}
