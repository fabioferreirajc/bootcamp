package org.academiadecodigo.stormrooters;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in, System.out);

        String[] menuOptions = {"Login", "Register", "Exit"};
        MenuInputScanner scanner = new MenuInputScanner(menuOptions);
        scanner.setMessage("Choose: ");


        Set<String> userNames = new HashSet<>();
        userNames.add("fabio");

        Set<String> password = new HashSet<>();
        password.add("password");


        int answerMenu = prompt.getUserInput(scanner);


        switch (answerMenu) {
            case 1:
                login(prompt, userNames, password);
                break;

            case 2:
                register(prompt, userNames, password);
                login(prompt, userNames, password);
                break;

            case 3:
                System.out.println("logout");
                break;
        }


    }

    private static void login(Prompt prompt, Set userNames, Set password) {

        System.out.println("Insert your Credentials");

        StringSetInputScanner userNameQuestion = new StringSetInputScanner(userNames);
        userNameQuestion.setMessage("Username: ");
        userNameQuestion.setError("Wrong username!");
        prompt.getUserInput(userNameQuestion);
        System.out.println("Username verified.");


        StringSetInputScanner passwordQuestion = new StringSetInputScanner(password);
        passwordQuestion.setMessage("Password: ");
        passwordQuestion.setError("Wrong password!");
        prompt.getUserInput(passwordQuestion);
        System.out.println("Password verified.");
    }

    private static void register(Prompt prompt, Set userNames, Set password) {

        System.out.println("Register your credentials");

        StringInputScanner newUserNameQuestion = new StringInputScanner();
        newUserNameQuestion.setMessage("Insert your username: ");
        newUserNameQuestion.setError("Enter a valid username!");
        String name = prompt.getUserInput(newUserNameQuestion);
        userNames.add(name);

        PasswordInputScanner newPasswordQuestion = new PasswordInputScanner();
        newPasswordQuestion.setMessage("Create your Password: ");
        newPasswordQuestion.setError("Enter a valid password");
        String pass = prompt.getUserInput(newPasswordQuestion);
        password.add(pass);

    }

}
