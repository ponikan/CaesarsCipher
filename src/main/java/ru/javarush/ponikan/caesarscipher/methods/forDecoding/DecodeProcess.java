package ru.javarush.ponikan.caesarscipher.methods.forDecoding;

import ru.javarush.ponikan.caesarscipher.constants.Constants;
import ru.javarush.ponikan.caesarscipher.ecxeptions.AppException;
import ru.javarush.ponikan.caesarscipher.methods.InitializeParameters;

import java.io.*;

public class DecodeProcess {

    private InitializeParameters init;

    public DecodeProcess(InitializeParameters init) {
        this.init = init;
    }

    public InitializeParameters getInit() {
        return init;
    }

    public void decodeProcess() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(init.getInputFilePath())));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(init.getOutputFilePath())))
        ) {
            int i;
            int indexletterInAlphabet;
            int indexUnciperLetter;
            char unchiperLetter;
            char letter;

            while ((i = reader.read()) > 0) {
                letter = (char) i;

                if (Constants.ALPHABET.indexOf(letter) >= 0) {
                    indexletterInAlphabet = Constants.ALPHABET.indexOf(letter);
                    indexUnciperLetter = (indexletterInAlphabet - init.getKey()) % Constants.ALPHABET.length();
                    if (indexUnciperLetter<0){
                        indexUnciperLetter = Constants.ALPHABET.length() + indexUnciperLetter;
                    }
                    unchiperLetter = Constants.ALPHABET.charAt(indexUnciperLetter);
                } else {
                    unchiperLetter = letter;
                }
                writer.write(unchiperLetter);
            }

        } catch (IOException e) {
            throw new AppException("Something wrong ", e);
        }
    }
}
