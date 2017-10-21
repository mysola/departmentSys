package action.common;

import java.util.List;

import service.CommonService;
import service.impl.CommonServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain.Bedroom;
import exception.DaoException;

public class GetBedroomByBuilding extends ActionSupport{
	private int buildingId;
	private List<Bedroom> bedrooms;

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public List<Bedroom> getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(List<Bedroom> bedrooms) {
		this.bedrooms = bedrooms;
	}

	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	public String execute(){
		try {
			setBedrooms(commonService.getBedroom(buildingId));
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
