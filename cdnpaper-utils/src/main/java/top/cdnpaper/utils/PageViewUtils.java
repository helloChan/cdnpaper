package top.cdnpaper.utils;

import top.cdnpaper.model.PageView;

/**
* @author JiangSiying E-mail:1036539739@qq.com
* @version 创建时间：2017年8月25日 上午11:21:41
* @description {@link top.cdnpaper.model.PageView}工具类
*/
public class PageViewUtils {
	
	/**
	 * 根据当前页返回一个PageView实例
	 * @param currentPage
	 * @return
	 */
	public static <T> PageView<T> getPageView(Integer currentPage){
		if(currentPage==null || currentPage<1) currentPage = 1;
		PageView<T> pageView = new PageView<T>();
		pageView.setCurrentPage(currentPage);
		return pageView;
	}
	

	/**
	 * 工具类不允许实例化
	 */
	private PageViewUtils(){
		
	}
	
}
