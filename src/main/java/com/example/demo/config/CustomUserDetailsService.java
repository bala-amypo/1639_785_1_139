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







package com.example.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // Demo users - Replace with repository.findByUsername(username) in production
        if ("user".equals(username)) {
            return buildUser("user", "{noop}password", "ROLE_USER");
        } else if ("admin".equals(username)) {
            return buildUser("admin", "{noop}adminpass", "ROLE_USER", "ROLE_ADMIN");
        }
        
        throw new UsernameNotFoundException("User not found: " + username);
    }
    
    private org.springframework.security.core.userdetails.User buildUser(
            String username, String password, String... roles) {
        
        List<GrantedAuthority> authorities = Arrays.stream(roles)
                .map(role -> new SimpleGrantedAuthority(role))
                .toList();
        
        return org.springframework.security.core.userdetails.User.builder()
                .username(username)
                .password(password)
                .authorities(authorities)
                .build();
    }
}
