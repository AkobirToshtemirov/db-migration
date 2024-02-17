package com.db.migration.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Long authorId;
}
