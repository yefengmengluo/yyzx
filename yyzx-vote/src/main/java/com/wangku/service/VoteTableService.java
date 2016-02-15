package com.wangku.service;

import java.util.List;

import com.wangku.entity.User;
import com.wangku.entity.VoteTable;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;

public interface VoteTableService {

	/**
	 * @author： 徐国辉 2015-6-23 上午9:24:07
	 * @方法名： quaryAll
	 * @方法描述：查询全部的 投票主题记录
	 * @param:
	 * @返回值：List<VoteTable>
	 * 
	 */
	@DataSource("slave")
	public List<VoteTable> quaryAll(User user);

	/**
	 * @author： 徐国辉 2015-6-25 下午3:02:20
	 * @方法名： quaryByUserId
	 * @方法描述：根据用户id查找 投票主题记录
	 * @param: userId 用户id
	 * @返回值：List<VoteTable>
	 * 
	 */
	@DataSource("slave")
	public List<VoteTable> quaryByUserId(Long userId,Integer userPower);

	/**
	 * @author： 徐国辉 2015-6-17 下午6:19:39
	 * @方法名： queryAllPage
	 * @方法描述：条件分页查询 投票主题记录,超级管理员登录调用
	 * @param: keyWord 关键字 , currentNum 当前页
	 * @返回值：List<VoteTable>
	 * 
	 */
	@DataSource("slave")
	public Page<VoteTable> queryAllPage(String keyWord, Integer currentNum);
	
	/**
	 * @author： 徐国辉 2015-6-17 下午6:19:39
	 * @方法名： querySomePage
	 * @方法描述：根据用户id条件分页查询 投票主题记录,普通用户登录调用
	 * @param: keyWord 关键字 , currentNum 当前页 , userId 登录用户id
	 * @返回值：List<VoteTable>
	 * 
	 */
	@DataSource("slave")
	public Page<VoteTable> querySomePage(String keyWord, Integer currentNum,Long userId);

	
	
	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:20:02
	 * @方法名： addVoteTable
	 * @方法描述：添加投票主题
	 * @param:
	 * @返回值：void
	 * 
	 */
	@DataSource("master")
	public void addVoteTable(VoteTable voteTable);

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:20:24
	 * @方法名： queryVoteTable
	 * @方法描述：查询投票主题
	 * @param:
	 * @返回值：VoteTable
	 * 
	 */
	@DataSource("slave")
	public VoteTable queryVoteTable(Long id);

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:27:07
	 * @方法名： emodifyVoteTable
	 * @方法描述：修改投票主题
	 * @param:
	 * @返回值：void
	 * 
	 */
	@DataSource("master")
	public void modifyVoteTable(VoteTable voteTable);

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:27:12
	 * @方法名： removeVoteTable
	 * @方法描述：删除 投票主题
	 * @param:
	 * @返回值：void
	 * 
	 */
	@DataSource("master")
	public void removeVoteTable(Long id);
}
