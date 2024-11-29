package com.sparta.msa_exam.product.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
public class HealthCheckResponseDto {

    private String health;
    private List<String> activeProfiles;

}
