package com.zjyx.right.model.controllerbean;

import com.mysql.jdbc.StringUtils;

public class SysRoleBean extends ListBaseBean{
    private String roleId;

    private String roleName;

    private String createuser;

    private Short siteId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null || StringUtils.isEmptyOrWhitespaceOnly(roleName) ? null : roleName.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public Short getSiteId() {
        return siteId;
    }

    public void setSiteId(Short siteId) {
        this.siteId = siteId;
    }
}