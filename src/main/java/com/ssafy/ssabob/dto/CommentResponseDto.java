package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private final Long id;
    private final String content;
    private final Long authorId;
    private final String authorName;
    private final LocalDateTime createdAt;

    public CommentResponseDto(Comment entity) {
        this.id = entity.getId();
        this.content = entity.getContent();
        this.authorId = entity.getAuthor().getId();
        this.authorName = entity.getAuthor().getName();
        this.createdAt = entity.getCreatedAt();
    }
}
