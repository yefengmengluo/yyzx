package com.wangku.upload.fastdfs;

import java.io.File;
import java.io.IOException;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.FileInfo;

public interface IFastDFSClient {
	
	//本地文件上传
	public String upload(File file) throws Exception;
	
	public String upload_file(String local_filename, String file_ext_name) throws Exception;
	
    public String upload(File file,NameValuePair... metaList) throws Exception; 
    
	public String upload_file(String local_filename, String file_ext_name, 
		       NameValuePair[] meta_list) throws Exception;

	public String upload_file(String group_name, String local_filename, String file_ext_name, 
		       NameValuePair[] meta_list) throws Exception;


	//远程文件上传
	public String upload_file(byte[] file_buff, String file_ext_name) throws Exception;
	
	public String upload_file(byte[] file_buff, String file_ext_name, 
		       NameValuePair[] meta_list) throws Exception;

	public String upload_file(String group_name, byte[] file_buff,	
		       String file_ext_name, NameValuePair[] meta_list) throws Exception;

	
	
	public String upload_file(String master_filename, String prefix_name, 
		       byte[] file_buff, String file_ext_name, NameValuePair[] meta_list) throws Exception ;

	
	public String upload_file(String master_filename,
			String prefix_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list) throws Exception;
	
	public byte[] download_file(String remote_filename) throws Exception;

    public File download(String fileName,String localPath) throws Exception;
	
	public int download_file(String remote_filename, 
		                  String local_filename) throws Exception;

	public boolean delete_file(String group_name,String remote_filename) throws Exception;

	public NameValuePair[] getFileMate(String fileName) throws Exception;
	
	public int set_metadata(String remote_filename, 
								NameValuePair[] meta_list, byte op_flag) throws Exception;

	public FileInfo get_file_info(String remote_filename) throws Exception;

	public FileInfo query_file_info(String remote_filename) throws Exception;
	
	public String getSourceIpAddr(String remote_filename)throws Exception;

}
