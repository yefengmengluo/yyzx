package com.wangku.service.impl;

import java.io.File;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.VoteItemTable;
import com.wangku.entity.VoteItemTableExample;
import com.wangku.entity.VoteItemTableWithBLOBs;
import com.wangku.mapper.VoteItemTableMapper;
import com.wangku.service.VoteItemService;
import com.wangku.util.Page;
/**
 * 
 * @author zsl
 * 2015-6-24下午1:44:01
 * 类描述：投票选项服务接口实现类
 */
@Service("voteItemService")
public class VoteItemServiceImpl implements VoteItemService{
	
	@Autowired
	public VoteItemTableMapper mapper;
	/**
	 * 保存投票选项信息
	 */
	@Override
	public int saveItem(VoteItemTableWithBLOBs item) {
		
		return mapper.insertSelective(item);
	}
	/**
	 * 根据id查询数据
	 */
	@Override
	public VoteItemTableWithBLOBs queryItemById(long id) {
		
		return mapper.selectByPrimaryKey(id);
	}
	/**
	 * 修改投票选项信息
	 */
	@Override
	public int modifyItem(VoteItemTableWithBLOBs item) {
		
		return mapper.updateByPrimaryKeyWithBLOBs(item);
	}
	/**
	 * 修改投票选项主题ID
	 */
	@Override
	public void modifyItemVoteIdByCopIdList(Long voteId, List<Long> copIdList) {
		mapper.modifyItemVoteIdByCopIdList(voteId,copIdList);
	}
	
	public int queryAllCount(String keyWord,long voteId) {
		VoteItemTableExample ep = new VoteItemTableExample();
		ep.createCriteria().andVdTitleLike(keyWord).andVIdEqualTo(voteId);
		int countAll = mapper.countByExample(ep);
		return countAll;
	}
	/**
	 * 分页查询投票选项数据
	 */
	@Override
	public Page<VoteItemTable> queryByPage(String keyWord, int currentNum,
			long voteId) {
		Page<VoteItemTable> page = new Page<VoteItemTable>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<VoteItemTable> itemList = null;
		int countAll = queryAllCount(keyWord,voteId);
		if (countAll > 0) {
			page.setMaxPage(countAll, page);
			itemList = mapper.queryByPage(keyWord,voteId, page.getOffsetValue(),
					page.getPageSize());
		}

		page.setPageList(itemList);
		return page;
	}
	
	@Override
	public void removeItem(List<Long> idList) {
		//将投票主题id滞空
		mapper.modifyItemByItemIdList(idList);
		
		//删除对应的会员数据，实则将状态改为关闭
		mapper.modifyCompanyStatusByItemIdList(0,idList);
		
		//删除对应的图片
		//根据投票选项id集合查询会员信息
//		List<Company> c = mapper.queryCompanyByViidList(0,idList);
//		for(Company cop :c){
//			this.deleteFile(cop.getLogo());
//			this.deleteFile(cop.getWeiboPic());
//			this.deleteFile(cop.getWeixinPic());
//			this.deleteFile(cop.getErweimaPic());
//		}
	}
	/**
	 * 
	 * @author： zsl  2015-7-2 下午5:28:55
	 * @方法名： removeItemByVid
	 * @方法描述：根据主题ID删除品牌
	 * @param:
	 * @返回值：void
	 *
	 */
	public void removeItemByVid(long vId){
		
		List<Long> idList = mapper.queryItemByVid(vId);
		if(!CollectionUtils.isEmpty(idList)){
			removeItem(idList);
		}
		
	}
	/**
	 * 
	 * @author： zsl 2015-6-23 下午3:45:39
	 * @方法名： deleteFile
	 * @方法描述：删除文件
	 * @param: 文件的路径
	 * @返回值：void
	 * 
	 */
	public void deleteFile(String fullFilePath) {
		File localFile = new File(fullFilePath);
		if (localFile.exists()) {
			localFile.delete();
		}
	}
	/**
	 * 修改票数
	 */
	@Override
	public int modifyCount(long id, int vdCount) {
		
		return mapper.modifyCount(id,vdCount);
	}
	//排序
	@Override
	
	public void modifySort(long voteId) {
		VoteItemTableExample ep = new VoteItemTableExample();
		ep.setOrderByClause("vd_count desc");
		ep.createCriteria().andVIdEqualTo(voteId);
		List<VoteItemTable> list = mapper.selectByExample(ep);
		if(CollectionUtils.isEmpty(list)){
			System.out.println("品牌数据为空！==========");
			return;
		}
		for(int i = 0 ;i<list.size();i++){
			VoteItemTable v = list.get(i);
			if(v.getItemSort()==null){
				v.setItemLastSort(i+1);
				v.setItemSort(i+1);
				mapper.updateByPrimaryKey(v);
			}else{
				if(v.getItemSort()!=(i+1)){
					v.setItemLastSort(v.getItemSort());
					v.setItemSort(i+1);
					mapper.updateByPrimaryKey(v);
				}				
			}
			System.out.println("================");
		}
	}
	

}
