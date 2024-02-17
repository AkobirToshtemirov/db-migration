package com.db.migration.post;

import com.db.migration.config.DatabaseConfig;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class PostRepository {
    private final DatabaseConfig databaseConfig;

    public PostRepository(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

    public void save(Post post) {
        String sql = "INSERT INTO post (title, description, author_id) VALUES (?, ?, ?)";
        try (Connection connection = databaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, post.getTitle());
            statement.setString(2, post.getDescription());
            statement.setLong(3, post.getAuthorId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
