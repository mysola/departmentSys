package action.student;

import java.util.Date;

import service.StudentService;
import service.impl.StudentServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Repair;
import domain.Student;
import domain.Type;
import exception.DaoException;


public class AddRepairAction extends ActionSupport{
	private int typeId;
	private String note;
	private Date repairTime;
	private boolean msg;

	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}
	public boolean isMsg() {
		return msg;
	}
	public void setMsg(boolean msg) {
		this.msg = msg;
	}
	
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String execute(){
		Repair repair = new Repair();
		//设置未接
		repair.setFinished(false);
		repair.setReceived(false);
		//获取报修的学生信息
		ActionContext ctx = ActionContext.getContext();
		Student stu = (Student) ctx.getSession().get("student");
		repair.setBedroom(stu.getBedroom());
		repair.setStudent(stu);
		//设置备注
		repair.setNote(note);
		//设置接收时间
		repair.setRepairTime(repairTime);
		//设置类型
		Type type = new Type();
		type.setTypeId(typeId);
		repair.setType(type);
		try {
			setMsg(studentService.addRepair(repair));		
		} catch (DaoException e) {
			addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;	
	}
}
