package top.cdnpaper.utils;

import java.util.ArrayList;
import java.util.List;

import top.cdnpaper.model.Result;

/**
* @author JiangSiying E-mail:1036539739@qq.com
* @version 创建时间：2017年8月24日 下午10:37:56
* @description 返回结果工具类
*/
public class ResultUtils {
	
	/**
	 * 创建status=true的{@link top.cdnpaper.model.Result}实例，data域为传入参数
	 * @param data
	 * @return
	 */
	public static <T> Result<T> success(T data){
		Result<T> result = new Result<T>();
		result.setStatus(Boolean.TRUE);
		result.setMessage(Constants.DEFAULT_RESULT_SUCCESS_MESSAGE);
		result.setData(data);
		return result;
	}
	
	/**
	 * 创建status=true的{@link top.cdnpaper.model.Result}实例，data域为空
	 * @return
	 */
	public static <T> Result<T> success(){
		return success(null);
	}
	
	/**
	 * 创建status=false的{@link top.cdnpaper.model.Result}实例，data域为空
	 * @param message 失败信息
	 * @return
	 */
	public static <T> Result<T> error(String message){
		Result<T> result = new Result<T>();
		result.setStatus(Boolean.FALSE);
		result.setMessage(message);
		result.setData(null);
		return result;
	}

	/**
	 * 创建status=false的{@link top.cdnpaper.model.Result}实例，data域为空
	 * @return
	 */
	public static <T> Result<T> error(){
		return error(Constants.DEFAULT_RESULT_ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Result<List<String>> success = success(list);
		System.out.println(success);
	}
}
