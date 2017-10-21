package action.student;

import service.StudentService;
import service.impl.StudentServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import exception.DaoException;

public class DeleteRepairAction extends ActionSupport{
	private int repairId;

	public int getRepairId() {
		return repairId;
	}

	public void setRepairId(int repairId) {
		this.repairId = repairId;
	}
	
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String execute() {
		try {
			studentService.deleteRepair(repairId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
}
