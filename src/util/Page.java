package util;

public class Page {
	private int pageNum1;
	private int pageSum1;
	private int begin;
	private int end;

	public int getPageNum1() {
		return pageNum1;
	}
	public void setPageNum1(int pageNum1) throws Exception {
		this.pageNum1 = pageNum1;
		if(pageNum1<1)
			throw new Exception("页面pageNum参数错误");
	}
	public int getPageSum1() {
		return pageSum1;
	}
	public void setPageSum1(int pageSum1) throws Exception {
		this.pageSum1 = pageSum1;
		if(pageSum1<0)
			throw new Exception("页面pageSum参数错误");
	}


	public int getBegin() {
		if(pageNum1<=5){
			begin=1;
		}
		else if(pageNum1>5&&pageNum1<pageSum1-4){
			begin=pageNum1-4;
		}
		else{
			begin=pageSum1-9;
		}
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		if(pageSum1<=10){
			end=pageSum1;
		}
		else if(pageNum1>=pageSum1-4){
			end=pageSum1;
		}
		else if(pageNum1>5&&pageNum1<pageSum1-4){
			end=pageNum1+5;
		}
		else{
			end=10;
		}
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}

