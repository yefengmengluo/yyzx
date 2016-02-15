package com.wangku.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;



/**
 * 广告图片本地存储处理类
 * 
 * @author xuguohui
 * 
 */
public class CreateDirectory {

	/**
	 * @author： 徐国辉 2015-6-23 下午5:37:34
	 * @方法名： createDirectory
	 * @方法描述：在web根路径下的backstage创建一个advImages目录，用于保存广告上传的图片文件
	 * @param: request 请求对象
	 * @返回值：String 创建的目录全路径
	 * 
	 */
	public static String createDirectory(HttpServletRequest request) {
		String path =request.getSession().getServletContext().getRealPath("/");
		path = path + File.separator + "backstage" + File.separator
				+ "advImages" + File.separator;
		File file = new File(path);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			file.mkdir();
		}
		return path;
	}

	/**
	 * @author： 徐国辉 2015-6-24 上午8:50:26
	 * @方法名： getPicUrl
	 * @方法描述：获取图片的uri
	 * @param: 图片名称，如 a.png
	 * @返回值：String 图片的uri
	 * 
	 */

	public static String getPicUrl(String imgName) {
		String picUri = "backstage" + "/" + "advImages" + "/" + imgName;
		return picUri;
	}

	/**
	 * @author： 徐国辉 2015-6-25 上午10:59:56
	 * @方法名： getDirectory
	 * @方法描述：获取文件目录
	 * @param:
	 * @返回值：String
	 * 
	 */
	public static String getDirectory(HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/");
		path = path + File.separator + "backstage" + File.separator
				+ "advImages" + File.separator;
		return path;
	}

	/**
	 * @author： 徐国辉 2015-6-25 上午10:57:33
	 * @方法名： deleteImage
	 * @方法描述：删除文件
	 * @param: imageName 文件名称(包括后缀名),request 请求对象
	 * @返回值：void
	 * 
	 */
	public static void deleteImage(String imageName, HttpServletRequest request) {
		String path = getDirectory(request);
		String fullPath = path + imageName;
		File file = new File(fullPath);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}

	/**
	 * 
	 * 删除文件
	 * @author： 徐国辉 2015-7-3 下午1:58:56
	 * @方法名： deleteImg
	 * @方法描述：删除文件，根据项目路径查找文件并删除，不使用request获取项目路径的方式
	 * 			以方便调度器定时删除无效的广告位及其相关图文信息记录时无法获取request对象
	 * @param:
	 * @返回值：void
	 * 
	 */
	public static void deleteImg(String imageName) {
		String path = System.getProperty("user.dir");
		path = path + File.separator + "WebContent" + File.separator
				+ "backstage" + File.separator + "advImages" + File.separator;
		String fullPath = path + imageName;
		File file = new File(fullPath);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			file.delete();
		}
	}

}
