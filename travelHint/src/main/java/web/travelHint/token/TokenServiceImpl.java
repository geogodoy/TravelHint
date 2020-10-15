package web.travelHint.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import web.travelHint.usuario.Usuario;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService{

    private static final long expirationTime = 1800000;
    private static final String key = "teste";

    @Override
    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setSubject(usuario.getNome())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.ES256.HS256, key)
                .compact();
    }

    @Override
    public Claims decodeToken(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }
}
