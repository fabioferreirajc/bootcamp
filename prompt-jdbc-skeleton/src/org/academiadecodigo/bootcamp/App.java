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

public class App {

    public static void main(String[] args) {

        ConnectionManager connectionManager= new ConnectionManager();
        JdbcUserService jdbcUserService= new JdbcUserService();


        jdbcUserService.setDbConnection(connectionManager.getConnection());
        jdbcUserService.count();

        LoginController loginController = new LoginController();
        MainController mainController = new MainController();
        UserListController userListController = new UserListController();
        LoginView loginView = new LoginView();
        MainView mainView = new MainView();
        UserListView userListView = new UserListView();
        UserDetailsController userDetailsController = new UserDetailsController();
        UserDetailsView userDetailsView = new UserDetailsView();
        Prompt prompt = new Prompt(System.in, System.out);


        UserService userService = new MockUserService();
        userService.add(new User("jorge", "mestre@academiadecodigo.org", Security.getHash("academiadecodigo"),
                "Jorge", "Antunes", "912345678"));
        userService.add(new User("soraia", "so@academiadecodigo.org", Security.getHash("academiadecodigo"),
                "Soraia", "Veríssimo", "966666666"));
        userService.add(new User("sid", "elcid@academiadecodigo.org", Security.getHash("academiadecodigo"),
                "Sidónio", "Câmara", "934567890"));

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


    }
}
