package dao.impl;

import org.hibernate.SessionFactory;

import dao.MeterDao;
import domain.Meter;

public class MeterDaoImpl implements MeterDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Meter get(int meterId) {
		return (Meter) sessionFactory.getCurrentSession().get(Meter.class, meterId);
	}

}
