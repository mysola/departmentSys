package action.common;

import java.util.List;

import service.CommonService;
import service.impl.CommonServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain._File;
import exception.DaoException;

public class GetFileListAction extends ActionSupport{
	private int pageNum;//页数
	private int sumPerPage;//每页结果数
	private int resultSum;//结果总数
	private int pageSum;// 总页数
	private List<_File> files;//返回的文件列表
	
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
	public List<_File> getFiles() {
		return files;
	}
	public void setFiles(List<_File> files) {
		this.files = files;
	}
	
	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public String execute(){
		if(pageNum<=0)
			return ERROR;
		int index=(pageNum-1)*sumPerPage;
		try {
			setFiles(commonService.getFilePage(index, sumPerPage));
			setResultSum(commonService.countFile());
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}	
		setPageSum(resultSum % sumPerPage == 0 ? resultSum / sumPerPage
				: resultSum / sumPerPage + 1);
		return SUCCESS;	
	}
}
