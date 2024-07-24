package com.johncarlo.authapi.application;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class MemberUserDetails extends UserInfo implements UserDetails {

    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public MemberUserDetails(UserInfo userInfo) {
        username = userInfo.getUsername();
        password = userInfo.getPassword();
        authorities = userInfo
                .getUserRoles()
                .stream()
                .map((roles) -> new SimpleGrantedAuthority(roles.getName()))
                .collect(Collectors.toSet());
    }
}
