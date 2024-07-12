package ru.javarush.ponikan.caesarscipher.methods;

public class InitializeParameters {

    private String inputFilePath;
    private String outputFilePath;
    private int key;

    public InitializeParameters(String[] parameters) {
        this.inputFilePath = parameters[0];
        this.outputFilePath = parameters[1];
        this.key = Integer.parseInt(parameters[2]);
    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public int getKey() {
        return key;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
