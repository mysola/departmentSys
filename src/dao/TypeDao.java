package dao;

import java.util.List;

import domain.Type;

public interface TypeDao {

		/**
		 * 获取所有类型
		 * @return
		 * @throws Exception
		 */
		public List<Type> getAll();
}
