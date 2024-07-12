package ru.javarush.ponikan.caesarscipher.actions;

import ru.javarush.ponikan.caesarscipher.results.Result;
import ru.javarush.ponikan.caesarscipher.results.ResultCode;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {
        // TODO DECODING THE ENCODING FILE

        return new Result("Decoding text complite", ResultCode.OK);
    }
}
