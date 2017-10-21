package dao;

import java.util.List;

import domain.Building;

public interface BuildingDao {
	/**
	 * 根据校区编号获取宿舍楼
	 * @param campusId
	 * @return
	 * @throws Exception
	 */
	public List<Building> getByCampus(int campusId);
}
