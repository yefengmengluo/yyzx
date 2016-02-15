/**
 * @author 谢虹英
 * 2015-6-23上午9:13:59
 * 类描述：
 */

package com.wangku.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.Comment;
import com.wangku.entity.CommentExample;
import com.wangku.mapper.CommentMapper;
import com.wangku.mapper.VoteItemTableMapper;
import com.wangku.service.CommentService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * @author 谢虹英
 * 2015-6-23上午9:13:59
 * 类描述：
 */
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired CommentMapper comMapper;
	@Autowired VoteItemTableMapper itemMapper;
	@Autowired VoteSequenceDao seqDao;
	/**
	 * 
	 * @author： 谢虹英  2015-6-17 下午4:41:53
	 * @方法名： queryAllVoteItemByCommentCount
	 * @方法描述：根据评论数降序排列 查所有品牌
	 * @param::用户权限，主题ID,page
	 * @返回值：List<Comment>
	 *
	 */
	@Override
	
	public Page<Comment> queryAllVoteItemByCommentCount(Integer uPower,Long vId,Page<Comment> page)throws Exception {
		List<Comment> list=null;
		List<Comment> list2=null;
		if(page==null){
				page = new Page<Comment>();
			}else{
				page.setPageSize(10);
			}//设置查sql语句中使用的page
			page.setSqlPage(page);
			//超级管理员   ：分页查所有品牌  按评论数降序排列
			if(uPower!=null){
			if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){
				list = comMapper.selectAllVoteItemByCommentCountByPage(page.getOffsetValue(),page.getPageSize());
				//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
				 if(list.size()==0&&page.getCurrentNum()!=1){
					 page.setCurrentNum(page.getCurrentNum()-1);
					 page.setSqlPage(page);
					 list = comMapper.selectAllVoteItemByCommentCountByPage(page.getOffsetValue(),page.getPageSize());
				 }
				//超级管理员   ：非分页查所有品牌  按评论数降序排列
				list2= comMapper.selectAllVoteItemByCommentCount();
			}else{
				//普通管理员   ：分页查所有品牌  按评论数降序排列
				list=comMapper.selectOneVoteTableAllVoteItemByCommentCountByPage(vId,page.getOffsetValue(),page.getPageSize());
				//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
				if(list.size()==0&&page.getCurrentNum()!=1){
					 page.setCurrentNum(page.getCurrentNum()-1);
					 page.setSqlPage(page);
					 list=comMapper.selectOneVoteTableAllVoteItemByCommentCountByPage(vId,page.getOffsetValue(),page.getPageSize());
				 }
				//普通管理员   ：非分页查所有品牌  按评论数降序排列
				list2=comMapper.selectOneVoteTableAllVoteItemByCommentCount(vId);
			}
			//添加PageList集合对象
			page.setPageList(list);
			//设置最大页数
			page.setMaxPage(list2.size(), page);
		}
		return page;
	}
	 /**
     * 
     * @author： 谢虹英  2015-6-24 上午10:00:41
     * @方法名： selectVoteItemLikeByUser
     * @方法描述：超级管理员/普通管理员  模糊查品牌
     * @param:关键字
     * @返回值：List<Comment>
     *
     */
	@Override
	
	public Page<Comment> queryVoteItemLikeByUser(String keyWord,Long userId,Integer uPower,Page<Comment> page)throws Exception{
		List<Comment> list=null;
		List<Comment> list2=null;
		if ("请输入关键字".equals(keyWord)) {
			keyWord = "%%";
		} else {
			keyWord = "%" + keyWord.trim() + "%";
		}
    		if(page==null){
				page = new Page<Comment>();
			}else{
				page.setPageSize(10);
			}//设置查sql语句中使用的page
			page.setSqlPage(page);
    		if(uPower==VoteSeqEnum.UPOWER.ALLPOWER.getValue()||uPower==VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()){//超级管理员模糊查
	    		list=comMapper.selectVoteItemLikeByUserByPage(keyWord,page.getOffsetValue(),page.getPageSize());
	    		list2=comMapper.selectVoteItemLikeByUser(keyWord);
    		}else if(uPower==VoteSeqEnum.UPOWER.VOTE_POWER.getValue()){//普通管理员模糊查
    			list=comMapper.selectVoteItemLikeByPage(keyWord, userId,page.getOffsetValue(),page.getPageSize());
    			list2=comMapper.selectVoteItemLike(keyWord,userId);
    		}
    		page.setPageList(list);
    		//普通管理员   ：非分页查所有品牌  按评论数降序排列
			
    		page.setMaxPage(list2.size(), page);
    		
    	return page;
    }
   
	/**
	 * 
	 * @author： 谢虹英  2015-6-17 下午4:59:20
	 * @方法名： queryAllCommentByViId
	 * @方法描述：根据品牌Id查该品牌下的所有评论
	 * @param: 品牌Id,Page
	 * @返回值：List<Comment>
	 *
	 */
	@Override
	
	public Page<Comment> queryAllCommentByViId(Long userId,Page<Comment> page)throws Exception {
		List<Comment> list=null;
		List<Comment> list2=null;
		if(userId!=null){
			if(page==null){
				page=new Page<Comment>();
			}else{
				page.setPageSize(10);
			} page.setSqlPage(page);
			//分页查一个品牌下的所有评论
			list=comMapper.selectAllCommentByViIdByPage(userId, page.getOffsetValue(), page.getPageSize());
			//若当前页大于最后一页，即无值的时。且。当前页并非第一页时，查前一页的内容
			if(list.size()==0&&page.getCurrentNum()>1){
				 page.setCurrentNum(page.getCurrentNum()-1);
				 page.setSqlPage(page);
				 list=comMapper.selectAllCommentByViIdByPage(userId, page.getOffsetValue(), page.getPageSize());
			}//不分页查
			CommentExample ce = new CommentExample();
			ce.createCriteria().andViIdEqualTo(userId);
			 list2 = comMapper.selectByExample(ce);
			 //设置最大页数
			 page.setMaxPage(list2.size(),page);
			 //将集合存入pageList中
			 page.setPageList(list);
		}
		return page;
	}

	/**
	 * 
	 * @author： 谢虹英  2015-6-23 上午9:15:28
	 * @方法名： removeCommentByViId
	 * @方法描述：批量删除评论
	 * @param:删除的id拼接的字符串
	 * @返回值：String
	 *
	 */
	@Override
	
	public String removeCommentByViId(String comIds)throws Exception {
		String code="0";
		if(comIds!=null){
			String[] split = comIds.split(",");
			List<Long> comIdList=new ArrayList<Long>();
			for (int i = 0; i < split.length; i++) {
				comIdList.add(Long.parseLong(split[i]));
			}
			CommentExample ce = new CommentExample();
			ce.createCriteria().andComIdIn(comIdList);
			comMapper.deleteByExample(ce);
			code="1";
		}
		return code;
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-23 下午12:08:49
	 * @方法名： addOneComment
	 * @方法描述：添加一条评论
	 * @param:
	 * @返回值：String
	 *
	 */
	@Override
	
	public String addOneComment(Comment com)throws Exception{
		String code="0";
		if(com!=null){
			Long val = seqDao.getIdByTableName(VoteSeqEnum.VOTE_SYSTEM_SEQ.VOTE_COMMENT.getValue());
			com.setComId(val);
			comMapper.insertSelective(com);
			code="1";
		}
		return code;
	}

}
