package com.wangku.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.wangku.entity.Picture;
import com.wangku.entity.PictureExample;
import com.wangku.mapper.PictureMapper;
import com.wangku.service.PictureService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.upload.service.FastDFSService;
import com.wangku.util.VoteSeqEnum;

/**
 * vote服务实现。
 * 
 */
@Service("pictureService")
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	@Autowired
	private FastDFSService fastDFSService;//访问图片服务器
	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryByAdvId
	 * @方法描述：根据广告位id查询 广告图/文记录
	 * @param: advId 广告位id
	 * @返回值：List<Picture>
	 * 
	 */
	
	public List<Picture> queryByAdvId(Long advId) {
		PictureExample qbe = new PictureExample();
		qbe.createCriteria().andAdvIdEqualTo(advId);
		List<Picture> pictures = mapper.selectByExample(qbe);
		return pictures;
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： addPicture
	 * @方法描述：添加广告图/文
	 * @param: 广告图/文对象
	 * @throws Exception 
	 * @返回值：void
	 * 
	 */
	
	public String addPicture(Picture picture, Integer advType,
			HttpServletRequest request) throws Exception {
		Long id = voteSequenceDao
				.getIdByTableName(VoteSeqEnum.VOTE_SYSTEM_SEQ.VOTE_PICTURE.getValue());

		if (advType == 0) {// 图片广告
			// 处理上传文件
			String originalImgName = null;// 原始图片名
			String picUrl = null;// 图片URL

			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if (multipartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				Iterator<String> iter = multiRequest.getFileNames();
				while (iter.hasNext()) {
					MultipartFile file = multiRequest.getFile(iter.next());
					originalImgName = file.getOriginalFilename();
					//调用上传图片服务器的方法
					 picUrl=fastDFSService.uploadImage(file);
					 System.out.println("==投票系统中===修改图片时获取图片服务器url:===="+picUrl);
						if("false".equals(picUrl)){
							return "flase";
						}
					picture.setPicId(id);
					picture.setPicName(originalImgName);
					picture.setPicUrl(picUrl);
					picture.setStarttime(new Date());
					mapper.insert(picture);
				}
			}
			return "ok";
		} else {// 文字广告
			picture.setPicId(id);
			picture.setStarttime(new Date());
			if(!StringUtils.isEmpty(picture.getText())){
				mapper.insert(picture);
				return "ok";
			}return "ok";
		}
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryPicture
	 * @方法描述：查询广告图/文
	 * @param: 广告图/文id
	 * @返回值：Picture
	 * 
	 */
	public Picture queryPicture(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： emodifyPicture
	 * @方法描述：修改广告图/文
	 * @param: 广告图/文对象
	 * @返回值：void
	 * 
	 */
	public String modifyPicture(Picture picture, Integer advType,
			HttpServletRequest request)throws Exception {
		if (advType == 0) {// 图片广告
			//获取所需属性
			String oldImg = picture.getPicUrl();// 数据库中保留的图片路径
			String originalImgName = picture.getPicName();// 获取修改后的图片名
			String picUrl = picture.getPicUrl();// 获取修改后的图片URL
			String group_name;//服务器组别
			String remote_filename;//服务器图片名
			// 处理上传文件
				CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
						request.getSession().getServletContext());
				if (multipartResolver.isMultipart(request)) {
					MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
					Iterator<String> iter = multiRequest.getFileNames();
					while (iter.hasNext()) {
						MultipartFile file = multiRequest.getFile(iter.next());
	
						if (!StringUtils.isEmpty(file.getOriginalFilename())) {// 说明上传了图片
							originalImgName = file.getOriginalFilename();
							 picUrl=fastDFSService.uploadImage(file);
								System.out.println("===修改后获取的图片服务器路径====="+picUrl);
								if("false".equals(picUrl)){
									return "false";
								}
								//删除服务器图片
								System.out.println(" 修改删除前，图片路径为："+oldImg);
								if(!StringUtils.isEmpty(oldImg)&&oldImg.contains("http://img.99114.com/")){
									String[] split = oldImg.split("/", 5);
									group_name=split[3];
									remote_filename=split[4];
									boolean isok = fastDFSService.remove_file(group_name, remote_filename);
									if(isok==false){
										System.out.println(" 图片库此操作未成功：图片路径为："+oldImg);
									}
								}
							}
						picture.setPicName(originalImgName);
						picture.setPicUrl(picUrl);
					}
				}
				mapper.updateByPrimaryKey(picture);//修改除图片外的其他信息；
		} else {// 文字广告
			mapper.updateByPrimaryKey(picture);//修改文字广告信息
		}
		return "ok";
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： removePicture
	 * @方法描述：删除 广告图/文
	 * @param: 广告图/文id
	 * @返回值：void
	 * 
	 */
	/*public void removePicture(Long id) {
		mapper.deleteByPrimaryKey(id);
	}*/

	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-25 下午3:57:09
	 * @方法名： removePictureByAdvId
	 * @方法描述：删除指定广告位下的图文信息
	 * @param: advId 广告位id
	 * @throws Exception 
	 * @返回值：void
	 * 
	 */
	
	public void removePictureByAdvId(Long advId) throws Exception {
		PictureExample qbe = new PictureExample();
		qbe.createCriteria().andAdvIdEqualTo(advId);
		String group_name;
		String remote_filename;
		//删除图片
		List<Picture> pictures = mapper.selectByExample(qbe);
		if(!CollectionUtils.isEmpty(pictures)){
			for(Picture picture : pictures){
				String imgUrl=picture.getPicUrl();
				System.out.println("删除前图片服务器路径imgUrl："+imgUrl);
					if(!StringUtils.isEmpty(imgUrl)&&imgUrl.contains("http://img.99114.com/")){
						String saveImgName = picture.getPicUrl();
						String[] split = saveImgName.split("/", 5);
						group_name=split[3];
						remote_filename=split[4];
						boolean isok = fastDFSService.remove_file(group_name, remote_filename);
						if(isok==false){
							System.out.println(" 图片库此操作未成功：图片路径为："+picture.getPicUrl());
						}
					}
				mapper.deleteByPrimaryKey(picture.getPicId());//删除表中记录   图/文
			}
		}
		
		
	}
}
