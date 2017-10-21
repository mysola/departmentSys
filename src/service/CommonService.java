package service;

import java.util.List;

import domain.Bedroom;
import domain.Building;
import domain.Notice;
import domain.Type;
import domain._File;
import domain.Campus;
import exception.DaoException;

public interface CommonService {
	/**
	 * 
	 * @param index  起始索引
	 * @param sum  结果数
	 * @return
	 * @throws Exception
	 */
	public List<Notice> getNoticePage(int index,int sum)throws DaoException;
	/**
	 * 
	 * @param index  起始索引
	 * @param sum  结果数
	 * @return
	 * @throws Exception
	 */
	public List<_File> getFilePage(int index,int sum)throws DaoException;
	/**
	 * 统计文件总数
	 * @return
	 * @throws Exception
	 */
	public int countFile()throws DaoException;
	/**
	 * 统计通知总数
	 * @return
	 * @throws Exception
	 */
	public int countNotice()throws DaoException;
	/**
	 * 根据编号获取通知
	 * @param noticeId
	 * @return
	 * @throws Exception
	 */
	public Notice getNotice(int noticeId)throws DaoException;
	/**
	 * 根据编号获取文件对象
	 * @param fileId
	 * @return
	 * @throws Exception
	 */
	public _File getFile(int fileId)throws DaoException;
	/**
	 * 根据校区编号获取宿舍楼
	 * @param campusId
	 * @return
	 * @throws Exception
	 */
	public List<Building> getBuilding(int campusId)throws DaoException;
	/**
	 * 根据宿舍楼获取宿舍
	 * @param buildingId
	 * @return
	 * @throws DaoException
	 */
	public List<Bedroom> getBedroom(int buildingId)throws DaoException;
	/**
	 * 获取所有类型
	 * @return
	 * @throws DaoException
	 */
	public List<Type> getAllType()throws DaoException;
	/**
	 * 获取所有校区
	 * @return
	 * @throws DaoException
	 */
	public List<Campus> getAllCampus()throws DaoException;
}
