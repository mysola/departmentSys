package dao;

import java.util.List;

import domain.Notice;

public interface NoticeDao {
		/**
		 * 
		 * @param notice
		 * @return
		 * @throws Exception
		 */
		public void save(Notice notice);
		/**
		 * 
		 * @param noticeId
		 * @return
		 * @throws Exception
		 */
		public int delete(int noticeId);
		/**
		 * 获取通知
		 * @param noticeId
		 * @return
		 * @throws Exception
		 */
		public Notice get(int noticeId);
		/**
		 * 获取通知列表
		 * @param index
		 * @param sum
		 * @return
		 * @throws Exception
		 */
		public List<Notice> getPage(int index,int sum);
		/**
		 * 统计通知总数
		 * @return
		 * @throws Exception
		 */
		public int countAll();
}

