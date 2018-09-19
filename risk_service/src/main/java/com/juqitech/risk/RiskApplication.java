package com.juqitech.risk;

import com.juqitech.service.utils.PropertyRepository;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class, SessionAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.juqitech.risk","com.juqitech.sneeze"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {com.juqitech.service.routing.ReadOnlyConnectionInterceptor.class, com.juqitech.service.endpoint.MonitorEndpoint.class})
//})
@MapperScan({"com.juqitech.risk.mapper"})
@EnableDiscoveryClient
@EnableFeignClients()
@EnableEurekaClient
@EnableSwagger2
public class RiskApplication extends SpringBootServletInitializer {

    private static Logger logger = LoggerFactory.getLogger(RiskApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RiskApplication.class);
    }

    static {
        try {
            PropertyRepository.init("global.properties");
            PropertyRepository.init("risk.properties");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(RiskApplication.class, args);
    }
}
