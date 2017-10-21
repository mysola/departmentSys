package dao;

import java.util.List;

import domain.Student;

public interface StudentDao {
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int update(Student student);
	/**
	 * 根据宿舍楼号获取学生
	 * @param buildingId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Student> get(int buildingId,int index,int sum);
	/**
	 * 登录
	 * @param student,包含username 和password
	 * @return
	 * @throws Exception
	 */
	public Student get(Student student);
	/**
	 * 统计宿舍楼学生总数
	 * @param buildingId
	 * @return
	 * @throws Exception
	 */
	public int countByBuildingId(int buildingId);
}
