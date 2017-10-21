package action.common;

import java.util.List;

import service.CommonService;
import service.impl.CommonServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain.Campus;
import exception.DaoException;

public class GetCampusAction extends ActionSupport{
	private List<Campus> campus;
	
	public List<Campus> getCampus() {
		return campus;
	}

	public void setCampus(List<Campus> campus) {
		this.campus = campus;
	}

	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	public String execute(){
		try {
			setCampus(commonService.getAllCampus());
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
