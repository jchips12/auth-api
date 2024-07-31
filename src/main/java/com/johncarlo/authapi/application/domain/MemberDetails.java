package com.johncarlo.authapi.application.domain;

import com.johncarlo.authapi.application.entity.MemberInfo;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class MemberDetails implements UserDetails {

    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public MemberDetails(MemberInfo memberInfo) {
        username = memberInfo.getUsername();
        password = memberInfo.getPassword();
        authorities = memberInfo
                .getMemberRoles()
                .stream()
                .map((roles) -> new SimpleGrantedAuthority(roles.getName()))
                .collect(Collectors.toSet());
    }
}
