package com.cib.demo.app;


import com.cib.icarus.spring.annotation.EnableIcarusConfig;
import com.cib.icarus.spring.annotation.IcarusSpringConsts;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableIcarusConfig(value = {IcarusSpringConsts.XSS_ATTACK_MODULE_NAME})
public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) {

        Stopwatch stopWatch = Stopwatch.createStarted();

        SpringApplication springApplication = new SpringApplication(DemoApplication.class);

        ApplicationContextRunningHelper.beforeRunningStep(springApplication, args);

        ConfigurableApplicationContext context = springApplication.run(args);

        ApplicationContextRunningHelper.afterRunningStep(context, springApplication, args);

        callback(context, stopWatch);
    }


    private static void callback(ConfigurableApplicationContext context, Stopwatch stopWatch) {
        stopWatch.stop();
        String name = context.getEnvironment().getProperty("spring.application.name");
        String port = context.getEnvironment().getProperty("server.port");
        logger.info("======服务{}:{}启动成功，本次启动累计耗时{}毫秒======", name, port, stopWatch.elapsed(TimeUnit.MILLISECONDS));
    }


}
