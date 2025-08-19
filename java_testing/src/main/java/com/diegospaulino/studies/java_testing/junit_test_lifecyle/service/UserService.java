package com.diegospaulino.studies.java_testing.junit_test_lifecyle.service;

import java.util.Map;

public interface UserService {

    String createUser(Map userDetails);
    Map updateUser(String userId, Map userDetails);
    Map getUserDetails(String userId);
    void deleteUser(String userId);
}
