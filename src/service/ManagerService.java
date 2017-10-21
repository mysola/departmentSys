package service;

import java.io.*;
import java.util.List;

import domain.HouseMaster;
import domain.Mainstenance;
import domain.Notice;
import domain.SysManager;
import domain._File;
import exception.DaoException;

public interface ManagerService {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public SysManager login(String username,String password)throws DaoException;
	/**
	 * 删除通知
	 * @param noticeId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteNotice(int noticeId)throws DaoException;
	/**
	 * 上传通知
	 * @param notice
	 * @return
	 * @throws Exception
	 */
	public boolean uploadNotice(Notice notice)throws DaoException;
	/**
	 * 删除文件
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteFile(int fileId)throws DaoException;
	/**
	 * 上传文件
	 * @param fileObj  保存文件信息的领域对象
	 * @param file   文件对象
	 * @param dir 文件保存的目录
	 * @return
	 * @throws Exception
	 */
	public boolean uploadFile(_File fileObj,File file,String dir)throws Exception;
	/**
	 * 获取维修人员列表
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Mainstenance> getMainstPage(int index,int sum)throws DaoException;
	/**
	 * 删除
	 * @param mainstId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteMainst(int mainstId)throws DaoException;
	/**
	 * 增加
	 * @param mainst
	 * @return
	 * @throws Exception
	 */
	public boolean addMainst(Mainstenance mainst)throws DaoException;
	/**
	 * 获取维修人员列表
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<HouseMaster> getMasterPage(int index,int sum)throws DaoException;
	/**
	 * 删除
	 * @param masterId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteMaster(int masterId)throws DaoException;
	/**
	 * 增加
	 * @param master
	 * @return
	 * @throws Exception
	 */
	public boolean addMaster(HouseMaster master)throws DaoException;
}
