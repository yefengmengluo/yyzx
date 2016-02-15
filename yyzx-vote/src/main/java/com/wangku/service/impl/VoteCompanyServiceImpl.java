package com.wangku.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.wangku.entity.Company;
import com.wangku.entity.CompanyExample;
import com.wangku.entity.User;
import com.wangku.entity.VoteItemTable;
import com.wangku.entity.VoteItemTableWithBLOBs;
import com.wangku.mapper.CompanyMapper;
import com.wangku.mapper.VoteItemTableMapper;
import com.wangku.service.VoteCompanyService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.upload.service.FastDFSService;
import com.wangku.util.Page;
import com.wangku.util.VoteSeqEnum;

/**
 * 
 * @author zsl 2015-6-18上午9:44:43 类描述：投票会员服务接口实现
 */
@Service("voteCompanyService")
public class VoteCompanyServiceImpl implements VoteCompanyService {

	@Autowired
	private CompanyMapper mapper;

	@Autowired
	private VoteSequenceDao voteSequenceDao;

	@Autowired
	private VoteItemTableMapper itemMapper;

	@Autowired
	private FastDFSService fastDFSService;// 访问图片服务器

	/**
	 * 
	 * @author： zsl 2015-6-19 上午9:46:33 @方法名： queryAllCount
	 * 
	 * @方法描述：查询满足条件的会员数据的数量
	 * @param:
	 * @返回值：int
	 * 
	 */
	public int queryAllCount(String keyWord, User user) {
		CompanyExample ep = new CompanyExample();
		Integer uPower = user.getUserPower();
		if (uPower == VoteSeqEnum.UPOWER.ALLPOWER.getValue() || uPower == VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()) {
			ep.createCriteria().andCopNameLike(keyWord);
		} else if (uPower == VoteSeqEnum.UPOWER.VOTE_POWER.getValue()) {
			ep.createCriteria().andCopNameLike(keyWord).andUserIdEqualTo(user.getUserId());
		}

		int countAll = mapper.countByExample(ep);
		return countAll;
	}

	/**
	 * zsl 分页查询投票会员数据
	 */
	@Override
	public Page<Company> queryByPage(String keyWord, int currentNum, User user) {
		Page<Company> page = new Page<Company>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<Company> copList = null;
		Integer uPower = user.getUserPower();
		int countAll = queryAllCount(keyWord, user);
		if (countAll > 0) {
			page.setMaxPage(countAll, page);
			if (uPower == VoteSeqEnum.UPOWER.ALLPOWER.getValue() || uPower == VoteSeqEnum.UPOWER.YUNYING_POWER.getValue()) {
				copList = mapper.queryByPage(keyWord, page.getOffsetValue(), page.getPageSize(), null);
			} else if (uPower == VoteSeqEnum.UPOWER.VOTE_POWER.getValue()) {
				copList = mapper.queryByPage(keyWord, page.getOffsetValue(), page.getPageSize(), user.getUserId());
			}

		}

		page.setPageList(copList);
		return page;
	}

	/**
	 * zsl 删除投票会员数据
	 * @throws Exception 
	 */
	@Override
	// @Transactional
	public void removeCompany(List<Long> idList, HttpServletRequest request) throws Exception {

		// 删除投票选项表对应数据
		mapper.deleteVoteItem(idList);

		// 删除会员信息
		CompanyExample ep = new CompanyExample();
		ep.createCriteria().andCopIdIn(idList);

		List<Company> cops = mapper.selectByExample(ep);
		mapper.deleteByExample(ep);

		// 删除对应的图片
		for (Company cop : cops) {
			if(!StringUtils.isEmpty(cop.getLogo())){
				this.removePic(cop.getLogo());
			}if(!StringUtils.isEmpty(cop.getWeiboPic())){
				this.removePic(cop.getWeiboPic());
			}if(!StringUtils.isEmpty(cop.getWeixinPic())){
				this.removePic(cop.getWeixinPic());
			}if(!StringUtils.isEmpty(cop.getErweimaPic())){
				this.removePic(cop.getErweimaPic());
			}
		}
	}
	public void removePic(String imgUrl) throws Exception{
		System.out.println("删除前图片服务器路径imgUrl："+imgUrl);
		if(!StringUtils.isEmpty(imgUrl)&&imgUrl.contains("http://img.99114.com/")){
			String group_name;
			String remote_filename;
			String[] split = imgUrl.split("/", 5);
			group_name=split[3];
			remote_filename=split[4];
			boolean isok = fastDFSService.remove_file(group_name, remote_filename);
			if(isok==false){
				System.out.println(" 图片库此操作未成功：图片路径为："+imgUrl);
			}
		}
	}

