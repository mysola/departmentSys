package dao;

import java.util.List;

import domain.Mainstenance;

public interface MainstenanceDao {
	/**
	 * 
	 * @param mainstenance
	 * @return
	 * @throws Exception
	 */
	public void save(Mainstenance mainstenance);

	/**
	 * 
	 * @param mainstId
	 * @return
	 * @throws Exception
	 */
	public int delete(int mainstId);

	/**
	 * 修改信息
	 * @param mainst
	 * @return
	 * @throws Exception
	 */
	public int update(Mainstenance mainst);

	/**
	 * 登录操作
	 * @param mainst,包含username 和password
	 * @return
	 * @throws Exception
	 */
	public Mainstenance get(Mainstenance mainst);
	/**
	 * 获取维修人员列表
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Mainstenance> getPage(int index,int sum);
}
