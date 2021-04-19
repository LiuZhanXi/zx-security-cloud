package lzx.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import lzx.security.dto.OauthUserDto;
import lzx.security.model.OauthUser;

/**
 * @author liuzhanxi
 * @Classname UserService
 * @Description
 * @Date 2021/4/19 11:07 上午
 */
public interface IOauthUserService extends IService<OauthUser> {

    /**
     * @return java.lang.Boolean
     * @Author zhanxi.liu@seaboxdata.com
     * @Description 新增/更新用户信息
     * @Date  2021/4/19 4:05 下午
     * @Param user 用户信息
     **/
    Boolean saveUser(OauthUserDto userDto);
}
