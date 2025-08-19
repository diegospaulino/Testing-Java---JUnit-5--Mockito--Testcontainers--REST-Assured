package com.diegospaulino.studies.java_testing.junit_test_lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import com.diegospaulino.studies.java_testing.junit_test_lifecyle.io.UsersDatabase;
import com.diegospaulino.studies.java_testing.junit_test_lifecyle.io.UsersDatabaseMapImpl;
import com.diegospaulino.studies.java_testing.junit_test_lifecyle.service.UserService;
import com.diegospaulino.studies.java_testing.junit_test_lifecyle.service.UserServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceImplTest {

    UsersDatabase usersDatabase;
    UserService userService;
    String createdUserId = "";

    @BeforeAll
    void setup() {
        // Create and initialize database
        usersDatabase = new UsersDatabaseMapImpl();
        usersDatabase.init();
        userService = new UserServiceImpl(usersDatabase);
    }

    @AfterAll
    void cleanup() {
        // Close connection
        // Delete database
        usersDatabase.close();

    }

    @Test
    @Order(1)
    @DisplayName("Create user works")
    void testCreateUser_whenProvidedWithValidDetails_returnsUserId() {
        
        // Arrange
        Map<String, String> user = new HashMap<>();
        user.put("firstName", "Diego");
        user.put("lastName", "Paulino");

        // Act
        createdUserId = userService.createUser(user);

        // Assert
        assertNotNull(createdUserId, "User ID should not be null");
    }

    @Test
    @Order(2)
    @DisplayName("Update user works")
    void testUpdateUser_whenProvidedWithValidDetails_returnsUpdatedUserDetails() {

        //Arrange
        Map<String, String> newUserDetails = new HashMap<>();
        newUserDetails.put("firstName", "Diogo");
        newUserDetails.put("lastName", "Paulino");

        // Act
        Map updatedUserDetails = userService.updateUser(createdUserId, newUserDetails);

        // Assert
        assertEquals(newUserDetails.get("firstName"), updatedUserDetails.get("firstName"), 
                    "Returned value of user's first name should match the one provided");
        assertEquals(newUserDetails.get("lastName"), updatedUserDetails.get("lastName"), 
                    "Returned value of user's last name should match the one provided");
    }

    @Test
    @Order(3)
    @DisplayName("Find user works")
    void testGetUser_whenProvidedWithValidUserId_returnsUpdatedUserDetails() {
        // Act
        Map userDetails = userService.getUserDetails(createdUserId);

        // Assert
        assertNotNull(userDetails, "User details should not be null");
        assertEquals(createdUserId, userDetails.get("userId"), 
                    "Returned value of user's ID should match the one provided");
    }

    @Test
    @Order(4)
    @DisplayName("Delete user works")
    void testDeleteUser_whenProvidedWithValidUserId_returnsUpdatedUserDetails() {
        
        // Act
        userService.deleteUser(createdUserId);

        // Assert
        assertNull(userService.getUserDetails(createdUserId), 
                    "User details should be null after deletion");
    }

}
