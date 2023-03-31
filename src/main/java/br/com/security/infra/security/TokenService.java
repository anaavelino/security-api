package br.com.security.infra.security;

import br.com.security.domain.user.Users;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Configuration
@EnableWebSecurity
@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Users user){
        try {
            var algorithn = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Security")
                    .withSubject(user.getEmail())
                    .withExpiresAt(dataExpiration())
                    .withClaim("name",user.getUsername())
                    .withClaim("email", user.getEmail())
                    .withClaim("city", user.getCity())
                    .sign(algorithn);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("erro ao gerar token", exception);
        }
    }

    public String getSubject(String tokenJWT){
        try {
            var algorithm2 = Algorithm.HMAC256(secret);
            var object =  JWT.require(algorithm2)
                    .withIssuer("API Security")
                    .build()
                    .verify(tokenJWT).getSubject();
            return object;
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token Inválido ou Expirado! ");
        }
    }

    private Instant dataExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}