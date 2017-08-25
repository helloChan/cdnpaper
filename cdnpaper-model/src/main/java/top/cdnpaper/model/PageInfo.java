package top.cdnpaper.model;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月24日 下午5:30:41
 * @description 开始索引和结束索引的封装类
 */
public class PageInfo {
	private long startIndex; // 开始索引
	private long endIndex; // 结束索引

	public PageInfo(long startIndex, long endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	public long getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(long endIndex) {
		this.endIndex = endIndex;
	}

	/**
	 * 根据所需参数获取PageInfo实例
	 * 
	 * @param pageBarLength
	 *            页码条长度
	 * @param currentPage
	 *            当前页
	 * @param totalPage
	 *            总页数
	 * @return PageInfo实例{@link PageInfo}
	 */
	public static PageInfo getPageInfo(int pageBarLength, int currentPage, long totalPage) {
		long startIndex = currentPage - (pageBarLength % 2 == 0 ? pageBarLength / 2 - 1 : pageBarLength / 2);
		long endIndex = currentPage + pageBarLength / 2;

		if (startIndex < 1) {
			startIndex = 1;
			if (totalPage >= pageBarLength) {
				endIndex = pageBarLength;
			} else {
				endIndex = totalPage;
			}
		}

		if (endIndex > totalPage) {
			endIndex = totalPage;
			if (endIndex - pageBarLength > 0) {
				startIndex = endIndex - pageBarLength + 1;
			} else {
				startIndex = 1;
			}
		}

		return new PageInfo(startIndex, endIndex);
	}
}
