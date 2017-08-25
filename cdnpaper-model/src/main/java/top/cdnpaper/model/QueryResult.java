package top.cdnpaper.model;

import java.util.List;

/**
 * @author JiangSiying E-mail:1036539739@qq.com
 * @version 创建时间：2017年8月24日 下午7:19:00
 * @description 查询结果封装类
 */
public class QueryResult<T> {
	private List<T> resultList;
	private long totalRecord;

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
	}

	public QueryResult(List<T> resultList, long totalRecord) {
		super();
		this.resultList = resultList;
		this.totalRecord = totalRecord;
	}

	public QueryResult() {
		super();
	}

}
