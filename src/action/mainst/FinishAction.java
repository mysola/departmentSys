package action.mainst;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import service.MainstService;
import service.impl.MainstServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Mainstenance;
import domain.Repair;
import exception.DaoException;

public class FinishAction extends ActionSupport{
	private int[] repairId;
	private Date finishTime;

	public int[] getRepairId() {
		return repairId;
	}

	public void setRepairId(int[] repairId) {
		this.repairId = repairId;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	MainstService mainstService;
	
	public void setMainstService(MainstService mainstService) {
		this.mainstService = mainstService;
	}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		Mainstenance mainst = (Mainstenance)session.get("mainst");
		List<Repair> repair = new ArrayList<Repair>(); 
		try{
			for(int i=0;i<repairId.length;i++){
				Repair re = new Repair();
				re.setRepairId(repairId[i]);
				re.setFinishTime(finishTime);
				re.setReceiver(mainst);
				repair.add(re);
			}	
			mainstService.finish(repair);
		}catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
