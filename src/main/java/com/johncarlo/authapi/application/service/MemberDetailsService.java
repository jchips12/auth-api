package com.johncarlo.authapi.application.service;

import com.johncarlo.authapi.application.domain.MemberDetails;
import com.johncarlo.authapi.application.entity.MemberInfo;
import com.johncarlo.authapi.application.repository.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberDetailsService implements UserDetailsService {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberInfo memberInfo = memberInfoRepository.findByUsername(username);
        if (memberInfo == null) {
            throw new UsernameNotFoundException("could not found user..!!");
        }
        return new MemberDetails(memberInfo);
    }
}
