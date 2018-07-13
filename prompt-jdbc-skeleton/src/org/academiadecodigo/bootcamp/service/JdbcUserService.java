package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JdbcUserService implements UserService {


    private Connection dbConnection;


    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User findByName(String username) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public int count() {
        int result = 0;


        try {

            Statement statement = dbConnection.createStatement();
            String query = "SELECT COUNT(*) FROM user";
            ResultSet resultSet = null;
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                result = resultSet.getInt(1);

            }
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;

    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
