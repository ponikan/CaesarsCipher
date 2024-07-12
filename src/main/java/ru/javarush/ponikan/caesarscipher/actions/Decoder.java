package ru.javarush.ponikan.caesarscipher.actions;

import ru.javarush.ponikan.caesarscipher.constants.Constants;
import ru.javarush.ponikan.caesarscipher.ecxeptions.AppException;
import ru.javarush.ponikan.caesarscipher.methods.InitializeParameters;
import ru.javarush.ponikan.caesarscipher.methods.ValidFileChecker;
import ru.javarush.ponikan.caesarscipher.methods.forDecoding.StartDecoding;
import ru.javarush.ponikan.caesarscipher.methods.forEncoding.StartEncoding;
import ru.javarush.ponikan.caesarscipher.results.Result;
import ru.javarush.ponikan.caesarscipher.results.ResultCode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Decoder implements Action {
    @Override
    public Result execute(String[] parameters) {

        InitializeParameters initializeParameters = new InitializeParameters(parameters);

        ValidFileChecker validInputFile = new ValidFileChecker(initializeParameters.getInputFilePath());
        boolean isValidInputFile = validInputFile.isValidFile();

        ValidFileChecker validOutputFile = new ValidFileChecker(initializeParameters.getOutputFilePath());
        boolean isValidOutputFile = validOutputFile.isValidFile();

        if (isValidInputFile && isValidOutputFile) {
            StartDecoding.decodingStart(initializeParameters);
        } else if (!isValidInputFile && !isValidOutputFile) {
            System.out.println("File for decoding does not exist. Default file for Decoding :" + Constants.DEFAULT_TXT_FILE_FOR_DECODE);
            try {
                Path pathFileForDecoding = Path.of(Constants.DEFAULT_TXT_FILE_FOR_DECODE);
                Path pathFileForSaveEncoding = Path.of(Constants.DEFAULT_TXT_FILE_TO_SAVE_ENCODE);
                if (Files.size(pathFileForDecoding) <= 0 && Files.size(pathFileForSaveEncoding) > 0) {
                    Files.copy(pathFileForSaveEncoding, pathFileForDecoding, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            initializeParameters.setInputFilePath(Constants.DEFAULT_TXT_FILE_FOR_DECODE);

            System.out.println("File for saving decoding results does not exist. Default file for saving :" + Constants.DEFAULT_TXT_FILE_TO_SAVE_DECODE);
            initializeParameters.setOutputFilePath(Constants.DEFAULT_TXT_FILE_TO_SAVE_DECODE);
            StartDecoding.decodingStart(initializeParameters);
        } else if (!isValidInputFile && isValidOutputFile) {
            System.out.println("File for decoding does not exist. Default file for Decoding :" + Constants.DEFAULT_TXT_FILE_FOR_DECODE);
            try {
                Path pathFileForDecoding = Path.of(Constants.DEFAULT_TXT_FILE_FOR_DECODE);
                Path pathFileForSaveEncoding = Path.of(Constants.DEFAULT_TXT_FILE_TO_SAVE_ENCODE);
                if (Files.size(pathFileForDecoding) <= 0 && Files.size(pathFileForSaveEncoding) > 0) {
                    Files.copy(pathFileForSaveEncoding, pathFileForDecoding, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            initializeParameters.setInputFilePath(Constants.DEFAULT_TXT_FILE_FOR_DECODE);
            StartDecoding.decodingStart(initializeParameters);
        } else if (isValidInputFile && !isValidOutputFile) {
            System.out.println("File for saving decoding results does not exist. Default file for saving :" + Constants.DEFAULT_TXT_FILE_TO_SAVE_DECODE);
            initializeParameters.setOutputFilePath(Constants.DEFAULT_TXT_FILE_TO_SAVE_DECODE);
            StartDecoding.decodingStart(initializeParameters);
        }

        return new Result("Decoding text complite", ResultCode.OK);
    }
}
