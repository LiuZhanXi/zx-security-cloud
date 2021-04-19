package lzx.security.util.idGenerator;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

/**
 * @author liuzhanxi
 * @Classname SnowIdUtil
 * @Description 雪花id生成工具类
 * @Date 2021/4/17 4:11 下午
 */
@Slf4j
public class SnowIdGenerator implements IdGenerator {
	private static final int MAX_WORKER_ID = 1000;

	//工作节点ID(0 - 31)
	private final long workerId;
	//数据中心ID(0 - 31)
	private final long datacenterId;


	public SnowIdGenerator(Long datacenterId, Long workerId) {
		Assert.isTrue(workerId < MAX_WORKER_ID && workerId >= 0,
				String.format("worker can't be greater than %d or less than 0", MAX_WORKER_ID));

		log.info("创建 Snowflake IdGenerator: datacenter={}, worker={}", datacenterId, workerId);

		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	@Override
	public synchronized Long getId() {
		return IdUtil.createSnowflake(workerId, datacenterId).nextId();
	}
}
