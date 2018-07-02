package org.academiadecodigo.stormrooters;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.util.HashMap;

public class WithHashMap {
    public static void main(String[] args) {

        Prompt prompt = new Prompt(System.in, System.out);

        String[] menuOptions = {"Login", "Register","Delete", "Exit"};
        MenuInputScanner scanner = new MenuInputScanner(menuOptions);
        scanner.setMessage("Choose: ");

        HashMap<String, String> userAndPass = new HashMap();
        userAndPass.put("joao", "pass");

        int answerMenu = prompt.getUserInput(scanner);

        switch (answerMenu) {
            case 1:
                login(prompt, userAndPass);
                break;

            case 2:
                register(prompt, userAndPass);
                login(prompt, userAndPass);
                break;

            case 3:
                delete(prompt,userAndPass);
                break;

            case 4:
                System.out.println("logout");
                break;
        }


    }

    private static void register(Prompt prompt, HashMap userAngPass) {
        System.out.println("Register Credentials");

        StringInputScanner userNameQuestion = new StringInputScanner();
        userNameQuestion.setMessage("Username: ");
        String nameReg = prompt.getUserInput(userNameQuestion);
        userNameQuestion.setError("Wrong username!");

        StringInputScanner passwordQuestion = new StringInputScanner();
        passwordQuestion.setMessage("Password: ");
        passwordQuestion.setError("Wrong password!");
        String passReg = prompt.getUserInput(passwordQuestion);

        userAngPass.put(nameReg, passReg);
        System.out.println(userAngPass.entrySet());

    }

    private static void login(Prompt prompt, HashMap userAndPass) {

        System.out.println("Insert your Credentials");

        StringInputScanner userNameQuestion = new StringInputScanner();
        userNameQuestion.setMessage("Username: ");
        String name = prompt.getUserInput(userNameQuestion);
        userNameQuestion.setError("Wrong username!");

        StringInputScanner passwordQuestion = new StringInputScanner();
        passwordQuestion.setMessage("Password: ");
        passwordQuestion.setError("Wrong password!");
        String pass = prompt.getUserInput(passwordQuestion);


        if (userAndPass.containsKey(name) && userAndPass.containsValue(pass)) {
            System.out.println("Username verified.");
            System.out.println("Password verified.");

        }

    }

    private static void delete(Prompt prompt, HashMap userAndPass) {

        StringInputScanner userNameQuestion = new StringInputScanner();
        userNameQuestion.setMessage("Username: ");
        String name = prompt.getUserInput(userNameQuestion);
        userNameQuestion.setError("Wrong username!");

        userAndPass.remove(name);

        System.out.println(userAndPass.entrySet());



    }



}
