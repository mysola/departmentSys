package action.manager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import domain.SysManager;
import domain._File;
import org.apache.struts2.ServletActionContext;
import service.ManagerService;

import java.io.File;
import java.util.Date;
import java.util.Map;

public class AddFileAction extends ActionSupport{
	private String title;
	private Date time;
	private File file;
	private boolean msg;
	private String savePath;
	private String fileFileName;
	
	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isMsg() {
		return msg;
	}

	public void setMsg(boolean msg) {
		this.msg = msg;
	}

	private ManagerService managerService;
		
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		SysManager manager = (SysManager)session.get("manager");
		_File fi = new _File();
		fi.setPublisher(manager);
		fi.setSavePath(getSavePath()+"\\"+time+"\\"+title+"\\"+fileFileName);
		fi.setTime(time);
		fi.setTitle(title);
		try {
			managerService.uploadFile(fi,getFile(),getSavePath()+"\\"+time+"\\"+title);
			setMsg(true);
		} catch (Exception e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;	
	}
}
