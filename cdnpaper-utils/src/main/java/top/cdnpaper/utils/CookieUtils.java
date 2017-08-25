package top.cdnpaper.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月22日 上午11:41:56
 * @description cookie工具类
 */
public class CookieUtils {

	/**
	 * 工具类不允许实例化
	 */
	private CookieUtils() {

	}

	/**
	 * 创建默认Cookie，失效时间为30min，路径为/
	 * @param cookieName
	 * @param cookieValue
	 * @return
	 * @throws CustomException 当cookieName为空时抛出异常
	 */
	public static Cookie makeDefaultCookie(String cookieName, String cookieValue) throws CustomException {
		return makeCookie(cookieName, cookieValue, Constants.DEFAULT_COOKIE_EXPIRE, "/");
	}

	/**
	 * 创建Cookie
	 * @param cookieName
	 * @param cookieValue
	 * @param maxAge 失效时间
	 * @param path 路径
	 * @return
	 * @throws CustomException 当cookieName为空时抛出异常
	 */
	public static Cookie makeCookie(String cookieName, String cookieValue, int maxAge, String path)
			throws CustomException {
		if (StringUtils.isNotBlank(cookieName)) {
			Cookie cookie = new Cookie(cookieName, cookieValue);
			cookie.setMaxAge(maxAge);
			cookie.setPath(path);
			return cookie;
		} else {
			throw new CustomException(new NullPointerException());
		}
	}

	/**
	 * 根据cookieName获取对应的Cookie
	 * @param request
	 * @param cookieName
	 * @return 当cookieName没有对应Cookie时返回空
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String cookieName) {
		Cookie findCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					findCookie = cookie;
					break;
				}
			}
		}
		return findCookie;
	}

	/**
	 * 根据cookieName获取对应Cookie的value
	 * @param request
	 * @param cookieName
	 * @return 当cookieName对应的cookie为空时返回""
	 */
	public static String getCookieValueByName(HttpServletRequest request, String cookieName){
		Cookie findCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(cookieName)) {
					findCookie = cookie;
					break;
				}
			}
		}
		return findCookie==null?"":findCookie.getValue();
	}
	
	/**
	 * 删除默认cookie，路径为/
	 * @param response
	 * @param cookieName
	 * @throws CustomException 当cookieName为空时抛出异常
	 */
	public static void removeDefaultCookie(HttpServletResponse response, String cookieName) throws CustomException{
		removeCookie(response, cookieName, "/");
	}
	
	/**
	 * 删除cookie
	 * @param response
	 * @param cookieName
	 * @param path 路径
	 * @throws CustomException 当cookieName为空时抛出异常
	 */
	public static void removeCookie(HttpServletResponse response, 
			String cookieName, String path) throws CustomException{
		Cookie cookie = makeCookie(cookieName, "", 0, path);
		response.addCookie(cookie);
	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
