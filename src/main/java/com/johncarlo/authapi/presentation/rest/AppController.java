package com.johncarlo.authapi.presentation.rest;

import com.johncarlo.authapi.application.service.JwtService;
import com.johncarlo.authapi.presentation.dto.AuthRequestDTO;
import com.johncarlo.authapi.presentation.dto.AuthResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AppController {

    private final JwtService jwtService;
    private final AuthenticationConfiguration authenticationConfiguration;


    @PostMapping("/login")
    public AuthResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) throws Exception {
        Authentication authentication = authenticationConfiguration.getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            return AuthResponseDTO.builder().accessToken(jwtService.generateToken(authRequestDTO.getUsername())).build();
        } else {
            throw new UsernameNotFoundException("Invalid user login or password..!!");
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/ping")
    public String test() {
        try {
            return "Welcome";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}