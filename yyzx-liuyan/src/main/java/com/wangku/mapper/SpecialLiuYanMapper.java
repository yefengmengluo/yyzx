package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.SpecialLiuYan;
import com.wangku.entity.SpecialLiuYanExample;

public interface SpecialLiuYanMapper {
	
    int countByExample(SpecialLiuYanExample example);
	
    int deleteByExample(SpecialLiuYanExample example);
	
    int deleteByPrimaryKey(Long lyId);
	
    int insert(SpecialLiuYan record);
	
    int insertSelective(SpecialLiuYan record);
	
    List<SpecialLiuYan> selectByExample(SpecialLiuYanExample example);
	
    SpecialLiuYan selectByPrimaryKey(Long lyId);
	
    int updateByExampleSelective(@Param("record") SpecialLiuYan record, @Param("example") SpecialLiuYanExample example);
	
    int updateByExample(@Param("record") SpecialLiuYan record, @Param("example") SpecialLiuYanExample example);
	
    int updateByPrimaryKeySelective(SpecialLiuYan record);
	
    int updateByPrimaryKey(SpecialLiuYan record);
    
    /**
    		 * 
    		 * @author：  周海朋  2015-7-8 下午7:23:24
    		 * @方法名： selectAllLiuYanByPage
    		 * @方法描述：分页查留言
    		 * @param:
    		 * @返回值：List<SpecialLiuYan>
    		 *
    		 */
	
    List<SpecialLiuYan> selectAllLiuYanByPage(
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize,
			@Param("userId")Long userId
			
			);
	
	
	/**
	  * 
	  * @author：  周海朋  2015-7-9 上午11:08:15
	  * @方法名： selectAllLiuYanByPageStatus
	  * @方法描述：根据状态分页查留言信息
	  * @param:
	  * @返回值：Page<SpecialLiuYan>
	  *
	  **/
	
    List<SpecialLiuYan> selectAllLiuYanByPageStatus(
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize,
			@Param("status")Integer status,
			@Param("userId")Long userId
			);
    
    /**
    		 * 
    		 * @author：  周海朋  2015-7-8 下午7:23:47
    		 * @方法名： selectLiuYanLikeByPage
    		 * @方法描述：分页模糊查留言
    		 * @param:
    		 * @返回值：  List<SpecialLiuYan> 
    		 *
    		 */
	
    List<SpecialLiuYan>  selectLiuYanLikeByPage(@Param("keyWord") String keyWord,
			@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize,
			@Param("userId")Long userId
			);
    
    /**
    		 * 
    		 * @author：  周海朋  2015-7-8 下午7:24:24
    		 * @方法名： selectLiuYanLike
    		 * @方法描述：模糊查留言
    		 * @param:
    		 * @返回值：  List<SpecialLiuYan> 
    		 *
    		 */
	
    List<SpecialLiuYan>  selectLiuYanLike(@Param("keyWord") String keyWord,
			@Param("userId")Long userId
		);
}