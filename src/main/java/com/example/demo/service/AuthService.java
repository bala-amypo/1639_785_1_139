package com.example.demo.service;

import com.example.demo.AuthService;
import com.example.demo.User;
import java.util.List;

public interface  AuthService{
    User register();
    User login();
}