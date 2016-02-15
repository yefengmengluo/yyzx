/**
 * @author 谢虹英
 * 2015-6-18上午11:30:24
 * 类描述：
 */

package com.wangku.controller.vote;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.User;
import com.wangku.service.UserService;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * @author 谢虹英
 * 2015-6-18上午11:30:24
 * 类描述：管理员
 */
@Controller
@RequestMapping("userController")
public class UserController {
	@Autowired UserService userService;
	
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 下午4:18:42
	 * @方法名： queryAllUserByPage
	 * @方法描述：超级管理员查所有员工
	 * @param: 管理员权限、page当前页
	 * @返回值：String
	 *
	 */
	@RequestMapping("/queryAllUserByPage")
	public String queryAllUserByPage(ModelMap map,HttpServletRequest request,Page<User> page){
		try {
			User user = (User)request.getSession().getAttribute("user");
			Integer power = user.getUserPower();
			if(user!=null){
				if(power==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||power==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
					page = userService.queryAllUserByPage(user, page);
						map.put("page", page);
						return "backstage/backPage/users/users_list";
				}
				/*else{
					return "backstage/backPage/errors/prower_error";
				}*/
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/errors/prower_error";
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 下午4:18:42
	 * @方法名： queryUserLikeByPage
	 * @方法描述：超级管理员     模糊   查所有员工
	 * @param: 管理员权限、page当前页 ，搜索关键字keyWord
	 * @返回值：String
	 *
	 */
	@RequestMapping("/queryUserLikeByPage")
	public String queryUserLikeByPage(ModelMap map,HttpServletRequest request,Page<User> page,String keyWord ){
		try {
			User user = (User)request.getSession().getAttribute("user");
			Integer power=user.getUserPower();
			if(user!=null){
				if(power==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||power==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
					
					page = userService.queryUserLikeBySiteName(keyWord, page, user);
						map.put("page", page);
						map.put("keyWord", keyWord.trim());
						return "backstage/backPage/users/users_like_list";
				}
				/*else{
					return "backstage/backPage/errors/prower_error";
				}*/
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/errors/prower_error";
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-20 下午12:48:55
	 * @方法名： queryOneByUserId
	 * @方法描述：根据用户id查一个
	 * @param:用户对象
	 * @返回值：String
	 *
	 */
	@RequestMapping("/queryOneByUserId")
	public String queryOneByUserId(ModelMap map,User user,Integer uPower,Page<User> page){
		try {
			user = userService.queryOneByUserId(user);
			map.put("user", user);
			map.put("uPower", uPower);
			map.put("page", page);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/userController/queryAllUserByPage";
		}
		return "backstage/backPage/users/users_edit";
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-20 下午12:48:55
	 * @方法名： queryOneByUserId
	 * @方法描述：根据用户账号查找
	 * @param:用户对象
	 * @返回值：String
	 *
	 */
	@RequestMapping("/queryOneByUseraccount")
	@ResponseBody
	public String queryOneByUseraccount(String account){
		String code="1";//表示用户不存在。可以使用该账号
		try {
			User user = new User();
			user.setAccount(account);
			 List<User> list = userService.queryOneByAcocount(user);
			 if(list.size()>0){
				 code="0";//表示用户存在。不可以使用该账号
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return code;
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 下午4:20:50
	 * @方法名： addAllUser
	 * @方法描述：添加一个用户
	 * @param:用户对象
	 * @返回值：String
	 *
	 */
	@RequestMapping("/addAllUser")
	public String addAllUser(ModelMap map,User user,Page<User> page){
		try {
			userService.addOneUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/userController/queryAllUserByPage";
		}
		return "redirect:/userController/queryAllUserByPage";
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 下午4:24:50
	 * @方法名： modifyUser
	 * @方法描述：修改用户信息
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/modifyUser")
	public String modifyUser(User user,Page<User> page,String newpaw){
		try {
			userService.modifyOneUser(user,newpaw);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/userController/queryAllUserByPage?currentNum="+page.getCurrentNum();
		}
		return "redirect:/userController/queryAllUserByPage?currentNum="+page.getCurrentNum();
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 下午4:24:50
	 * @方法名： modifyUser
	 * @方法描述：修改密码
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public String modifyPassword(User user,String newpaw){
		String code="0";
		try {
			code=userService.modifyOneUser(user,newpaw);
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return code;
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 下午4:24:40
	 * @方法名： removeUser
	 * @方法描述：删除用户
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping("/removeUser")
	public String removeUser(String deleteIds,Page<User> page){
		try {
			userService.removeOneUser(deleteIds);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/userController/queryAllUserByPage?currentNum="+page.getCurrentNum();
		}
		return "redirect:/userController/queryAllUserByPage?currentNum="+page.getCurrentNum();
	}
	
	
}
