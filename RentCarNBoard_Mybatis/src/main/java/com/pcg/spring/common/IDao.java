package com.pcg.spring.common;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IDao<T, K> {
	public int insert(T dto) throws SQLException;
	public int delete(K key) throws SQLException;
	public int update(T dto) throws SQLException;
	public T select(K key) throws SQLException;
	public List<T> selectAll() throws SQLException;
	public List<T> find(Map<String,String> conditionMap) throws SQLException;
	public boolean close() throws SQLException;
}
