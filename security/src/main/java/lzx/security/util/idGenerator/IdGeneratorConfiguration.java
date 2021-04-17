package lzx.security.util.idGenerator;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "lzx.idgenerator")
@Setter
@Slf4j
/**
 * @author liuzhanxi
 * @Description  idGenerator配置类
 * @Date 4:31 下午 2021/4/17
 **/
public class IdGeneratorConfiguration {
	private Long datacenter;
	private Long worker;

	@Bean("idGenerator")
	@ConditionalOnProperty(name = "lzx.idgenerator.mode", havingValue = "snowflake")
	public SnowIdUtil snowflakeIdGenerator() {
		return new SnowIdUtil(datacenter, worker);
	}
}
