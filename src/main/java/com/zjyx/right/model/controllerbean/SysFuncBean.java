package com.zjyx.right.model.controllerbean;

public class SysFuncBean extends ListBaseBean{
	
	private String id;

    private String name;

    private String funcType;

    private String funcUrl;

    private String pid;

    private Long funcSeq;

    private Short siteId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFuncType() {
		return funcType;
	}

	public void setFuncType(String funcType) {
		this.funcType = funcType;
	}

	public String getFuncUrl() {
		return funcUrl;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Long getFuncSeq() {
		return funcSeq;
	}

	public void setFuncSeq(Long funcSeq) {
		this.funcSeq = funcSeq;
	}

	public Short getSiteId() {
		return siteId;
	}

	public void setSiteId(Short siteId) {
		this.siteId = siteId;
	}

}