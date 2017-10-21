package dao;

import java.util.List;

import domain.HouseMaster;

public interface HouseMasterDao {
		/**
		 * 
		 * @param housemaster
		 * @return
		 * @throws Exception
		 */
		public void save(HouseMaster housemaster);
		/**
		 * 
		 * @param masterId
		 * @return
		 * @throws Exception
		 */
		public int delete(int masterId);
		/**
		 * 修改信息
		 * @param master
		 * @return
		 * @throws Exception
		 */
		public int update(HouseMaster master);
		
	
		/**
		 * 登录
		 * @param master,包含username 和password
		 * @return
		 * @throws Exception
		 */
		public HouseMaster get(HouseMaster master);
		/**
		 * 
		 * @param index
		 * @param sum
		 * @return
		 * @throws Exception
		 */
		public List<HouseMaster> getPage(int index,int sum);
}	
