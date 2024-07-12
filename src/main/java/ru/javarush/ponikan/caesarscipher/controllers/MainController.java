package ru.javarush.ponikan.caesarscipher.controllers;

import ru.javarush.ponikan.caesarscipher.actions.Action;
import ru.javarush.ponikan.caesarscipher.results.Result;

public class MainController {

   public Result doAction(String actionNAme, String[] parameters){
       Action action = Actions.find(actionNAme);
       Result result = action.execute(parameters);
       return result;
   }
}
