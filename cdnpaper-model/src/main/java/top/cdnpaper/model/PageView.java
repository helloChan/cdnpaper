package top.cdnpaper.model;

import java.util.List;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月24日 下午5:28:50
 * @description 分页封装类
 */
public class PageView<T> {
	private List<T> resultList; // 结果集
	private long totalRecord; // 结果数
	private PageInfo pageInfo; // 开始索引和结束索引的封装
	private int currentPage = 1; // 当前页
	private int perPageResult = 5; // 每页显示数量
	private long totalPage; // 总页数
	private int pageBarLength = 5; // 页码条长度
	private long firstIndex; // sql语句开始索引

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord % this.perPageResult == 0 ? this.totalRecord
				/ this.perPageResult
				: this.totalRecord / this.perPageResult + 1);
	}

	public PageInfo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPerPageResult() {
		return perPageResult;
	}

	public void setPerPageResult(int perPageResult) {
		this.perPageResult = perPageResult;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
		this.pageInfo = PageInfo.getPageInfo(this.pageBarLength,
				this.currentPage, this.totalPage);
	}

	public int getPageBarLength() {
		return pageBarLength;
	}

	public void setPageBarLength(int pageBarLength) {
		this.pageBarLength = pageBarLength;
	}

	public long getFirstIndex() {
		this.firstIndex = (this.currentPage - 1) * this.perPageResult;
		return firstIndex;
	}
	
	public void setQueryResult(QueryResult<T> qr) {
		setResultList(qr.getResultList());
		setTotalRecord(qr.getTotalRecord());
	}

}
