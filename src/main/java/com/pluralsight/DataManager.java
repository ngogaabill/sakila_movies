package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataManager {

    public ArrayList<Actor> getActors(String firstName, String lastName) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("yearup");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");

        String query = "SELECT first_name, last_name, actor_id FROM actor WHERE first_name = ? AND last_name = ?";

        ArrayList<Actor> actors = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String firstNameResult = resultSet.getString("first_name");
                String lastNameResult = resultSet.getString("last_name");
                int id = resultSet.getInt("actor_id");
                actors.add(new Actor(id, firstNameResult, lastNameResult));
            }
        } catch (SQLException e) {
            System.out.println("Bad query: " + e);
        }
        return actors;
    }

    public ArrayList<Product> getProduct() {
        return null;
    }
}