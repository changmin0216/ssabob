package com.ssafy.ssabob.domain;

public enum PostCategory {
    BAP_YAK("밥약"),
    COFFEE_CHAT("커피챗"),
    STUDY("스터디");

    private final String description;

    PostCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}