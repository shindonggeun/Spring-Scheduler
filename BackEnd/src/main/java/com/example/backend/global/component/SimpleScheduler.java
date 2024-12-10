package com.example.backend.global.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Spring 스케줄링 기능을 활용한 작업을 정의하는 클래스입니다.
 * <ul>
 * <li>고정된 주기로 실행되는 작업</li>
 * <li>CRON 표현식을 사용하여 실행되는 작업</li>
 * </ul>
 */
@Slf4j
@Component
public class SimpleScheduler {

    /**
     * 고정된 주기로 실행되는 작업 메서드
     * <p>
     * 이 메서드는 매 5초마다 실행됩니다.
     */
    @Scheduled(fixedRate = 5000) // 5초마다 실행
    public void runTaskWithFixedRate() {
        log.info("Fixed Rate Task: {}", System.currentTimeMillis());
    }

    /**
     * CRON 표현식을 기반으로 실행되는 작업
     * <p>
     * 이 메서드는 매 분마다 실행됩니다.
     */
    @Scheduled(cron = "0 0/1 * * * ?") // 매 분마다 실행
    public void runTaskWithCron() {
        log.info("Cron Task: {}", System.currentTimeMillis());
    }
}
