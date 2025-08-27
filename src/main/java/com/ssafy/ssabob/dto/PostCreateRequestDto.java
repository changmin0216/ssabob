package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.Post;
import com.ssafy.ssabob.domain.PostCategory;
import com.ssafy.ssabob.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostCreateRequestDto {

    private String category;
    private String title;
    private String content;

    // 약속(이벤트) 정보
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime eventTime;
    private String location;
    private int capacity;

    public Post toEntity(User author) {
        return Post.builder()
                .category(PostCategory.valueOf(this.category))
                .title(this.title)
                .content(this.content)
                .author(author)
                .eventTime(this.eventTime)
                .location(this.location)
                .capacity(this.capacity)
                .build();
    }
}
