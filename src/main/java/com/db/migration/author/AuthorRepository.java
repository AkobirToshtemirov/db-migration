package com.db.migration.author;

import com.db.migration.config.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class AuthorRepository {
    private final DatabaseConfig databaseConfig;

    public AuthorRepository(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public void save(Author author) {
        String sql = "INSERT INTO author (first_name, last_name) VALUES (?, ?)";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, author.getFirstName());
            statement.setString(2, author.getLastName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}