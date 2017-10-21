package action.student;

import java.util.List;

import service.CommonService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Type;
import exception.DaoException;

public class AddRepairPageAction extends ActionSupport{
	private List<Type> types;
	
	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public String execute(){
		try {
			setTypes(commonService.getAllType());
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
