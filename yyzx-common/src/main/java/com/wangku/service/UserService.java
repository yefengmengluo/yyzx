/**
 * @author 谢虹英
 * 2015-6-18上午8:53:55
 * 类描述：
 */

package com.wangku.service;

import java.util.List;

import com.wangku.entity.User;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;

/**
 * @author 谢虹英
 * 2015-6-18上午8:53:55
 * 类描述：
 */
public interface UserService {
/**
 * 
 * @author： 谢虹英  2015-6-18 上午8:55:25
 * @方法名： queryAllUser
 * @方法描述：使用与超级管理员查所有管理员
 * @param:超级管理员对象
 * @返回值：List<User>
 *
 */
	@DataSource("slave")
	public Page<User> queryAllUserByPage(User user,Page<User> page)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午9:03:50
	 * @方法名： queryOneUserBySiteName
	 * @方法描述：根据站点名称    模糊查
	 * @param: 搜索条件
	 * @返回值：User
	 *
	 */
	@DataSource("slave")
	public Page<User> queryUserLikeBySiteName(String sitName,Page<User> page,User user)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午11:21:20
	 * @方法名： queryOneByAcocount
	 * @方法描述：账户登录 查询该用户
	 * @param: 用户对象：含账户名和密码
	 * @返回值：String
	 *
	 */
	@DataSource("master")
	public List<User> queryOneByAcocount(User user)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午11:21:20
	 * @方法名： queryOneByUserId
	 * @方法描述：根据UserId查一个对象
	 * @param: 用户对象：id
	 * @返回值：User
	 *
	 */
	@DataSource("slave")
	public User queryOneByUserId(User user)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午8:57:15
	 * @方法名： addOneUser
	 * @方法描述：添加一个管理员
	 * @param:添加的对象
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public String addOneUser(User user)throws Exception;
	
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午8:58:38
	 * @方法名： modifyOneUser
	 * @方法描述：修改管理员信息
	 * @param:修改对象
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public String modifyOneUser(User user,String newpaw)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午8:59:35
	 * @方法名： removeOneUser
	 * @方法描述：删除一个管理员
	 * @param:删除对象
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public String removeOneUser(String deleteId)throws Exception;
}
