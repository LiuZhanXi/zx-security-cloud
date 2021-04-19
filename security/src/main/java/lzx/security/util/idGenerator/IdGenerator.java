package lzx.security.util.idGenerator;

/**
 * @author liuzhanxi
 * @Classname IdGenerator
 * @Description 主键id生成器
 * @Date 2021/4/17 5:04 下午
 */
public interface IdGenerator {

	/**
	 * 获得主键
	 *
	 * @return 64 bit 长整型主键，>0
	 */
	Long getId();
}
