/**
 * @author 谢虹英
 * 2015-6-23下午4:20:03
 * 类描述：
 */

package com.wangku.controller.vote;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wangku.entity.Comment;
import com.wangku.entity.User;
import com.wangku.entity.VoteItemTableWithBLOBs;
import com.wangku.mapper.VoteItemTableMapper;
import com.wangku.service.CommentService;
import com.wangku.util.Page;

/**
 * @author 谢虹英
 * 2015-6-23下午4:20:03
 * 类描述：
 */
@Controller
@RequestMapping("CommentController")
public class CommentController {
	@Autowired CommentService comService;
	@Autowired VoteItemTableMapper itemMapper;
	/**
	 * 
	 * @author： 谢虹英  2015-6-17 下午4:41:53
	 * @方法名： queryAllVoteItemByCommentCount
	 * @方法描述：根据评论数降序排列 查所有品牌
	 * @param:用户权限，主题ID,page
	 * @返回值：List<Comment>
	 *
	 */
	@RequestMapping("/queryAllVoteItemByCommentCount")
	public String queryAllVoteItemByCommentCount(ModelMap map,HttpServletRequest request,Page<Comment> page){
		try {
			User user = (User)request.getSession().getAttribute("user");
			if(user!=null){
				page =comService.queryAllVoteItemByCommentCount(user.getUserPower(), user.getUserId(), page);
				map.put("page", page);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/comment/comment_list";
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
	@RequestMapping("/queryVoteItemLikeByUser")
	public String queryVoteItemLikeByUser(ModelMap map,HttpServletRequest request,String keyWord,Page<Comment> page){
		try {
			User user = (User)request.getSession().getAttribute("user");
			if(user!=null){
				Page<Comment> list=comService.queryVoteItemLikeByUser(keyWord, user.getUserId(),user.getUserPower(), page);
				map.put("page", list);
			
			}map.put("keyWord", keyWord.trim());
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/comment/comment_like_list";
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
	@RequestMapping("/queryAllCommentByViId")
	public String queryAllCommentByViId(ModelMap map,Long viId,Page<Comment> page,Integer tag){
		try {
			VoteItemTableWithBLOBs item = itemMapper.selectByPrimaryKey(viId);
			page = comService.queryAllCommentByViId(viId, page);
			map.put("page", page);
			map.put("item", item);
			map.put("tag", tag);
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "backstage/backPage/comment/comment_detial";
	}
	/**
	 * 
	 * @author： 谢虹英  2015-6-23 下午4:54:24
	 * @方法名： removeComment
	 * @方法描述：批量删除评论
	 * @param: 要删除的id数组
	 * @返回值：String
	 *
	 */
	@RequestMapping("/removeComment")
	public String removeComment(ModelMap map,String comIds,Long viId,Page<Comment> page,Integer tag ){
		try {
			String code=comService.removeCommentByViId(comIds);
			map.put("code", code);
			map.put("tag", tag);
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
		return "redirect:/CommentController/queryAllCommentByViId?viId="+viId+"&currentNum="+page.getCurrentNum();
	}
}
