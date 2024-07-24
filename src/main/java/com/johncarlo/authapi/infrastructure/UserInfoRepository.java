package com.johncarlo.authapi.infrastructure;

import com.johncarlo.authapi.application.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
}
