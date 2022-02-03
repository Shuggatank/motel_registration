package com.motelreg.motel_registration.containertests;

import org.testcontainers.containers.PostgreSQLContainer;

public class BaseContainerTest {
    // Settings for the PostgreSQL docker database
    static PostgreSQLContainer postgresContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:latest")
            .withDatabaseName("spring-project-test-db")
            .withUsername("postgres")
            .withPassword("postgres")
            .withReuse(true);
    static {
        postgresContainer.start();
    }
}
