package action.manager;

import java.util.Date;
import java.util.Map;

import service.ManagerService;
import service.impl.ManagerServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Notice;
import domain.SysManager;
import exception.DaoException;

public class AddNoticeAction extends ActionSupport{
	private String title;
	private String text;
	private Date time;
	private boolean msg;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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
		Notice notice = new Notice();
		notice.setText(text);
		notice.setTime(time);
		notice.setTitle(title);
		Map session = ActionContext.getContext().getSession();
		SysManager manager = (SysManager)session.get("manager");
		notice.setPublisher(manager);
		try {
			managerService.uploadNotice(notice);
			setMsg(true);
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;	
	}
}
