package service;

import java.util.Date;
import java.util.List;

import domain.Mainstenance;
import domain.Repair;
import exception.DaoException;

public interface MainstService {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Mainstenance login(String username,String password)throws DaoException;
	/**
	 * 接收报修
	 * @param repair
	 * @return
	 * @throws Exception
	 */
	public boolean receive(List<Repair> repair)throws DaoException;
	/**
	 * 完成报修
	 * @param repair
	 * @return
	 * @throws Exception
	 */
	public boolean finish(List<Repair> repair)throws DaoException;
	/**
	 * 修改信息
	 * @param mainst
	 * @return
	 * @throws Exception
	 */
	public boolean updateMainst(Mainstenance mainst)throws DaoException;
	/**
	 * 根据维修人员编号获取已接未完成
	 * @param mainstId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Repair> getReceivedPage(int mainstId,int index,int sum)throws DaoException;
	
	/**
	 * 根据维修人员编号获取未接
	 * @param mainstId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Repair> getNotReceivedPage(int mainstId,int index,int sum)throws DaoException;
	/**
	 * 根据维修人员编号获取历史（已完成）
	 * @param mainstId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Repair> getHistoryPage(int mainstId,int index,int sum)throws DaoException;
	/**
	 * 根据维修人员编号统计已接未完成总数
	 * @param mainstId
	 * @return
	 * @throws Exception
	 */
	public int countReceived(int mainstId)throws DaoException;
	
	/**
	 * 根据维修人员编号统计未接总数
	 * @param mainstId
	 * @return
	 * @throws Exception
	 */
	public int countNotReceived(int mainstId)throws DaoException;
	/**
	 * 根据维修人员编号统计历史（已完成）总数
	 * @param mainstId
	 * @return
	 * @throws Exception
	 */
	public int countHistory(int mainstId)throws DaoException;
	
}
