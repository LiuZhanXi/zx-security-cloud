package lzx.security.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;

/**
 * @Classname PasswordUtil
 * @Description 密码处理工具类
 * @Date 2021/4/19 5:38 下午
 * @Author liuzhanxi
 */
@Slf4j
public class PasswordUtil implements PasswordEncoder {


	@Value("${lzx.aes.value}")
	private String encodeRules;

	private static final String AES = "AES";

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			// 1. 根据字节数组生成AES密钥
			SecretKey key = getSecretKey();
			// 2. 根据指定算法AES自成密码器
			Cipher cipher = Cipher.getInstance(AES);
			// 3. 初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
			cipher.init(Cipher.ENCRYPT_MODE, key);
			// 4. 获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
			byte[] byteEncode = rawPassword.toString().getBytes(StandardCharsets.UTF_8);
			// 5. 根据密码器的初始化方式--加密：将数据加密
			byte[] byteAES = cipher.doFinal(byteEncode);
			// 6. 将加密后的数据转换为字符串
			//这里用Base64Encoder中会找不到包
			//解决办法：
			//在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
			return new String(Base64.encodeBase64(byteAES));
		} catch (Exception e) {
			log.error("AESEncode", e);
		}
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return !StringUtils.isBlank(rawPassword) && encode(rawPassword).equals(encodedPassword);
	}

	private SecretKey getSecretKey() throws NoSuchAlgorithmException {
		//1.构造密钥生成器，指定为AES算法,不区分大小写
		KeyGenerator keygen = KeyGenerator.getInstance(AES);
		//2.根据ecnodeRules规则初始化密钥生成器
		//生成一个128位的随机源,根据传入的字节数组
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		random.setSeed(encodeRules.getBytes());
		keygen.init(192, random);
		//3.产生原始对称密钥
		SecretKey originalKey = keygen.generateKey();
		//4.获得原始对称密钥的字节数组
		byte[] raw = originalKey.getEncoded();
		//5.根据字节数组生成AES密钥
		return new SecretKeySpec(raw, AES);
	}
}
