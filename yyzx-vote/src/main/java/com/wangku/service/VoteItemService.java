package com.wangku.service;

import java.util.List;

import com.wangku.entity.VoteItemTable;
import com.wangku.entity.VoteItemTableWithBLOBs;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;

public interface VoteItemService {
	/**
	 * 
	 * @author： zsl  2015-6-23 下午4:58:57
	 * @方法名： saveItem
	 * @方法描述：新增投票选项表数据
	 * @param:投票选项对象
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public int saveItem(VoteItemTableWithBLOBs item);
	/**
	 * 
	 * @author： zsl  2015-6-24 下午1:42:55
	 * @方法名： queryItemById
	 * @方法描述：根据ID查询数据
	 * @param:
	 * @返回值：VoteItemTableWithBLOBs
	 *
	 */
	@DataSource("slave")
	public VoteItemTableWithBLOBs queryItemById(long id);
	/**
	 * 
	 * @author： zsl  2015-6-24 下午1:43:06
	 * @方法名： modifyItem
	 * @方法描述：修改投票选项信息
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public int modifyItem(VoteItemTableWithBLOBs item);
	/**
	 * 
	 * @author： zsl  2015-6-24 下午3:20:11
	 * @方法名： modifyItemVoteIdByCopIdList
	 * @方法描述：根据会员id的集合修改投票选项的主题ID(信息推荐操作)
	 * @param: voteId:主题id
	 *         idList:会员id集合
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void modifyItemVoteIdByCopIdList(Long voteId,List<Long> copIdList);
	/**
	 * 
	 * @author： zsl  2015-6-24 下午4:27:22
	 * @方法名： queryByPage
	 * @方法描述：分页查询
	 * @param: keyWord:关键字
	 *         currentNum：当前页数
	 *         voteId：主题ID
	 * @返回值：Page<VoteItemTable>
	 *
	 */
	@DataSource("slave")
	public Page<VoteItemTable> queryByPage(String keyWord,int currentNum,long voteId);
	
	/**
	 * 
	 * @author： zsl  2015-6-25 上午9:54:10
	 * @方法名： removeItem
	 * @方法描述：删除投票选项数据
	 * @param:投票选项记录id集合
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void removeItem(List<Long> idList);
	
	/**
	 * 
	 * @author： zsl  2015-7-2 下午5:40:05
	 * @方法名： removeItemByVid
	 * @方法描述：根据主题id删除品牌
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void removeItemByVid(long vId);
	/**
	 * 
	 * @author： zsl  2015-6-25 下午1:34:28
	 * @方法名： modifyCount
	 * @方法描述：修改票数
	 * @param: id:投票选项id
	 *        vdCount:票数
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public int modifyCount(long id,int vdCount);
	/**
	 * 
	 * @author： zsl  2015-7-2 下午3:51:32
	 * @方法名： modifySort
	 * @方法描述：对某个主题下的所有品牌排序
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void modifySort(long voteId);

}
