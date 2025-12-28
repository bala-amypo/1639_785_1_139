// package com.example.demo.security;

// import com.example.demo.entity.User; // or your user entity
// import com.example.demo.repository.UserRepository;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     private final UserRepository userRepository; // adjust name to your repository

//     public CustomUserDetailsService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username)
//             throws UsernameNotFoundException {

//         User user = userRepository.findByUsername(username)
//                 .orElseThrow(() ->
//                         new UsernameNotFoundException("User not found: " + username));

//         // Map your User entity to Spring Security's UserDetails implementation
//         return org.springframework.security.core.userdetails.User
//                 .withUsername(user.getUsername())
//                 .password(user.getPassword())
//                 .authorities("ROLE_USER") // or map real roles
//                 .build();
//     }
// }







package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Requirement: Throw exception with "User not found" message
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Requirement: Authorities derived from role field (e.g., ROLE_AGENT)
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }
}