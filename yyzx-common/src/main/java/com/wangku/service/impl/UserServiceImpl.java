/**
 * @author 谢虹英
 * 2015-6-18上午9:15:18
 * 类描述：
 */

package com.wangku.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.User;
import com.wangku.entity.UserExample;
import com.wangku.mapper.UserMapper;
import com.wangku.service.UserService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.DigestUtil;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * @author 谢虹英
 * 2015-6-18上午9:15:18
 * 类描述：
 */
@Service
public class UserServiceImpl implements UserService {
@Autowired 
private UserMapper userMapper;
@Autowired 
private VoteSequenceDao seqDao;
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午8:55:25
	 * @方法名： queryAllUserByPage
	 * @方法描述：使用与超级管理员查所有管理员
	 * @param:超级管理员对象
	 * @返回值：List<User>
	 *
	 */
	@Override
	
	public Page<User> queryAllUserByPage(User user,Page<User> page)throws Exception {
		System.out.println("======================");
		//DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_TYPE_R);
		List<User> list=new ArrayList<User>();
		Integer uPower=user.getUserPower();
		System.out.println("service层---：进判断前"+uPower);
		if(user!=null){
			if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){//判断是否为超级管理员
				System.out.println("service层---：进判断前"+uPower);
				if(page==null){
					page = new Page<User>();
				}else{
					page.setPageSize(10);
				}//设置查sql语句中使用的page
				page.setSqlPage(page);
				//调用分页查所用管理员
				 list = userMapper.selectAllUserByPage(page.getOffsetValue(), page.getPageSize(),user.getUserId());
				 System.out.println("分页查所有---------"+list);
				//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
				 if(list.size()==0&&page.getCurrentNum()!=1){
					 page.setCurrentNum(page.getCurrentNum()-1);
					 page.setSqlPage(page);
					//调用分页查所用管理员
					 list = userMapper.selectAllUserByPage(page.getOffsetValue(), page.getPageSize(),user.getUserId());
				 }
				 //将查找出的对象放入PageList中
				 page.setPageList(list);
				//查未分页是的全部条数
				 UserExample ue = new UserExample();
				 ue.createCriteria();
				 List<User> users = userMapper.selectByExample(ue);
				//设置最大页数
				 page.setMaxPage(users.size()-1, page);
			}
			
		}
		return page;
	}

	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午9:03:50
	 * @方法名： queryOneUserBySiteName
	 * @方法描述：根据站点名称模糊查
	 * @param: 搜索条件
	 * @返回值：User
	 *
	 */
	@Override
	
	
	public Page<User> queryUserLikeBySiteName(String keyWord,Page<User> page,User user)throws Exception {
		//DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_TYPE_R);
		Integer uPower=user.getUserPower();
		if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
			if(page==null){
				page = new Page<User>();
			}else{
				page.setPageSize(10);
			}
			page.setSqlPage(page);
			
			if ("请输入关键字".equals(keyWord)) {
				keyWord = "%%";
			} else {
				keyWord = "%" + keyWord.trim() + "%";
			}
			List<User> list = userMapper.selectUserLikeByPage(keyWord,page.getOffsetValue(), page.getPageSize(),user.getUserId());
			page.setPageList(list);
			List<User> allList = userMapper.selectUserLike(keyWord,user.getUserId());
			page.setMaxPage(allList.size(), page);
		}
		return page;
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午11:21:20
	 * @方法名： queryOneByAcocount
	 * @方法描述：账户登录 查询该用户
	 * @param: 用户对象：含账户名和密码
	 * @返回值：List<User>
	 *
	 */
	@Override
	
	public List<User> queryOneByAcocount(User user)throws Exception{
		//DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_TYPE_R);
		UserExample ue = new UserExample();
		ue.createCriteria().andAccountLike(user.getAccount());
		List<User> list = userMapper.selectByExample(ue);
		return list;
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午11:21:20
	 * @方法名： queryOneByUserId
	 * @方法描述：根据UserId查一个对象
	 * @param: 用户对象：id
	 * @返回值：User
	 *
	 */
	@Override
	public User queryOneByUserId(User user)throws Exception{
		
		user = userMapper.selectByPrimaryKey(user.getUserId());
		return user;
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午8:57:15
	 * @方法名： addOneUser
	 * @方法描述：添加一个管理员
	 * @param:添加的对象
	 * @返回值：void
	 *
	 */
	@Override
	
	public String addOneUser(User user)throws Exception {
		//DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_TYPE_RW);
		String code="0";
		if(user!=null){
			Long seqVal = seqDao.getIdByTableName(VoteSeqEnum.VOTE_SYSTEM_SEQ.VOTE_USER.getValue());
			user.setUserId(seqVal);//设置对象id
			user.setPassword(DigestUtil.digestPassword(user.getPassword()));
			userMapper.insert(user);//滴啊用添加对象的方法
			code="1";
		}
		return code;
	}

	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午8:58:38
	 * @方法名： modifyOneUser
	 * @方法描述：修改管理员信息
	 * @param:修改对象
	 * @返回值：void
	 *
	 */
	@Override
	
	public String modifyOneUser(User user,String newpaw)throws Exception {
		//DynamicDataSourceHolder.setDbType(DynamicDataSourceHolder.DB_TYPE_RW);
		String code="0";
		if(user!=null){
			if(newpaw!=null){
				user.setPassword(DigestUtil.digestPassword(newpaw));
			}
			userMapper.updateByPrimaryKeySelective(user);
			code="1";
			
		}
		return code;
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-18 上午8:59:35
	 * @方法名： removeOneUser
	 * @方法描述：删除一个管理员
	 * @param:删除对象
	 * @返回值：void
	 *
	 */
	@Override
	
	public String removeOneUser(String deleteId)throws Exception {
		String code="0";
		if(deleteId!=null){
			String[] split = deleteId.split(",");
			List<Long>  deleteIds= new ArrayList<Long>();
			for (int i = 0; i < split.length; i++) {
				deleteIds.add(Long.parseLong(split[i]));
			}
			UserExample ue = new UserExample();
			ue.createCriteria().andUserIdIn(deleteIds);
			userMapper.deleteByExample(ue);
			code="1";
		}
		return code;
	}

}
