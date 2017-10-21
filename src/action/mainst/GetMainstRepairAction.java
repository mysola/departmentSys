package action.mainst;

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

public class GetMainstRepairAction extends ActionSupport{
	private int pageNum;//页数
	private int sumPerPage;//每页结果数
	private int resultSum;//结果总数
	private int pageSum;//总页数
	private List<Repair> repairs;//返回的文件列表
	private String flag;//unReceived代表未接，received代表已接未完成，history代表已接已完成
	
	
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getSumPerPage() {
		return sumPerPage;
	}
	public void setSumPerPage(int sumPerPage) {
		this.sumPerPage = sumPerPage;
	}
	public int getResultSum() {
		return resultSum;
	}
	public void setResultSum(int resultSum) {
		this.resultSum = resultSum;
	}
	
	public List<Repair> getRepairs() {
		return repairs;
	}
	public void setRepairs(List<Repair> repairs) {
		this.repairs = repairs;
	}
	MainstService mainstService;
	
	public void setMainstService(MainstService mainstService) {
		this.mainstService = mainstService;
	}

	public String execute(){
		if(pageNum<=0)
			return ERROR;
		int index=(pageNum-1)*sumPerPage;
		Map session = ActionContext.getContext().getSession();
		int mainstId = ((Mainstenance)session.get("mainst")).getMainstenanceId();
		try{
			if("unReceived".equals(flag)){					
				setRepairs(mainstService.getNotReceivedPage(mainstId, index, sumPerPage));			
				setResultSum(mainstService.countNotReceived(mainstId));	
			}
			else if("received".equals(flag)){
				setRepairs(mainstService.getReceivedPage(mainstId, index, sumPerPage));
				setResultSum(mainstService.countReceived(mainstId));
			}
			else if("history".equals(flag)){
				setRepairs(mainstService.getHistoryPage(mainstId, index, sumPerPage));
				setResultSum(mainstService.countHistory(mainstId));
			}
			else
				return ERROR;
		}catch (DaoException e) {
			addActionError(e.getMessage());
		}
		setPageSum(resultSum % sumPerPage == 0 ? resultSum / sumPerPage
				: resultSum / sumPerPage + 1);
		return SUCCESS;	
	}
}
