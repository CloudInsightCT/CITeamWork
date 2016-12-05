package ict.monitor.dao;

public interface BaseDao<T> {
	void insert(T entity);
	 T findById(int id);
	 void update(T entity);
}
