package edu.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T, PK extends Serializable> {

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> entityClass;

	private Session session;

	private Session getSession() {
		if (null == session || !session.isOpen())
			session = sessionFactory.openSession();
		return session;
	}

	public void flush() {
			session.flush();
	}

	@SuppressWarnings("unchecked")
	public BaseDao() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public List<T> findList() {
		String hql = "from " + entityClass.getSimpleName();
		Query query = getSession().createQuery(hql);
		List<T> list = query.list();
		return list;
	}

	public T get(PK pk) {
		T result = (T) getSession().load(entityClass, pk);
		return result;
	}

	public void add(T entity) {
		getSession().save(entity);
	}

	public void delete(PK pk) {
		getSession().delete(this.get(pk));
	}

	public void update(T entity) {
		getSession().update(entity);
	}

}
