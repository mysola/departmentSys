package action.student;

import com.opensymphony.xwork2.ActionSupport;

import domain.Meter;
import exception.DaoException;
import service.StudentService;
import service.impl.StudentServiceImpl;

public class GetMeterAction extends ActionSupport{
	private int meterId;
	private Meter meter;
	
	public int getMeterId() {
		return meterId;
	}

	public void setMeterId(int meterId) {
		this.meterId = meterId;
	}

	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String execute() {
		try {
			setMeter(studentService.getMeter(meterId));
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
		
	}
}
