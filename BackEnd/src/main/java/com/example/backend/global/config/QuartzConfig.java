package com.example.backend.global.config;

import com.example.backend.global.component.SampleJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 이 클래스는 Quartz 스케줄링 설정을 담당합니다.
 * JobDetail 및 Trigger를 정의하여 Quartz 작업을 예약할 수 있습니다.
 */
@Configuration
public class QuartzConfig {

    /**
     * Quartz Job의 세부 정보를 정의합니다.
     * Job 클래스는 실행될 작업의 로직을 포함하는 {@link SampleJob}입니다.
     *
     * @return JobDetail 객체
     */
    @Bean
    public JobDetail sampleJobDetail() {
        return JobBuilder.newJob(SampleJob.class) // 실행될 Job 클래스 지정
            .withIdentity("sampleJob", "group1") // Job의 이름과 그룹 설정
            .storeDurably() // Job을 영구적으로 저장하여 Trigger 없이도 유지 가능
            .build();
    }

    /**
     * 특정 JobDetail을 반복 실행하도록 설정하는 Quartz Trigger를 정의합니다.
     * 이 예제에서는 10초 간격으로 반복 실행됩니다.
     *
     * @param sampleJobDetail 트리거가 실행할 JobDetail
     * @return Trigger 객체
     */
    @Bean
    public Trigger sampleJobTrigger(JobDetail sampleJobDetail) {
        // 반복 실행 스케줄 설정: 10초 간격으로 반복
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
            .withIntervalInSeconds(10) // 10초 마다 실행
            .repeatForever(); // 무한 반복

        // Trigger 생성
        return TriggerBuilder.newTrigger()
            .forJob(sampleJobDetail) // 위에서 정의한 JobDetail과 연결
            .withIdentity("sampleTrigger", "group1") // Trigger의 이름과 그룹 설정
            .withSchedule(scheduleBuilder) // 스케줄 설정
            .build();
    }
}
