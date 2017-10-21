package action.common;



import service.MainstService;
import service.ManagerService;
import service.MasterService;
import service.StudentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.HouseMaster;
import domain.Mainstenance;
import domain.Student;
import domain.SysManager;

public class ProLoginAction extends ActionSupport {

	private String username;
	private String password;
	private boolean msg;
	private String userType;// 权限
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isMsg() {
		return msg;
	}

	public void setMsg(boolean msg) {
		this.msg = msg;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	private StudentService studentService;
	private MasterService masterService;
	private MainstService mainstService;
	private ManagerService managerService;
	

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}

	public void setMainstService(MainstService mainstService) {
		this.mainstService = mainstService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String execute() throws Exception {
		if ("student".equals(userType)) {
			Student stu = studentService.login(username, password);
			if (stu != null) {
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("student", stu);
				setMsg(true);
			} else
				setMsg(false);
		} else if ("master".equals(userType)) {
			HouseMaster master = masterService.login(username, password);
			if (master != null) {
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("master", master);
				setMsg(true);
			} else
				setMsg(false);
		} else if ("mainst".equals(userType)) {
			Mainstenance mainst = mainstService.login(username, password);
			if (mainst != null) {
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("mainst", mainst);
				setMsg(true);
			} else
				setMsg(false);
		} else if ("manager".equals(userType)) {
			SysManager manager = managerService.login(username, password);
			if (manager != null) {
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("manager", manager);
				setMsg(true);
			} else
				setMsg(false);
		} else
			return ERROR;
		return SUCCESS;
	}
}
