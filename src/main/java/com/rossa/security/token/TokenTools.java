package com.rossa.security.token;

import com.rossa.security.objects.AuthenticationToken;
import com.rossa.security.objects.UserCredential;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Class responsible for handling things with token exchanged by Angular app and Java server.
 *
 * @author wim
 *
 */
@Component
public class TokenTools {
  private static final Logger LOGGER = Logger.getLogger(TokenTools.class.getName());
  @Value("${globema.jwt.expirationHours:1}")
  private Integer DEFAULT_EXPIRATION_HOURS;
  @Value("${globema.jwt.secret}")
  private String secret;

  public AuthenticationToken createTokenForUser(UserCredential executor) {
    Date res = createValidationDate(DEFAULT_EXPIRATION_HOURS);
    String token = Jwts.builder().setSubject(executor.getLogin()).claim("roles", "user").setExpiration(res).signWith(SignatureAlgorithm.HS512, secret).compact();
    return new AuthenticationToken(token);
  }

  private Date createValidationDate(int validHours) {
    LocalDateTime expirationLocal = LocalDateTime.now().plusHours(validHours);
    Instant instant = expirationLocal.atZone(ZoneId.systemDefault()).toInstant();
    Date res = Date.from(instant);
    return res;
  }

  public String parseAuthenticationFromToken(String token) {
    try {
      Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      Date d = claims.getBody().getExpiration();
      if (d == null || createValidationDate(0).after(d)) {
        return null;
      }
      String login = claims.getBody().getSubject();
      return login;
    } catch (Exception ex) {
      LOGGER.severe("Exception throwed in method: parseAuthenticationFromToken. Cause: " + ex.getMessage());
    }
    return null;
  }
}
