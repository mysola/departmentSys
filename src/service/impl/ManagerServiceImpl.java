package service.impl;

import java.io.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.FileDao;
import dao.NoticeDao;
import dao.SysManagerDao;
import domain.HouseMaster;
import domain.Mainstenance;
import domain.Notice;
import domain.SysManager;
import domain._File;
import exception.DaoException;
import service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private SysManagerDao managerDao;
	private NoticeDao noticeDao; 
	private FileDao fileDao;

	
	public void setManagerDao(SysManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	public SysManager login(String username, String password)
			throws DaoException {
		SysManager manager = new SysManager();
		manager.setUsername(username);
		manager.setPassword(password);
		return(managerDao.get(manager));
	}

	@Override
	public boolean deleteNotice(int noticeId) throws DaoException {
		if(noticeDao.delete(noticeId)==1)
			return true;
		return false;
	}

	@Override
	public boolean uploadNotice(Notice notice) throws DaoException {
		noticeDao.save(notice);
		return true;
	}

	@Override
	public boolean deleteFile(int fileId) throws DaoException {
		_File fi = fileDao.get(fileId);
		File file = new File(fi.getSavePath());
		if(fileDao.delete(fileId)==1&&file.delete())
			return true;
		return false;
	}

	@Override
	public boolean uploadFile(_File fileObj,File file,String dir) throws Exception {
		File serverFiles = new File(dir);
		if(!serverFiles.exists()){
			serverFiles.mkdirs();
		}	
		FileOutputStream fos = new FileOutputStream(fileObj.getSavePath());
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		byte[] buffer = new byte[1024]; 
		int len = 0;
		while((len=bis.read(buffer))>0){
			fos.write(buffer, 0, len);
		}
		fos.close();
		bis.close();
		fileDao.save(fileObj);
		return true;
	}

	@Override
	public List<Mainstenance> getMainstPage(int index, int sum)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMainst(int mainstId) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMainst(Mainstenance mainst) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<HouseMaster> getMasterPage(int index, int sum)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteMaster(int masterId) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addMaster(HouseMaster master) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
