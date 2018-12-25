package com.zjyx.right.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.zjyx.right.mapper.SysFuncRoleMapper;
import com.zjyx.right.mapper.SysUserMapper;
import com.zjyx.right.mapper.SysUserRoleMapper;
import com.zjyx.right.model.persistence.SysRole;
import com.zjyx.right.model.persistence.SysUser;

public class CustomRealm extends AuthorizingRealm {
	
	@Resource
	SysUserMapper sysUserMapper; 
	
	@Resource
	SysFuncRoleMapper sysFuncRoleMapper;
	
	@Resource
	SysUserRoleMapper sysUserRoleMapper;
	
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    	SysUser sysUser= (SysUser) principalCollection.getPrimaryPrincipal();
    	SimpleAuthorizationInfo info = null;
    	if(sysUser!=null){
    		List<SysRole> sysRoleList=sysUserRoleMapper.getByRoleId(sysUser.getUserId());
    		List<String> roleIdList = new ArrayList<String>();
    		List<String> roleNameList = new ArrayList<String>();
    		for(SysRole sysRole:sysRoleList){
    			roleIdList.add(sysRole.getRoleId());
    			roleNameList.add(sysRole.getRoleName());
    		}
    		List<String> funcCodeList = sysFuncRoleMapper.selectFuncCode(roleIdList);
    	    info = new SimpleAuthorizationInfo();
            info.addStringPermissions(funcCodeList);
            info.addRoles(roleNameList);
    	}
        return info;
    }
    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        SysUser sysUser = sysUserMapper.selectByUserName(userName);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),this.getName());
        return info;
    }
}
