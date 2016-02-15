package com.wangku.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.FootPrints;
import com.wangku.entity.PrintCount;
import com.wangku.mapper.FootPrintsMapper;
import com.wangku.mapper.PrintCountMapper;
import com.wangku.service.FootprintsService;
import com.wangku.service.PrintsCountService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.VoteSeqEnum;

/**
 * vote服务实现。
 * 
 */
@Service
public class FootprintsServiceImpl implements FootprintsService {
	
	@Autowired
	private FootPrintsMapper mapper;
	@Autowired
	private PrintCountMapper countmapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	@Autowired
	private PrintsCountService printsCountService;
	/**
	 * @author： 何利娟 2015-7-9 上午11:19:26
	 * @方法名： queryByKey
	 * @方法描述：根据会员Id或IP地址查询
	 * @param:memberId  会员Id
	 * @parame:ip Ip
	 * @返回值： List<FootPrints>
	 */
	@Override
	public List<Long> queryByKey(FootPrints footPrint,int offset,int pageSize) {
//		FootPrintsExample qbe = new FootPrintsExample();
		
		//qbe.createCriteria().andMemberIdEqualTo(memberId).andIpEqualTo(ip);
		List<FootPrints> footprints = mapper.selectByExample(offset, pageSize, footPrint);
		List<Long> supplyIdList=new ArrayList<Long>();
		for(int i=0;i<footprints.size();i++){
			if(footprints.get(i)!=null){
				supplyIdList.add(footprints.get(i).getSupplyId());
			}
		}
		return supplyIdList;
	}

	/**
	 * @author： 何利娟 2015-7-9 上午11:34:48
	 * @方法名： addFootprints
	 * @方法描述：添加足迹记录
	 * @param:FootPrints footprints
	 * @param:HttpServletRequest request
	 * @返回值：void
	 */
	@Override
	public void addFootprints(FootPrints footprints) {
		//查询记录是否存在
		int count=mapper.countByExample(footprints);
		PrintCount printCount = countmapper.selectByPrimaryKey(footprints.getSupplyId());
		//判定改产品是否被访问过，没有则添加，有则修改其次数count+1
		if(printCount==null){
			printCount=new PrintCount();
			Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.footprints.PRINTSCOUNT.getValue());
			printCount.setCountId(id);
			printCount.setSupplyId(footprints.getSupplyId());
			countmapper.insert(printCount);
		}else{
			countmapper.updateByPrimaryKey(printCount);
		}
		//判定该用户的浏览该产品的足迹是否存在
		//1、不存在 直接添加
		footprints.setVisitTime(new Date());//更新访问时间为最新访问时间
		if(count==0){
			Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.footprints.FOOTPRINTS.getValue());
			footprints.setId(id);
			mapper.insert(footprints);//添加该用户足迹
		}else{
			//2、存在 更新
			mapper.updateCount(footprints);
		}
	}

	/**
	 * 
	 * @author： 何利娟 2015-7-9 上午11:47:17
	 * @方法名： modifyAdvertising
	 * @方法描述：如果访问记录存在 count 加 1；更新访问
	 * @param:
	 * @返回值：
	 *
	 *//*
	@Override
	public void modifyFootprints(FootPrints footprint) {
		footprint.setVisitTime(new Date());
		mapper.updateCount(footprint);
		
	}*/
	/**
	 * 
	 * @author： 何利娟 2015-7-9 下午2:02:49
	 * @方法名： removeFootprints
	 * @方法描述：删除足迹记录
	 * @param:Long memberId
	 * @param:String ip
	 * @返回值：
	 *
	 */
	@Override
	public void removeFootprints(long id) {
		mapper.deleteByPrimaryId(id);
	}

	@Override
	public int countByExample(FootPrints footprint){
		int sum=0;
		sum=mapper.countByExample(footprint);
		return sum;
	}
}
