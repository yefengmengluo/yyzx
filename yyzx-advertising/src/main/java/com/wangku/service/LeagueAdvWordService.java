package com.wangku.service;

import java.util.List;

import com.wangku.entity.LeagueAdvWord;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;

public interface LeagueAdvWordService {
	/**
	 * 徐国辉  2015年8月5日 上午11:07:03
	 * 方法名称:queryAdvWordssByKeywordPaged
	 * 方法描述:条件分页查询文字广告信息记录
	 * @param:industryId 行业ID,currentNum 当前页
	 * @返回值:Page<LeagueAdvWord>
	 * I can do anything in my world with program !!!
	 */
	@DataSource("slave")
	public Page<LeagueAdvWord> queryAdvWordsByKeywordPaged(Long industryId,String titleKeyWod,Integer currentNum);

	/**
	 * 徐国辉  2015年8月5日 下午2:20:23
	 * 方法名称:addAdvWord
	 * 方法描述:添加文字广告
	 * @param:advWord 文字广告对象
	 * @返回值:void
	 * I can do anything in my world with program !!!
	 */
	@DataSource("master")
	public int addAdvWord(LeagueAdvWord advWord);
	
	/**
	 * 徐国辉  2015年8月5日 下午3:20:09
	 * 方法名称:queryAdvWordsByIndustryIdAndAdvName
	 * 方法描述:文字广告查看页数据集合
	 * @param:industryId 行业ID,advName 广告名称
	 * @返回值:List<LeagueAdvWord>
	 * I can do anything in my world with program !!!
	 */
	@DataSource("slave")
	public List<LeagueAdvWord> queryAdvWordsByIndustryIdAndAdvName(Long industryId,String advName);
	
	/**
	 * 徐国辉  2015年8月6日 上午9:22:18
	 * 方法名称:modifyWordAdvName
	 * 方法描述:修改文字广告名称
	 * @param:industryId 行业名称，advName 
	 * @返回值:void
	 * I can do anything in my world with program !!!
	 */
	@DataSource("master")
	public void modifyWordAdvName(Long industryId,String originalAdvName,String advName);

	/**
	 * 徐国辉  2015年8月6日 上午9:32:14
	 * 方法名称:queryWordAdvById
	 * 方法描述:主键查询一条文字广告
	 * @param:
	 * @返回值:LeagueAdvWord
	 * I can do anything in my world with program !!!
	 */
	@DataSource("slave")
	public LeagueAdvWord queryWordAdvById(Long id);
	
	/**
	 * 徐国辉  2015年8月6日 上午9:38:52
	 * 方法名称:modifyWordAdv
	 * 方法描述:修改文字广告
	 * @param:
	 * @返回值:void
	 * I can do anything in my world with program !!!
	 */
	@DataSource("master")
	public void modifyWordAdv(LeagueAdvWord advWord);
	
	/**
	 * 徐国辉  2015年8月6日 下午4:52:56
	 * 方法名称:removeWordAdvByIndustryIdAndAdvName
	 * 方法描述: 根据行业id和广告名称删除文字广告
	 * @param: industryId 行业id,advName 广告名称
	 * @返回值:void
	 * I can do anything in my world with program !!!
	 */
	@DataSource("master")
	public void removeWordAdvByIndustryIdAndAdvName(Long industryId,String advName);
	
	/**
	 * 徐国辉  2015年8月6日 下午4:52:56
	 * 方法名称:removeWordAdvById
	 * 方法描述: 根据id删除文字广告
	 * @param: id 文字广告id
	 * @返回值:void
	 * I can do anything in my world with program !!!
	 */
	@DataSource("master")
	public void removeWordAdvById(Long id);
	
	
	
	/**
	 * 徐国辉  2015年8月7日 上午11:48:00
	 * 方法名称:queryWordAdvOnFlag
	 * 方法描述:查询文字广告--用于单品网展示的文字广告记录
	 * @param:
	 * @返回值:List<LeagueAdvWord>
	 * I can do anything in my world with program !!!
	 */
	@DataSource("slave")
	public List<LeagueAdvWord> queryWordAdvOnFlag(Long industryId,Integer dataNum);
	
	/**
	 * 徐国辉  2015年8月24日 上午11:45:48
	 * 方法名称:modifyWordAdvOrder
	 * 方法描述:修改文字广告的排序号
	 * @param: id 文字广告id,orderNum 排序号
	 * @返回值:void
	 * I can do anything in my world with program !!!
	 */
	@DataSource("master")
	public void modifyWordAdvOrder(Long id,Integer orderNum);
}
