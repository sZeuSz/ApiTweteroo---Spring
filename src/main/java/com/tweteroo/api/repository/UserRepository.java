package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.tweteroo.api.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    
    @Query("SELECT u FROM Users u WHERE u.username LIKE :name")
    UserModel filterByName(@Param("name") String name);
}
