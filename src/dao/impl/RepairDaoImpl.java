package dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.RepairDao;
import domain.Repair;

public class RepairDaoImpl implements RepairDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Repair repair) {
		sessionFactory.getCurrentSession().save(repair);
	}

	@Override
	public int delete(int repairId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"delete Repair "
								+ "as repair where repair.repairId = :repairId")
				.setInteger("repairId", repairId).executeUpdate();
	}

	@Override
	public List<Repair> getPageByBedroom(int bedroomId, int index, int sum) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Repair as repair"
								+ " where repair.bedroom.bedroomId = :bedroomId")
				.setInteger("bedroomId", bedroomId).setFirstResult(index)
				.setMaxResults(sum).list();
	}

	@Override
	public List<Repair> getPageByMainstId(int mainstId, int index, int sum,
			int status) {
		Boolean received = false;
		Boolean finished = false;
		// 已接未完成
		if (status == 1) {
			received = true;
		}// 已接已完成
		else if (status == 2) {
			received = true;
			finished = true;
		}
		List p = null;
		if (status != 0) {
			p = sessionFactory
					.getCurrentSession()
					.createQuery(
							"from Repair as repair "
									+ "where repair.received = :received and repair.finished = :finished"
									+ " and repair.receiver.mainstenanceId = :mainstId")
					.setBoolean("received", received)
					.setBoolean("finished", finished)
					.setInteger("mainstId", mainstId).setFirstResult(index)
					.setMaxResults(sum).list();
		}
//		Map cache = sessionFactory.getStatistics()
//				.getSecondLevelCacheStatistics("domain.Repair")
//				.getEntries();
//		System.out.print(cache);
		if (status == 0) {
			p = sessionFactory
					.getCurrentSession()					
					.createQuery(
							"from Repair as repair "
									+ "where repair.received = :received and repair.finished = :finished")
					.setBoolean("received", received)
					.setBoolean("finished", finished)
					.setCacheable(true)
					.setFirstResult(index)
					.setMaxResults(sum)
					.list();
		}

		return p;
	}

	@Override
	public int countByBedroom(int bedroomId) {
		long l = (long) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*) from Repair as repair where "
								+ "repair.bedroom.bedroomId = :bedroomId")
				.setInteger("bedroomId", bedroomId).uniqueResult();
		return (int) l;
	}

	@Override
	public int countByMainstId(int mainstId, int status) {
		Boolean received = false;
		Boolean finished = false;
		// 已接未完成
		if (status == 1) {
			received = true;
		}// 已接已完成
		else if (status == 2) {
			received = true;
			finished = true;
		}
		long l = (long) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*) from Repair as repair where repair.received = "
								+ ":received and repair.finished = :finished and "
								+ "repair.receiver.mainstenanceId = :mainstId")
				.setBoolean("received", received)
				.setBoolean("finished", finished)
				.setInteger("mainstId", mainstId).uniqueResult();
		return (int) l;
	}

	@Override
	public int updateReceive(Repair repair) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"update Repair "
								+ "as repair set repair.receiveTime = "
								+ ":receiveTime,repair.received = true,repair.receiver.mainstenanceId "
								+ "= :mainstId where repair.received = false and repair.finished "
								+ "= false and repair.repairId = :repairId")
				.setDate("receiveTime", repair.getReceiveTime())
				.setInteger("mainstId",
						repair.getReceiver().getMainstenanceId())
				.setInteger("repairId", repair.getRepairId()).executeUpdate();
	}

	@Override
	public int updateFinish(Repair repair) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"update Repair "
								+ "as repair set repair.finishTime = :finishTime,"
								+ "repair.finished = true where repair.received = true and "
								+ "repair.finished = false and repair.repairId = :repairId and "
								+ "repair.receiver.mainstenanceId = :mainstId")
				.setDate("finishTime", repair.getFinishTime())
				.setInteger("mainstId",
						repair.getReceiver().getMainstenanceId())
				.setInteger("repairId", repair.getRepairId()).executeUpdate();
	}

}
