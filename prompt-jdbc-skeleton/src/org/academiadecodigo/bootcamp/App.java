package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.controller.LoginController;
import org.academiadecodigo.bootcamp.controller.MainController;
import org.academiadecodigo.bootcamp.controller.UserDetailsController;
import org.academiadecodigo.bootcamp.controller.UserListController;
import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.persistance.ConnectionManager;
import org.academiadecodigo.bootcamp.service.JdbcUserService;
import org.academiadecodigo.bootcamp.service.MockUserService;
import org.academiadecodigo.bootcamp.service.UserService;
import org.academiadecodigo.bootcamp.utils.Security;
import org.academiadecodigo.bootcamp.view.LoginView;
import org.academiadecodigo.bootcamp.view.MainView;
import org.academiadecodigo.bootcamp.view.UserDetailsView;
import org.academiadecodigo.bootcamp.view.UserListView;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        ConnectionManager connectionManager= new ConnectionManager();

        UserService userService= new JdbcUserService(connectionManager.getConnection());




        userService.add(new User("joaquim","js@mail.com","academia3", "joaquim",
                "silva","922123432"));

        userService.add(new User("mestre","m@mail.com","academia5", "mestre",
                "mestre","922123432"));

        userService.add(new User("sergio","js@mail.com","jkgdcfoahsfcouagtfapkjnfiasygfdajfbaiuyfgeasg", "joaquim", "silva", "123"));

        userService.count();

        LoginController loginController = new LoginController();
        MainController mainController = new MainController();
        UserListController userListController = new UserListController();
        LoginView loginView = new LoginView();
        MainView mainView = new MainView();
        UserListView userListView = new UserListView();
        UserDetailsController userDetailsController = new UserDetailsController();
        UserDetailsView userDetailsView = new UserDetailsView();
        Prompt prompt = new Prompt(System.in, System.out);



        // Wire login controller and view
        loginView.setPrompt(prompt);
        loginView.setController(loginController);
        loginController.setUserService(userService);
        loginController.setView(loginView);
        loginController.setNextController(mainController);

        // Wire main controller and view
        mainView.setPrompt(prompt);
        mainView.setController(mainController);
        mainController.setView(mainView);
        mainController.setUserListController(userListController);
        mainController.setUserDetailsController(userDetailsController);

        // Wire userList controller and view
        userListView.setPrompt(prompt);
        userListView.setController(userListController);
        userListController.setUserService(userService);
        userListController.setView(userListView);

        // Wire userDetails controller and view
        userDetailsView.setPrompt(prompt);
        userDetailsView.setController(userDetailsController);
        userDetailsController.setUserService(userService);
        userDetailsController.setView(userDetailsView);


        // Start APP
        loginController.init();

        connectionManager.close();
    }
}
