package com.ssafy.ssabob.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostCategory category;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob // 긴 텍스트를 위한 어노테이션
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) // User와의 다대일 관계
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @CreationTimestamp // 엔티티 생성 시 자동으로 시간 기록
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp // 엔티티 수정 시 자동으로 시간 기록
    private LocalDateTime updatedAt;

    @Builder
    public Post(PostCategory category, String title, String content, User author) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.author = author;
    }
}