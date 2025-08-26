package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class PostDetailResponseDto {

    private final Long id;
    private final String category;
    private final String title;
    private final String content;
    private final Long authorId;
    private final String authorName;
    private final LocalDateTime createdAt;

    // --- Phase 2 추가 필드 ---
    private final long participantCount;
    private final boolean isUserParticipating;
    private final List<CommentResponseDto> comments;


    public PostDetailResponseDto(Post entity, long participantCount, boolean isUserParticipating, List<CommentResponseDto> comments) {
        this.id = entity.getId();
        this.category = entity.getCategory().getDescription();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.authorId = entity.getAuthor().getId();
        this.authorName = entity.getAuthor().getName();
        this.createdAt = entity.getCreatedAt();
        this.participantCount = participantCount;
        this.isUserParticipating = isUserParticipating;
        this.comments = comments;
    }
}
