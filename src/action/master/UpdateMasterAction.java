package action.master;

import java.util.Map;

import service.MasterService;
import service.impl.MasterServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.HouseMaster;
import exception.DaoException;

public class UpdateMasterAction extends ActionSupport{
	private int tel;
	private int flag;//0代表改电话，1代表改密码
	private String oldPass;
	private String newPass;
	private Boolean msg;
	
	public Boolean getMsg() {
		return msg;
	}

	public void setMsg(Boolean msg) {
		this.msg = msg;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}

	private MasterService masterService;
	
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	public String execute(){
		Map session = ActionContext.getContext().getSession();
		HouseMaster master = (HouseMaster)session.get("master");
		if(master==null)
			return LOGIN;
		if(flag==0){
			master.setTel(tel);
		}
		else if(flag==1){
			if(master.getPassword().equals(oldPass))
				master.setPassword(newPass);
			else{
				setMsg(false);
				return SUCCESS;
			}
		}
		else
			return ERROR;
		try {
			masterService.updateMaster(master);
			setMsg(true);
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
