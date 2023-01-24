package com.tweteroo.api.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {
    
    @Autowired
    UserService service;

    @PostMapping("/sign-up")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Valid UserDTO body) {

        service.create(body);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Criado com sucesso");
        
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return service.getUsers();
    }
}
