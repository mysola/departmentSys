package dao;

import domain.Meter;

public interface MeterDao {
	/**
	 * 查询电表
	 * @param meterId
	 * @return
	 * @throws Exception
	 */
	public Meter get(int meterId);
}
