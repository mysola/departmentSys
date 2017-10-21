package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.BedroomDao;
import domain.Bedroom;

public class BedroomDaoImpl implements BedroomDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int update(Bedroom bedroom) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"update Bedroom "
								+ "as bedroom set bedroom.score = :score,bedroom.used = :used,"
								+ "bedroom.updateTime = :updateTime where bedroom.bedroomId = "
								+ ":bedroomId")
				.setInteger("score", bedroom.getScore())
				.setBoolean("used", bedroom.isUsed())
				.setDate("updateTime", bedroom.getUpdateTime())
				.setInteger("bedroomId", bedroom.getBedroomId())
				.executeUpdate();
	}

	@Override
	public List<Bedroom> getByBuilding(int buildingId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Bedroom as bedroom "
								+ "where bedroom.building.buildingId = :buildingId")
				.setInteger("buildingId", buildingId).list();
	}

	@Override
	public List<Bedroom> getPageByBuilding(int buildingId, int index, int sum) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Bedroom as bedroom "
								+ "where bedroom.building.buildingId = :buildingId")
				.setInteger("buildingId", buildingId).setFirstResult(index)
				.setMaxResults(sum).list();
	}

	public int countByBuildingId(int buildingId) {
		long l = (long) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*)from Bedroom as bedroom where bedroom.building"
								+ ".buildingId = :buildingId")
				.setInteger("buildingId", buildingId).uniqueResult();
		return (int) l;
	}
}
