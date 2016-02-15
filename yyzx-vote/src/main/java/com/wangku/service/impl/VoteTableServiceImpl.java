package com.wangku.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.User;
import com.wangku.entity.VoteTable;
import com.wangku.entity.VoteTableExample;
import com.wangku.mapper.VoteTableMapper;
import com.wangku.service.VoteItemService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.service.VoteTableService;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * vote服务实现。
 * 
 */
@Service
public class VoteTableServiceImpl implements VoteTableService {
	
	@Autowired
	private VoteTableMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	@Autowired
	private VoteItemService voteItemService;

	

	/**
	 * @author： 徐国辉 2015-6-23 上午9:24:07
	 * @方法名： quaryAll
	 * @方法描述：查询全部的 投票主题记录
	 * @param:
	 * @返回值：List<VoteTable>
	 * 
	 */
	public List<VoteTable> quaryAll(User user) {
		VoteTableExample qbe=new VoteTableExample();
		Integer userPower=user.getUserPower();
		if(userPower == VoteSeqEnum.UPOWER.ALLPOWER.getValue()||userPower == VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
			qbe.createCriteria();
		}else{
			qbe.createCriteria().andUserIdEqualTo(user.getUserId());
		}
		return mapper.selectByExample(qbe);
	}
	
	/**
	 * @author： 徐国辉 2015-6-25 下午3:02:20
	 * @方法名： quaryByUserId
	 * @方法描述：根据用户id查找 投票主题记录
	 * @param: userId 用户id
	 * @返回值：List<VoteTable>
	 * 
	 */
	public List<VoteTable> quaryByUserId(Long userId,Integer userPower){
		
		VoteTableExample qbe=new VoteTableExample();
		if(userPower == VoteSeqEnum.UPOWER.ALLPOWER.getValue()||userPower == VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
			qbe.createCriteria();
		}else if(userPower == VoteSeqEnum.UPOWER.VOTE_POWER.getValue()){
			qbe.createCriteria().andUserIdEqualTo(userId);
		}
		

		return mapper.selectByExample(qbe);
	}

	
	
	/**
	 * @author： 徐国辉 2015-6-17 下午6:19:39
	 * @方法名： queryAllPage
	 * @方法描述：条件分页查询 投票主题记录,超级管理员登录调用
	 * @param: keyWord 关键字 , currentNum 当前页
	 * @返回值：List<VoteTable>
	 * 
	 */
	
	public Page<VoteTable> queryAllPage(String keyWord,Integer currentNum) {
		Page<VoteTable> page = new Page<VoteTable>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<VoteTable> voteTables=mapper.selectWithKeyWordPaged(keyWord,page.getOffsetValue(),page.getPageSize());
		//查询该条件下的总记录数
		VoteTableExample qbe=new VoteTableExample();
		qbe.createCriteria().andVSubjectLike(keyWord);
		int listsize = mapper.countByExample(qbe);
		page.setPageList(voteTables);
		page.setMaxPage(listsize, page);
		return page;
	}
	
	/**
	 * @author： 徐国辉 2015-6-17 下午6:19:39
	 * @方法名： querySomePage
	 * @方法描述：根据用户id条件分页查询 投票主题记录,普通用户登录调用
	 * @param: keyWord 关键字 , currentNum 当前页 , userId 登录用户id
	 * @返回值：List<VoteTable>
	 * 
	 */
	
	public Page<VoteTable> querySomePage(String keyWord,Integer currentNum,Long userId) {
		Page<VoteTable> page = new Page<VoteTable>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<VoteTable> voteTables=mapper.selectSomeWithKeyWordPaged(keyWord,page.getOffsetValue(),page.getPageSize(),userId);
		//查询该条件下的总记录数
		VoteTableExample qbe=new VoteTableExample();
		qbe.createCriteria().andVSubjectLike(keyWord).andUserIdEqualTo(userId);
		int listsize = mapper.countByExample(qbe);
		page.setPageList(voteTables);
		page.setMaxPage(listsize, page);
		return page;
	}
	
	
	
	

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:20:02
	 * @方法名： addVoteTable
	 * @方法描述：添加投票主题
	 * @param: 投票主题对象
	 * @返回值：void
	 * 
	 */
	
	public void addVoteTable(VoteTable voteTable) {
		Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.VOTE_SYSTEM_SEQ.VOTE_TABLE.getValue());
		voteTable.setId(id);
		voteTable.setDataAddTime(new Date());
		mapper.insert(voteTable);
	}
	
	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:20:24
	 * @方法名： queryVoteTable
	 * @方法描述：查询投票主题
	 * @param: 投票主题id
	 * @返回值：VoteTable
	 * 
	 */
	public VoteTable queryVoteTable(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:27:07
	 * @方法名： emodifyVoteTable
	 * @方法描述：修改投票主题
	 * @param: 投票主题对象
	 * @返回值：void
	 * 
	 */
	public void modifyVoteTable(VoteTable voteTable) {
		voteTable.setDataModifyTime(new Date());
		mapper.updateByPrimaryKey(voteTable);
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-17 下午6:27:12
	 * @方法名： 	removeVoteTable
	 * @方法描述：删除 投票主题
	 * @param: 投票主题id
	 * @返回值：void
	 * 
	 */
	
	public void removeVoteTable(Long id) {
		mapper.deleteByPrimaryKey(id);
		//修改投票品牌
		voteItemService.removeItemByVid(id);
	}

}
