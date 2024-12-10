package com.example.backend.global.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleScheduler {

    @Scheduled(fixedRate = 5000) // 5초마다 실행
    public void runTaskWithFixedRate() {
        log.info("Fixed Rate Task: " + System.currentTimeMillis());
    }

    @Scheduled(cron = "0 0/1 * * * ?") // 매 분마다 실행
    public void runTaskWithCron() {
        log.info("Cron Task: " + System.currentTimeMillis());
    }
}
