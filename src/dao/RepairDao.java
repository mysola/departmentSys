package dao;

import java.util.List;

import domain.Repair;

public interface RepairDao {
	/**
	 * 增加报修
	 * @param repair
	 * @return
	 * @throws Exception
	 */
	public void save(Repair repair);
	/**
	 * 删除(未修)
	 * @param repairId
	 * @return
	 * @throws Exception
	 */
	public int delete(int repairId);
	/**
	 * 更新接收状态
	 * @param repair
	 * @return
	 * @throws Exception
	 */
	public int updateReceive(Repair repair);
	/**
	 * 更新完成状态
	 * @param repair
	 * @return
	 * @throws Exception
	 */
	public int updateFinish(Repair repair);
	/**
	 * 根据宿舍编号批量查询修理单
	 * @param bedroomId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Repair> getPageByBedroom(int bedroomId,int index,int sum);
	/**
	 * 根据宿舍编号统计维修单总数
	 * @param bedroomId
	 * @return
	 * @throws Exception
	 */
	public int countByBedroom(int bedroomId);
	
	/**
	 * 根据维修人员编号批量查询修理单
	 * @param mainstId
	 * @param index
	 * @param sum
	 * @param status  0代表未接，1代表已接未完成，2代表已接已完成
	 * @return
	 * @throws Exception
	 */
	public List<Repair> getPageByMainstId(int mainstId,int index,int sum,int status);
	
	/**
	 * 根据维修人员编号统计维修单总数
	 * @param mainstId
	 * @param status  0代表未接，1代表已接未完成，2代表已接已完成
	 * @return
	 * @throws Exception
	 */
	public int countByMainstId(int mainstId,int status);

}
