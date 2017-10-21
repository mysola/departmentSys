package action.student;

import java.util.List;
import java.util.Map;

import service.StudentService;
import service.impl.StudentServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Repair;
import domain.Student;

public class GetStuRepairListAction extends ActionSupport{
	private int pageNum;//页数
	private int sumPerPage;//每页结果数
	private int resultSum;//结果总数
	private int pageSum;//总页数
	private List<Repair> repairs;

	public int getPageSum() {
		return pageSum;
	}

	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
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
	
	private StudentService studentService;
	
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String execute()throws Exception {
		if(pageNum<=0)
			return ERROR;
		int index = (pageNum-1)*sumPerPage;
		Map session = ActionContext.getContext().getSession();
		int bedroomId = ((Student)session.get("student")).getBedroom().getBedroomId();
		setRepairs(studentService.getRepairPage(bedroomId, index, sumPerPage));
		setResultSum(studentService.countRepairByBedroomId(bedroomId));
		setPageSum(resultSum % sumPerPage == 0 ? resultSum / sumPerPage
				: resultSum / sumPerPage + 1);
		return SUCCESS;
	}

}
