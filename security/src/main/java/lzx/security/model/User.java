package lzx.security.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname user
 * @Description 用户实体
 * @Date 2021/4/17 3:01 下午
 * @Email zhanxi.liu@seaboxdata.com
 * @author liuzhanxi
 */
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -515804970567149516L;

	/** 用户id*/
	private Long id;

	/** 用户名*/
	private String userName;

	/** 密码*/
	private String password;
}