	/**
	 * 信息推荐，就是将status状态改掉，改成开启
	 */
	@Override

	public void modifyCompanyStatus(Long voteId, List<Long> idList, int status)throws Exception {

		mapper.modifyCompanyStatus(idList, status);

		// 修改投票选项表对应数据
		itemMapper.modifyItemVoteIdByCopIdList(voteId, idList);
	}

	/**
	 * 根据ID查询会员信息
	 */
	@Override
	public Company queryById(Long id)throws Exception {
		Company company = mapper.selectByPrimaryKey(id);
		VoteItemTable item = itemMapper.selectByPrimaryKey(company.getViId());
		if (item != null) {
			company.setVoteId(item.getvId());
		}
		return company;
	}

	/**
	 * 新增会员信息
	 */

	@Override
	public String saveCompany(Company company, HttpServletRequest req, int status)throws Exception {
		// logo
		String logo = this.fileUpload(req, "_logo");// 前端对应的file标签的名字
		if ("fail".equals(logo)) {
			return "fail";
		}
		company.setLogo(logo);

		// 微信
		String weixinPic = this.fileUpload(req, "_weixinPic");// 前端对应的file标签的名字
		if ("fail".equals(weixinPic)) {
			return "fail";
		}
		company.setWeixinPic(weixinPic);

		// 微博
		String weiboPic = this.fileUpload(req, "_weiboPic");// 前端对应的file标签的名字
		if ("fail".equals(weiboPic)) {
			return "fail";
		}
		company.setWeiboPic(weiboPic);

		// 二维码
		String erweimaPic = this.fileUpload(req, "_erweimaPic");// 前端对应的file标签的名字
		if ("fail".equals(erweimaPic)) {
			return "fail";
		}
		company.setErweimaPic(erweimaPic);

		// 会员ID
		Long copId = voteSequenceDao.getIdByTableName(VoteSeqEnum.VOTE_SYSTEM_SEQ.VOTE_COMPANY.getValue());
		company.setCopId(copId);
		company.setAddTime(new Date());
		company.setStatus(status);

		// 投票选项ID
		Long itemId = voteSequenceDao.getIdByTableName(VoteSeqEnum.VOTE_SYSTEM_SEQ.VOTE_ITEM_TABLE.getValue());

		company.setViId(itemId);
		mapper.insertSelective(company);

		VoteItemTableWithBLOBs item = new VoteItemTableWithBLOBs();
		item.setId(itemId);
		item.setvId(company.getVoteId());
		item.setVdCount(0);
		item.setVdTitle(company.getCopBrand());

		// 封装detail
		// VoteItemDetail detail = new VoteItemDetail();
		// detail.setVi_address(company.getCopAddress());
		// detail.setVi_brand(company.getCopBrand());
		// detail.setVi_companyurl(company.getCopUrl());
		// detail.setVi_erweima(company.getErweimaPic());
		// detail.setVi_industry(company.getIndustry());
		// detail.setVi_logo(company.getLogo());
		// detail.setVi_summary(company.getCopSummary());
		// detail.setVi_wexin(company.getWeixinPic());
		//
		// JSONObject jasonObject = JSONObject.fromObject(detail);
		// item.setVdDetail(jasonObject.toString());
		itemMapper.insertSelective(item);
		return "";
	}

