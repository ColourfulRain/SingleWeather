package com.li.weather.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：lqq
 * @ClassName：QuarzConfiguration
 * @Time：2020/1/14
 * @Describe：配置Quartz
 */
@Configuration
public class QuartzConfiguration {

    //JobDetail主要用来定义一个特定的Job
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        //通过jobBuilder创建一个job
        return JobBuilder.newJob(WeatherDataSynJob.class).withIdentity("weatherDataSynJob")
                .storeDurably().build();
    }
    //Trigger怎么样的形式触发
    @Bean
    public Trigger weatherDataSyncTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1800).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
