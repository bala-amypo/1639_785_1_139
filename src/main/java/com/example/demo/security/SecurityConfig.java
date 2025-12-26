// // package com.example.demo.security;

// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.http.SessionCreationPolicy;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.web.SecurityFilterChain;
// // import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// // @Configuration
// // public class SecurityConfig {

// //     @Autowired
// //     private JwtAuthenticationFilter jwtFilter;

// //     @Bean
// //     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// //         http.csrf().disable()
// //             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
// //             .and()
// //             .authorizeHttpRequests(auth -> auth
// //                 .requestMatchers("/api/auth/**").permitAll()
// //                 .anyRequest().authenticated()
// //             )
// //             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

// //         return http.build();
// //     }

// //     @Bean
// //     public BCryptPasswordEncoder passwordEncoder() {
// //         return new BCryptPasswordEncoder();
// //     }
// // }


// package com.example.demo.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// public class SecurityConfig {

//     @Autowired
//     private JwtAuthenticationFilter jwtFilter;

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//             .authorizeHttpRequests(auth -> auth
//                 // permit both variants – use the one your controllers actually use
//                 .requestMatchers("/api/auth/**", "/auth/**").permitAll()
//                 .anyRequest().authenticated()
//             )
//             .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }