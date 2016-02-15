package com.wangku.service;

import com.wangku.entity.VoteSequence;

public interface VoteSequenceDao {

	/**
	 * 
	 * 
	 * @author： 2015-6-19 上午10:14:33
	 * @方法名： addVoteSequence
	 * @方法描述：添加序列
	 * @param:
	 * @返回值：void
	 * 
	 */
	
	public void addVoteSequence(VoteSequence VoteSequence);

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 上午10:14:33
	 * @方法名： queryVoteSequence
	 * @方法描述：查询序列
	 * @param:
	 * @返回值：VoteSequence
	 * 
	 */
	
	public VoteSequence queryVoteSequence(String seqName);

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 上午10:14:33
	 * @方法名： emodifyVoteSequence
	 * @方法描述：修改序列
	 * @param:
	 * @返回值：void
	 * 
	 */
	
	public void modifyVoteSequence(VoteSequence VoteSequence);

	
	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 上午10:22:46
	 * @方法名： getIdByTableName
	 * @方法描述：根据表名获取主键，并维护序列表状态
	 * @param: 序列表的主键(即投票业务表的表名)
	 * @返回值：Long 投票业务表的新增数据id
	 * 
	 */
	public Long getIdByTableName(String seqName);
}
