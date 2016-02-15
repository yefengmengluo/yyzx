package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.User;
import com.wangku.entity.UserExample;

public interface UserMapper {
	
    int countByExample(UserExample example);
	
    int deleteByExample(UserExample example);
	
    int deleteByPrimaryKey(Long userId);
	
    int insert(User record);
	
    int insertSelective(User record);
	
    List<User> selectByExample(UserExample example);
	
    User selectByPrimaryKey(Long userId);
    
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
    
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    
    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
   /**
    * 
    * @author： 谢虹英  2015-6-19 上午11:20:07
    * @方法名： selectWithKeyWordPaged
    * @方法描述：分页查所有管理员
    * @param:
    * @返回值：List<VoteTable>
    *
    */
    
	List<User> selectAllUserByPage(
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize,
			@Param("userId")Long userId);
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 上午11:20:07
	 * @方法名： selectWithKeyWordPaged
	 * @方法描述：模糊分页查所有管理员
	 * @param:
	 * @返回值：List<VoteTable>
	 *
	 */
    
	List<User> selectUserLikeByPage(@Param("keyWord") String keyWord,
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize,
			@Param("userId")Long userId);
	/**
	 * 
	 * @author： 谢虹英  2015-6-19 上午11:20:07
	 * @方法名： selectUserLike
	 * @方法描述：模糊查所有管理员   不分页
	 * @param:
	 * @返回值：List<VoteTable>
	 *
	 */
    
	List<User> selectUserLike(@Param("keyWord") String keyWord,
			@Param("userId")Long userId);
}