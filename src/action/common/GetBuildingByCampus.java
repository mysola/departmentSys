package action.common;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import service.CommonService;
import service.impl.CommonServiceImpl;
import domain.Building;
import exception.DaoException;

public class GetBuildingByCampus extends ActionSupport{
	private int campusId;
	private List<Building> buildings;

	public int getCampusId() {
		return campusId;
	}

	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	public String execute(){
		try {
			setBuildings(commonService.getBuilding(campusId));
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
