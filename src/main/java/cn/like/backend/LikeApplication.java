package cn.like.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author like
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LikeApplication {

    public static void main(String[] args) {

        SpringApplication.run(LikeApplication.class, args);
        System.out.println("----------------------- 系统启动成功 -------------------------");
    }
}
