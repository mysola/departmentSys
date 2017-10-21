package action.manager;

import service.ManagerService;
import service.impl.ManagerServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import exception.DaoException;

public class DeleteFileAction extends ActionSupport{
	private int fileId;
	private boolean msg;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
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
		try {
			managerService.deleteFile(fileId);
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;	
	}
}
