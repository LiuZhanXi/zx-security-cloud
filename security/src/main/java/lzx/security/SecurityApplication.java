package lzx.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname AuthenicationApplication
 * @Description
 * @Date 2021/4/15 3:39 下午
 * @Email zhanxi.liu@seaboxdata.com
 * @author liuzhanxi
 */
@SpringBootApplication(scanBasePackages = {"lzx.security"})
public class SecurityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class,args);
	}
}
