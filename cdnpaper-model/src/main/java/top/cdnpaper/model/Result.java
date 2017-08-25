package top.cdnpaper.model;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月24日 下午10:34:27
 * @description 返回结果封装类
 */
public class Result<T> {
	@Override
	public String toString() {
		return "Result [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

	private Boolean status;
	private String message;
	private T data;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
