package com.motelreg.motel_registration;

import org.testcontainers.containers.PostgreSQLContainer;

public class BaseContainerTest {

    static PostgreSQLContainer postgresContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:latest")
            .withDatabaseName("spring-project-test-db")
            .withUsername("postgres")
            .withPassword("postgres")
            .withReuse(true);
    static {
        postgresContainer.start();
    }
}
