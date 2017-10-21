package dao.impl;

import java.util.List;

import dao.StudentDao;
import domain.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class StudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int update(Student student) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"update Student "
								+ "as stu set stu.bedroom.bedroomId = :bedroomId where stu.studentId = "
								+ ":studentId")
				.setInteger("bedroomId", student.getBedroom().getBedroomId())
				.setInteger("studentId", student.getStudentId())
				.executeUpdate();
	}

	@Override
	public List<Student> get(int buildingId, int index, int sum) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Student as stu "
								+ "where stu.bedroom.building.buildingId = :buildingId")
				.setInteger("buildingId", buildingId).setMaxResults(sum)
				.setFirstResult(index).list();
	}

	@Override
	public Student get(Student student) {
		List p = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Student as stu where stu.studentNum = "
								+ ":username and stu.password = :password")
				.setString("username", student.getStudentNum())
				.setString("password", student.getPassword()).list();
		return (Student) p.get(0);
	}

	public int countByBuildingId(int buildingId) {
		long l = (long) sessionFactory
				.getCurrentSession()
				.createQuery(
						"select count(*)from Student as stu where stu.bedroom.building"
								+ ".buildingId = :buildingId")
				.setInteger("buildingId", buildingId).uniqueResult();
		return (int) l;
	}
}
