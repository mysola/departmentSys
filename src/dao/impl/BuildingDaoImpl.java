package dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;

import dao.BuildingDao;
import domain.Building;

public class BuildingDaoImpl implements BuildingDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Building> getByCampus(int campusId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Building as"
								+ " building where building.campus.campusId = :campusId")
				.setInteger("campusId", campusId).list();
	}

}
