package com.sparta.msa_exam.gateway.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class HealthCheckResponseDto {

    private String health;
    private String port;
    private List<String> activeProfiles;

}
