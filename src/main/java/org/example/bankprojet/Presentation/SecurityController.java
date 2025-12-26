package org.example.bankprojet.Presentation;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")

public class SecurityController {
@Autowired
    private AuthenticationManager autenticationManager;
@Autowired
    private JwtEncoder jwtEecoder;
    @GetMapping("/profile")
    public Authentication authentication(Authentication a){
        return a;
    }
   @PostMapping("/login")
    public Map<String,String> login(String username, String password){
Authentication auth= autenticationManager.authenticate
        (new UsernamePasswordAuthenticationToken(username, password));
Instant instant = Instant.now();
String scope=auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet= JwtClaimsSet.builder()
                .issuedAt(instant)
                .expiresAt(instant.plus(10, ChronoUnit.MINUTES))
                .subject(username)
                .claim("scope",scope)
                .build();
        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(
                JwsHeader.with(MacAlgorithm.HS256).build(),jwtClaimsSet
        );
        String jwt= jwtEecoder.encode(jwtEncoderParameters).getTokenValue();
return Map.of("access-token",jwt);
    }

}
