package com.example.backend.global.config;

import com.example.backend.global.component.SampleJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail sampleJobDetail() {
        return JobBuilder.newJob(SampleJob.class)
            .withIdentity("sampleJob", "group1") // Job의 이름과 그룹 설정
            .storeDurably() // Job을 영구 저장
            .build();
    }

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
            .withSchedule(scheduleBuilder)
            .build();
    }
}
