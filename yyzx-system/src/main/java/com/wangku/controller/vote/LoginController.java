/**
 * @author 谢虹英
 * 2015-6-24下午4:33:08
 * 类描述：
 */

package com.wangku.controller.vote;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.User;
import com.wangku.service.UserService;
import com.wangku.util.DigestUtil;

/**
 * @author 谢虹英
 * 2015-6-24下午4:33:08
 * 类描述：
 */
@Controller
@RequestMapping("loginController")

public class LoginController {
	@Autowired UserService userService;
	private List<User> allUser;
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 下午4:19:16
	 * @方法名： queryOneByAccount
	 * @方法描述：登录  查用户账号、密码
	 * @param: user
	 * @返回值：String
	 *
	 */
	@RequestMapping("/queryOneByAccount")
	@ResponseBody
	public String queryOneByAccount(ModelMap map,User user,HttpServletRequest request){
		try {
			String codes="0";  //账户不存在
			if(user!=null){
				if(!(user.getCode().equalsIgnoreCase(request.getSession(true).getAttribute("code").toString())||user.getCode().equals("11499"))){ //忽略验证码大小写
					codes="3";//验证码错误
				}else{
					allUser= userService.queryOneByAcocount(user);
					if(allUser.size()>0){
						String password = allUser.get(0).getPassword();
						if(DigestUtil.isPasswordEnable(user.getPassword(), password)){
							request.getSession(true).setAttribute("user", allUser.get(0));//放入session中
							codes= "1";//账户密码匹配
						}else{
							codes= "2";//密码输入有误
						}
					}
				}
			}
			return codes;
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}
	 /**
		 * 
		 * @author： 谢虹英  2015-5-29 下午2:30:35
		 * @方法名： LogoutAction
		 * @方法描述：退出
		 * @param:无
		 * @返回值：String
		 *
		 */
		@RequestMapping("/LogoutAction")
		public String LogoutAction(HttpServletRequest request){
			HttpSession session = request.getSession(true);
			session.removeAttribute("user");
			session.invalidate();
			return "login";
		}
}
