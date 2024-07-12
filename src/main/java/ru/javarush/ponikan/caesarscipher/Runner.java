package ru.javarush.ponikan.caesarscipher;

import ru.javarush.ponikan.caesarscipher.results.Result;

public class Runner {
    public static void main(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }

}
