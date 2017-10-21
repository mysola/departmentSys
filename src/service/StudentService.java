package service;

import java.util.List;

import domain.Mainstenance;
import domain.Meter;
import domain.Repair;
import domain.Student;
import exception.DaoException;

public interface StudentService {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Student login(String username,String password)throws DaoException;
	/**
	 * 报修
	 * @param repair
	 * @return
	 * @throws Exception
	 */
	public boolean addRepair(Repair repair)throws DaoException;
	/**
	 * 根据宿舍编号批量查询修理单
	 * @param bedroomId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Repair> getRepairPage(int bedroomId,int index,int sum)throws DaoException;
	/**
	 * 删除报修单(未接)
	 * @param repairId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteRepair(int repairId)throws DaoException;
	/**
	 * 查询电表
	 * @param meterId
	 * @return
	 * @throws Exception
	 */
	public Meter getMeter(int meterId)throws DaoException;
	/**
	 * 根据宿舍编号统计维修单总数
	 * @param bedroomId
	 * @return
	 * @throws Exception
	 */
	public int countRepairByBedroomId(int bedroomId)throws DaoException;
}
