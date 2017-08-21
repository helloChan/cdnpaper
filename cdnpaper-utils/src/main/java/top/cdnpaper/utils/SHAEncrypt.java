package top.cdnpaper.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月20日 下午11:00:46
 * @description SHA加密工具类
 */
public class SHAEncrypt {
	/**
	 * 工具类不允许实例化
	 */
	private SHAEncrypt() {
		
	}

	/**
	 * @param value 需加密的数据
	 * @return 加密后的数据，如果value为空则返回空
	 * @throws CustomException 返回原异常信息
	 */
	public static String encrypt(String value) throws CustomException {
		if (StringUtils.isNotBlank(value)) {
			MessageDigest sha = null;
			try {
				sha = MessageDigest.getInstance("SHA");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				throw new CustomException(e);
			}
			byte[] byteArray;
			try {
				byteArray = value.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new CustomException(e);
			}
			byte[] md5Bytes = sha.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16) {
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		}
		return null;
	}
}
