package service.impl;

import java.util.List;

import org.hibernate.Session;

import dao.BedroomDao;
import dao.BuildingDao;
import dao.CampusDao;
import dao.FileDao;
import dao.NoticeDao;
import dao.TypeDao;
import domain.Bedroom;
import domain.Building;
import domain.Campus;
import domain.Notice;
import domain.Type;
import domain._File;
import exception.DaoException;
import service.CommonService;

public class CommonServiceImpl implements CommonService {
	private FileDao fileDao;
	private NoticeDao noticeDao;
	private TypeDao typeDao;
	private CampusDao campusDao;
	private BuildingDao buildingDao;
	private BedroomDao bedroomDao;

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

	public void setCampusDao(CampusDao campusDao) {
		this.campusDao = campusDao;
	}

	public void setBuildingDao(BuildingDao buildingDao) {
		this.buildingDao = buildingDao;
	}

	public void setBedroomDao(BedroomDao bedroomDao) {
		this.bedroomDao = bedroomDao;
	}

	@Override
	public List<Notice> getNoticePage(int index, int sum) throws DaoException {
		
		try{
			return noticeDao.getPage(index, sum);
		}catch(Exception e){
			throw new DaoException("查询通知页面出错");
		}
	}

	@Override
	public List<_File> getFilePage(int index, int sum) throws DaoException {
		try {
			return fileDao.getPage(index, sum);
		} catch (Exception e) {
			throw new DaoException("文件页面查询出错");
		}
	}

	@Override
	public Notice getNotice(int noticeId) throws DaoException {
		try {
			return (noticeDao.get(noticeId));
		} catch (Exception e) { 
			throw new DaoException("通知细则查询出错");  
		}
	}

	@Override
	public _File getFile(int fileId) throws DaoException {
		try {
			return (fileDao.get(fileId));
		} catch (Exception e) {
			throw new DaoException("获取文件出错");
		}
	}

	@Override
	public int countFile() throws DaoException {
		try {
			return fileDao.countAll();
		} catch (Exception e) {
			throw new DaoException("文件总数查询出错");
		}
	}

	@Override
	public int countNotice() throws DaoException {
		try {
			return noticeDao.countAll();
		} catch (Exception e) {
			throw new DaoException("通知总数查询出错");
		}
	}

	@Override
	public List<Type> getAllType() throws DaoException {
		try {
			return typeDao.getAll();
		} catch (Exception e) {
			throw new DaoException("获取类型出错");
		}
	}

	@Override
	public List<Building> getBuilding(int campusId) throws DaoException {
		try {
			return buildingDao.getByCampus(campusId);
		} catch (Exception e) {
			throw new DaoException("获取宿舍楼出错");
		}
	}

	@Override
	public List<Bedroom> getBedroom(int buildingId) throws DaoException {
		try {
			return bedroomDao.getByBuilding(buildingId);
		} catch (Exception e) {
			throw new DaoException("获取宿舍出错");
		}
	}

	@Override
	public List<Campus> getAllCampus() throws DaoException {
		try {
			return campusDao.getAll();
		} catch (Exception e) {
			throw new DaoException("获取校区出错");
		}
	}

}
