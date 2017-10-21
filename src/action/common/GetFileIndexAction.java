package action.common;

import java.util.List;

import service.CommonService;
import service.impl.CommonServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

import domain._File;
import exception.DaoException;

public class GetFileIndexAction extends ActionSupport{
	private List<_File> files;//返回的文件列表

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
		try {
			setFiles(commonService.getFilePage(0, 5));
		} catch (DaoException e) {
			addActionError(e.getMessage());
		}
		return SUCCESS;	
	}
}
