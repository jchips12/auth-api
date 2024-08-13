package com.johncarlo.authapi.presentation.rest;

import com.johncarlo.authapi.application.service.JwtService;
import com.johncarlo.authapi.presentation.dto.AuthRequestDTO;
import com.johncarlo.authapi.presentation.dto.AuthResponseDTO;
import com.johncarlo.authapi.presentation.dto.SignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class AppController {

    private final JwtService jwtService;
    private final AuthenticationConfiguration authenticationConfiguration;

    @PostMapping("/login")
    public AuthResponseDTO authenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO) throws Exception {
        Authentication authentication = authenticationConfiguration.getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if (authentication.isAuthenticated()) {
            return AuthResponseDTO.builder().accessToken(jwtService.generateToken(authRequestDTO.getUsername())).build();
        } else {
            throw new UsernameNotFoundException("Invalid user login or password..!!");
        }
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody SignupRequestDTO signupRequestDTO) {

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/ping")
    public Map<String, String> test(Principal principal) {
        return Map.of("message", "Hello " + principal.getName());
    }

}