	public String fileUpload(HttpServletRequest request, String file_name)throws Exception {

		// 文件存储路径
		String filePath = "";// 文件全路径
		// 获取图片上图片服务器
		try {
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

				MultipartFile file = multiRequest.getFile(file_name);
				if (!file.isEmpty()) {
					// 调用上传图片服务器的方法
					filePath = fastDFSService.uploadImage(file);
					System.out.println("==投票系统中：添加会员时，获取图片服务器路径：======" + filePath);
					if ("false".equals(filePath)) {
						return "fail";
					}
				} else {
					System.out.println("文件未上传！");
					return "";
				}
			}
		} catch (Exception e) {
			return "fail";

		}

		return filePath;
	}


	/**
	 * 修改会员信息
	 */
	@Override
	public String modifyCompany(Company company, HttpServletRequest req) throws Exception{
		Company copOld = mapper.selectByPrimaryKey(company.getCopId());

		// logo
		String logo = this.modifyFile(req, "_logo", copOld.getLogo());// 前端对应的file标签的名字
		if ("fail".equals(logo)) {
			return "fail";
		}
		company.setLogo(logo);

		// 微信
		String weixinPic = this.modifyFile(req, "_weixinPic", copOld.getWeixinPic());// 前端对应的file标签的名字
		if ("fail".equals(weixinPic)) {
			return "fail";
		}
		company.setWeixinPic(weixinPic);

		// 微博
		String weiboPic = this.modifyFile(req, "_weiboPic", copOld.getWeiboPic());// 前端对应的file标签的名字
		if ("fail".equals(weiboPic)) {
			return "fail";
		}
		company.setWeiboPic(weiboPic);

		// 二维码
		String erweimaPic = this.modifyFile(req, "_erweimaPic", copOld.getErweimaPic());// 前端对应的file标签的名字
		if ("fail".equals(erweimaPic)) {
			return "fail";
		}
		company.setErweimaPic(erweimaPic);
		company.setStatus(copOld.getStatus());
		company.setAddTime(copOld.getAddTime());
		company.setViId(copOld.getViId());
		company.setUserId(copOld.getUserId());
		// company.setVoteId(copOld.getVoteId());
		mapper.updateByPrimaryKey(company);

		VoteItemTableWithBLOBs item = itemMapper.selectByPrimaryKey(copOld.getViId());
		// item.setvId(company.getVoteId());
		item.setVdTitle(company.getCopBrand());

		itemMapper.updateByPrimaryKeyWithBLOBs(item);
		return "";
	}

	public String modifyFile(HttpServletRequest request, String file_name, String old_info) throws Exception{

		String filePath = "";// 文件全路径
		String group_name;//服务器组名
		String remote_filename;//服务器文件名

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		try {
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

				MultipartFile file = multiRequest.getFile(file_name);
				if (!file.isEmpty()) {
					// 调用上传图片服务器的方法
					filePath = fastDFSService.uploadImage(file);
					System.out.println("==t投票系统：会员修改时，获取图片服务器路径：======" + filePath);
					if ("false".equals(filePath)) {
						return "fail";
					}
					System.out.println("修改前图片服务器路径："+old_info);
					if(!StringUtils.isEmpty(old_info)&&old_info.contains("http://img.99114.com/")){
						String[] split = old_info.split("/", 5);
						group_name=split[3];
						remote_filename=split[4];
						boolean isok = fastDFSService.remove_file(group_name, remote_filename);
						if(isok==false){
							System.out.println(" 图片库此操作未成功：图片路径为："+old_info);
						}
					}
				} else {
					System.out.println("用户没有修改上传文件！");
					return old_info;
				}
			}
		} catch (Exception e) {
			return "fail";
		}

		return filePath;
	}

}
