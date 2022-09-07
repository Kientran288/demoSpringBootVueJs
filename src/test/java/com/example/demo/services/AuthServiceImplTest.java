package com.example.demo.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceImplTest {
    @Autowired
    NoteService noteService;

    @Test
    void authenticateUser() {
//        Mockito.when(authService.authenticateUser(Mockito.any(LoginRequest.class)))
////                .thenReturn(Mockito.any());
    }

    @Test
    void registerUser() {
    }
}