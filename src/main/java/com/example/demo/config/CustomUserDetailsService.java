// package com.example.demo.security;

// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         // Simple in-memory user for demo - replace with database later
//         if ("user".equals(username)) {
//             return org.springframework.security.core.userdetails.User.builder()
//                 .username("user")
//                 .password("{noop}password")  // {noop} for plain text
//                 .roles("USER")
//                 .build();
//         }
//         throw new UsernameNotFoundException("User not found: " + username);
//     }
// }







package com.example.demo.security;  // ✅ CORRECT PACKAGE

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        if ("user".equals(username)) {
            return User.builder()
                .username("user")
                .password("{noop}password")
                .authorities("ROLE_USER")
                .build();
        } else if ("admin".equals(username)) {
            return User.builder()
                .username("admin")
                .password("{noop}adminpass")
                .authorities("ROLE_USER", "ROLE_ADMIN")
                .build();
        }
        
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
