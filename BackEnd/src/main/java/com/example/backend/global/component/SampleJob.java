package com.example.backend.global.component;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * Quartz Job으로 실행될 작업의 로직을 정의합니다.
 * <p>
 * Quartz Job은 execute 메서드를 통해 실행됩니다.
 */
@Slf4j
@Component
public class SampleJob implements Job {

    /**
     * 작업 실행 로직 메서드
     * <p>
     * Quartz 스케줄러에 의해 트리거될 때 실행됩니다.
     *
     * @param jobExecutionContext Quartz JobExecutionContext 객체
     * @throws JobExecutionException 작업 실행 중 예외 발생 시
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Executing Sample Job at: {}", System.currentTimeMillis());
    }
}
