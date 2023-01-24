package com.tweteroo.api.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.service.UserService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class UserController {
    
    @Autowired
    UserService service;

    @PostMapping("/sign-up")
    public ResponseEntity<Map<String, String>> create(@RequestBody @Valid UserDTO body) {

        service.create(body);

        Map<String, String> response = new HashMap<>();
        response.put("message", "OK");

        return new ResponseEntity<Map<String, String>>(response, HttpStatus.CREATED);
    }
}
