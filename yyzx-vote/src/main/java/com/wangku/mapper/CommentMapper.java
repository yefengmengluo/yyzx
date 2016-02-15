package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.Comment;
import com.wangku.entity.CommentExample;

public interface CommentMapper {
	
    int countByExample(CommentExample example);
	
    int deleteByExample(CommentExample example);
    
    int deleteByPrimaryKey(Long comId);
    
    int insert(Comment record);
    
    int insertSelective(Comment record);
    
    List<Comment> selectByExample(CommentExample example);
    
    Comment selectByPrimaryKey(Long comId);
    
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);
    
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);
    
    int updateByPrimaryKeySelective(Comment record);
    
    int updateByPrimaryKey(Comment record);
    /**
     * 
     * @author： 谢虹英  2015-6-23 下午3:39:04
     * @方法名： selectAllVoteItemByCommentCountByPage
     * @方法描述：分页  超级管理员查所有品牌，按评论数降序排列
     * @param:
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectAllVoteItemByCommentCountByPage(@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
    /**
     * 
     * @author： 谢虹英  2015-6-23 下午3:39:04
     * @方法名： selectAllVoteItemByCommentCount
     * @方法描述：不分页  超级管理员查所有品牌，按评论数降序排列
     * @param:
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectAllVoteItemByCommentCount();
    /**
     * 
     * @author： 谢虹英  2015-6-23 下午3:36:41
     * @方法名： selectOneVoteTableAllVoteItemByCommentCountByPage
     * @方法描述：分页    普通管理员查其名下主题中所有品牌，按评论数降序排列
     * @param:管理员id   Page
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectOneVoteTableAllVoteItemByCommentCountByPage(@Param("userId")Long userId,@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
    /**
     * 
     * @author： 谢虹英  2015-6-23 下午3:36:41
     * @方法名： selectOneVoteTableAllVoteItemByCommentCount
     * @方法描述：不分页       普通管理员查其名下主题中所有品牌，按评论数降序排列
     * @param：管理员id
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectOneVoteTableAllVoteItemByCommentCount(@Param("userId")Long userId);
    /**
     * 
     * @author： 谢虹英  2015-6-23 下午3:35:39
     * @方法名： selectAllCommentByViIdByPage
     * @方法描述：查一个品牌下的所有评论  ，按时间降序排序
     * @param:品牌id ,page
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectAllCommentByViIdByPage(@Param("viId")Long viId,@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
    /**
     * 
     * @author： 谢虹英  2015-6-24 上午10:00:41
     * @方法名： selectVoteItemLikeByUserByPage
     * @方法描述：1、超级管理员模糊查品牌 --- 分页
     * @param:关键字
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectVoteItemLikeByUserByPage(@Param("keyWord")String keyWord,@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
    /**
     * 
     * @author： 谢虹英  2015-6-24 上午10:00:41
     * @方法名： selectVoteItemLikeByUser
     * @方法描述：2、超级管理员模糊查品牌---不分页
     * @param:关键字
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectVoteItemLikeByUser(@Param("keyWord")String keyWord);
    /**
     * 
     * @author： 谢虹英  2015-6-24 上午10:00:41
     * @方法名： selectVoteItemLikeByPage
     * @方法描述：1、普通管理员模糊查品牌
     * @param:关键字，管理员id
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectVoteItemLikeByPage(@Param("keyWord")String keyWord,@Param("userId") Long userId,@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
    /**
     * 
     * @author： 谢虹英  2015-6-24 上午10:00:41
     * @方法名： selectVoteItemLike
     * @方法描述：2、普通管理员模糊查品牌
     * @param:关键字，管理员id
     * @返回值：List<Comment>
     *
     */
    
    List<Comment> selectVoteItemLike(@Param("keyWord")String keyWord,@Param("userId") Long userId);
    
   
}