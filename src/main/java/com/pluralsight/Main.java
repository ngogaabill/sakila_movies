package com.pluralsight;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        DataManager dataManager = new DataManager();
        ArrayList<Actor> actors = dataManager.getActors("Bob", "Fawcett");

        for (Actor a : actors) {
            System.out.println(a.getActorId() + " " + a.getFirstName() + " " + a.getLastName());
        }
    }
}