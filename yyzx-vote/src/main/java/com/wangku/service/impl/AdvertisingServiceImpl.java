package com.wangku.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.wangku.entity.Advertising;
import com.wangku.entity.AdvertisingExample;
import com.wangku.entity.Picture;
import com.wangku.mapper.AdvertisingMapper;
import com.wangku.service.AdvertisingService;
import com.wangku.service.PictureService;
import com.wangku.service.VoteSequenceDao;
import com.wangku.util.VoteSeqEnum;

/**
 * vote服务实现。
 * 
 */
@Service("advertisingService")
public class AdvertisingServiceImpl implements AdvertisingService {
	
	@Autowired
	private AdvertisingMapper mapper;
	@Autowired
	private VoteSequenceDao voteSequenceDao;
	@Autowired
	private PictureService pictureService;

	
	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryAll
	 * @方法描述：查询全部 广告位记录
	 * @param: keyWord 关键字 , currentNum 当前页
	 * @返回值：List<Advertising>
	 * 
	 */
	
	public List<Advertising> queryByVid(Long vId,Integer channelName)throws Exception {
		AdvertisingExample qbe = new AdvertisingExample();
		qbe.createCriteria().andVIdEqualTo(vId).andChannelNameEqualTo(channelName);
		qbe.setOrderByClause("adv_order");
		List<Advertising> advertisings = mapper.selectByExample(qbe);
		if(!CollectionUtils.isEmpty(advertisings)){
			for(Advertising advertising : advertisings){
				List<Picture> pictures = pictureService.queryByAdvId(advertising.getAdvId());
				advertising.setPictures(pictures);
			}
		}
		return advertisings;
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： addAdvertising
	 * @方法描述：添加广告位
	 * @param: 广告位对象
	 * @返回值：void
	 * 
	 */
	
	public String addAdvertising(Advertising advertising,HttpServletRequest request)throws Exception {
		String code=null;//"false"-失败，"ok"-成功
		Integer maxAdvOrder = mapper.queryMaxAdvOrder(advertising.getChannelName(),advertising.getvId());
		if(maxAdvOrder==null){
			maxAdvOrder = 0;
		}
		Long id = voteSequenceDao.getIdByTableName(VoteSeqEnum.VOTE_SYSTEM_SEQ.VOTE_ADVERTISING.getValue());
		advertising.setAdvId(id);
		advertising.setCreateTime(new Date());
		advertising.setAdvOrder(maxAdvOrder+1);
		System.out.println(StringUtils.isEmpty(advertising.getAdvTag()));
		if(StringUtils.isEmpty(advertising.getAdvTag())){
			advertising.setAdvTag("0");
		}
		mapper.insert(advertising);
		
		//添加广告图文信息
		Picture picture = advertising.getPicture();
		List<Picture> pictures = advertising.getPictures();
		
		Integer advType = advertising.getAdvType();
		if(advType == 0){//图片广告
			picture.setAdvId(id);
			 code = pictureService.addPicture(picture,advType,request);
		}else if(advType == 1){//文字广告
			if(!CollectionUtils.isEmpty(pictures)){
				for(Picture picture2 : pictures){
					picture2.setAdvId(id);
					picture2.setTitle(picture.getTitle());
					code=pictureService.addPicture(picture2,advType,request);
				}
			}
		}return code;
	}
	
	/**
	 * 
	 * 
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryAdvertising
	 * @方法描述：查询广告位
	 * @param: 广告位id
	 * @返回值：Advertising
	 * 
	 */
	public Advertising queryAdvertising(Long id)throws Exception{
		
		Advertising advertising =  mapper.selectByPrimaryKey(id);

		//查找该广告位下的图文信息
		Picture picture = null;
		List<Picture> pictures = null;
		if(advertising.getAdvType()==0){
			picture = pictureService.queryByAdvId(id).get(0);
		}else if(advertising.getAdvType()==1){
			pictures = pictureService.queryByAdvId(id);
		}
		advertising.setPicture(picture);
		advertising.setPictures(pictures);
		return advertising;
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： emodifyAdvertising
	 * @方法描述：修改广告位
	 * @param: 广告位对象
	 * @返回值：void
	 * 
	 */
	
	public String modifyAdvertising(Advertising advertising,HttpServletRequest request) throws Exception{
		mapper.updateByPrimaryKey(advertising);
		//修改广告图文信息
		String code=null;//"false"-失败，"ok"-成功
		Long advId = advertising.getAdvId();
		Picture picture = advertising.getPicture();
		List<Picture> pictures = advertising.getPictures();
		
		Integer advType = advertising.getAdvType();
		if(advType == 0){//图片广告
			picture.setAdvId(advId);
			if(picture.getPicId()==null){//说明在修改时是由文字广告切换为图片广告
				//先删除原图文信息中的记录
//				pictureService.removePictureByAdvId(advId, request);
				pictureService.removePictureByAdvId(advId);
				//添加新的图文信息记录
				code=pictureService.addPicture(picture,advType,request);
				
			}else{
				 code = pictureService.modifyPicture(picture,advType,request);
				 
			}
			
		}else if(advType == 1){//文字广告
			//有可能是 图片广告 切换到 文字广告，所以，先去查找有没有图片广告，有的话，将该图文记录删除
			List<Picture> mayPictures = pictureService.queryByAdvId(advId);
			if(!CollectionUtils.isEmpty(mayPictures)){
				for(Picture picture2 : mayPictures){
					if(!StringUtils.isEmpty(picture2.getPicUrl())){//说明是由图片广告切换到的文字广告
//						pictureService.removePictureByAdvId(advId, request);
						pictureService.removePictureByAdvId(advId);
					}
				}
			}
			
			if(!CollectionUtils.isEmpty(pictures)){
				for(Picture picture3 : pictures){
					picture3.setAdvId(advId);
					picture3.setTitle(picture.getTitle());
					if(picture3.getPicId()==null){//新增项  文字广告
						code=pictureService.addPicture(picture3,advType,request);
					}else{
						code=pictureService.modifyPicture(picture3,advType,request);//修改项  文字广告
					}
				}
			}
		}return code;
		
	}

	/**
	 * 
	 * 
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： 	removeAdvertising
	 * @方法描述：删除 广告位
	 * @param: 广告位id
	 * @返回值：void
	 * 
	 */
	
	public void removeAdvertising(Long id) throws Exception{
		mapper.deleteByPrimaryKey(id);
		//删除该广告位下的图/文信息
		pictureService.removePictureByAdvId(id);
	}

	/**
	 * @author： 徐国辉 2015-6-19 下午3:50:41
	 * @方法名： queryAdvertisingOnly
	 * @方法描述：根据广告位id查询 广告位记录,不包含图文信息，用于优化下面排序接口的单条记录查询
	 * @param: id 广告位id
	 * @返回值：Advertising
	 */
	public Advertising queryAdvertisingOnly(Long id)throws Exception {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * @author： 徐国辉 2015-6-26 上午9:24:44
	 * @方法名： modifyAdvOrder
	 * @方法描述：广告位排序
	 * @param: id：广告位id，order 新的排序号
	 * @返回值：void
	 */
	public void modifyAdvOrder(Advertising advertising, Integer order)throws Exception {
		advertising.setAdvOrder(order);
		mapper.updateByPrimaryKey(advertising);
	}



	/**
	 * @author： 徐国辉 2015-7-3 上午10:40:51
	 * @方法名： selectInvalidAdvs
	 * @方法描述：查询已经失效的广告位记录(查询出来的结果集将被定时清理)
	 * 			注：详细功能介绍请见AdvertisingDeleteScheduled类的类级注释
	 * @param:
	 * @返回值：List<Advertising> 无效的广告位集合
	 * 
	 */
	public List<Advertising> selectInvalidAdvs() {
		return mapper.selectInvalidAdvs();
	}

}
