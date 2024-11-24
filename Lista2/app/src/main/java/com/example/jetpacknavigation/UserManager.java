package com.example.jetpacknavigation;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private static List<User> users = new ArrayList<>();

    static {

        users.add(new User("u1", "p1"));
        users.add(new User("u2", "p2"));
        users.add(new User("u3", "p3"));
        users.add(new User("u4", "p4"));
        users.add(new User("u5", "p5"));
    }


    public static boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    public static boolean register(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }

        users.add(new User(username, password));
        return true;
    }

    public static List<User> getUsers() {
        return users;
    }
}
