package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcUserService implements UserService {

    private Connection dbConnection;

    public JdbcUserService(Connection connection) {
        this.dbConnection = connection;
    }

    public Connection getDbConnection() {
        return dbConnection;
    }

    @Override
    public boolean authenticate(String username, String password) {

        try {

            String query = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement statment = dbConnection.prepareStatement(query);

            statment.setString(1, username);
            statment.setString(2, password);

            ResultSet resultSet = statment.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void add(User user) {
        String userNameTry = user.getUsername();
        String userPassword = user.getPassword();
        String userEmail = user.getEmail();
        String userFirstName = user.getFirstName();
        String userLastName = user.getLastName();
        String userPhone = user.getPhone();


        if (findByName(userNameTry) != null) {
            return;
        }
        try {

            String query = "INSERT INTO user (username, password, email, firstname, lastname, phone) VALUES (?,?,?,?,?,?)";

            PreparedStatement statment = dbConnection.prepareStatement(query);

            statment.setString(1, userNameTry);
            statment.setString(2, userPassword);
            statment.setString(3, userEmail);
            statment.setString(4, userFirstName);
            statment.setString(5, userLastName);
            statment.setString(6, userPhone);

            statment.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User findByName(String username) {

        try {

            String query = "SELECT * FROM user WHERE username = ?";

            PreparedStatement statment = dbConnection.prepareStatement(query);
            statment.setString(1, username);

            ResultSet resultSet = statment.executeQuery();

            if (resultSet.next()) {

                String userNameString = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");

                return new User(userNameString, email, password, firstname, lastname, phone);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> findAll() {

        List usersList = new LinkedList();

        try {
            String query = "SELECT * FROM user;";
            PreparedStatement statment = dbConnection.prepareStatement(query);

            ResultSet resultSet = statment.executeQuery();

            while (resultSet.next()) {

                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String phone = resultSet.getString("phone");

                User user = new User(username, email, password, firstname, lastname, phone);

                usersList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usersList;

    }

    @Override
    public int count() {
        int result = 0;

        try {

            String query = "SELECT COUNT(*) FROM user;";
            PreparedStatement statement= dbConnection.prepareStatement(query);

            ResultSet resultSet;
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = resultSet.getInt(1);
                System.out.println(result);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;

    }

}
