package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tweteroo.api.model.TweetModel;

import java.util.List;

public interface TweetRepository extends JpaRepository<TweetModel, Long> {

    @Query("SELECT t FROM Tweets t ORDER BY t.id DESC LIMIT 5 OFFSET :page")
    List<TweetModel> filterByPage(@Param("page") int page);

    @Query("SELECT t FROM Tweets t WHERE t.username LIKE :name ORDER BY t.id DESC")
    List<TweetModel> filterByName(@Param("name") String name);
}