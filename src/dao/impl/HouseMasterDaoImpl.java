package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.HouseMasterDao;
import domain.HouseMaster;

public class HouseMasterDaoImpl implements HouseMasterDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(HouseMaster housemaster) {
		// TODO Auto-generated method stub
	}

	@Override
	public int delete(int masterId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(HouseMaster master) {
		sessionFactory.getCurrentSession().update(master);
		return 1;
	}

	@Override
	public HouseMaster get(HouseMaster master) {
		List p = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from HouseMaster"
								+ " as master where master.username = "
								+ ":username and master.password = :password")
				.setString("username", master.getUsername())
				.setString("password", master.getPassword()).list();
		return (HouseMaster) p.get(0);
	}

	@Override
	public List<HouseMaster> getPage(int index, int sum) {
		// TODO Auto-generated method stub
		return null;
	}

}
