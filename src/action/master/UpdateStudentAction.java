package action.master;

import java.util.ArrayList;
import java.util.List;

import service.MasterService;
import service.impl.MasterServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain.Bedroom;
import domain.Student;
import exception.DaoException;

public class UpdateStudentAction extends ActionSupport{
	private int[] studentId;
	private int[] bedroomId;
	public int[] getStudentId() {
		return studentId;
	}
	public void setStudentId(int[] studentId) {
		this.studentId = studentId;
	}
	public int[] getBedroomId() {
		return bedroomId;
	}
	public void setBedroomId(int[] bedroomId) {
		this.bedroomId = bedroomId;
	}
	
	private MasterService masterService;
	
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	
	public String execute(){
		List<Student> students = new ArrayList<Student>(); 
		try{	
			for(int i=0;i<studentId.length;i++){
				Student stu = new Student();
				Bedroom bedroom = new Bedroom();
				bedroom.setBedroomId(bedroomId[i]);
				stu.setStudentId(studentId[i]);
				stu.setBedroom(bedroom);
				students.add(stu);
			}	
			masterService.updateStudent(students);
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
