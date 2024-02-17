CREATE TABLE IF NOT EXISTS post
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255),
    description TEXT,
    author_id   BIGINT,
    FOREIGN KEY (author_id) REFERENCES author (id)
);