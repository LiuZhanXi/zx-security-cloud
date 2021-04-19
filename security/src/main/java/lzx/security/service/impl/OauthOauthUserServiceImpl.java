package lzx.security.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lzx.security.dto.OauthUserDto;
import lzx.security.mapper.OauthUserMapper;
import lzx.security.model.OauthUser;
import lzx.security.service.IOauthUserService;
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

	@Autowired
	public OauthOauthUserServiceImpl(OauthUserMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public Boolean saveUser(OauthUserDto userDto) {
		OauthUser oauthUser = new OauthUser();
		BeanUtil.copyProperties(userDto, oauthUser);
		mapper.insert(oauthUser);
		return true;
	}
}
