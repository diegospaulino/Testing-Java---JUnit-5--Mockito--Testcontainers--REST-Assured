package com.diegospaulino.studies.java_testing.junit_test_lifecyle.service;

import java.util.Map;
import java.util.UUID;

import com.diegospaulino.studies.java_testing.junit_test_lifecyle.io.UsersDatabase;

public class UserServiceImpl implements UserService {

    UsersDatabase usersDatabase;

    public UserServiceImpl(UsersDatabase usersDatabase) {
        this.usersDatabase = usersDatabase;
    }

    public String createUser(Map userDetails) {
        // Implementation for creating a user
        String userId = UUID.randomUUID().toString();
        userDetails.put("userId", userId);
        usersDatabase.save(userId, userDetails);
        return userId;
    }

    public Map updateUser(String userId, Map userDetails) {
        // Implementation for updating a user
        Map existingUser = usersDatabase.find(userId);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found");
        }

        existingUser.put("firstName", userDetails.get("firstName"));
        existingUser.put("lastName", userDetails.get("lastName"));
        
        return usersDatabase.update(userId, existingUser);
    }

    public Map getUserDetails(String userId) {
        // Implementation for getting user details
        return usersDatabase.find(userId);
    }

    public void deleteUser(String userId) {
        // Implementation for deleting a user
        Map existingUser = usersDatabase.find(userId);
        if (existingUser == null) {
            throw new IllegalArgumentException("User not found");
        }
        usersDatabase.delete(userId);
    }
}
