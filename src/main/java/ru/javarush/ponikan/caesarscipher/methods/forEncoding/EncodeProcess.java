package ru.javarush.ponikan.caesarscipher.methods.forEncoding;

import ru.javarush.ponikan.caesarscipher.constants.Constants;
import ru.javarush.ponikan.caesarscipher.ecxeptions.AppException;
import ru.javarush.ponikan.caesarscipher.methods.InitializeParameters;

import java.io.*;

public class EncodeProcess {

    private InitializeParameters init;

    public EncodeProcess(InitializeParameters init) {
        this.init = init;
    }

    public InitializeParameters getInit() {
        return init;
    }

    public void ecncodeProcess() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(init.getInputFilePath())));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(init.getOutputFilePath())))
        ) {
            int i;
            int indexletterInAlphabet;
            int indexCiperLetter;
            char chiperLetter;
            char letter;

            while ((i = reader.read()) > 0) {
                letter = (char) i;

                if (Constants.ALPHABET.indexOf(letter) >= 0) {
                    indexletterInAlphabet = Constants.ALPHABET.indexOf(letter);
                    indexCiperLetter = (indexletterInAlphabet + init.getKey()) % Constants.ALPHABET.length();
                    chiperLetter = Constants.ALPHABET.charAt(indexCiperLetter);
                } else {
                    chiperLetter = letter;
                }
                writer.write(chiperLetter);
            }

        } catch (IOException e) {
            throw new AppException("Something wrong ", e);
        }
    }
}
