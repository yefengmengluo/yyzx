package com.wangku.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.wangku.entity.LeagueAdvInfo;
import com.wangku.entity.LeagueAdvInfoExample;
import com.wangku.entity.LeagueDataModel;
import com.wangku.entity.LeagueSize;
import com.wangku.mapper.LeagueAdvInfoMapper;
import com.wangku.mapper.LeagueSizeMapper;
import com.wangku.pojo.LeagueAdvListModel;
import com.wangku.service.LeagueAdvInfoService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.upload.service.FastDFSService;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

@Service("leagueAdvInfoService")
public class LeagueAdvInfoServiceImpl implements LeagueAdvInfoService {

	@Autowired
	LeagueAdvInfoMapper mapper;

	@Autowired
	private LeagueSizeMapper sizeMapper;

	@Autowired
	private VoteSequenceDao voteSequenceDao;
	
	@Autowired
	private FastDFSService fastDFSService;//访问图片服务器
	/**
	 * 条件分页查询广告位信息记录
	 */
	public Page<LeagueAdvListModel> queryAdvInfosByKeywordPaged(Long industryId, Long typeId, Integer currentNum) {
		Page<LeagueAdvListModel> page = new Page<LeagueAdvListModel>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<LeagueAdvListModel> advInfos = mapper.queryAdvInfosByKeywordPaged(industryId, typeId,
				page.getOffsetValue(), page.getPageSize());
		System.out.println("集合：===="+advInfos);
		int listsize = mapper.queryAdvInfosByKeywordPagedCount(industryId, typeId);
		page.setPageList(advInfos);
		page.setMaxPage(listsize, page);
		return page;
	}

