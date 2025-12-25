// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import org.springframework.stereotype.Component;
// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final String JWT_SECRET = "secretKey123";
//     private final long JWT_EXPIRATION = 86400000; // 1 day

//     public String generateToken(String username) {

//         Date now = new Date();
//         Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

//         return Jwts.builder()
//                 .setSubject(username)
//                 .setIssuedAt(now)
//                 .setExpiration(expiryDate)
//                 .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
//                 .compact();
//     }

//     public String getUsernameFromJWT(String token) {
//         Claims claims = Jwts.parser()
//                 .setSigningKey(JWT_SECRET)
//                 .parseClaimsJws(token)
//                 .getBody();

//         return claims.getSubject();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException ex) {
//             return false;
//         }
//     }
// }
package com.example.demo.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Set;

@Component
public class JwtTokenProvider {

    private final String JWT_SECRET = "yourVeryStrongSecretKeyChangeInProduction1234567890";
    private final long JWT_EXPIRATION = 86400000L;

    public String createToken(Long userId, String email, Set<String> roles) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("email", email)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

    public String getEmail(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return claims.get("email", String.class);
    }

    public Set<String> getRoles(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
        return Set.copyOf(claims.get("roles", Set.class));
    }
}