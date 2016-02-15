package com.wangku.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.LeaguePram;
import com.wangku.entity.LeaguePramExample;
import com.wangku.mapper.LeaguePramMapper;
import com.wangku.service.LeaguePramService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.VoteSeqEnum;

@Service("leaguePramService")
public class LeaguePramServiceImpl implements LeaguePramService{
	
	@Autowired
	LeaguePramMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	
	/**
	 * @author:李焕焕 2015年7月28日 下午2:36:25
	 * @方法名:queryAll
	 * @方法描述:TODO(查询所有参数)
	 * @param:@return
	 * @返回值:
	 */
	@Override
	public List<LeaguePram> queryAll() {
		// TODO 查询所有参数
		LeaguePramExample lpe = new LeaguePramExample();
		lpe.setOrderByClause("create_time desc");//按时间降序
		lpe.createCriteria();//查询所有参数
		List<LeaguePram> leaguePrams = mapper.selectByExample(lpe);
		return leaguePrams;
	}
	
	
	
	/**
	 * @author:李焕焕 2015年7月27日 下午1:45:47
	 * @方法名:queryLeaguePram
	 * @方法描述:TODO(查询所有行业)    根据参数类型查询参数(zsl)
	 * @param:@return
	 * @返回值:
	 */
	@Override
	public List<LeaguePram> queryLeaguePram(int paramType) {
		
		LeaguePramExample lpe = new LeaguePramExample();
		lpe.setOrderByClause("create_time desc");//按时间降序
		lpe.createCriteria().andParamTypeEqualTo(paramType);
		List<LeaguePram> leaguePrams = mapper.selectByExample(lpe);
		return leaguePrams;
	}
	
	
	
	/**
	 * @author:李焕焕 2015年7月28日 上午10:05:27
	 * @方法名:addLeaguePram
	 * @方法描述:TODO(添加行业，id按VoteSeq的设置自增，ParamType=0，time)
	 * @param:@param leaguePram
	 * @返回值:
	 */
	@Override
	public void addLeaguePram(LeaguePram leaguePram) {
		// TODO 添加行业
		Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.LEAGUE_SYS_SEQ.ADV_PARAM.getValue());
		leaguePram.setId(id);
		leaguePram.setCreateTime(new Date());
		mapper.insertSelective(leaguePram);
	}

	
	
	/**
	 * @author:李焕焕 2015年7月28日 上午10:06:49
	 * @方法名:modifyLeaguePram
	 * @方法描述:TODO(修改行业名称，连带修改时间)
	 * @param:@param leaguePram
	 * @返回值:
	 */
	@Override
	public void modifyLeaguePram(LeaguePram leaguePram) {
		//修改参数名
		mapper.updateByPrimaryKey(leaguePram);
		//修改尺寸表中的参数名字
		
		if(leaguePram.getParamType()==VoteSeqEnum.LEAGUE_PARAM_TYPE.ADV_TYPE.getValue()){//广告类型
			mapper.modifyLeagueSizePramNameById(1,leaguePram.getId(),leaguePram.getParamName());
		}else if(leaguePram.getParamType()==VoteSeqEnum.LEAGUE_PARAM_TYPE.INDUSTRY_TYPE.getValue()){//行业
			mapper.modifyLeagueSizePramNameById(0,leaguePram.getId(),leaguePram.getParamName());
		}
	}

	
	
	/**
	 * @author:李焕焕 2015年7月28日 下午2:37:09
	 * @方法名:removeLeaguePram
	 * @方法描述:TODO(这里用一句话描述这个方法的作用)
	 * @param:@param id
	 * @返回值:
	 */
	@Override
	public void removeLeaguePram(Long id) {
		// TODO 删除行业
		mapper.deleteByPrimaryKey(id);
	}
	
	

	/**
	 * @author:李焕焕 2015年7月28日 下午2:32:37
	 * @方法名:queryById
	 * @方法描述:TODO(按id查询，用于修改时获取id)
	 * @param:@param id
	 * @param:@return
	 * @返回值:
	 */
	@Override
	public LeaguePram queryById(long id) {
		// TODO 按id查询
		return mapper.selectByPrimaryKey(id);
	}

	

	/**
	 * @author:李焕焕 2015年7月28日 下午2:33:15
	 * @方法名:queryByParamName
	 * @方法描述:TODO(查询参数名称是否存在，用于参数添加时)
	 * @param:@param paramName            paramType:参数类型
	 * @param:@return
	 * @返回值:
	 */
	@Override
	public int queryByParamName(Integer paramType,String paramName) {
		LeaguePramExample lpe = new LeaguePramExample();
		lpe.createCriteria().andParamTypeEqualTo(paramType)
		.andParamNameEqualTo(paramName);
		//List<LeaguePram> leaguePrams = mapper.selectByExample(lpe);
		//return leaguePrams.size();
		
		return mapper.countByExample(lpe);		
	}
	
	/**
	 * 
	 * @author： zsl  2015年8月11日 下午12:01:29
	 * @方法名： queryByParamNameAndId
	 * @方法描述：根据名字和id查询参数个数，用于判重
	 *
	 */
	@Override
	public int queryByParamNameAndId(Integer paramType, String paramName, Long id)
			throws Exception {
		LeaguePramExample lpe = new LeaguePramExample();
		lpe.createCriteria().andParamTypeEqualTo(paramType)
		.andParamNameEqualTo(paramName).andIdNotEqualTo(id);
		
		return mapper.countByExample(lpe);
	}


/**
 * 
 * @author： zsl  2015年7月29日 下午5:00:45
 * @方法名： queryLeaguePramByPramType
 * @方法描述：根据参数类型查询数据
 *
 */
	@Override
	public List<LeaguePram> queryLeaguePramByPramType(int pramType)
			throws Exception {
		LeaguePramExample lpe = new LeaguePramExample();
		lpe.setOrderByClause("id");
		lpe.createCriteria().andParamTypeEqualTo(pramType);
		return mapper.selectByExample(lpe);
	}


/**
 * 
 * @author： zsl  2015年9月7日 上午11:50:24
 * @方法名： querySizeCountByParamId
 * @方法描述：
 *
 */
	@Override
	public int querySizeCountByParamId(int paramType, Long id) throws Exception {
		return mapper.querySizeCountByParamId(paramType,id);
	}



	@Override
	public void delLeaguePram(Long id) throws Exception {
		mapper.deleteByPrimaryKey(id);
	}



	@Override
	public int queryWordCountByParamId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return mapper.queryWordCountByParamId(id);
	}
}