	/**
	 * 添加图片广告
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public String addAdvInfoPic(HttpServletRequest request, List<LeagueAdvInfo> advInfos) throws Exception {

		String originalImgName = null;// 原始图片名
		String picUrl = null;// 图片URL
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next());
				 picUrl=fastDFSService.uploadImage(file);
				 if("false".equals(picUrl)){
					 return "nok";
				 }
				System.out.println("==广告联盟 ====添加图片广告所获取的图片服务器的imgUrl:======"+picUrl);
				originalImgName = file.getOriginalFilename();
			}
		}

		if (!CollectionUtils.isEmpty(advInfos)) {

			for (LeagueAdvInfo advInfo : advInfos) {
				Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.LEAGUE_SYS_SEQ.ADV_INFO.getValue());
				advInfo.setId(id);
				advInfo.setCreateTime(new Date());
				advInfo.setPicName(originalImgName);
				advInfo.setPicUrl(picUrl);
				 mapper.insert(advInfo);
			}
			return "ok";
		}
		return "nok";
	}

	/**
	 * 根据广告id删除广告位信息表相关记录
	 */
	public void removeAdvInfoById(Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	/**
	 * 
	 * @author： zsl 2015年8月5日 上午9:59:03 @方法名： queryAdvInfoById
	 * 
	 * @方法描述：根据ID查询图片广告信息,包括行业名称
	 * @param:
	 * @返回值：LeagueAdvInfo
	 *
	 */
	public LeagueAdvInfo queryAdvInfoById(Long id) throws Exception {
		return mapper.queryAdvInfoById(id);
	}

	@Override
	public String modifyAdvPic(LeagueAdvInfo info, HttpServletRequest req)throws Exception {
		LeagueAdvInfo oldInfo = mapper.selectByPrimaryKey(info.getId());
		// 修改图片picUrl---图片服务器上的路径，以及删除原有的图片
		Map<String, Object> map = this.modifyFile(req, "pic_file",info,oldInfo);// 前端对应的file标签的名字
		if (map.get("msg") instanceof String) {

			if ("false".equals((String) map.get("msg"))) {
				System.out.println("上传图片失败==================");
				return "fail";
			}
		}
		LeagueAdvInfo info2 = (LeagueAdvInfo) map.get("msg");
		Date date = new Date();
		if (info2.getStartTime().getTime() > date.getTime()) {
			info2.setOnFlag(1);//待上线
		} else if ((info2.getEndTime().getTime()+24*60*60*1000) < date.getTime()) {
			info2.setOnFlag(0);//过期
		} else {
			info2.setOnFlag(2);//在线
		}

		mapper.updateByPrimaryKeySelective(info2);

		// this.modifyStatus(oldInfo.getAdvCode());
		return "success";
	}

	/**
	 * 
	 * @author： zsl 2015-6-23 下午3:45:39 @方法名： deleteFile
	 * 
	 * @方法描述：删除文件
	 * @param: 文件的路径
	 * @返回值：void
	 * 
	 */
	public void deleteFile(String fullFilePath) {
		File localFile = new File(fullFilePath);
		if (localFile.exists()) {
			System.out.println("图片存在========================");
			localFile.delete();
		}
	}

	/**
	 * 
	 * @author： zsl 2015年8月5日 下午3:43:17 @方法名： modifyFile
	 * 
	 * @方法描述：修改上传的图片
	 * @param:
	 * @返回值：String
	 *
	 */
	public Map<String, Object> modifyFile(HttpServletRequest request, String file_name,
			LeagueAdvInfo info,LeagueAdvInfo oldInfo)throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String uploadFileName = "";// 上传文件的名称
		String group_name = "";// 服务器上的文件组别
		String remote_filename = "";// 服务器上的文件名
		String filePath = "";// 文件全路径
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
	
				MultipartFile file = multiRequest.getFile(file_name);
				
				if (!file.isEmpty()) {
					uploadFileName = file.getOriginalFilename();// 获取上传文件的名称
					filePath=fastDFSService.uploadImage(file);
					if("false".equals(filePath)){
						map.put("msg", "false");
						return map;
					}
					System.out.println("==广告联盟===修改图片时获取图片服务器url:===="+filePath);
					info.setPicUrl(filePath);
					info.setPicName(uploadFileName);
					//删除服务器图片
					String imgUrl=oldInfo.getPicUrl();
					if (!StringUtils.isEmpty(imgUrl)&&imgUrl.contains("http://img.99114.com")) {
						LeagueAdvInfoExample eap = new LeagueAdvInfoExample();
						eap.createCriteria().andPicUrlEqualTo(oldInfo.getPicUrl()).andIdNotEqualTo(oldInfo.getId());
						int count = mapper.countByExample(eap);
						System.out.println("删除时：查看某一图片路径的使用数量，以此还判断需要删除该路径下的图片与否：=====："+count);
						if(count == 0){
							String[] split = imgUrl.split("/", 5);
							group_name=split[3];
							remote_filename=split[4];
							boolean isok = fastDFSService.remove_file(group_name, remote_filename);
							System.out.println("删除图片服务器图片结果："+isok);
						}
					}
					map.put("msg", info);
					return map;
				} else {
					System.out.println("用户没有修改上传文件！");
					map.put("msg", info);
					return map;
				}
			}
			map.put("msg", info);
			return map;
	}

	/**
	 * 
	 * @author： zsl 2015年8月6日 下午4:11:54 @方法名： removeAdvPic
	 * @throws Exception 
	 * 
	 * @方法描述：批量删除图片广告数据
	 *
	 */
	@Override
	public void removeAdvPic(List<Long> idList, HttpServletRequest request) throws Exception {
		LeagueAdvInfoExample ep = new LeagueAdvInfoExample();
		ep.createCriteria().andIdIn(idList);
		String group_name;
		String remote_filename;
		List<LeagueAdvInfo> infos = mapper.selectByExample(ep);
	
		// 删除对应的图片
		for (LeagueAdvInfo info : infos) {
			LeagueAdvInfoExample ep2 = new LeagueAdvInfoExample();
			System.out.println(info.getPicUrl());
			ep2.createCriteria().andPicUrlEqualTo(info.getPicUrl());

			int count = mapper.countByExample(ep2);
			System.out.println("删除时：查看某一图片路径的使用数量，以此还判断需要删除该路径下的图片与否：=====："+count);
			if(count == 1){//说明这条记录是最后一条引用图片的
				String imgurl=info.getPicUrl();
				if(!StringUtils.isEmpty(imgurl)&&imgurl.contains("http://img.99114.com/")){
					String[] split = imgurl.split("/", 5);
					group_name=split[3];
					remote_filename=split[4];
					//System.out.println("group_name:"+group_name+"   remote_filename:"+remote_filename);
					boolean isok = fastDFSService.remove_file(group_name, remote_filename);
					System.out.println("删除图片服务器图片结果："+isok);
				}
			}
			
		}	// 批量删除图片广告数据
		mapper.removeAdvPic(idList);
	}

	// 用于定时调度-根据发布时间(startTime)、结束时间(endTime)、当前系统时间(sysTime)进行图片广告发布状态标识(on_flag)的修改
	// on_flag:0 过期,1 待用,2 启用
	public void modifyOnFlag() {
		mapper.updateOn();//修改为上线，on_flag = 2
		mapper.updateOff();//修改为过期 on_flag = 0
//		Date sysTime = new Date();
//		LeagueAdvInfo info = new LeagueAdvInfo();
//		// 全部查处后遍历修改状态会使得和数据库的交互太过频繁，采用批量修改2次的方式进行发布状态的修改
//		// 1、过期的:sysTime>endTime
//		LeagueAdvInfoExample qbe1 = new LeagueAdvInfoExample();
//		qbe1.createCriteria().andEndTimeLessThan(sysTime);
//		info.setOnFlag(0);
//		mapper.updateByExampleSelective(info, qbe1);
//		// 2、启用的:startTime<sysTime<endTime
//		LeagueAdvInfoExample qbe2 = new LeagueAdvInfoExample();
//		qbe2.createCriteria().andStartTimeLessThan(sysTime).andEndTimeGreaterThan(sysTime);
//		info.setOnFlag(2);
//		mapper.updateByExampleSelective(info, qbe2);
	}

	/**
	 * @author： zsl 2015年8月10日 上午11:03:56 @方法名： modifyStatus
	 * 
	 * @方法描述：修改广告的投放状态 ============禁用==============
	 * @param: 0：过期
	 *             1：未到期 2：投放中
	 * @返回值：void
	 *
	 */
	@SuppressWarnings("unused")
	private void modifyStatus(String advCode) {
		Date nowTime = new Date();
		LeagueAdvInfo info = new LeagueAdvInfo();

		// 将结束时间小于当前时间的状态改为过期
		LeagueAdvInfoExample qbe1 = new LeagueAdvInfoExample();
		qbe1.createCriteria().andEndTimeLessThan(nowTime).andOnFlagNotEqualTo(0).andAdvCodeEqualTo(advCode);
		info.setOnFlag(0);
		mapper.updateByExampleSelective(info, qbe1);

		// 将开始时间大于当前时间的状态全部改为未到期
		LeagueAdvInfoExample qbe2 = new LeagueAdvInfoExample();
		qbe2.createCriteria().andStartTimeGreaterThan(nowTime).andOnFlagNotEqualTo(1).andAdvCodeEqualTo(advCode);
		info.setOnFlag(1);
		mapper.updateByExampleSelective(info, qbe2);

		// 将当前时间处于开始时间和结束时间之内的状态全部改为投放中
		LeagueAdvInfoExample qbe3 = new LeagueAdvInfoExample();
		qbe3.createCriteria().andStartTimeLessThanOrEqualTo(nowTime).andEndTimeGreaterThanOrEqualTo(nowTime)
				.andOnFlagNotEqualTo(2).andAdvCodeEqualTo(advCode);
		info.setOnFlag(2);
		mapper.updateByExampleSelective(info, qbe3);
	}

	/**
	 * 
	 * @author： zsl 2015年8月7日 上午11:30:28 @方法名： queryLeagueAdvList
	 * 
	 * @方法描述：用于查询广告数据展示在网站广告位中
	 *
	 */
	@Override
	public List<LeagueDataModel> queryLeagueAdvList(String advCode, int dataNum) {
		List<LeagueAdvInfo> infoList;
		// Date nowTime = new Date();
		// 修改广告的投放状态
		// this.modifyStatus(advCode);

		// 根据查询条数查询满足条件的数据集合
		LeagueAdvInfoExample ep = new LeagueAdvInfoExample();
		String str = "create_time desc limit " + dataNum;
		ep.setOrderByClause(str);
		// ep.createCriteria().andStartTimeLessThanOrEqualTo(nowTime).andEndTimeGreaterThanOrEqualTo(nowTime).andAdvCodeEqualTo(advCode);
		//优先获取客户购买的图片的广告图片
		ep.createCriteria().andOnFlagEqualTo(2).andAdvCodeEqualTo(advCode).andRedFlagIsNull();

		 infoList = mapper.selectByExample(ep);
		//如客户购买的图片  无     ，  那么获取默认图片===“虚位以待图片”
		if (CollectionUtils.isEmpty(infoList)) {
			LeagueAdvInfoExample ep1 = new LeagueAdvInfoExample();
			String str1 = "create_time desc limit " + dataNum;
			ep1.setOrderByClause(str1);
			ep1.createCriteria().andOnFlagEqualTo(2).andAdvCodeEqualTo(advCode).andRedFlagEqualTo(0);
			infoList = mapper.selectByExample(ep1);
			}
		if(!CollectionUtils.isEmpty(infoList)) {
			List<LeagueDataModel> dataList = new ArrayList<LeagueDataModel>();
			for (LeagueAdvInfo lai : infoList) {
				LeagueDataModel d = new LeagueDataModel();
				LeagueSize size = sizeMapper.selectByPrimaryKey(lai.getSizeId());
				if (size == null) {
					System.out.println(lai.toString() + ",查询广告对应的尺寸数据为空，数据可能出问题！！！！！！！！！！");
					continue;
				} else {
					String[] sizeA = size.getAdvSize().split("x");

					d.setPicWidth(sizeA[0]);
					d.setPicHeight(sizeA[1]);
					d.setIndustryId(size.getIndustryId());
					d.setIndustryName(size.getIndustryName());
					d.setTypeId(size.getTypeId());
					d.setTypeName(size.getTypeName());

					d.setAdvName(lai.getAdvName());
					d.setAdvCode(advCode);
					d.setPicUrl(lai.getPicUrl());
					d.setTargetUrl(lai.getTargetUrl());
					d.setTitle(lai.getTitle());
					d.setMemo(lai.getMemo());
					d.setOrderNum(lai.getOrderNum());
					d.setAdID(lai.getId());
					dataList.add(d);
				}
			}
			return dataList;
		}
		return null;
	}
	
	/**
	 * 
	 * @author： zsl  2015年8月17日 下午4:52:51
	 * @方法名： queryAdvCountBySizeId
	 * @方法描述：根据查询查询广告数量
	 *
	 */
	@Override
	public int queryAdvCountBySizeId(Long sizeId) {
		LeagueAdvInfoExample ep = new LeagueAdvInfoExample();
		ep.createCriteria().andSizeIdEqualTo(sizeId);
		return mapper.countByExample(ep);
	}
	
	/**
	 * 
	 * @author： 谢虹英  2015年9月17日 下午5:30:34
	 * @方法名： updateRedFage
	 * @方法描述：暂时性   使用red_flag字段作为区别默认图片还是用户上传的广告图片  red_flag为0则为默认的图片--广告位招租
	 * @param:
	 * @返回值：
	 *
	 */
	public int updateRedFage() throws ParseException{
		LeagueAdvInfoExample ep = new LeagueAdvInfoExample();
		ep.createCriteria().andCreateTimeLessThan(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2015-09-16 00:00:00"));
		List<LeagueAdvInfo> list = mapper.selectByExample(ep);
		System.out.println("list集合："+list);
		for(LeagueAdvInfo li:list){
			li.setRedFlag(0);
			mapper.updateByPrimaryKeySelective(li);
		}
	
		return 0;
	}

}
