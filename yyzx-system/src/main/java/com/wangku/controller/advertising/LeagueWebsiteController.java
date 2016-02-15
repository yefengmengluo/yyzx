package com.wangku.controller.advertising;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wangku.entity.LeaguePram;
import com.wangku.entity.LeagueWebsite;
import com.wangku.entity.LeagueWebsiteExample;
import com.wangku.service.LeaguePramService;
import com.wangku.service.LeagueWebsiteService;
import com.wangku.util.ExcelUtil;
import com.wangku.util.Page;

@Controller
@RequestMapping("/LeagueWebsite")
public class LeagueWebsiteController {

	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

	private static final Logger logger = LoggerFactory
			.getLogger(LeagueWebsiteController.class);

	@Autowired
	private LeagueWebsiteService leagueWebsiteService;
	@Autowired
	private LeaguePramService leaguePramService;

	@RequestMapping(value = "/queryIndustry")
	public @ResponseBody
	List<LeaguePram> queryIndustry() {
		try {
			logger.debug("查询全部行业数据===============================");
			List<LeaguePram> industrys = leaguePramService.queryLeaguePram(0);
			return industrys;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午6:14:09
	 * @方法名： queryLeagueWebsite
	 * @方法描述：根据行业ID分页查询网站信息
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping(value = "/queryLeagueWebsite")
	public ModelAndView queryLeagueWebsite(ModelAndView mav, Long industryId,
			Integer currentNum,String likeParam) {
		try {
			logger.debug("根据行业ID分页查询网站信息===========");
			Page<LeagueWebsite> page = leagueWebsiteService
					.queryLeagueWebsitesByIndustryIdPaged(industryId,
							currentNum,10,likeParam);
			// System.out.println("pagelist==============================="+page.getPageList());
			logger.debug("查询全部行业数据===============================");
			// 查询所有行业
			List<LeaguePram> industrys = leaguePramService.queryLeaguePram(0);
			mav.getModel().put("page", page);
			mav.getModel().put("industrys", industrys);
			mav.getModel().put("industryId", industryId);
			mav.getModel().put("likeParam", likeParam);
			System.out.println("***************===" + page.getPageList().size());
			System.out.println("currentNum===========" + page.getCurrentNum());
			mav.setViewName("jsp/league/website_manage/industry_website_list");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午6:03:07
	 * @方法名： addLeagueWebsite
	 * @方法描述：添加网站记录
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping("/addLeagueWebsite")
	public @ResponseBody String addLeagueWebsite(ModelAndView mav,
			LeagueWebsite leagueWebsite, HttpServletRequest request) {
		try {
			LeagueWebsiteExample example = new LeagueWebsiteExample();
			example.createCriteria().andSiteNameEqualTo(
					leagueWebsite.getSiteName()).andDelFlagEqualTo(0);
			int count = leagueWebsiteService.countByExample(example);
			if (count == 0) {
				leagueWebsiteService.addLeagueWebsite(leagueWebsite);
				return "0";
			} else {
				logger.debug("名为" + leagueWebsite.getSiteName() + "的网站已经存在");
				return "1";

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
		
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午6:03:19
	 * @方法名： modifyLeagueWebsite
	 * @方法描述：修改网站记录
	 * @param:
	 * @返回值：String
	 * 
	 */
	@RequestMapping("/modifyLeagueWebsite")
	public @ResponseBody String modifyLeagueWebsite(LeagueWebsite leagueWebsite,
			HttpServletRequest request) {
		logger.debug("修改网站信息===============");
		try {
			LeagueWebsiteExample example = new LeagueWebsiteExample();
			example.createCriteria().andSiteNameEqualTo(
					leagueWebsite.getSiteName()).andIdNotEqualTo(leagueWebsite.getId()).andDelFlagEqualTo(0);
			int count = leagueWebsiteService.countByExample(example);
			if (count == 0) {
				leagueWebsiteService.modifyLeagueWebsite(leagueWebsite);
				return "0";
			} else {
				logger.debug("名为" + leagueWebsite.getSiteName() + "的网站已经存在");
				return "1";

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月21日 下午6:04:30
	 * @方法名： delLeagueWebsite
	 * @方法描述：删除网站记录
	 * @param:
	 * @返回值：String
	 */
	@RequestMapping("/delLeagueWebsite")
	public String delLeagueWebsite(Long id, Integer currentNum,
			Long industryId,String likeParam) {
		logger.debug("删除网站信息===============");
		try {
			leagueWebsiteService.removeLeagueWebsiteById(id);
			System.out
					.println("=========================================delLeagueWebsite industrys:"
							+ industryId);
			System.out
					.println("=========================================delLeagueWebsite currentNum:"
							+ currentNum);
			if (currentNum == null) {
				currentNum = 1;
			}
			return "redirect:/LeagueWebsite/queryLeagueWebsite?currentNum="
					+ currentNum + "&industryId=" + industryId+"&likeParam="+likeParam;
		} catch (Exception e) {
			e.printStackTrace();
			return "backstage/backPage/errors/error";
		}
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月23日 上午10:19:50
	 * @方法名： selectLeagueWebsiteById
	 * @方法描述：根据ID查询网站信息
	 * @param:
	 * @返回值：ModelAndView
	 * 
	 */
	@RequestMapping("/selectLeagueWebsiteById")
	public ModelAndView selectLeagueWebsiteById(ModelAndView mav, Long id,
			Integer currentNum) {
		logger.debug("根据ID查询网站信息===============");
		try {
			logger.debug("查询全部行业数据===============================");
			List<LeaguePram> industrys = leaguePramService.queryLeaguePram(0);

			LeagueWebsite leagueWebsite = leagueWebsiteService.queryById(id);
			mav.getModel().put("leagueWebsite", leagueWebsite);
			
			mav.getModel().put("industrys", industrys);
			mav.getModel().put("industryId", leagueWebsite.getIndustryId());
			mav.getModel().put("currentNum", currentNum);
			mav.setViewName("jsp/league/website_manage/industry_website_edit");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
		}
		return mav;
	}

	@RequestMapping("/downloadWebsites")
	public String download(HttpServletRequest request,
			HttpServletResponse response, Long industryId,String likeParam) throws IOException {
		// excel文件名称
		String fileName = "excel文件";
		// 查询预导出的数据
		Page<LeagueWebsite> page = null;
		try {
			page = leagueWebsiteService.queryLeagueWebsitesByIndustryIdPaged(
					industryId, 1, 1000,likeParam);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<LeagueWebsite> websites = page.getPageList();

		List<Map<String, Object>> list = createExcelRecord(websites);
		String columnNames[] = { "行业名称", "单品名称", "URL链接", "基地", "添加人姓名" };// 列名
		String keys[] = { "industryName", "siteName", "siteUrl", "jdBelong",
				"optPerson" };// map中的key
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			ExcelUtil.createWorkBook(list, keys, columnNames).write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (final IOException e) {
			throw e;
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
		return null;
	}

	private List<Map<String, Object>> createExcelRecord(
			List<LeagueWebsite> websites) {
		List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sheetName", "sheet2");
		listmap.add(map);
		LeagueWebsite leagueWebsite = null;

		for (int j = 0; j < websites.size(); j++) {
			leagueWebsite = websites.get(j);

			Map<String, Object> mapValue = new HashMap<String, Object>();
			mapValue.put("industryName", leagueWebsite.getIndustryName());
			mapValue.put("siteName", leagueWebsite.getSiteName());
			mapValue.put("siteUrl", leagueWebsite.getSiteUrl());
			mapValue.put("jdBelong", leagueWebsite.getJdBelong());
			mapValue.put("optPerson", leagueWebsite.getOptPerson());

			listmap.add(mapValue);
		}
		return listmap;
	}

	/**
	 * 
	 * @author： 何利娟 2015年9月24日 下午5:03:28
	 * @方法名： getAllByExcel
	 * @方法描述：读取excel文件中记录到List<LeagueWebsite>
	 * @param:
	 * @返回值：List<LeagueWebsite>
	 * 
	 */
	public List<LeagueWebsite> getAllByExcel(String file) {
		List<LeagueWebsite> list = new ArrayList<LeagueWebsite>();
		try {
			List<LeaguePram> industrys = leaguePramService.queryLeaguePram(0);
			int industrysLen = 0;
			if (industrys != null) {
				industrysLen = industrys.size();
			}

			Workbook rwb = Workbook.getWorkbook(new File(file));
			Sheet rs = rwb.getSheet("Test Shee 1");// 或者rwb.getSheet(0)
			int clos = rs.getColumns();// 得到所有的列
			int rows = rs.getRows();// 得到所有的行

			LeagueWebsite leagueWebsite = null;
			Date createTime = new Date();
			System.out.println(clos + " rows:" + rows);
			for (int i = 1; i < rows; i++) {
				for (int j = 0; j < clos; j++) {
					// 第一个是列数，第二个是行数
					String industryName = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
																			// 所以这里得j++
					String siteName = rs.getCell(j++, i).getContents();
					String siteUrl = rs.getCell(j++, i).getContents();
					String jdBelong = rs.getCell(j++, i).getContents();
					String optPerson = rs.getCell(j++, i).getContents();
					leagueWebsite = new LeagueWebsite();
					leagueWebsite.setCreateTime(createTime);
					// leagueWebsite.setId(id);
					// leagueWebsite.setIndustryId(industryId);
					for (int k = 0; k < industrysLen; k++) {
						if (industryName
								.equals(industrys.get(k).getParamName())) {
							leagueWebsite.setIndustryId(industrys.get(k)
									.getId());
							break;
						}
					}
					leagueWebsite.setIndustryName(industryName);
					leagueWebsite.setJdBelong(jdBelong);
					leagueWebsite.setOptPerson(optPerson);
					leagueWebsite.setSiteName(siteName);
					leagueWebsite.setSiteUrl(siteUrl);
					leagueWebsite.setUpdateTime(createTime);
					list.add(leagueWebsite);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public String readWebsiteFromExcel(String file) {

		List<LeagueWebsite> listExcel = getAllByExcel("d://book.xls");
		/*
		 * //得到数据库表中所有的数据 List<LeagueWebsite> listDb=StuService.getAllByDb();
		 */

		for (LeagueWebsite leagueWebsite : listExcel) {
			try {
				leagueWebsiteService.addLeagueWebsite(leagueWebsite);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String upload(HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		String responseStr = "";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		// 文件保存路径 ctxPath本地路径
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ File.separator + "uploadFiles";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String ymd = sdf.format(new Date());
		ctxPath += File.separator + ymd + File.separator;

		System.out.println("ctxpath=" + ctxPath);
		// 创建文件夹
		File file = new File(ctxPath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String fileName = null;
		// 文件名称生成[时间戳]+三位随机数
		Date date = new Date();
		long now = date.getTime();
		// Random random = new Random();
		String fileExtension = "";
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			// 上传文件
			MultipartFile mf = entity.getValue();
			// fileExtension=CommonUtil.getExtensionName(mf.getOriginalFilename());
			// fileName = mf.getOriginalFilename();//获取原文件名
			fileName = String.valueOf(now++);
			// 生成三位随机数 100-999
			// fileName+=CommonUtil.getRandomNumber(3);
			File uploadFile = new File(ctxPath + fileName + "." + fileExtension);
			try {
				FileCopyUtils.copy(mf.getBytes(), uploadFile);
				responseStr += ymd + File.separator + fileName + "."
						+ fileExtension;
			} catch (IOException e) {
				responseStr = "上传失败";
				e.printStackTrace();
				break;
			}
		}
		return responseStr;
	}
	
	
	
	/**
	 * 跳转到添加行业单品页面
	 * @author： zsl  2015年10月8日 上午10:31:21
	 * @方法名： toAddIndustryWebSite
	 * @方法描述：
	 * @param:sourceL  入口            0 从菜单进入        1 从列表进入
	 * @返回值：List<LeaguePram>
	 *
	 */
	@RequestMapping(value = "/toAddIndustryWebSite/{sourceL}")
	public ModelAndView toAddIndustryWebSite(
			ModelAndView mav,
			@PathVariable Integer sourceL){
		try {
			logger.debug("跳转到行业单品添加页面，查询全部行业数据===============================");
			List<LeaguePram> industrys = leaguePramService.queryLeaguePram(0);
			mav.getModel().put("industrys", industrys);
			mav.getModel().put("sourceL", sourceL);
			mav.setViewName("jsp/league/website_manage/industry_website_add");
			return mav;
		}catch(Exception e){
			e.printStackTrace();
			mav.setViewName("backstage/backPage/errors/error");
			return mav;
		}
	}
	
	
	/**
	 * 导入行业单品数据
	 * @author： zsl  2015年10月15日 上午11:34:33
	 * @方法名： excelImport
	 * @方法描述：
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/excelImport", method = RequestMethod.POST)
	public String excelImport(ModelAndView mav,HttpServletRequest request) {
		List<LeagueWebsite> listYes = new ArrayList<LeagueWebsite>();//新导入的数据
		List<LeagueWebsite> listU = new ArrayList<LeagueWebsite>();//数据库存在需要修改的
		List<LeagueWebsite> listNo = new ArrayList<LeagueWebsite>();//行业ID找不到的
		

		try {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			// 检查form是否有enctype="multipart/form-data"
			if (multipartResolver.isMultipart(request)) {
				//System.out.println("&&&&&&&&&&&&===111111111");
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				MultipartFile file = multiRequest.getFile("file");
				if (!file.isEmpty()) {
					//System.out.println("&&&&&&&&&&&&===122222222222");
					List<LeaguePram> industrys = leaguePramService
							.queryLeaguePram(0);
					int industrysLen = 0;
					if (industrys == null) {
						return "redirect:/LeagueWebsite/queryLeagueWebsite?currentNum=1&industryId=0";
					}
					industrysLen = industrys.size();
					// excel获得文件
					Workbook book = Workbook.getWorkbook(file.getInputStream());
					//Sheet rs = book.getSheet("Test Shee 1");// 或者rwb.getSheet(0)
					Sheet rs = book.getSheet(0);
					int clos = rs.getColumns();// 得到所有的列
					int rows = rs.getRows();// 得到所有的行

					LeagueWebsite leagueWebsite = null;
					Date nowTime = new Date();
					System.out.println(clos + " rows:" + rows);
					outer: for (int i = 1; i < rows; i++) {
						for (int j = 0; j < clos; j++) {
							// 第一个是列数，第二个是行数
							String industryName = rs.getCell(j++, i)
									.getContents();// 默认最左边编号也算一列
													// 所以这里得j++
							String siteName = rs.getCell(j++, i).getContents();
							String siteUrl = rs.getCell(j++, i).getContents();
							String jdBelong = rs.getCell(j++, i).getContents();
							String optPerson = rs.getCell(j++, i).getContents();
							leagueWebsite = new LeagueWebsite();

							leagueWebsite.setCreateTime(nowTime);
							leagueWebsite.setUpdateTime(nowTime);
							leagueWebsite.setDelFlag(0);
							// leagueWebsite.setId(id);
							// leagueWebsite.setIndustryId(industryId);
							boolean flag = false;
							if(!StringUtils.isEmpty(industryName)){
								for (int k = 0; k < industrysLen; k++) {
									if (industryName.trim().equals(industrys.get(k)
											.getParamName().trim())) {
										leagueWebsite.setIndustryId(industrys
												.get(k).getId());
										flag = true;
										break;
									}
								}
							}
							
							if (flag == false) {
								// 没有找到对应的行业ID
								leagueWebsite.setIndustryName(industryName);
								leagueWebsite.setJdBelong(jdBelong);
								leagueWebsite.setOptPerson(optPerson);
								leagueWebsite.setSiteName(siteName);
								leagueWebsite.setSiteUrl(siteUrl);
								listNo.add(leagueWebsite);
								continue outer;
							}

							LeagueWebsite leagueWebsiteDB = leagueWebsiteService
									.queryLeagueWebsiteBySiteName(siteName.trim());// 根据站点名查询数据库数据
							if (leagueWebsiteDB == null) {
								// leagueWebsite.setIndustryName(industryName);
								leagueWebsite.setJdBelong(jdBelong);
								leagueWebsite.setOptPerson(optPerson);
								leagueWebsite.setSiteName(siteName);
								leagueWebsite.setSiteUrl(siteUrl);
								leagueWebsiteService.addLeagueWebsite(leagueWebsite);
								listYes.add(leagueWebsite);
							} else {
								
								leagueWebsite.setId(leagueWebsiteDB.getId());
								leagueWebsite.setJdBelong(jdBelong);
								leagueWebsite.setOptPerson(optPerson);
								leagueWebsite.setSiteName(siteName);
								leagueWebsite.setSiteUrl(siteUrl);
								leagueWebsiteService
										.updateLeagueWebsite(leagueWebsite);
								listU.add(leagueWebsite);
								
								
							}
						}
					}
				} else {
					System.out.println("用户没有修改上传文件！");

					
				}

			}

		} catch (Exception e) {
			logger.error("操作上传文件出现错误:{}", e.getMessage());
		}
//		System.out.println("新导入的数据个数&&&&&&&&&========："+listYes.size());
//		if(!CollectionUtils.isEmpty(listYes)){
//			for(LeagueWebsite leagueWebsite :listYes){
//				System.out.println(leagueWebsite.toString());
//			}
//		}
//		System.out.println("新导入的数据重复的并修改的个数&&&&&&&&&========："+listU.size());
//		if(!CollectionUtils.isEmpty(listU)){
//			for(LeagueWebsite leagueWebsite :listU){
//				System.out.println(leagueWebsite.toString());
//			}
//		}
//		
//		System.out.println("导入失败的数据个数&&&&&&&&&========："+listNo.size());
//		if(!CollectionUtils.isEmpty(listNo)){
//			for(LeagueWebsite leagueWebsite :listNo){
//				System.out.println(leagueWebsite.toString());
//			}
//		}
		return "redirect:/LeagueWebsite/queryLeagueWebsite?currentNum=1&industryId=0";
	}
}