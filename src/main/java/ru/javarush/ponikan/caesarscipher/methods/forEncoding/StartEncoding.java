package ru.javarush.ponikan.caesarscipher.methods.forEncoding;

import ru.javarush.ponikan.caesarscipher.methods.InitializeParameters;
import ru.javarush.ponikan.caesarscipher.methods.forEncoding.EncodeProcess;

public class StartEncoding {

    public static void encodingStart(InitializeParameters parameters){

        EncodeProcess process = new EncodeProcess(parameters);
        process.ecncodeProcess();
    }
}
