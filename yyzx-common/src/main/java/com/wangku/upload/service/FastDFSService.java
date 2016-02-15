/**
 * 
 */
package com.wangku.upload.service;

/**
 * @author 谢虹英
 * 2015年8月25日下午2:53:49
 * 类描述：
 */
public interface FastDFSService {
	/**
	 * 
	 * @author： 谢虹英  2015年8月26日 上午10:07:56
	 * @方法名： uploadImage
	 * @方法描述：上传图片服务器
	 * @param:
	 * @返回值：String图片服务器上存储是图片路径http://img.99114.com/.....
	 *
	 */
	public <T> String uploadImage(T t)throws Exception ;
	
	/**
	 * 
	 * @author： 谢虹英  2015年8月26日 上午10:08:11
	 * @方法名： remove_file
	 * @方法描述：删除图片服务器图片
	 * @param:
	 * @返回值：boolean
	 *
	 */
	
	public boolean remove_file(String group_name,String remote_filename)throws Exception;
}
