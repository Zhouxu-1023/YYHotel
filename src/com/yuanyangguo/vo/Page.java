package com.yuanyangguo.vo;

public class Page {

	private String url;
	private int count;
	private int page;
	private int allPage;
	
	public Page(int count, int page, int allPage) {
		this.count = count;
		this.page = page;
		this.allPage = allPage;
	}

	public Page(String url, int count, int page, int allPage) {
		this.url = url;
		this.count = count;
		this.page = page;
		this.allPage = allPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	@Override
	public String toString() {
		return "Page [url=" + url + ", count=" + count + ", page=" + page + ", allPage=" + allPage + "]";
	}
}
