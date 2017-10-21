package dao;

import java.util.List;

import domain.Campus;

public interface CampusDao {
	/**
	 * 获取校区集合
	 * @return
	 * @throws Exception
	 */
	public List<Campus> getAll();
}
