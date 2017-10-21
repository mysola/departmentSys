package service;

import java.util.List;

import domain.Bedroom;
import domain.HouseMaster;
import domain.Mainstenance;
import domain.Student;
import exception.DaoException;

public interface MasterService {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public HouseMaster login(String username,String password)throws DaoException;
	/**
	 * 修改信息
	 * @param master
	 * @return
	 * @throws Exception
	 */
	public boolean updateMaster(HouseMaster master)throws DaoException;
	/**
	 * 根据宿舍楼号获取宿舍
	 * @param buildingId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	
	public List<Bedroom> getBedroomPage(int buildingId,int index,int sum)throws DaoException;
	
	/**
	 * 统计宿舍楼的宿舍数量
	 * @param buildingId
	 * @return
	 * @throws DaoException
	 */
	public int countBedroom(int buildingId)throws DaoException;
	/**
	 * 修改学生信息(寝室)
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean updateStudent(List<Student> student)throws DaoException;
	/**
	 * 根据宿舍楼号获取学生
	 * @param buildingId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Student> getStudentPage(int buildingId,int index,int sum)throws DaoException;
	/**
	 * 统计宿舍楼的学生数量
	 * @param buildingId
	 * @return
	 * @throws DaoException
	 */
	public int countStudent(int buildingId)throws DaoException;
	/**
	 * 根据编号更新宿舍状态和分数
	 * @param bedroom
	 * @return
	 * @throws Exception
	 */
	public boolean updateBedroom(List<Bedroom> bedroom)throws DaoException;
	/**
	 * 调用存储过程
	 * @return
	 * @throws Exception
	 */
	public boolean updateBedroomStar()throws DaoException;
}
