package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.SysManagerDao;
import domain.SysManager;

public class SysManagerDaoImpl implements SysManagerDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SysManager get(SysManager manager) {
		List p = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from SysManager as "
								+ "manager where manager.username = "
								+ ":username and manager.password = :password")
				.setString("username", manager.getUsername())
				.setString("password", manager.getPassword()).list();
		return (SysManager) p.get(0);
	}

}
