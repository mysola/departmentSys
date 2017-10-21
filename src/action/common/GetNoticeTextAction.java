package action.common;

import service.CommonService;
import service.impl.CommonServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain.Notice;
import exception.DaoException;

public class GetNoticeTextAction extends ActionSupport{
	private int noticeId;
	private Notice notice;
	
	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public String execute(){
		try {
			setNotice(commonService.getNotice(noticeId));
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;	
	}
}
