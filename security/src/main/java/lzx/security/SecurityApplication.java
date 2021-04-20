package lzx.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Classname AuthenicationApplication
 * @Description 启动类
 * @Date 2021/4/15 3:39 下午
 * @author liuzhanxi
 */
@SpringBootApplication(scanBasePackages = {"lzx.security"})
@MapperScan(value = "lzx.security.mapper")
@EnableScheduling
public class SecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class,args);
	}
}
