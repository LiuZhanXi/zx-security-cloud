import lzx.security.util.idGenerator.IdGenerator;
import lzx.security.util.idGenerator.SnowIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liuzhanxi
 * @Classname IdGeneratorTest
 * @Description
 * @Date 2021/4/17 5:01 下午
 * @Email zhanxi.liu@seaboxdata.com
 */
public class IdGeneratorTest {

    private IdGenerator idGenerator;

    @Autowired
    public IdGeneratorTest(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public static void main(String[] args) {

        System.out.println(new SnowIdGenerator(1L, 1L).getId());
    }
}
