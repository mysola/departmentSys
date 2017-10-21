package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.TypeDao;
import domain.Type;

public class TypeDaoImpl implements TypeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Type> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Type")
				.list();
	}

}
