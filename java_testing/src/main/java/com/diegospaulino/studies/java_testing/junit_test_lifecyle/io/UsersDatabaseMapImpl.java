package com.diegospaulino.studies.java_testing.junit_test_lifecyle.io;

import java.util.HashMap;
import java.util.Map;

public class UsersDatabaseMapImpl implements UsersDatabase {

    Map<String, Map> users;

    public void init() {
        // Initialize the database
        users = new HashMap<>();
    }

    public void close() {
        // Close the database connection
        users = null;
    }

    public Map save(String userId, Map userDetails) {
        // Save the user details in the database
        users.put(userId, userDetails);
        return userDetails;
    }

    public Map update(String userId, Map existingUser) {
        // Update the user details in the database
        users.put(userId, existingUser);
        return existingUser;
    }

    public Map find(String userId) {
        // Find the user details in the database
        return users.get(userId);
    }

    public void delete(String userId) {
        // Delete the user from the database
        users.remove(userId);
    }
}
