package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.NoticeDao;
import domain.Notice;

public class NoticeDaoImpl implements NoticeDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Notice notice) {
		sessionFactory.getCurrentSession().save(notice);
	}

	@Override
	public int delete(int noticeId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"delete Notice "
								+ "as notice where notice.noticeId = :noticeId")
				.setInteger("noticeId", noticeId).executeUpdate();

	}

	@Override
	public Notice get(int noticeId) {
		return (Notice) sessionFactory.getCurrentSession().get(Notice.class,
				noticeId);
	}

	@Override
	public List<Notice> getPage(int index, int sum) {
		return sessionFactory.getCurrentSession().createQuery("from Notice")
				.setFirstResult(index).setMaxResults(sum).list();
	}

	@Override
	public int countAll() {
		long i = (long) sessionFactory.getCurrentSession()
				.createQuery("select count(*) from Notice").uniqueResult();
		return (int) i;
	}

}
