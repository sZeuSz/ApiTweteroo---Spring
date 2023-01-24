package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetRepository repository;

    @Autowired
    UserRepository userRepository;

    public void insert(TweetDTO tweetDTO) {
        repository.save(new TweetModel(tweetDTO, userRepository));
    }

    public List<TweetModel> getTweets(Integer page) {
        
        return repository.filterByPage(page != null && page >= 0 ? 5 * page : 0);
    }

    public List<TweetModel> getUserTweets(String username) {
        return repository.filterByName(username);
    }
}