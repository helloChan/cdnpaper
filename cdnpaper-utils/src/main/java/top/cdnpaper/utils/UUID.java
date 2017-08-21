package top.cdnpaper.utils;
/**
* @author JiangSiying E-mail:1036539739@qq.com
* @version 创建时间：2017年8月21日 下午6:00:20
* @description UUID工具类
*/
public class UUID {
	
	/**
	 * 工具类不允许实例化
	 */
	private UUID(){
		
	}
	
	/**
	 * 生成原生uuid
	 * @return uuid
	 */
	public static String uuid(){
		return java.util.UUID.randomUUID().toString();
	}
	
	/**
	 * 生成没有-的uuid
	 * @return 没有-的uuid
	 */
	public static String uuidTrim(){
		return java.util.UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(UUID.uuid());
		System.out.println(UUID.uuidTrim());
	}
}
