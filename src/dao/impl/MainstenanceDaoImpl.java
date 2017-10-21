package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.MainstenanceDao;
import domain.Mainstenance;

public class MainstenanceDaoImpl implements MainstenanceDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Mainstenance mainstenance) {
		sessionFactory.getCurrentSession().save(mainstenance);
	}

	@Override
	public int delete(int mainstId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Mainstenance mainst) {
		sessionFactory.getCurrentSession().update(mainst);
		return 1;
	}

	@Override
	public Mainstenance get(Mainstenance mainst) {
		List p = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Mainstenance "
								+ "as mainst where mainst.username = :username and "
								+ "mainst.password = :password")
				.setString("username", mainst.getUsername())
				.setString("password", mainst.getPassword()).list();
		return (Mainstenance) p.get(0);
	}

	@Override
	public List<Mainstenance> getPage(int index, int sum) {
		// TODO Auto-generated method stub
		return null;
	}

}
