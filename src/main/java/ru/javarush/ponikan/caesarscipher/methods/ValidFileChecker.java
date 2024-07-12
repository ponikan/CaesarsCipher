package ru.javarush.ponikan.caesarscipher.methods;

import java.nio.file.Files;
import java.nio.file.Path;

public class ValidFileChecker {

   private String filePath;

    public ValidFileChecker(String filePath) {
        this.filePath = filePath;
    }

    public boolean isValidFile() {
        return Files.exists(Path.of(filePath));
    }


}
