package com.wangku.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wangku.entity.AdTrafficModel;
import com.wangku.entity.AdvSpaceTrafficCountModel;
import com.wangku.entity.AdvTrafficCountModel;
import com.wangku.entity.ChartData;
import com.wangku.entity.DateGroupCount;
import com.wangku.entity.LeagueAdTrafficTab;
import com.wangku.entity.LeagueAdTrafficTabExample;
import com.wangku.mapper.LeagueAdTrafficTabMapper;
import com.wangku.service.LeagueAdTrafficTabService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;
/**
 * 
 * @author zsl
 * 2015年9月15日下午3:46:26
 * 类描述：广告联盟广告流量统计接口服务实现 
 */
@Service("leagueAdTrafficTabService")
public class LeagueAdTrafficTabServiceImpl implements LeagueAdTrafficTabService{
	@Autowired
	private LeagueAdTrafficTabMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	
	/**
	 * 
	 * @author： 何利娟  2015年9月15日 下午4:01:04
	 * @方法名： addTrafficRecord
	 * @方法描述：添加广告联盟流量记录
	 * @返回值：
	 */
	@Override
	public int addTrafficRecord(LeagueAdTrafficTab leagueAdTrafficTab) throws Exception {
		// TODO Auto-generated method stub
		Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.LEAGUE_SYS_SEQ.ADV_TRAFFIC.getValue());
		leagueAdTrafficTab.setId(id);
		leagueAdTrafficTab.setVisitTime(new Date());
		return mapper.insert(leagueAdTrafficTab);
	}

	/**
	 * 
	 * @author： 何利娟  2015年9月16日 上午10:15:29
	 * @方法名： queryAdTrafficByKeywordPaged
	 * @方法描述：查询广告流量某时间区间流量记录
	 * @param:
	 * @返回值：
	 */
	@Override
	public Page<LeagueAdTrafficTab> queryAdTrafficByKeywordPaged(Long adId, Date beginDate, Date endDate,Integer currentNum)
			throws Exception {
		Page<LeagueAdTrafficTab> page = new Page<LeagueAdTrafficTab>();
		
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		System.out.println("page.getOffsetValue()================="+page.getOffsetValue());
		System.out.println("page.getPageSize()================="+page.getPageSize());
		List<LeagueAdTrafficTab> adTraffics = mapper.queryAdTrafficByKeywordPaged(adId,beginDate,endDate,page.getOffsetValue(), page.getPageSize());
		int listsize = mapper.queryAdTrafficByKeywordCount(adId,beginDate,endDate);
		page.setPageList(adTraffics);
		page.setMaxPage(listsize, page);
		return page;
	}
	
	/**
	 * @author： 何利娟  2015年9月16日 下午4:45:06
	 * @方法名： queryAdTrafficArea
	 * @方法描述：查询某时间段内广告流量区域统计
	 * @param:
	 * @返回值：
	 *
	 */
	@Override
	public List<LeagueAdTrafficTab> queryAdTrafficArea(Long adId, Date beginDate, Date endDate)
			throws Exception {
		List<LeagueAdTrafficTab> advInfos = mapper.queryAdTrafficArea(adId,beginDate,endDate);
		return advInfos;
	}

	/**
	 * 
	 * @author： zsl 2015年9月18日 下午1:05:10
	 * @方法名： queryChart
	 * @方法描述：查询走势图 queryType ：0：按今天查询 1 ：按近一周查询 2：按近一个月查询  3 :昨天
	 * 					advType   :  0 :图片广告     1  ：文字广告
	 */
	@Override
	public ChartData queryChart(String sizeCode, String queryType,Long industryId,Integer advType)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:00");
		Date startTime = new Date();
		Date beginDate = new Date();
		Date endDate = new Date();
		List<String> dateList = new ArrayList<String>();
		List<Integer> numList = new ArrayList<Integer>();
		Calendar c = Calendar.getInstance();
		Date x;
		if ("0".equals(queryType) || "3".equals(queryType)) {//今天 或者昨天
			
			dateList.add("00:00");
			numList.add(0);
			if("0".equals(queryType)){
				startTime = sdf
						.parse(sdf.format(beginDate));
			}else{
				c.setTime(beginDate);
				c.add(Calendar.DAY_OF_MONTH, -1);
				startTime = sdf
						.parse(sdf.format(c.getTime()));
			}
			
			for (int i = 1; i <= 6; i++) {
				c.setTime(startTime);
				c.add(Calendar.HOUR_OF_DAY, 4 * (i - 1));
				int begin = c.get(Calendar.HOUR_OF_DAY);
				beginDate = c.getTime();

				c.setTime(beginDate);
				c.add(Calendar.HOUR_OF_DAY, 4);
				x = c.getTime();

				c.add(Calendar.MILLISECOND, -1);
				endDate = c.getTime();

				c.setTime(new Date());
				int d = c.get(Calendar.HOUR_OF_DAY);

				if (i == 6) {
					// dateList.add("23:59");
					dateList.add("");
				} else {
					dateList.add(sdf2.format(x));
				}
				
				if("0".equals(queryType) && d < begin){
//					if (d < begin) {
//						continue;
//					} else {
//						Integer num = mapper.queryChartNum(beginDate, endDate,
//								sizeCode,industryId);
//						numList.add(num);
//					}
					continue;
				}else{
					Integer num = 0;
					
					if(advType == 0){//图片广告
						num = mapper.queryChartNum(beginDate, endDate,
								sizeCode,industryId);
					}else if(advType == 1){//文字广告
						num = mapper.queryWordChartNum(beginDate, endDate,industryId);
					}
					numList.add(num);
				}
				
			}
		}else if ("1".equals(queryType) || "2".equals(queryType)) {//近一周 或者一个月
			if("1".equals(queryType)){
				beginDate = getLastMonth(0, 7);//往前推一周        0：日              1： 月
			}else{
				beginDate = getLastMonth(1, 1);//往前推一个月      0：日              1： 月
			}
			
			List<DateGroupCount> list = new ArrayList<DateGroupCount>();
			
			if(advType == 0){//图片广告
				list = mapper.queryChartNumByDayGroup(
						beginDate, sizeCode,industryId);
			}else if(advType == 1){//文字广告
				list = mapper.queryWordChartNumByDayGroup(
						beginDate,industryId);
			}
			
			dateList = dateSplit(sdf.parse(sdf.format(beginDate)),
					sdf.parse(sdf.format(new Date())));
			int i = 0 ;
			int j = 0 ;
			if (!dateList.isEmpty()) {
				if(list.isEmpty()){
					for (String date : dateList) {
						numList.add(0);	
					}
				}else{
					outer: for (String date : dateList) {
						numList.add(i, 0);
						j = i;
						i++;
						for (DateGroupCount dc : list) {
							if (date.equals(dc.getDateStr())) {
								numList.set(j, dc.getNum());
								list.remove(dc);
								continue outer;
							}
						}
					}
				}
				
			}
		}

		ChartData data = new ChartData();
		data.setDateList(dateList);
		data.setNumList(numList);
		return data;
	}

	/**
	 * 
	 * @author： zsl  2015年9月21日 上午11:48:08
	 * @方法名： dateSplit
	 * @方法描述：根据时间段查询时间列表集合
	 * @param:
	 * @返回值：List<String>
	 *
	 */
	private List<String> dateSplit(Date startDate, Date endDate)
			throws Exception {
		if (!startDate.before(endDate))
			throw new Exception("开始时间应该在结束时间之前");
		Long spi = endDate.getTime() - startDate.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 一天的毫秒数
		Long step = (long) (24 * 60 * 60 * 1000);
		// 一共多少天
		Long num = spi / step;

		List<String> dateList = new ArrayList<String>();
		dateList.add(sdf.format(startDate));
		for (int i = 1; i <= num; i++) {
			dateList.add(sdf.format(new Date(startDate.getTime() + step * i)));
		}
		return dateList;
	}

	// type : 操作类型    0：日              1： 月
	// step ： 步调
	private Date getLastMonth(int type, int step) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1); // 得到前一天
		if (type == 0) {
			cal.add(Calendar.DAY_OF_MONTH, -step);// 往前推step天
		} else if (type == 1) {
			cal.add(Calendar.MONTH, -step); // 往前推step月
		}

		return cal.getTime();
	}
	

	/**
	 * 
	 * @author： zsl 2015年9月16日 上午9:03:26
	 * @方法名： queryTrafficCount_advSpace
	 * @方法描述：分页统计图片广告位的流量
	 * 
	 */
	@Override
	public Page<AdTrafficModel> queryAdvSpaceListByPaged(
			Integer currentNum) throws Exception {
		Page<AdTrafficModel> page = new Page<AdTrafficModel>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<AdTrafficModel> advSpaces = mapper.queryTrafficCount_advSpace_list(
				page.getOffsetValue(), page.getPageSize());
		int listsize = mapper.queryTrafficCount_advSpace_count();
		page.setPageList(advSpaces);
		page.setMaxPage(listsize, page);
		return page;
	}

	/**
	 * 
	 * @author： zsl  2015年9月23日 下午2:33:57
	 * @方法名： getAllAdvSpaceTotalFlow
	 * @方法描述：获取所有广告位的总流量
	 *
	 */
	@Override
	public int getAllAdvSpaceTotalFlow() {
		
		return mapper.getAllAdvSpaceTotalFlow();
	}

	@Override
	public List<AdvSpaceTrafficCountModel> queryTrafficCountBySizeCode(
			String sizeCode,Long industryId,String keyWord,Integer advType) throws Exception {
		if(StringUtils.isEmpty(keyWord)){
			keyWord = null;
		}else{
			keyWord = keyWord.trim();
		}
		
		List<AdvSpaceTrafficCountModel> list = new ArrayList<AdvSpaceTrafficCountModel>();
		
		if(advType == 0){//图片广告
			list = mapper
					.queryTrafficCountBySizeCode(sizeCode,industryId,keyWord);
		}else if(advType == 1){//文字广告
			list = mapper.queryWordTrafficCountBySizeCode(industryId, keyWord);
		}
		
		if (!CollectionUtils.isEmpty(list)) {
			for (AdvSpaceTrafficCountModel aa : list) {
				int count = aa.getAdvAllTrafficCount();
				if (!CollectionUtils.isEmpty(aa.getTrafficModel())) {
					for (AdvTrafficCountModel bb : aa.getTrafficModel()) {
						count += bb.getAdvOneTrafficCount();
					}
				}
				aa.setAdvAllTrafficCount(count);
			}
		}

		return list;
	}
	
	/**
	 * 
	 * @author： zsl  2015年10月21日 下午1:27:38
	 * @方法名： queryTrafficCountBySizeCode
	 * @方法描述：selectDate: -1:全部   0：按今天查询 1 ：按近一周查询 2：按近一个月查询  3 :昨天
	 *
	 */
	@Override
	public List<AdvSpaceTrafficCountModel> queryTrafficCountBySizeCode(
			String sizeCode, Long industryId, String keyWord, Integer advType,
			Long selectDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date beginDate = getBeginDate(selectDate);		
		Date endDate = new Date();
		if(selectDate == 3){
			endDate = sdf.parse(sdf.format(endDate));
		}
			
		if(StringUtils.isEmpty(keyWord)){
			keyWord = null;
		}else{
			keyWord = keyWord.trim();
		}
		
		List<AdvSpaceTrafficCountModel> list = new ArrayList<AdvSpaceTrafficCountModel>();
		
		if(advType == 0){//图片广告
			
				//list = mapper.queryTrafficCountBySizeCode(sizeCode,industryId,keyWord);
			
				list = mapper
						.queryTrafficCountBySizeCode2(sizeCode,industryId,keyWord,selectDate,beginDate,endDate);
			
			
		}else if(advType == 1){//文字广告
			
				//list = mapper.queryWordTrafficCountBySizeCode(industryId, keyWord);
			
				list = mapper.queryWordTrafficCountBySizeCode2(industryId, keyWord,selectDate,beginDate,endDate);
			
		}
		
		if (!CollectionUtils.isEmpty(list)) {
			for (AdvSpaceTrafficCountModel aa : list) {
				int count = aa.getAdvAllTrafficCount();
				if (!CollectionUtils.isEmpty(aa.getTrafficModel())) {
					for (AdvTrafficCountModel bb : aa.getTrafficModel()) {
						count += bb.getAdvOneTrafficCount();
					}
				}
				aa.setAdvAllTrafficCount(count);
			}
		}

		return list;
	}

	/**
	 * @author： zsl  2015年10月21日 下午2:33:35
	 * @方法名： getBeginDate
	 * @方法描述：
	 * @param:
	 * @返回值：Date
	 *
	 */
	private Date getBeginDate(Long selectDate) throws ParseException {
		Calendar cal = Calendar.getInstance();
		Date beginDate = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		if(selectDate == 0){//今天
			beginDate = sdf.parse(sdf.format(beginDate));
		}else if(selectDate == 3){//昨天
			cal.add(Calendar.DAY_OF_MONTH, -1);
			beginDate = sdf.parse(sdf.format(cal.getTime()));
			
		}else if(selectDate == 1){//一周
			beginDate = getLastMonth(0, 7);//往前推一周        0：日              1： 月
		}else if(selectDate == 2){//一个月
			beginDate = getLastMonth(1, 1);//往前推一个月      0：日              1： 月
		}
		return beginDate;
	}

	
	/**
	 * 
	 * @author： zsl  2015年9月24日 下午4:55:41
	 * @方法名： delTraffics
	 * @方法描述：清空对应广告的流量数据
	 *
	 */
	@Override
	public void delTraffics(Long adId) {
		LeagueAdTrafficTab lat = new LeagueAdTrafficTab();
		lat.setUpdateTime(new Date());
		lat.setDelFlag(1);
		LeagueAdTrafficTabExample ep = new LeagueAdTrafficTabExample();
		ep.createCriteria().andAdIdEqualTo(adId);
		mapper.updateByExampleSelective(lat, ep);
		//mapper.deleteByExample(ep);
	}
	
	/**
	 * 查询指定广告位下所有广告的总流量
	 * @author： zsl  2015年9月24日 下午6:09:58
	 * @方法名： queryAllTrafficCountBySizeCode
	 * @方法描述：
	 *
	 */
	@Override
	public int queryAllTrafficCountBySizeCode(String sizeCode, Integer advType) throws Exception{
		int totalCount = 0;
		if(advType == 0){//图片广告
			totalCount = mapper
					.queryAllTrafficCountBySizeCode(sizeCode);
		}else if(advType == 1){//文字广告
			totalCount = mapper.queryWordAllTrafficCountBySizeCode();
		}
		
		return totalCount;
	}
	
	@Override
	public int queryAllTrafficCountBySizeCode(String sizeCode, Integer advType,Long selectDate) throws Exception {
		int totalCount = 0;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		Date beginDate = getBeginDate(selectDate);		
		Date endDate = new Date();
		if(selectDate == 3){
			endDate = sdf.parse(sdf.format(endDate));
		}
		
		if(advType == 0){//图片广告
			//totalCount = mapper.queryAllTrafficCountBySizeCode(sizeCode);
			totalCount = mapper.queryAllTrafficCountBySizeCode2(sizeCode,selectDate,beginDate,endDate);
		}else if(advType == 1){//文字广告
			//totalCount = mapper.queryWordAllTrafficCountBySizeCode();
			totalCount = mapper.queryWordAllTrafficCountBySizeCode2(selectDate,beginDate,endDate);
		}
		
		return totalCount;
	}

}
