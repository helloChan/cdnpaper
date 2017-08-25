package top.cdnpaper.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 基本增删改查dao接口
 * @author JiangSiying
 *
 * @param <T>
 */
public interface BaseDao<T> {
	public Boolean insert(T var);
	
	public Boolean delete(T var);
	
	public Boolean update(T var);
	
	public List<T> select(@Param("var")T var, @Param("firstIndex")long firstIndex, 
			@Param("perPageResult")int perPageResult, 
			@Param("order")Map<String, String> order);
	
	public long count(T var);
	
}
