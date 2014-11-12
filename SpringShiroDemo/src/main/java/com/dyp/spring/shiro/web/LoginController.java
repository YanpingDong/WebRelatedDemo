package com.dyp.spring.shiro.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Controller  
@RequestMapping("mydemo")  
public class LoginController {  
	private static final transient Logger log = LoggerFactory.getLogger(LoginController.class);
    /** 
     * 获取验证码图片和文本(验证码文本会保存在HttpSession中) 
     */  
    @RequestMapping("/getVerifyCodeImage")  
    public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {  
        //设置页面不缓存  
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        // String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);  
        //将验证码放到HttpSession里面  
        //request.getSession().setAttribute("verifyCode", verifyCode);  
        //System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");  
        //设置输出的内容的类型为JPEG图像  
        response.setContentType("image/jpeg");  
        //BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);  
        //写给浏览器  
        //ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());  
    }  
    
    /*
     * post 和 get两个login都是必需提供的。
     * Post是给Jsp调用Post用户数据的。而Get则是给Shiro使用。当第一次直接访问一个页面需要授权的页面的时候由Shiro
     * 转向的URL即loginUrl所指配置的
     */
    @RequestMapping(value="/login")  
    public String loginGet(HttpServletRequest request){  
    	return InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";  
    }
    
    /** 
     * 用户登录 
     * 如果在applicationContext.xml中配置了/mydemo/login=authc则不会执行到这个接口。会去执行
     * authc代表类实体的功能。所以在没有配置/mydemo/login=authc的时候解开下面注释
     * 注： /mydemo/login代表JSP中登录时访问的URL 可以参看login.jsp
     */  
    @RequestMapping(value="/login", method=RequestMethod.POST)  
    public String login(HttpServletRequest request){  
    	log.info("user login!!!!!");
        String resultPageURL = InternalResourceViewResolver.FORWARD_URL_PREFIX + "/";  
        
        //没有配置/mydemo/login=authc的时候解开下面注释
       /* String username = request.getParameter("username");  
        String password = request.getParameter("password");  
        //获取HttpSession中的验证码  
        String verifyCode = (String)request.getSession().getAttribute("verifyCode");  
        //获取用户请求表单中输入的验证码  
        String submitCode = WebUtils.getCleanParam(request, "verifyCode");  
        System.out.println("用户[" + username + "]登录时输入的验证码为[" + submitCode + "],HttpSession中的验证码为[" + verifyCode + "]");  

        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(verifyCode, submitCode.toLowerCase())){  
            request.setAttribute("message_login", "验证码不正确");  
            return resultPageURL;  
        }  
        if(submitCode.isEmpty() || verifyCode.equalsIgnoreCase(submitCode.toLowerCase()))
        {
        	 request.setAttribute("message_login", "验证码不正确");  
             return resultPageURL + "login.jsp";  
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
        token.setRememberMe(true);  
      //  System.out.println("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));  
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();  
        try {  
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            System.out.println("对用户[" + username + "]进行登录验证..验证开始");  
            currentUser.login(token);  
            System.out.println("对用户[" + username + "]进行登录验证..验证通过");  
            resultPageURL += "main";  
        }catch(UnknownAccountException uae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");  
            request.setAttribute("message_login", "未知账户");  
        }catch(IncorrectCredentialsException ice){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");  
            request.setAttribute("message_login", "密码不正确");  
        }catch(LockedAccountException lae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");  
            request.setAttribute("message_login", "账户已锁定");  
        }catch(ExcessiveAttemptsException eae){  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");  
            request.setAttribute("message_login", "用户名或密码错误次数过多");  
        }catch(AuthenticationException ae){  
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");  
            ae.printStackTrace();  
            request.setAttribute("message_login", "用户名或密码不正确");  
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");  
        }else{  
            token.clear();  
        }  */
        return resultPageURL;  

    }  
      
      
    /** 
     * 用户登出 
     * 如果在
     */  
    @RequestMapping("/logout")  
    public String logout(HttpServletRequest request){  
    	log.info("user logout!!!!!");
         SecurityUtils.getSubject().logout(); 
         
          /* 返回redirect:/ 然后根据<mvc:view-controller path="/" view-name="forward:/login.jsp"/> 
          * 的配置会转向login.jsp。
          * 如果在applicationContext.xml中配置了/mydemo/logout=logout则不会跳转到这里会去执行Shiro中logout
          * 代表的类.注： /mydemo/logout代表JSP中退出时访问的URL 可以参看mian.jsp
          */
          
         return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";  
    }  
    
    @SuppressWarnings("restriction")
	@RequestMapping("/test")
    public void test( HttpServletResponse response)
    {
    	try {
			response.sendRedirect("login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}  
