package action.common;

import java.util.List;

import service.CommonService;
import service.impl.CommonServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain.Notice;
import exception.DaoException;

public class GetNoticeIndexAction extends ActionSupport{
	private List<Notice> notices;//返回的文件列表
	
	public List<Notice> getNotices() {
		return notices;
	}
	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public String execute(){
		try {
			setNotices(commonService.getNoticePage(0, 5));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return SUCCESS;	
	}
}