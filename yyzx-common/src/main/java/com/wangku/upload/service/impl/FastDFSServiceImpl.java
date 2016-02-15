/**
 * 
 */
package com.wangku.upload.service.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wangku.upload.fastdfs.impl.FastDFSClientImpl;
import com.wangku.upload.service.FastDFSService;

/**
 * @author 谢虹英
 * 2015年8月25日下午2:54:18
 * 类描述：
 */
@Service
public class FastDFSServiceImpl implements FastDFSService {
	@Autowired
	private FastDFSClientImpl  fastDFSClient;
	/**
	 * 
	 * @author： 谢虹英  2015年8月26日 上午10:07:56
	 * @方法名： uploadImage
	 * @方法描述：上传图片服务器
	 * @param:
	 * @返回值：String图片服务器上存储是图片路径http://img.99114.com/.....
	 *
	 */
	public <T> String uploadImage(T t)throws Exception {
		if(t instanceof String){
			//通过网络上传文件
			String url = (String) t;
			return uploadImage1(url);
		}else if(t instanceof MultipartFile){
			//通过spring的MultipartFile上传文件
			MultipartFile file = (MultipartFile) t;
			return uploadImage2(file);
		}else if(t instanceof FileItem){
			//使用apache的fileupload上传文件
			FileItem item = (FileItem) t;
			//return uploadImage3(item,map);
		}
		System.out.println("没上传到图片服务器！。。。");
		return "false";
	}
private String uploadImage1(String imgUrl)throws Exception{
		
		//map.put("imgSourceUrl", imgUrl);
        String fileName = "";      //文件名
        String fileExt = "";       //文件后缀
        
		//拆分url路径获取 图片名称及后缀
		if(imgUrl.indexOf("/") >= 0)
			fileName = imgUrl.substring(imgUrl.lastIndexOf("/")+1,imgUrl.length());
		else if(imgUrl.indexOf("\\") >= 0)
			fileName = imgUrl.substring(imgUrl.lastIndexOf("\\")+1,imgUrl.length());
		if(imgUrl.indexOf(".") >= 0)
			fileExt = imgUrl.substring(imgUrl.lastIndexOf(".")+1,imgUrl.length()).toLowerCase();

		try{
			URL url = new URL(imgUrl);
			InputStream input = url.openStream();
        
			BufferedImage bis = ImageIO.read(input);  //原始图片
	        int w = bis.getWidth();     //图片原始大小
	        int h = bis.getHeight();  
	        //System.out.println("图片的宽为："+w+" 图片的长为: "+h);
	        
            NameValuePair[] meta_list = new NameValuePair[3];
    		meta_list[0] = new NameValuePair("width", w+"");
    		meta_list[1] = new NameValuePair("heigth", h+"");
    		meta_list[2] = new NameValuePair("type", fileExt);
	        
    		url = new URL(imgUrl);
    		input = url.openStream();
    		ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
			byte[] buff = new byte[9024];
			//从指定 url下载图片
			while(true) {
				int readed = input.read(buff);
				if(readed == -1) {
					break;
				}
				byte[] temp = new byte[readed];
				System.arraycopy(buff, 0, temp, 0, readed);
				out.write(temp);
			}
    		
    		
    		
            /*int ch;
            byte[] b = new byte[9024];
			while((ch = input.read(b)) != -1){	
				out.write(b, 0, ch);
			}*/
			
            /*while ((ch = input.read()) != -1) {
                 out.write(ch);
            }*/
            byte [] result = out.toByteArray();
    		
        	//FastDFSClientImpl client = new FastDFSClientImpl();
        	
        	//上传成功返回的文件名包含文件路径
        	String filePath = "http://img.99114.com/"+fastDFSClient.upload_file(result, fileExt,meta_list);
        	System.out.println("返回的图片路径："+filePath);
        	if(filePath == null){
        		return "false";
        	}
        /*	if(null !=map){
        		map.put("imgHeight", h+"");
	        	map.put("imgWidth", w+"");
	        	map.put("imgSize", (int)result.length+"");
	        	
	        	String imgName = fileName.substring(0, fileName.lastIndexOf("."));
	        	map.put("imgName", imgName);
	        	map.put("imgType", fileExt);
	        	map.put("originalName", fileName);
	        	map.put("imgPath", "/"+filePath);
        	}*/
        	
        	/*imgImage.setImgHeight(h);
	        imgImage.setImgWidth(w);
	        imgImage.setImgSize((int)result.length);
        	imgImage.setImgPath(filePath);
        	imgImage.setImgName(imgName);
        	imgImage.setImgType(fileExt);
        	imgImage.setOriginalName(fileName);*/
        } catch (Exception e) {
			e.printStackTrace();
			//LogMgr.writeDebugLog(msg + " : " + e.getMessage());
			return "false";
		}
		
		return "true";
	}
	public String uploadImage2(MultipartFile file)throws Exception{
		String filePath = "";  //上传成功返回的文件名包含文件路径
        if(null == file){
           return "false";
        }
      //  map.put("imgSourceUrl", "");
        
        //文件名
        String fileName = file.getOriginalFilename();
        //文件后缀
        String fileExt = fileName.substring(fileName.lastIndexOf(".")+1)
                .toLowerCase();
        
        try {
        	
        	InputStream input = file.getInputStream();
			BufferedImage bis = ImageIO.read(input);  //原始图片
	        int w = bis.getWidth();     //图片原始大小
	        int h = bis.getHeight();  
	        //System.out.println("图片的宽为："+w+" 图片的长为: "+h);
	        
            NameValuePair[] meta_list = new NameValuePair[3];
    		meta_list[0] = new NameValuePair("width", w+"");
    		meta_list[1] = new NameValuePair("heigth", h+"");
    		meta_list[2] = new NameValuePair("type", fileExt);
	        
        	//FastDFSClientImpl client = new FastDFSClientImpl();
        	filePath = fastDFSClient.upload_file(file.getBytes(), fileExt,meta_list);
        	
        	//System.out.println("filePath:"+filePath);
        	
        	if(filePath == null){
        		return "false";
        	}else{
        		filePath = "http://img.99114.com/"+filePath;
        	}return filePath;
        	/*if(null !=map){
        		map.put("imgHeight", h+"");
	        	map.put("imgWidth", w+"");
	        	map.put("imgSize", (int)file.getSize()+"");
	        	
	        	String imgName = fileName.substring(0, fileName.lastIndexOf("."));
	        	map.put("imgName", imgName);
	        	map.put("imgType", fileExt);
	        	map.put("originalName", fileName);
	        	map.put("imgPath", "/"+filePath);
        	}*/
        	
        } catch (Exception e) {
			String msg = "上传图片出错!";
			//LogMgr.writeDebugLog(msg + " : " + e.getMessage());
			e.printStackTrace();
			return "false";
		}
		
	}
	/**
	 * 
	 * @author： 谢虹英  2015年8月26日 上午10:08:11
	 * @方法名： remove_file
	 * @方法描述：删除图片服务器图片
	 * @param:
	 * @throws Exception 
	 * @返回值：boolean
	 *
	 */
	
	public boolean remove_file(String group_name,String remote_filename) throws Exception{
		
		return fastDFSClient.delete_file(group_name, remote_filename);
	}
	
}
