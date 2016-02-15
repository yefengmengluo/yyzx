package com.wangku.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wangku.entity.Picture;
import com.wangku.jdbc.DataSource;

public interface PictureService {

	/**
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： queryByAdvId
	 * @方法描述：根据广告位id查询 广告图/文记录
	 * @param:
	 * @返回值：List<Picture>
	 */
	@DataSource("slave")
	public List<Picture> queryByAdvId(Long advId)throws Exception;

	/**
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： addPicture
	 * @方法描述：添加广告图/文
	 * @param:
	 * @返回值：void
	 */
	@DataSource("master")
	public String addPicture(Picture picture,Integer advType,HttpServletRequest request)throws Exception;

	/**
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： queryPicture
	 * @方法描述：主键查询广告图/文
	 * @param:
	 * @返回值：Picture
	 * 
	 */
	@DataSource("slave")
	public Picture queryPicture(Long id)throws Exception;

	/**
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： emodifyPicture
	 * @方法描述：修改广告图/文
	 * @param:
	 * @返回值：void
	 */
	@DataSource("master")
	public String modifyPicture(Picture picture,Integer advType,HttpServletRequest request)throws Exception;

	/**
	 * @author： 徐国辉  2015-6-19 下午3:50:41
	 * @方法名： 	removePicture
	 * @方法描述：删除 广告图/文
	 * @param:
	 * @返回值：void
	 */
	/*@DataSource("master")
	public void removePicture(Long id)throws Exception;*/
	
	/**
	 * @author： 徐国辉 2015-6-25 下午3:57:09
	 * @方法名： removePictureByAdvId
	 * @方法描述：删除指定广告位下的图文信息
	 * @param: advId 广告位id
	 * @返回值：void
	 */
	@DataSource("master")
	public void removePictureByAdvId(Long advId)throws Exception;
}
