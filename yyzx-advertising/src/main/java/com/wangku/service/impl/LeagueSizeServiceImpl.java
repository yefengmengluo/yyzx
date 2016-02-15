package com.wangku.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wangku.entity.AdvTypeAndSize;
import com.wangku.entity.LeagueSize;
import com.wangku.entity.LeagueSizeExample;
import com.wangku.entity.LeagueSizeListModel;
import com.wangku.mapper.LeagueSizeMapper;
import com.wangku.pojo.LeagueAdvListModel;
import com.wangku.service.LeagueSizeService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.upload.service.FastDFSService;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;
/**
 * 
 * @author zsl
 * 2015年7月23日下午4:46:48
 * 类描述：尺寸表接口服务实现 
 */
@Service("leagueSizeService")
public class LeagueSizeServiceImpl implements LeagueSizeService{
	@Autowired
	private LeagueSizeMapper mapper;
	
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	
	@Autowired
	private FastDFSService fastDFSService;//访问图片服务器
	
	
	/**
	 * 查询全部的数据
	 */
	@Override
	public List<LeagueSize> queryAll() throws Exception{
		LeagueSizeExample example = new LeagueSizeExample();
		example.createCriteria();
		List<LeagueSize> list = mapper.selectByExample(example);
		return list;
	}
	
	
	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:06:29
	 * @方法名： queryById
	 * @方法描述：根据id查询尺寸信息
	 *
	 */
	public LeagueSize queryById(Long id)throws Exception{
		
		LeagueSize leagueSize = mapper.selectByPrimaryKey(id);
		
		return leagueSize;
	}


	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:12:41
	 * @方法名： addLeagueSize
	 * @方法描述：新增一条尺寸信息
	 *
	 */
	@Override
	public int addLeagueSize(LeagueSize leagueSize) throws Exception {
		// 投票选项ID
		Long id = voteSequenceDao
						.getIdByTableName(VoteSeqEnum.LEAGUE_SYS_SEQ.ADV_SIZE.getValue());
		leagueSize.setId(id);
		leagueSize.setCreateTime(new Date());
		
		return mapper.insertSelective(leagueSize);
	}


	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:13:38
	 * @方法名： updateLeagueSize
	 * @方法描述：修改一条尺寸信息
	 *
	 */
	@Override
	public int updateLeagueSize(LeagueSize leagueSize) throws Exception {
		
		return mapper.updateByPrimaryKeySelective(leagueSize);
	}


