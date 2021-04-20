package lzx.security.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;


/**
 * @Classname Base64Util
 * @Description base 64加密/解密 工具类
 * @Date 2021/4/20 10:56 上午
 * @Author liuzhanxi
 */
@Slf4j
public class Base64Util {


	/**
	 * @return java.lang.String
	 * @Description 使用Base64加密
	 * @Date 2021/4/20 11:05 上午
	 * @Param origin
	 **/
	public static String encode(String origin) {
		if (StringUtils.isAllEmpty(origin)) {
			return null;
		}
		String s = null;
		try {
			s = Arrays.toString(Base64.encodeBase64(origin.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			log.error("Base64加密异常:", e);
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * @return java.lang.String
	 * @Description 使用Base64解密
	 * @Date  2021/4/20 11:11 上午
	 * @Param origin
	 **/
	public static String decode(String origin) {
		if (StringUtils.isAllEmpty(origin)) {
			return null;
		}
		String s = null;
		try {
			s = Arrays.toString(Base64.decodeBase64(origin.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			log.error("Base64解密异常:", e);
			e.printStackTrace();
		}
		return s;
	}
}
