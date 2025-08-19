package com.diegospaulino.studies.java_testing.junit_test_lifecyle.io;

import java.util.Map;

public interface UsersDatabase {

    void init();
    void close();

    Map save(String userId, Map userDetails);
    Map find(String userId);
    Map update(String userId, Map existingUser);
    void delete(String userId);

}
