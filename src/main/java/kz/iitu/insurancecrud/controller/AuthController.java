package kz.iitu.insurancecrud.controller;

import kz.iitu.insurancecrud.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthController {
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        log.debug("Requested authentication for user: {}", authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.debug("Token granted: {}", token);
        return token;
    }
}