	/**
	 * 
	 * @author： zsl  2015年7月23日 下午5:14:27
	 * @方法名： deleteLeagueSizeById
	 * @方法描述：根据ID删除尺寸信息
	 *
	 */
	@Override
	public int deleteLeagueSizeById(Long id) throws Exception {
		
		return mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 
	 * @author： zsl  2015年7月27日 上午11:10:22
	 * @方法名： queryAdvTypeAndSizeByIndustryIds
	 * @方法描述：根据行业id集合查询行业下共同的尺寸
	 *
	 */
	@Override
	public List<AdvTypeAndSize> queryAdvTypeAndSizeByIndustryIds(List<Long> ids) throws Exception {
		if(!CollectionUtils.isEmpty(ids)){
			if(ids.size()==1){
				return mapper.queryTypeSizeByOneIndustryId(ids.get(0));
			}else{
				return mapper.queryTypeSizeByIndustryIds(ids,ids.size());
			}
		}
		return mapper.queryInitTypeSize();
	}


//	@Override
//	public List<AdvTypeAndSize> queryInitTypeSize() throws Exception{
//		
//		return mapper.queryInitTypeSize();
//	}
//
//
//	@Override
//	public List<AdvTypeAndSize> queryTypeSizeByOneIndustryId(Long industryId) throws Exception{
//		
//		return mapper.queryTypeSizeByOneIndustryId(industryId);
//	}
//
//
//	@Override
//	public List<AdvTypeAndSize> queryTypeSizeByIndustryIds(
//			List<Long> industryIdList) throws Exception{
//		
//		return mapper.queryTypeSizeByIndustryIds(industryIdList);
//	}

	/**
	 * 
	 * @author： zsl  2015年7月29日 下午4:53:51
	 * @方法名： addLeagueSizeBatch
	 * @方法描述：批量添加尺寸
	 *
	 */
	@Override
	public List<LeagueSize> addLeagueSizeBatch(String[] industryIds, String[] advTypeIds,
			String advSize) throws Exception {
		List<String> industrys = Arrays.asList(industryIds); 
		List<String> advTypes = Arrays.asList(advTypeIds); 
		
		List<LeagueSize> aYes = new ArrayList<LeagueSize>();
		List<LeagueSize> aNo = new ArrayList<LeagueSize>();
		
		for(String s:industrys){
			String[] strS = s.split(";");
			for(String a:advTypes){
				String[] strA = a.split(";");
				List<LeagueSize> list = this.queryLeagueByIndustryIdAndTypeId(Long.parseLong(strS[0]),Long.parseLong(strA[0]), advSize);
				if(CollectionUtils.isEmpty(list)){
					LeagueSize l = new LeagueSize();
					Long id = voteSequenceDao
							.getIdByTableName(VoteSeqEnum.LEAGUE_SYS_SEQ.ADV_SIZE.getValue());
					l.setId(id);
					l.setIndustryId(Long.parseLong(strS[0]));
					l.setIndustryName(strS[1]);
					l.setTypeId(Long.parseLong(strA[0]));
					l.setTypeName(strA[1]);
					l.setAdvSize(advSize);
					l.setCreateTime(new Date());
					l.setSizeCode(strA[0]+"_"+advSize);
					aYes.add(l);
				}else{
					LeagueSize l = new LeagueSize();
					l.setIndustryId(Long.parseLong(strS[0]));
			 		l.setIndustryName(strS[1]);
					l.setTypeId(Long.parseLong(strA[0]));
					l.setTypeName(strA[1]);
					l.setAdvSize(advSize);
					aNo.add(l);
				}
			}
		}
		if(!CollectionUtils.isEmpty(aYes)){
			this.addBatch(aYes);
		}
		
		return aNo;
	}
	
	/**
	 * 
	 * @author： zsl  2015年7月27日 下午3:40:03
	 * @方法名： addBatch
	 * @方法描述：批量添加尺寸数据
	 * @param:
	 * @返回值：void
	 *
	 */
	public void addBatch(List<LeagueSize> list)throws Exception {
		mapper.addBatch(list);
	}
	
	/**
	 * 
	 * @author： zsl  2015年7月27日 下午3:38:14
	 * @方法名： queryLeagueByIndustryIdAndTypeId
	 * @方法描述：根据行业ID、类型Id、尺寸查询尺寸数据
	 * @param:
	 * @返回值：List<LeagueSize>
	 *
	 */
	public List<LeagueSize> queryLeagueByIndustryIdAndTypeId(Long industryId,Long typeId,String advSize) throws Exception{
		LeagueSizeExample example = new LeagueSizeExample();
		example.createCriteria().andIndustryIdEqualTo(industryId).andTypeIdEqualTo(typeId).andAdvSizeLike(advSize);
		List<LeagueSize> list = mapper.selectByExample(example);
		return list;
	}

	/**
	 * 
	 * @author： zsl  2015年7月28日 下午2:29:55
	 * @方法名： queryLeagueSizeList
	 * @方法描述：查询尺寸列表
	 *
	 */
	@Override
	public List<LeagueSizeListModel> queryLeagueSizeList() throws Exception {
		
		return mapper.queryLeagueSizeList();
	}
	/**
	 * 
	 * @author： zsl  2015年8月3日 下午3:37:01
	 * @方法名： queryLeagueSizeByIndustryIdAndSizeCode
	 * @方法描述：根据行业ID和尺寸编码查询尺寸数据
	 * @param:
	 * @返回值：LeagueSize
	 *
	 */
	public LeagueSize queryLeagueSizeByIndustryIdAndSizeCode(Long industryId,String sizeCode)throws Exception {
		return mapper.queryLeagueSizeByIndustryIdAndSizeCode(industryId,sizeCode);
	}

	/**
	 * 根据关键字查询尺寸信息
	 * @author： zsl  2015年8月17日 下午3:55:05
	 * @方法名： queryAdvSizeListByKeywordPaged
	 * @方法描述：
	 *
	 */
	@Override
	public Page<LeagueSize> queryAdvSizeListByKeywordPaged(Long industryId,
			Long typeId, Integer currentNum)  throws Exception {
		Page<LeagueSize> page = new Page<LeagueSize>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<LeagueSize> advInfos = mapper.queryAdvSizeListByKeywordPaged(industryId, typeId,
				page.getOffsetValue(), page.getPageSize());
		int listsize = mapper.queryAdvSizeListByKeywordPagedCount(industryId, typeId);
		page.setPageList(advInfos);
		page.setMaxPage(listsize, page);
		return page;
	}

	/**
	 * 
	 * @author： zsl  2015年8月18日 上午8:55:55
	 * @方法名： removeAdvSize
	 * @throws Exception 
	 * @方法描述：根据ID删除尺寸数据           id 尺寸id           count：用来判断此尺寸广告位下有无广告    0无    1有
	 *
	 */
	@Override
	public void removeAdvSize(Long id,Integer count) throws Exception {
		if(count != 0){
			
			List<String> listStr = new ArrayList<String>();
			listStr = mapper.queryAdvStrList(id);
			mapper.deleteAdvInfos(id);
			if(!CollectionUtils.isEmpty(listStr)){
				for(String picUrl:listStr){
					if(!StringUtils.isEmpty(picUrl)&&picUrl.contains("http://img.99114.com/")){
						String[] split = picUrl.split("/", 5);
						String group_name=split[3];
						String remote_filename=split[4];
						boolean isok = fastDFSService.remove_file(group_name, remote_filename);
						System.out.println("删除图片服务器图片结果："+isok);
					}
				}
			}
			
			
			
		}
		mapper.deleteByPrimaryKey(id);
	};
}
