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







// package com.example.demo.security;

// import com.example.demo.entity.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     @Autowired
//     private UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User user = userRepository.findByUsername(username)
//             .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

//         return org.springframework.security.core.userdetails.User.builder()
//             .username(user.getUsername())
//             .password(user.getPassword())
//             .authorities(user.getRoles().split(","))
//             .build();
//     }
// }
