package com.db.migration.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DatabaseConfig {
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Failed to load JDBC driver class: " + driverClassName);
        }
        return DriverManager.getConnection(url, username, password);
    }
}