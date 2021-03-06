package top.cdnpaper.utils;

/**
* @author JiangSiying E-mail:1036539739@qq.com
* @version 创建时间：2017年8月20日 下午10:58:57
* @description 常量类
*/
public class Constants {
	
	/**
	 * 默认自定义异常信息
	 */
	public static final String DEFAULT_CUSTOMEXCETION_MESSAGE = "系统异常";
	
	/**
	 * yyyyMMdd
	 */
	public static final String YYYYMMDD = "yyyyMMdd";
	
	/**
	 * yyyy-MM-dd
	 */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/**
	 * yyyy年MM月dd日
	 */
	public static final String YYYYMMDD_CHINESE = "yyyy年MM月dd日";
	
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String YYYY_MM_DD_HHSSMM_24 = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * yyyy-MM-dd hh:mm:ss aa
	 */
	public static final String YYYY_MM_DD_HHSSMM_12_ENGLISH = "yyyy-MM-dd hh:mm:ss aa";
	
	/**
	 * yyyy-MM-dd aa hh:mm:ss
	 */
	public static final String YYYY_MM_DD_HHSSMM_12_CHINESE = "yyyy-MM-dd aa hh:mm:ss";
	
	/**
	 * 默认cookie失效时间
	 */
	public static final int DEFAULT_COOKIE_EXPIRE = 30*60;
	
	/**
	 * 默认返回结果封装类{@link top.cdnpaper.model.Result}中成功信息
	 */
	public static final String DEFAULT_RESULT_SUCCESS_MESSAGE = "操作成功";

	/**
	 * 默认返回结果封装类{@link top.cdnpaper.model.Result}中失败信息
	 */
	public static final String DEFAULT_RESULT_ERROR_MESSAGE = "系统错误";
	
	/**
	 * 工具类不允许实例化
	 */
	private Constants(){
	}

	
}
