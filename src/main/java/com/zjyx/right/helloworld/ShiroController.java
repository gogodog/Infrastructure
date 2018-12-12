package com.zjyx.right.helloworld;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zjyx.right.model.persistence.AdminUser;

@Controller
public class ShiroController {

	@RequestMapping("index.do")    
	public String index(Model model) {    
	    //从shiro的session中取activeUser    
	    Subject subject = SecurityUtils.getSubject();    
	    //取身份信息    
	    AdminUser adminUser =  (AdminUser) subject.getPrincipal();    
	    //通过model传到页面    
	    model.addAttribute("adminUser", adminUser);    
	    return "admin/index";    
	}
	
	/**  
	 * 到登录界面  
	 *   
	 * @return  
	 * @throws Exception  
	 */    
	@RequestMapping("login.do")    
	public String adminPage(HttpServletRequest request) throws Exception {    
	    // 如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名    
	    String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");    
	    // 根据shiro返回的异常类路径判断，抛出指定异常信息    
	    if (exceptionClassName != null) {    
	        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {    
	            // 最终会抛给异常处理器    
	            throw new Exception("账号不存在");  
	        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {    
	            throw new Exception("用户名/密码错误");    
	        } else if ("randomCodeError".equals(exceptionClassName)) {    
	            throw new Exception("验证码错误 ");    
	        } else {    
	            throw new Exception();// 最终在异常处理器生成未知错误    
	        }    
	    }    
	    // 此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径    
	    // 登陆失败还到login页面    
	    return "admin/login";    
	}
	
	@RequestMapping("updatePassword.do")    
    @ResponseBody    
    public String updateAdminUserPassword(String newPassword) {    
        // 从shiro的session中取activeUser    
        Subject subject = SecurityUtils.getSubject();    
        // 取身份信息    
        AdminUser adminUser = (AdminUser) subject.getPrincipal();    
        // 生成salt,随机生成    
        SecureRandomNumberGenerator secureRandomNumberGenerator = new SecureRandomNumberGenerator();    
        String salt = secureRandomNumberGenerator.nextBytes().toHex();    
        Md5Hash md5 = new Md5Hash(newPassword, salt, 3);    
        String newMd5Password = md5.toHex();    
        // 设置新密码    
        adminUser.setPassword(newMd5Password);    
        // 设置盐    
        adminUser.setSalt(salt);    
        adminUserService.updateAdminUserPassword(adminUser);    
        return newPassword;    
    } 
}
