package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.CampusDao;
import domain.Campus;

public class CampusDaoImpl implements CampusDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Campus> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Campus")
				.list();
	}

}
