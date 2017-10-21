package action.common;

import java.io.*;

import service.CommonService;

import com.opensymphony.xwork2.ActionSupport;

import domain._File;

public class DownloadFileAction extends ActionSupport{
	private int fileId;
	private String inputPath1;
	private InputStream targetFile;
	

	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public InputStream getTargetFile() throws IOException{
		return new FileInputStream(inputPath1);
	}

	private CommonService commonService;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	public String execute(){
		_File file = null;
		try {
			file = commonService.getFile(fileId);
			String in = file.getSavePath();
			inputPath1 = in;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}	
