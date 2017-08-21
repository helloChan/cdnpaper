package top.cdnpaper.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月20日 下午11:14:36
 * @description 自定义异常类
 */
public class CustomException extends Exception {

	private static final long serialVersionUID = 4923538514131876982L;

	private String message;

	/**
	 * 创建一个message为自定义的{@link CustomException}对象
	 * @param message 异常信息
	 */
	public CustomException(String message) {
		super();
		this.message = message;
	}
	
	/**
	 * 获取拥有默认信息{@link Constants.DEFAULT_CUSTOMEXCETION_MESSAGE}的自定义异常对象
	 * @return {@link CustomException}
	 */
	public static CustomException getDefaultInstance(){
		return new CustomException(Constants.DEFAULT_CUSTOMEXCETION_MESSAGE);
	}
	
	/**
	 * 创建一个message为异常堆栈信息的{@link CustomException}对象
	 * @param t {@link Throwable}
	 */
	public CustomException(Throwable t){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		try {
			t.printStackTrace(pw);
			this.message = sw.toString();
		} finally {
			pw.close();
		}
	}

	public String getMessage() {
		return message;
	}

	/**
	 * 测试
	 * @param s
	 */
	public static void main(String[] s){
		CustomException ce = new CustomException("exception occur...");
		System.out.println(ce.getMessage());
		
		CustomException ce2 = new CustomException(new NullPointerException());
		System.out.println(ce2.getMessage());
		
		CustomException ce3 = CustomException.getDefaultInstance();
		System.out.println(ce3.getMessage());
	}
}
