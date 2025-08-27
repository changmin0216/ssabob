package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.Post;
import lombok.Getter;

@Getter
public class PostListResponseDto {
    private final Long id;
    private final String category;
    private final String title;
    private final String authorName;
    private final String location;
    private final long participantCount;
    private final int capacity;
    private final long likeCount;

    public PostListResponseDto(Post entity, long participantCount, long likeCount) {
        this.id = entity.getId();
        this.category = entity.getCategory().getDescription();
        this.title = entity.getTitle();
        this.authorName = entity.getAuthor().getName();
        this.location = entity.getLocation();
        this.capacity = entity.getCapacity();
        this.participantCount = participantCount;
        this.likeCount = likeCount;
    }
}
