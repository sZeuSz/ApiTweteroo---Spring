package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public void create(UserDTO body) {
        repository.save(new UserModel(body));
    }

    public List<UserModel> getUsers() {
        
        return repository.findAll();
    }
}
