package action.manager;

import service.ManagerService;
import service.impl.ManagerServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import exception.DaoException;

public class DeleteNoticeAction extends ActionSupport{
	private int noticeId;
	private boolean msg;
	
	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
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
			managerService.deleteNotice(noticeId);
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;	
	}
}
