package ru.javarush.ponikan.caesarscipher.actions;

import ru.javarush.ponikan.caesarscipher.constants.Constants;
import ru.javarush.ponikan.caesarscipher.methods.*;
import ru.javarush.ponikan.caesarscipher.methods.forEncoding.StartEncoding;
import ru.javarush.ponikan.caesarscipher.results.Result;
import ru.javarush.ponikan.caesarscipher.results.ResultCode;

public class Encoder implements Action {
    @Override
    public Result execute(String[] parameters) {

        InitializeParameters initializeParameters = new InitializeParameters(parameters);

        ValidFileChecker validInputFile = new ValidFileChecker(initializeParameters.getInputFilePath());
        boolean isValidInputFile = validInputFile.isValidFile();

        ValidFileChecker validOutputFile = new ValidFileChecker(initializeParameters.getOutputFilePath());
        boolean isValidOutputFile = validOutputFile.isValidFile();


        if (isValidInputFile && isValidOutputFile) {
            StartEncoding.encodingStart(initializeParameters);
        } else if (!isValidInputFile && !isValidOutputFile){
            System.out.println("File for encoding does not exist. Default file for Encoding :" + Constants.DEFAULT_TXT_FILE_FOR_ENCODE);
            initializeParameters.setInputFilePath(Constants.DEFAULT_TXT_FILE_FOR_ENCODE);
            System.out.println("File for saving encoding results does not exist. Default file for saving :" + Constants.DEFAULT_TXT_FILE_TO_SAVE_ENCODE);
            initializeParameters.setOutputFilePath(Constants.DEFAULT_TXT_FILE_TO_SAVE_ENCODE);
            StartEncoding.encodingStart(initializeParameters);
        }else if (!isValidInputFile && isValidOutputFile){
            System.out.println("File for encoding does not exist. Default file for Encoding :" + Constants.DEFAULT_TXT_FILE_FOR_ENCODE);
            initializeParameters.setInputFilePath(Constants.DEFAULT_TXT_FILE_FOR_ENCODE);
            StartEncoding.encodingStart(initializeParameters);
        } else if (isValidInputFile && !isValidOutputFile){
            System.out.println("File for saving encoding results does not exist. Default file for saving :" + Constants.DEFAULT_TXT_FILE_TO_SAVE_ENCODE);
            initializeParameters.setOutputFilePath(Constants.DEFAULT_TXT_FILE_TO_SAVE_ENCODE);
            StartEncoding.encodingStart(initializeParameters);
        }


        return new Result("Encodign text complite", ResultCode.OK);
    }
}
