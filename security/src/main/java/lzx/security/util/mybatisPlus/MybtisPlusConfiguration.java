package lzx.security.util.mybatisPlus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import lzx.security.util.idGenerator.IdGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MybtisPlusConfiguration
 * @Description MyBatisPlus 配置类
 * @Date  2021/4/19 5:08 下午
 **/
@Configuration
@Slf4j
public class MybtisPlusConfiguration {
	@Bean
	@ConditionalOnClass(IdGenerator.class)
	public MetaObjectHandler autoFillIdHandler(IdGenerator idGenerator) {
		log.info("初始化 Mybatis-Plus 自动填充");
		return new MybatisHandler(idGenerator);
	}
}
