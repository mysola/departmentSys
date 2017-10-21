package dao;

import java.util.List;

import domain.Bedroom;

public interface BedroomDao {
	/**
	 * 根据编号更新宿舍状态和分数
	 * @param bedroom
	 * @return
	 */
	public int update(Bedroom bedroom);
	/**
	 * 根据宿舍楼获取全部宿舍
	 * @param buildingId
	 * @return
	 * @throws Exception
	 */
	public List<Bedroom> getByBuilding(int buildingId);
	/**
	 * 根据宿舍楼号获取一页宿舍
	 * @param buildingId
	 * @param index
	 * @param sum
	 * @return
	 * @throws Exception
	 */
	public List<Bedroom> getPageByBuilding(int buildingId,int index,int sum);
	/**
	 * 根据宿舍楼号统计宿舍数量
	 * @param buildingId
	 * @return
	 * @throws Exception
	 */
	public int countByBuildingId(int buildingId);
}
