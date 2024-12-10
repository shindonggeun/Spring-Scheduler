package com.example.backend.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 이 클래스는 Spring의 기본 스케줄링 기능을 활성화합니다.
 * 스케줄러 작업을 수행하려면 @EnableScheduling 어노테이션이 필요합니다.
 */
@Configuration
@EnableScheduling
public class SchedulerConfig {
    // 이 클래스 자체에는 추가 로직이 없으며, 스케줄링 활성화를 위한 설정만 수행합니다.
}
