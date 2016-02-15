package com.wangku.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.LeagueAdvWord;
import com.wangku.entity.LeagueAdvWordExample;
import com.wangku.mapper.LeagueAdvWordMapper;
import com.wangku.service.LeagueAdvWordService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

@Service("leagueAdvWordService")
public class LeagueAdvWordServiceImpl implements LeagueAdvWordService {

	@Autowired
	private LeagueAdvWordMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;

	public Page<LeagueAdvWord> queryAdvWordsByKeywordPaged(Long industryId,String titleKeyWod, Integer currentNum) {
		Page<LeagueAdvWord> page = new Page<LeagueAdvWord>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<LeagueAdvWord> advWords = mapper.queryAdvWordsByKeywordPaged(industryId,titleKeyWod, page.getOffsetValue(),
				page.getPageSize());
		int listsize = mapper.queryAdvWordsByKeywordPagedCount(industryId,titleKeyWod);
		page.setPageList(advWords);
		page.setMaxPage(listsize, page);
		return page;
	}

	// 添加文字广告
	public int addAdvWord(LeagueAdvWord advWord) {
		Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.LEAGUE_SYS_SEQ.ADV_WORD.getValue());
		advWord.setId(id);
		advWord.setCreateTime(new Date());
		return mapper.insert(advWord);

	}
	//文字广告查看页数据集合
	public List<LeagueAdvWord> queryAdvWordsByIndustryIdAndAdvName(Long industryId, String advName) {
		return mapper.queryAdvWordsByIndustryIdAndAdvName(industryId, advName);
	}

	//修改文字广告名称
	public void modifyWordAdvName(Long industryId,String originalAdvName,String advName) {
		LeagueAdvWordExample qbe = new LeagueAdvWordExample();
		qbe.createCriteria().andIndustryIdEqualTo(industryId).andAdvNameEqualTo(originalAdvName);
		LeagueAdvWord advWord = new LeagueAdvWord();
		advWord.setAdvName(advName);
		mapper.updateByExampleSelective(advWord, qbe);
	}

	//主键查询一天文字广告记录
	public LeagueAdvWord queryWordAdvById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	//修改文字广告记录
	public void modifyWordAdv(LeagueAdvWord advWord) {
		mapper.updateByPrimaryKey(advWord);
		
	}

	//根据行业id和广告名称删除文字广告
	public void removeWordAdvByIndustryIdAndAdvName(Long industryId, String advName) {
		LeagueAdvWordExample qbe = new LeagueAdvWordExample();
		qbe.createCriteria().andIndustryIdEqualTo(industryId).andAdvNameEqualTo(advName);
		mapper.deleteByExample(qbe);
	}
	
	//根据文字广告id删除文字广告
	public void removeWordAdvById(Long id){
		mapper.deleteByPrimaryKey(id);
	}

	//查询文字广告--用于单品网展示的文字广告记录
	public List<LeagueAdvWord> queryWordAdvOnFlag(Long industryId,Integer dataNum) {
		return mapper.queryWordAdvOnFlag(industryId,dataNum);
	}

	//修改文字广告的排序号
	public void modifyWordAdvOrder(Long id, Integer orderNum) {
		mapper.updateWordAdvOrder(id, orderNum);
	}

}
