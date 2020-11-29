package org.apache.dubbo.dubbosamplesprovider.annotation.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "org.apache.dubbo.dubbosamplesprovider.annotation.action")
@PropertySource("classpath:/spring/dubbo-consumer.properties")
@ComponentScan(value = {"org.apache.dubbo.dubbosamplesprovider.annotation.action"})
public class ConsumerConfiguration {
}
