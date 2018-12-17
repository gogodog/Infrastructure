package com.zjyx.right.model.persistence;

public class SysFunc {
    private String id;

    private String name;

    private String funcType;

    private String funcUrl;

    private String pId;

    private Long funcSeq;

    private Short siteId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFuncType() {
        return funcType;
    }

    public void setFuncType(String funcType) {
        this.funcType = funcType == null ? null : funcType.trim();
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
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

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}
	
	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}
}