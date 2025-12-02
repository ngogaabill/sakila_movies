package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("yearup");

        queryActor(basicDataSource);
    }

    public static void queryActor(BasicDataSource basicDataSource) {
        String query = "SELECT * FROM actor WHERE last_name = ? ";
        System.out.println("Enter last name of the actor to search : ");
        String name = scanner.nextLine().trim();
        try (Connection connection = basicDataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");

                    System.out.println("Actor" + firstName + "," + lastName);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}