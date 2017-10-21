package action.mainst;

import java.util.Map;

import service.MainstService;
import service.MasterService;
import service.impl.MainstServiceImpl;
import service.impl.MasterServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Mainstenance;
import exception.DaoException;

public class UpdateMainstAction extends ActionSupport{
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

	MainstService mainstService;
	
	public void setMainstService(MainstService mainstService) {
		this.mainstService = mainstService;
	}

	public String execute(){
		Map session = ActionContext.getContext().getSession();
		Mainstenance mainst = (Mainstenance)session.get("mainst");
		if(mainst==null)
			return LOGIN;
		if(flag==0){
			mainst.setTel(tel);
		}
		else if(flag==1){
			if(mainst.getPassword().equals(oldPass))
				mainst.setPassword(newPass);
			else{
				setMsg(false);
				return SUCCESS;
			}
		}
		else
			return ERROR;
		try {
			mainstService.updateMainst(mainst);
			setMsg(true);
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}
}
