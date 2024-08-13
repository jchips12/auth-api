package com.johncarlo.authapi.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupRequestDTO {

    private String firstName;
    private String lastName;
    private String email;

    private String username;
    private String password;

}
