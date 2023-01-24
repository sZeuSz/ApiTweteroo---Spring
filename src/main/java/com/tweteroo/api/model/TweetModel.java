package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.repository.UserRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "Tweets")
@NoArgsConstructor
@Table(name = "tweets")
public class TweetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String text;
    private String avatar;

    public TweetModel(TweetDTO data, UserRepository repository) {
        this.username = data.getUsername();
        this.text = data.getTweet();
        this.avatar = (repository.filterByName(this.username)).getAvatar();
    }
}
