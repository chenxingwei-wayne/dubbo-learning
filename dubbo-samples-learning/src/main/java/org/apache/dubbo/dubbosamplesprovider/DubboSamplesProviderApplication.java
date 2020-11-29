package org.apache.dubbo.dubbosamplesprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class DubboSamplesProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboSamplesProviderApplication.class, args);
	}

}
