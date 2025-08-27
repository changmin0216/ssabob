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

    // --- 약속(이벤트) 정보 ---
    private final LocalDateTime eventTime;
    private final String location;
    private final int capacity;

    // --- 상호작용 정보 ---
    private final long participantCount;
    private final boolean isUserParticipating;
    private final long likeCount;
    private final boolean isUserLiking;


    public PostDetailResponseDto(Post entity, long participantCount, boolean isUserParticipating, long likeCount, boolean isUserLiking, List<CommentResponseDto> comments) {
        this.id = entity.getId();
        this.category = entity.getCategory().getDescription();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.authorId = entity.getAuthor().getId();
        this.authorName = entity.getAuthor().getName();
        this.createdAt = entity.getCreatedAt();
        this.eventTime = entity.getEventTime();
        this.location = entity.getLocation();
        this.capacity = entity.getCapacity();
        this.participantCount = participantCount;
        this.isUserParticipating = isUserParticipating;
        this.likeCount = likeCount;
        this.isUserLiking = isUserLiking;
    }
}
