package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.dto.response.HealthCheckResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApiController {

    private final Environment environment;

    // TODO: 추후 actuator 사용해서 healthCheck 진행?
    @GetMapping("/health-check")
    public ResponseEntity<HealthCheckResponseDto> healthCheck(){
        HealthCheckResponseDto healthCheckResponseDto = HealthCheckResponseDto.builder()
                .health("ok")
                .activeProfiles(List.of(environment.getActiveProfiles()))
                .build();
        return ResponseEntity.ok(healthCheckResponseDto);
    }

}
