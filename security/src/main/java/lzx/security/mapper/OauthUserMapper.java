package lzx.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lzx.security.model.OauthUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liuzhanxi
 * @Classname UserMapper
 * @Description
 * @Date 2021/4/19 3:46 下午
 */
@Mapper
public interface OauthUserMapper extends BaseMapper<OauthUser> {
}
