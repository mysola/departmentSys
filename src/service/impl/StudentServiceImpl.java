package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Meter;
import domain.Repair;
import domain.Student;
import dao.MeterDao;
import dao.RepairDao;
import dao.StudentDao;
import exception.DaoException;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao stuDao;
	private RepairDao repairDao;
	private MeterDao meterDao;

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}
	public void setRepairDao(RepairDao repairDao) {
		this.repairDao = repairDao;
	}
	public void setMeterDao(MeterDao meterDao) {
		this.meterDao = meterDao;
	}
	@Override
	public Student login(String username, String password) throws DaoException {
		Student stu = new Student();
		stu.setStudentNum(username);
		stu.setPassword(password);
		return stuDao.get(stu);
	}
	@Override
	public boolean addRepair(Repair repair) throws DaoException {
		repairDao.save(repair);
		return true;
	}
	@Override
	public List<Repair> getRepairPage(int bedroomId, int index, int sum)
			throws DaoException {
		return repairDao.getPageByBedroom(bedroomId, index, sum);	
	}
	@Override
	public int countRepairByBedroomId(int bedroomId) throws DaoException {
		return repairDao.countByBedroom(bedroomId);
	}
	@Override
	public boolean deleteRepair(int repairId) throws DaoException {
		if(repairDao.delete(repairId)==0)
			return false;
		return true;
	}
	@Override
	public Meter getMeter(int meterId) throws DaoException {
		return meterDao.get(meterId);
	}
	
}
