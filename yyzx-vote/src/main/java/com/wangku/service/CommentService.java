package com.wangku.service;

import com.wangku.entity.Comment;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;


/**
 * 
 * @author 谢虹英
 * 2015-6-17下午4:26:01
 * 类描述：评论Service接口
 */
public interface CommentService {
	/**
	 * 
	 * @author： 谢虹英  2015-6-17 下午4:41:53
	 * @方法名： queryAllVoteItemByCommentCount
	 * @方法描述：根据评论数降序排列 查所有品牌
	 * @param:
	 * @返回值：List<Comment>
	 *
	 */
	@DataSource("slave")
	public Page<Comment> queryAllVoteItemByCommentCount(Integer uPower,Long vId,Page<Comment> page)throws Exception;
	 /**
     * 
     * @author： 谢虹英  2015-6-24 上午10:00:41
     * @方法名： selectVoteItemLikeByUser
     * @方法描述：超级管理员/普通管理员  模糊查品牌
     * @param:关键字
     * @返回值：List<Comment>
     *
     */
	@DataSource("slave")
	public Page<Comment> queryVoteItemLikeByUser(String keyWord,Long userId,Integer uPower,Page<Comment> page)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-17 下午4:59:20
	 * @方法名： queryAllCommentByViId
	 * @方法描述：根据品牌Id查该品牌下的所有评论
	 * @param: 品牌Id
	 * @返回值：List<Comment>
	 *
	 */
	@DataSource("slave")
	public Page<Comment> queryAllCommentByViId(Long viId,Page<Comment> page)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-23 上午9:15:28
	 * @方法名： removeCommentByViId
	 * @方法描述：删除评论
	 * @param:删除的id拼接的字符串
	 * @返回值：String
	 *
	 */
	@DataSource("master")
	public String removeCommentByViId(String viIds)throws Exception;
	/**
	 * 
	 * @author： 谢虹英  2015-6-23 下午12:08:49
	 * @方法名： addOneComment
	 * @方法描述：添加一条评论
	 * @param:
	 * @返回值：String
	 *
	 */
	@DataSource("master")
	public String addOneComment(Comment com)throws Exception;
}
