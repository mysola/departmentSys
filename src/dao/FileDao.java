package dao;

import java.util.List;

import domain.Notice;
import domain._File;

public interface FileDao {
		/**
		 * 
		 * @param file
		 * @return
		 * @throws Exception
		 */
		public void save(_File file);
		/**
		 * 
		 * @param file
		 * @return
		 * @throws Exception
		 */
		public int delete(int fileId);
		/**
		 * 获取文件对象
		 * @param fileId
		 * @return
		 * @throws Exception
		 */
		public _File get(int fileId);
		/**
		 * 
		 * @param index
		 * @param sum
		 * @return
		 * @throws Exception
		 */
		public List<_File> getPage(int index,int sum);
		/**
		 * 统计文件总数
		 * @return
		 * @throws Exception
		 */
		public int countAll();
}
