package com.rs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.io.File;

@SpringBootTest
@Testcontainers
@TestConfiguration(proxyBeanMethods = false)
public class Demo1ApplicationTests {
	//    @Container//
	//    @ServiceConnection//
	//    private static PostgreSQLContainer<?> postgreSQLContainer =
	//    new PostgreSQLContainer<>("postgres:latest")//
	//    .withDatabaseName("mydb")//
	//    .withUsername("admin")//
	//    .withPassword("secret")//
	//    .waitingFor(Wait.forListeningPort());;////
	//
	//    @DynamicPropertySource//
	//    static void configureProperties(DynamicPropertyRegistry registry) {//
	//    registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);//
	//    registry.add("spring.datasource.password", postgreSQLContainer::getPassword);//
	//    registry.add("spring.datasource.username", postgreSQLContainer::getUsername);//
	//    }
	//
	//    @Bean
	//    @ServiceConnection(name = "redis")
	//    public GenericContainer<?> redisContainer() {
	//    	return new GenericContainer<>("redis:latest");
	//   }
	//
	   	@Test
	   	public void contextLoads() {
	   	}
}