package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.Post;
import lombok.Getter;

@Getter
public class PostListResponseDto {
    private final Long id;
    private final String category;
    private final String title;
    private final String authorName;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.category = entity.getCategory().getDescription();
        this.title = entity.getTitle();
        this.authorName = entity.getAuthor().getName();
    }
}
