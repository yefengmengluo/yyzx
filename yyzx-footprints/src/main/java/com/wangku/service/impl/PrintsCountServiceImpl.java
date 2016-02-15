package com.wangku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.PrintCount;
import com.wangku.mapper.PrintCountMapper;
import com.wangku.service.PrintsCountService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * vote服务实现。
 * 
 */
@Service
public class PrintsCountServiceImpl implements PrintsCountService {

	@Autowired
	private PrintCountMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	/**
	 * 
	 * @author： 何利娟 2015-7-10 上午9:04:19
	 * @方法名： deleteByPrimaryKey
	 * @方法描述：根据供应Id删除记录
	 * @param:Long supplyId 供应Id
	 *
	 */
	@Override
	public void deleteByPrimaryKey(Long countId) {
		mapper.deleteByPrimaryKey(countId);
	}

	/**
	 * @author： 何利娟 2015-7-10 上午9:05:07
	 * @方法名： insert
	 * @方法描述：添加记录
	 * @param:PrintCount 
	 *
	 */
	@Override
	public void insert(PrintCount record) {
		Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.footprints.PRINTSCOUNT.getValue());
		record.setCountId(id);
		mapper.insert(record);
	}

	/**
	 * @author： 何利娟 2015-7-10 上午9:05:33
	 * @方法名： countBySupplyId
	 * @方法描述：查询所有记录总数
	 *
	 */
	@Override
	public int countBySupplyId() {
		return mapper.countBySupplyId();
	}
	/**
	 * @author： 何利娟 2015-7-10 上午9:06:16
	 * @方法名： selectByPage
	 * @方法描述：分页查询总数
	 * @param:Page<PrintCount> page
	 *
	 */
	@Override
	public List<PrintCount> selectByPage(Page<PrintCount> page) {
		List<PrintCount> list=null;
		list=mapper.selectByPage(page.getOffsetValue(), page.getPageSize());
		return list;
	}

	/**
	 * @author： 何利娟 2015-7-10 上午9:07:02
	 * @方法名： selectByPrimaryKey
	 * @方法描述：根据供应Id查询访问量
	 * @param:Long supplyId
	 *
	 */
	@Override
	public PrintCount selectByPrimaryKey(Long supplyId) {
		PrintCount pcount=null;
		pcount=mapper.selectByPrimaryKey(supplyId);
		if(pcount!=null){
			return pcount;
		}
		return null;
	}

	/**
	 * 
	 * @author： 何利娟 2015-7-10 上午9:07:38
	 * @方法名： updateByPrimaryKey
	 * @方法描述：更新产品数量
	 * @param:PrintCount record
	 *
	 */
	@Override
	public void updateByPrimaryKey(PrintCount record) {
		mapper.updateByPrimaryKey(record);
	}



}
