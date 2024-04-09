package com.soraohayou.positioningmonitoring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
@MapperScan("com.soraohayou.positioningmonitoring.dao")
@SpringBootApplication
public class PositioningMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PositioningMonitoringApplication.class, args);
    }

}
