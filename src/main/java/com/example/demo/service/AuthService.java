package com.example.demo.service;

import com.example.demo.model.AuthService;
import java.util.List;

public interface  AuthService{
    User register();
    User login();
}