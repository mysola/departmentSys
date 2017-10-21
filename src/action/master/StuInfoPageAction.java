package action.master;

import java.util.List;
import java.util.Map;

import service.MasterService;
import service.impl.MasterServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.HouseMaster;
import domain.Student;
import exception.DaoException;


public class StuInfoPageAction extends ActionSupport{
	private int pageNum;//页数
	private int sumPerPage;//每页结果数
	private int resultSum;//结果总数
	private int pageSum;// 总页数
	private List<Student> students;//返回的学生列表
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
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	private MasterService masterService;
	
	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}
	public String execute(){
		if(pageNum<=0)
			return ERROR;
		int index=(pageNum-1)*sumPerPage;
		Map session = ActionContext.getContext().getSession();
		HouseMaster master = (HouseMaster)session.get("master");
		if(master==null)
			return LOGIN;
		int buildingId = master.getBuilding().getBuildingId();
		try {

			setStudents(masterService.getStudentPage(buildingId, index, sumPerPage));
			setResultSum(masterService.countStudent(buildingId));
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}	
		setPageSum(resultSum % sumPerPage == 0 ? resultSum / sumPerPage
				: resultSum / sumPerPage + 1);
		return SUCCESS;	
	}
}
