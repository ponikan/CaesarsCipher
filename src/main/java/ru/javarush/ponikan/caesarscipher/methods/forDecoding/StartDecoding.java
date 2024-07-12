package ru.javarush.ponikan.caesarscipher.methods.forDecoding;

import ru.javarush.ponikan.caesarscipher.methods.InitializeParameters;

public class StartDecoding {

    public static void decodingStart(InitializeParameters parameters){

        DecodeProcess process = new DecodeProcess(parameters);
        process.decodeProcess();
    }
}
