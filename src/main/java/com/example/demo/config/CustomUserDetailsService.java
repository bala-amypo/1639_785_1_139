package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Simple in-memory user for demo - replace with database later
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User.builder()
                .username("user")
                .password("{noop}password")  // {noop} for plain text
                .roles("USER")
                .build();
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
