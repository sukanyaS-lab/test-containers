package com.rs;

import org.jetbrains.annotations.NotNull;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
@Testcontainers
@TestConfiguration(proxyBeanMethods = false)
class Demo1ApplicationTests1 {

	@Container
	static GenericContainer<?> cont = new GenericContainer<>("postgres:latest");




//
//	@DynamicPropertySource
//	static void postgresProperties(DynamicPropertyRegistry registry) {
//		registry.add("spring.datasource.url", () -> cont.getJdbcUrl() != null ? cont.getJdbcUrl() : "jdbc:postgresql://localhost:5432/demodb");
//		registry.add("spring.datasource.username", () -> cont.getContainerName() != null ? cont.getContainerName() : "postgres_con");
//		registry.add("spring.datasource.password", () -> cont.getPassword() != null ? cont.getPassword() : "root");
//	}

	/*@DynamicPropertySource
	static void postgresProperties(DynamicPropertyRegistry registry) {
		cont.start();
	    registry.add("spring.datasource.url", () -> "jdbc:postgresql://localhost:5432/postgres_con"); // Access the JDBC URL  //cont.getJdbcUrl()
	    registry.add("spring.datasource.username", () -> cont.getEnvMap().get("POSTGRES_USER")); // Get the PostgreSQL user
	    registry.add("spring.datasource.password", () -> cont.getEnvMap().get("POSTGRES_PASSWORD")); // Get the PostgreSQL password
	}*/


//	 private static final DockerComposeContainer<?> environment =
//			 new DockerComposeContainer<>(new File("src/test/resources/docker-compose.yml"))
//					 .withExposedService("postgres", 5432);

	@Container
	private static final PostgreSQLContainer<?> postgreSQLContainer;

    static {
        postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
                .withDatabaseName("mydb")
                .withUsername("admin")
                .withPassword("secret");
    }

    @DynamicPropertySource
	static void configureProperties(@NotNull DynamicPropertyRegistry registry) {
		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
	}

//	@Bean
//	@ServiceConnection(name = "redis")
//	public GenericContainer<?> redisContainer() {
//		return new GenericContainer<>("redis:7");
//	}

	@BeforeClass
	public static void setUp() {
		postgreSQLContainer.start();
	}

	@AfterClass
	public static void tearDown() {
		postgreSQLContainer.stop();
	}

	@Test
	public void contextLoads() {

		System.out.println("JDBC URL: " + postgreSQLContainer.getJdbcUrl());
	}

}

//The method add(String, Supplier<Object>) in the type DynamicPropertyRegistry is not applicable for the arguments (String, () -> {})
