package lzx.security.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lzx.security.dto.OauthUserDto;
import lzx.security.mapper.OauthUserMapper;
import lzx.security.model.OauthUser;
import lzx.security.service.IOauthUserService;
import lzx.security.util.Base64Util;
import lzx.security.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuzhanxi
 * @Classname UserServiceImpl
 * @Description
 * @Date 2021/4/19 3:48 下午
 */
@Service
public class OauthOauthUserServiceImpl extends ServiceImpl<OauthUserMapper, OauthUser> implements IOauthUserService {

	private OauthUserMapper mapper;

	private PasswordUtil passwordUtil;

	@Autowired
	public OauthOauthUserServiceImpl(OauthUserMapper mapper, PasswordUtil passwordUtil) {
		this.mapper = mapper;
		this.passwordUtil = passwordUtil;
	}

	@Override
	public Boolean saveUser(OauthUserDto userDto) {
		OauthUser oauthUser = new OauthUser();
		BeanUtil.copyProperties(userDto, oauthUser);
		String decode = Base64Util.decode(userDto.getPassword());
		oauthUser.setPassword(passwordUtil.encode(decode));
		System.out.println(passwordUtil.encode(decode));
		mapper.insert(oauthUser);
		return true;
	}
}
