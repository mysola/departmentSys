package dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import dao.FileDao;
import domain._File;

public class FileDaoImpl implements FileDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(_File file) {
		sessionFactory.getCurrentSession().save(file);
	}

	@Override
	public int delete(int fileId) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"delete _File as file where file.fileId = :fileId")
				.setInteger("fileId", fileId).executeUpdate();
	}

	@Override
	public _File get(int fileId) {
		return (_File) sessionFactory.getCurrentSession().get(_File.class,
				fileId);
	}

	@Override
	public List<_File> getPage(int index, int sum) {
		return sessionFactory.getCurrentSession().createQuery("from _File")
				.setFirstResult(index).setMaxResults(sum).list();
	}

	@Override
	public int countAll() {
		long l = (long) sessionFactory.getCurrentSession()
				.createQuery("select count(*)from _File").uniqueResult();
		return (int) l;
	}

}
