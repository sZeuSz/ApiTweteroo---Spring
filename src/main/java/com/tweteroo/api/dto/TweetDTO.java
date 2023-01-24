package com.tweteroo.api.dto;

import jakarta.validation.constraints.NotNull;

public class TweetDTO {
    @NotNull(message = "o campo username é um campo obrigatório")
    private String username;

    @NotNull(message = "o campo text é um campo obrigatório")
    private String tweet;

    public TweetDTO(){};

    public TweetDTO(String username, String tweet) {
        this.setUsername(username);
        this.setTweet(tweet);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTweet() {
        return this.tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
