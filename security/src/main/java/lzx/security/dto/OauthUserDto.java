package lzx.security.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname OauthUserDto
 * @Description 用户dto
 * @Date 2021/4/19 4:05 下午
 * @Author liuzhanxi
 */
@Data
public class OauthUserDto implements Serializable {

	private static final long serialVersionUID = -6320763686697122894L;
	/** 用户id */
	private Long id;

	/** 用户名 */
	private String userName;

	/** 密码 */
	private String password;

}
