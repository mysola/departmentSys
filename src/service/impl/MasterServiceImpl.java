package service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.BedroomDao;
import dao.HouseMasterDao;
import dao.StudentDao;
import domain.Bedroom;
import domain.HouseMaster;
import domain.Student;
import exception.DaoException;
import service.MasterService;

public class MasterServiceImpl implements MasterService {

	private StudentDao stuDao;
	private BedroomDao bedroomDao;
	private HouseMasterDao masterDao;

	public void setStuDao(StudentDao stuDao) {
		this.stuDao = stuDao;
	}

	public void setBedroomDao(BedroomDao bedroomDao) {
		this.bedroomDao = bedroomDao;
	}

	public void setMasterDao(HouseMasterDao masterDao) {
		this.masterDao = masterDao;
	}

	@Override
	public HouseMaster login(String username, String password)
			throws DaoException {
		HouseMaster master = new HouseMaster();
		master.setUsername(username);
		master.setPassword(password);
		return masterDao.get(master);
	}

	@Override
	public boolean updateMaster(HouseMaster master) throws DaoException {
		masterDao.update(master);
		return true;
	}

	@Override
	public List<Bedroom> getBedroomPage(int buildingId, int index, int sum)
			throws DaoException {
			return bedroomDao.getPageByBuilding(buildingId, index, sum);
	}

	@Override
	public List<Student> getStudentPage(int buildingId, int index, int sum)
			throws DaoException {
			return stuDao.get(buildingId, index, sum);
	}

	@Override
	public boolean updateBedroom(List<Bedroom> bedroom) throws DaoException {
		for(Bedroom be : bedroom){
			if(bedroomDao.update(be)==0)
				return false;
		}		
		return true;
	}

	@Override
	public boolean updateBedroomStar() throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateStudent(List<Student> student) throws DaoException {
		for(Student stu : student){
			if(stuDao.update(stu)==0)
				return false;
		}		
		return true;
	}
	@Override
	public int countStudent(int buildingId) throws DaoException {
			return stuDao.countByBuildingId(buildingId);
	}
	@Override
	public int countBedroom(int buildingId) throws DaoException {
			return bedroomDao.countByBuildingId(buildingId);
	}
	
}
