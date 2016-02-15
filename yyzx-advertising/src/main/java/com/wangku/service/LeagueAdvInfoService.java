package com.wangku.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wangku.entity.LeagueAdvInfo;
import com.wangku.entity.LeagueDataModel;
import com.wangku.jdbc.DataSource;
import com.wangku.pojo.LeagueAdvListModel;
import com.wangku.util.Page;

public interface LeagueAdvInfoService {

	/**
	 * 徐国辉  2015年7月28日 上午9:21:06
	 * queryAdvInfosByKeywordPaged
	 * 方法描述:条件分页查询广告位信息记录
	 * @param:industryKeyword 行业关键字,sizeKeyWord 尺寸关键字 ,currentNum 当前页
	 * @返回值:Page<LeagueAdvInfo>
	 */
	@DataSource("slave")
	public Page<LeagueAdvListModel> queryAdvInfosByKeywordPaged(Long industryId,Long typeId,Integer currentNum)throws Exception;

	/**
	 * 
	 * 徐国辉 2015年7月27日 下午2:24:13 
	 * addAdvInfoWord 
	 * 方法描述:添加广告位信息-文字广告
	 * @param:advInfo 广告位信息对象
	 * @返回值:void
	 */
	@DataSource("master")
	public String addAdvInfoPic(HttpServletRequest request,List<LeagueAdvInfo> advInfos) throws Exception;

	/**
	 * 徐国辉 2015年7月27日 下午4:46:54 
	 * removeAdvInfoBySizeId 
	 * 方法描述: 根据广告id删除广告位信息记录
	 * @param: id 广告id
	 * @返回值:void
	 */
	@DataSource("master")
	public void removeAdvInfoById(Long id)throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年8月5日 上午10:02:12
	 * @方法名： queryAdvInfoById
	 * @方法描述：根据ID查询图片广告信息
	 * @param:
	 * @返回值：LeagueAdvInfo
	 *
	 */
	@DataSource("slave")
	public LeagueAdvInfo queryAdvInfoById(Long id) throws Exception;
	/**
	 * 
	 * @author： zsl  2015年8月5日 下午3:08:10
	 * @方法名： modifyAdvPic
	 * @方法描述：修改图片广告
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("master")
	public String modifyAdvPic(LeagueAdvInfo info,HttpServletRequest req)throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年8月6日 下午4:11:15
	 * @方法名： removeAdvPic
	 * @方法描述：批量删除图片广告数据
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void removeAdvPic(List<Long> idList,HttpServletRequest request)throws Exception;

	/**
	 * 
	 * 徐国辉  2015年8月7日 上午9:13:46
	 * 方法名称:modifyOnFlag
	 * 方法描述: 用于定时调度-根据发布时间、结束时间、当前系统时间进行图片广告发布状态标识(on_flag)的修改
	 * @param:
	 * @返回值:void
	 * I can do anything in my world with program !!!
	 */
	@DataSource("master")
	public void modifyOnFlag()throws Exception;
	/**
	 * 
	 * @author： zsl  2015年8月7日 上午11:29:32
	 * @方法名： queryLeagueAdvList
	 * @方法描述：用于查询广告数据展示在网站广告位中
	 * @param:advCode 广告位标识
	 * @返回值：LeagueDataModel
	 *
	 */
	@DataSource("slave")
	public List<LeagueDataModel> queryLeagueAdvList(String advCode,int dataNum)throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015年8月17日 下午5:41:44
	 * @方法名： queryAdvCountBySizeId
	 * @方法描述：根据尺寸ID查询此尺寸下的广告位的个数
	 * @param:
	 * @返回值：int
	 *
	 */
	@DataSource("slave")
	public int queryAdvCountBySizeId(Long sizeId)throws Exception;
	/*@DataSource("master")*/
	/*public int updateRedFage() throws ParseException;*/
}
