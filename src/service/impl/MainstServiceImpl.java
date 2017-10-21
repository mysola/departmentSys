package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.MainstenanceDao;
import dao.RepairDao;
import domain.Mainstenance;
import domain.Repair;
import exception.DaoException;
import service.MainstService;

public class MainstServiceImpl implements MainstService {
	private MainstenanceDao mainstDao;
	private RepairDao repairDao;

	public void setMainstDao(MainstenanceDao mainstDao) {
		this.mainstDao = mainstDao;
	}

	public void setRepairDao(RepairDao repairDao) {
		this.repairDao = repairDao;
	}

	@Override
	public Mainstenance login(String username, String password)
			throws DaoException {
		Mainstenance mainst = new Mainstenance();
		mainst.setUsername(username);
		mainst.setPassword(password);
		return (mainstDao.get(mainst));
	}

	@Override
	public boolean receive(List<Repair> repair) throws DaoException {
		for (Repair re : repair) {
			if (repairDao.updateReceive(re) == 0){
				return false;
			}	
		}
		return true;
	}

	@Override
	public boolean finish(List<Repair> repair) throws DaoException {
		for (Repair re : repair) {
			if (repairDao.updateFinish(re) == 0)
				return false;
		}
		return true;
	}

	@Override
	public boolean updateMainst(Mainstenance mainst) throws DaoException {
		mainstDao.update(mainst);
		return true;
	}

	@Override
	public List<Repair> getReceivedPage(int mainstId, int index, int sum)
			throws DaoException {
		return repairDao.getPageByMainstId(mainstId, index, sum, 1);
	}

	@Override
	public List<Repair> getNotReceivedPage(int mainstId, int index,
			int sum) throws DaoException {
		return repairDao.getPageByMainstId(mainstId, index, sum, 0);
	}

	@Override
	public List<Repair> getHistoryPage(int mainstId, int index, int sum)
			throws DaoException {
		return repairDao.getPageByMainstId(mainstId, index, sum, 2);

	}

	@Override
	public int countReceived(int mainstId) throws DaoException {
		return repairDao.countByMainstId(mainstId, 1);

	}

	@Override
	public int countNotReceived(int mainstId) throws DaoException {
		return repairDao.countByMainstId(mainstId, 0);
	}

	@Override
	public int countHistory(int mainstId) throws DaoException {
		return repairDao.countByMainstId(mainstId, 2);
	}

}
