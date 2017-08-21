package top.cdnpaper.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

/**
* @author JiangSiying E-mail:1036539739@qq.com
* @version 创建时间：2017年8月21日 下午5:57:07
* @description MD5加密工具类
*/
public class MD5Encrypt {
	public static final char[] salt = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
	
	/**
	 * 工具类不允许实例化
	 */
	private MD5Encrypt(){
		
	}
	
	/**
	 * 加密
	 * @param value 需加密的数据
	 * @return 加密后的数据，如果value为空则返回原始数据
	 */
	public static String encrypt(String value){
		if(StringUtils.isNotBlank(value)){
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] digest = md.digest(value.getBytes());
				return toHexString(digest);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				throw new RuntimeException("MD5加密出错");
			}
		}
		return value;
	}

	
	private static String toHexString(byte[] digest) {
		if(digest==null){
			return null;
		}
		StringBuilder s = new StringBuilder();
		for(byte b : digest){
			s.append(salt[(b>>4) & 0xF]);
			s.append(salt[(b & 0xF)]);
		}
		return s.toString();
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		String encrypt = MD5Encrypt.encrypt("awqf");
		System.out.println(encrypt);

		encrypt = MD5Encrypt.encrypt("");
		System.out.println(encrypt);
	}
	
}
