package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.TweetModel;
import com.tweteroo.api.service.TweetService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TweetController {
    
    @Autowired
    private TweetService service;
    
    @PostMapping("/tweets")
    public ResponseEntity<String> post(@RequestBody @Valid TweetDTO tweetDTO) {
        service.insert(tweetDTO);
        return new ResponseEntity("OK", HttpStatus.CREATED);
    }
    @GetMapping("/tweets")
    public List<TweetModel> getTweets(@RequestParam(required = false) Integer page) {
        System.out.println(service.getTweets(page));
        return service.getTweets(page);
    }
}
