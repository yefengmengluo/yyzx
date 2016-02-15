package com.wangku.service.impl;

import java.util.Date;
import java.util.HashMap;
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

import com.wangku.entity.LeagueAdvInfoExample;
import com.wangku.entity.LeagueWebsite;
import com.wangku.entity.LeagueWebsiteExample;
import com.wangku.mapper.LeagueWebsiteMapper;
import com.wangku.pojo.LeagueAdvListModel;
import com.wangku.service.LeagueWebsiteService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

@Service("leagueWebsiteService")
public class LeagueWebsiteServiceImpl implements LeagueWebsiteService {

	@Autowired
	LeagueWebsiteMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午2:12:06
	 * @方法名： addLeagueWebsite
	 * @方法描述：添加网站
	 * @param:
	 * @返回值：
	 * 
	 */
	@Override
	public void addLeagueWebsite(LeagueWebsite leagueWebsite) {
		// 查询数据库，是否存在该条记录
		Long id = voteSequenceDao
				.getIdByTableName(VoteSeqEnum.LEAGUE_SYS_SEQ.ADV_WEBSITE
						.getValue());
		leagueWebsite.setId(id);
		leagueWebsite.setCreateTime(new Date());
		leagueWebsite.setUpdateTime(new Date());
		// 设置添加人为当前登录用户
		mapper.insertSelective(leagueWebsite);
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午2:12:20
	 * @方法名： modifyLeagueWebsite
	 * @方法描述：修改网站
	 * @param:
	 * @返回值：
	 * 
	 */
	@Override
	public void modifyLeagueWebsite(LeagueWebsite leagueWebsite) {
		leagueWebsite.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(leagueWebsite);
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午2:15:46
	 * @方法名： removeLeagueWebsiteById
	 * @方法描述：通过ID删除网站信息
	 * @param:
	 * @返回值：
	 */
	@Override
	public void removeLeagueWebsiteById(Long id) {
		LeagueWebsite lw = mapper.selectByPrimaryKey(id);
		lw.setDelFlag(1);
		lw.setUpdateTime(new Date());
		mapper.updateByPrimaryKeySelective(lw);
	}

	/**
	 * @author： 何利娟 2015年9月21日 下午2:16:10
	 * @方法名： queryById
	 * @方法描述：根据ID查找网站信息
	 * @param:
	 * @返回值：
	 * 
	 */
	@Override
	public LeagueWebsite queryById(long id) {
		// TODO 按id查询
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<LeagueWebsite> queryLeagueWebsitesByIndustryIdPaged(
			Long industryId,Integer currentNum, Integer pageSize,String likeParam )
			throws Exception {
		Page<LeagueWebsite> page = new Page<LeagueWebsite>();
		page.setCurrentNum(currentNum);
		page.setPageSize(pageSize);
		page.setSqlPage(page);
		List<LeagueWebsite> websites = mapper
				.queryLeagueWebsitesByIndustryIdPaged(page.getOffsetValue(),
						page.getPageSize(), industryId,likeParam);
		/*
		 * LeagueWebsite leagueWebsite=null; for(int i=0;i<websites.size();i++){
		 * leagueWebsite=websites.get(i);
		 * System.out.println("IndustryName:"+i+":"
		 * +leagueWebsite.getIndustryName());
		 * System.out.println("JdBelong:"+i+":"+leagueWebsite.getJdBelong());
		 * System.out.println("OptPerson:"+i+":"+leagueWebsite.getOptPerson());
		 * System.out.println("SiteName:"+i+":"+leagueWebsite.getSiteName());
		 * System.out.println("SiteUrl"+i+":"+leagueWebsite.getSiteUrl());
		 * System
		 * .out.println("CreateTime:"+i+":"+leagueWebsite.getCreateTime()); }
		 */
		int listsize = mapper.queryLeagueWebsitesByIndustryIdCount(industryId,likeParam);

		page.setPageList(websites);
		page.setMaxPage(listsize, page);
		return page;
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午3:35:34
	 * @方法名： querySelective
	 * @方法描述：多条件分页查询【未完】
	 * @param:
	 * @返回值：Page<LeagueWebsite>
	 * 
	 */
	@Override
	public Page<LeagueWebsite> querySelective(LeagueWebsiteExample example,
			Integer currentNum) throws Exception {
		Page<LeagueWebsite> page = new Page<LeagueWebsite>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<LeagueWebsite> websites = mapper.selectByExample(example);
		int listsize = 0;
		// int listsize =mapper.queryLeagueWebsitesByIndustryIdCount(example);
		page.setPageList(websites);
		page.setMaxPage(listsize, page);
		return page;
	}

	@Override
	public int countByExample(LeagueWebsiteExample example) {
		int count = mapper.countByExample(example);
		return count;
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午3:45:28
	 * @方法名： delBatch
	 * @方法描述：批量删除
	 * @param:
	 * @返回值：
	 * 
	 */
	@Override
	public void delBatch(String ids) throws Exception {
		List<Long> idList = null;

		if (ids != null && "".equals(ids)) {
			String[] strArray = ids.split(";");
			int size = strArray.length;
			for (int i = 0; i < size; i++) {
				if (strArray[i] != null && (!"".equals(strArray[i]))) {
					idList.add(Long.parseLong(strArray[i]));
				}
			}
			if (idList != null) {
				mapper.delBatch(idList);
			}
		}

	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午3:46:23
	 * @方法名： addBatch
	 * @方法描述：批量添加
	 * @param:
	 * @返回值：
	 * 
	 */
	@Override
	public void addBatch(List<LeagueWebsite> list) throws Exception {
		if (list != null) {
			mapper.addBatch(list);
		}
		// 删除同名数据【同表连接，连接条件为名称相同】

	}
	
	/**
	 * 根据站点名查询数据库数据
	 * @author： zsl  2015年10月15日 上午10:25:40
	 * @方法名： queryLeagueWebsiteBySiteName
	 * @方法描述：
	 *
	 */
	@Override
	public LeagueWebsite queryLeagueWebsiteBySiteName(String siteName) {
		LeagueWebsiteExample lep = new LeagueWebsiteExample();
		lep.createCriteria().andDelFlagEqualTo(0).andSiteNameEqualTo(siteName);
		List<LeagueWebsite> list = mapper.selectByExample(lep);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 修改行业单品数据
	 * @author： zsl  2015年10月15日 上午10:47:12
	 * @方法名： updateLeagueWebsite
	 * @方法描述：
	 *
	 */
	@Override
	public void updateLeagueWebsite(LeagueWebsite leagueWebsite)
			throws Exception {
		mapper.updateByPrimaryKeySelective(leagueWebsite);
	}

	@Override
	public String uploadFile(HttpServletRequest request) throws Exception {
		
		String uploadFileName = "";// 上传文件的名称
		String group_name = "";// 服务器上的文件组别
		String remote_filename = "";// 服务器上的文件名
		String filePath = "";// 文件全路径
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
			request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			MultipartFile file = multiRequest.getFile("upload_excel");
			
			if (!file.isEmpty()) {
				uploadFileName = file.getOriginalFilename();// 获取上传文件的名称
				//file.transferTo(uploadFileName);
			} else {
				System.out.println("用户没有修改上传文件！");
				
				return "fail";
			}
		}
		
		return "fail";
	}

}
