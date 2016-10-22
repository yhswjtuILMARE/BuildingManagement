package domain;

import java.util.List;

public class page {
	
	private List list;
	private int totalRecord;//
	private int totalPage;//
	private int startPage;//
	private int endPage;//
	private int currentPage = 1;//
	private int pageInframe = 10;
	private int pageContain = 10;
	private String url;
	
	public page(int totalRecord,int currentPage){
		
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		totalPage = (totalRecord%pageContain == 0)?(totalRecord/pageContain):(totalRecord/pageContain)+1;
		if((currentPage - pageInframe/2 +1) <= 0){
			startPage = 1;
		}else{
			startPage = currentPage - pageInframe/2 + 1;
		}
		if(currentPage + pageInframe/2 >= totalPage){
			endPage = totalPage;
		}else{
			endPage = currentPage + pageInframe/2;
		}
	}
	
	
	public int getPageInframe() {
		return pageInframe;
	}


	public void setPageInframe(int pageInframe) {
		this.pageInframe = pageInframe;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPageContain() {
		return pageContain;
	}

	public void setPageContain(int pageContain) {
		this.pageContain = pageContain;
	}
}
