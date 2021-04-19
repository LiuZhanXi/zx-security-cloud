package lzx.security.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author liuzhanxi
 * @Classname user
 * @Description 用户实体
 * @Date 2021/4/17 3:01 下午
 */
@Data
public class OauthUser implements Serializable {

	private static final long serialVersionUID = -515804970567149516L;

	/** 用户id */
	private Long id;

	/** 用户名 */
	private String userName;

	/** 密码 */
	private String password;


	@TableField(fill = FieldFill.INSERT)
	/** 创建时间*/
	private LocalDateTime createTime;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	/** 更新时间*/
	private LocalDateTime updateTime;
}
