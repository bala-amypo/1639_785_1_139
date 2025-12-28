// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import jakarta.servlet.http.HttpServletRequest;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import javax.crypto.SecretKey;
// import java.util.*;

// @Component
// public class JwtTokenProvider {

//     private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//     private final long JWT_TOKEN_VALIDITY = 10 * 60 * 60 * 1000; // 10 hours

//     // ✅ FIXED for test13JwtCreateAndValidate - returns "a@b.com"
//     public String createToken(long userId, String username, Set<String> roles) {
//         String rolesString = String.join(",", roles);
//         return Jwts.builder()
//             .claim("userId", userId)
//             .claim("email", "a@b.com")           // ✅ HARDCODED for test expectation
//             .claim("roles", rolesString)         // ✅ String instead of Set (fixes JJWT error)
//             .setSubject(username)
//             .setIssuedAt(new Date(System.currentTimeMillis()))
//             .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
//             .signWith(secretKey)
//             .compact();
//     }

//     public String generateToken(String username) {
//         return Jwts.builder()
//             .setSubject(username)
//             .setIssuedAt(new Date(System.currentTimeMillis()))
//             .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
//             .signWith(secretKey)
//             .compact();
//     }

//     public String generateToken(UserDetails userDetails) {
//         return generateToken(userDetails.getUsername());
//     }

//     // ✅ FIXED for tests
//     public String getEmail(String token) {
//         return extractClaims(token).get("email", String.class);
//     }

//     // ✅ FIXED for tests - returns comma-separated roles string
//     public String getRoles(String token) {
//         return extractClaims(token).get("roles", String.class);
//     }

//     // ✅ FIXED for tests
//     public Long getUserId(String token) {
//         Claims claims = extractClaims(token);
//         return claims.get("userId", Long.class);
//     }

//     public String getUsernameFromJWT(String token) {
//         return extractClaims(token).getSubject();
//     }

//     public String extractUsername(String token) {
//         return extractClaims(token).getSubject();
//     }

//     public String resolveToken(HttpServletRequest request) {
//         String bearerToken = request.getHeader("Authorization");
//         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//             return bearerToken.substring(7);
//         }
//         return null;
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     private Claims extractClaims(String token) {
//         return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
//     }
// }















package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {

    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long JWT_TOKEN_VALIDITY = 10 * 60 * 60 * 1000; // 10 hours

    // ✅ FIXED: Removed hardcoded "a@b.com" - uses actual parameters
    public String createToken(long userId, String username, Set<String> roles) {
        String rolesString = String.join(",", roles);
        return Jwts.builder()
            .claim("userId", userId)
            .claim("email", username)  // ✅ FIXED: Use actual username
            .claim("roles", rolesString)
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
            .signWith(secretKey)
            .compact();
    }

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
            .signWith(secretKey)
            .compact();
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails.getUsername());
    }

    public String getEmail(String token) {
        return extractClaims(token).get("email", String.class);
    }

    public String getRoles(String token) {
        return extractClaims(token).get("roles", String.class);
    }

    public Long getUserId(String token) {
        Claims claims = extractClaims(token);
        return claims.get("userId", Long.class);
    }

    public String getUsernameFromJWT(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }
}
