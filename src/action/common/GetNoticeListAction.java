package action.common;

import java.util.List;

import service.CommonService;
import service.impl.CommonServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain.Notice;
import exception.DaoException;

public class GetNoticeListAction extends ActionSupport {
	private int pageNum;// 页数
	private int sumPerPage;// 每页结果数
	private int resultSum;// 结果总数
	private int pageSum;// 总页数
	private List<Notice> notices;// 返回的文件列表

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

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
	
	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public String execute(){
		if (pageNum <= 0)
			return ERROR;
		int index = (pageNum - 1) * sumPerPage;
		try {
			setNotices(commonService.getNoticePage(index, sumPerPage));
			setResultSum(commonService.countNotice());
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}		
		setPageSum(resultSum % sumPerPage == 0 ? resultSum / sumPerPage
				: resultSum / sumPerPage + 1);
		return SUCCESS;
	}
}
