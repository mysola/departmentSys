package action.master;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import service.MasterService;
import service.impl.MasterServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain.Bedroom;
import domain.Student;
import exception.DaoException;

import javax.servlet.http.HttpServletRequest;

public class UpdateBedroomAction extends ActionSupport{
	private int score;
	private int bedroomId;
	private Integer used;
	private Date updateTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBedroomId() {
		return bedroomId;
	}

	public void setBedroomId(int bedroomId) {
		this.bedroomId = bedroomId;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	private MasterService masterService;
	
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	public String execute(){
		List<Bedroom> bedrooms = new ArrayList<Bedroom>();
		try{
				Bedroom bedroom = new Bedroom();
				bedroom.setBedroomId(bedroomId);
				bedroom.setScore(score);
				if(used==1){
					bedroom.setUsed(true);
				}
				else{
					bedroom.setUsed(false);
				}
				bedroom.setUpdateTime(updateTime);
				bedrooms.add(bedroom);
			masterService.updateBedroom(bedrooms);
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
