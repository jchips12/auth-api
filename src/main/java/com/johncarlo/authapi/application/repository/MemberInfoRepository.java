package com.johncarlo.authapi.application.repository;

import com.johncarlo.authapi.application.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Long> {

    MemberInfo findByUsername(String username);
}
