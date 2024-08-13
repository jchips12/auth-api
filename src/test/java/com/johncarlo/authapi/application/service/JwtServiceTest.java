package com.johncarlo.authapi.application.service;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtServiceTest {

    private final JwtService jwtService = new JwtService(100000);

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateToken_returnsValidToken() {
        // Arrange
        String username = "john";
        // Act
        String token = jwtService.generateToken(username);
        // Assert
        assertNotNull(token);
    }

    @Test
    void extractUsername_returnsUsername() {
        // Arrange
        String username = "john";
        String token = jwtService.generateToken(username);
        // Act
        String extractedUsername = jwtService.extractUsername(token);
        // Assert
        assertNotNull(extractedUsername);
    }

    @Test
    void extractExpiration_returnsExpirationDate() {
        // Arrange
        String username = "john";
        String token = jwtService.generateToken(username);
        // Act
        var expiration = jwtService.extractExpiration(token);
        // Assert
        assertNotNull(expiration);
    }

    @Test
    void extractClaim_returnsClaim() {
        // Arrange
        String username = "john";
        String token = jwtService.generateToken(username);
        // Act
        var claim = jwtService.extractClaim(token, Claims::getSubject);
        // Assert
        assertNotNull(claim);
    }

}