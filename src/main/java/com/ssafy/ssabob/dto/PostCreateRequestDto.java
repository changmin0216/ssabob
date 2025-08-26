package com.ssafy.ssabob.dto;

import com.ssafy.ssabob.domain.Post;
import com.ssafy.ssabob.domain.PostCategory;
import com.ssafy.ssabob.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateRequestDto {

    private String category;
    private String title;
    private String content;

    public Post toEntity(User author) {
        return Post.builder()
                .category(PostCategory.valueOf(this.category))
                .title(this.title)
                .content(this.content)
                .author(author)
                .build();
    }
}
