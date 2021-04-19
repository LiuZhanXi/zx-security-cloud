package lzx.security.util.mybatisPlus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lzx.security.util.idGenerator.IdGenerator;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

/**
 * @Classname MybatisHandler
 * @Description MyBatisPlus 处理自动填充
 * @Date 2021/4/17 4:35 下午
 * @author liuzhanxi
 */

public class MybatisHandler implements MetaObjectHandler {

	private static final String ID = "id";
	private static final String CREATE_TM = "createTime";
	private static final String UPDATE_TM = "updateTime";


	private IdGenerator idGenerator;

	public MybatisHandler(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}

	@Override
	public void insertFill(MetaObject metaObject) {
		if (ObjectUtils.isEmpty(metaObject)){
			return;
		}
		if (metaObject.hasGetter(ID) && metaObject.hasSetter(ID)
				&& metaObject.getGetterType(ID).equals(Long.class)
				&& metaObject.getSetterType(ID).equals(Long.class)) {
			Long value = (Long) metaObject.getValue(ID);
			if (value == null || value < 0) {
				metaObject.setValue(ID, idGenerator.getId());
			}
		}
		setFieldValByNameIfNull(CREATE_TM, LocalDateTime.now(),metaObject);
		setFieldValByNameIfNull(UPDATE_TM, LocalDateTime.now(),metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		setFieldValByNameIfNull(CREATE_TM, LocalDateTime.now(),metaObject);
		setFieldValByNameIfNull(UPDATE_TM, LocalDateTime.now(),metaObject);
	}

	private void setFieldValByNameIfNull(String fieldname, Object value, MetaObject metaObject) {
		if (metaObject.hasGetter(fieldname) && metaObject.hasSetter(fieldname)) {
			Object existValue = metaObject.getValue(fieldname);
			if (existValue == null) {
				setFieldValByName(fieldname, value, metaObject);
			}
		}
	}
}
