package lzx.security.controller;

import lzx.security.dto.OauthUserDto;
import lzx.security.service.IOauthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OauthUserController
 * @Description
 * @Date 2021/4/19 4:12 下午
 * @Author liuzhanxi
 */
@RestController
public class OauthUserController {
	private IOauthUserService userService;

	@Autowired
	public OauthUserController(IOauthUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/oauth/saveUser")
	public Boolean saveUser(@RequestBody OauthUserDto dto) {
		return userService.saveUser(dto);
	}
}
