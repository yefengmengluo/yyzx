package com.wangku.upload.fastdfs.impl;

import java.io.File;
import java.util.UUID;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Repository;

import com.wangku.upload.fastdfs.ITrackerServerPool;

/**
 * @ClassName: SimpleClientImpl
 * @Description: TODO(对DFSjavaAPI的一个封装，加入连接池技术，提高效率)
 */
@Repository("fastDFSClient")
public class FastDFSClientImpl extends AbstractFastDFSClientImpl{
	private ITrackerServerPool pool = null;
	private int waitTime = 3;

	public FastDFSClientImpl(){
		this.pool = LinkedQueueTrackerPool.getPoolInstance();
	}

	public FastDFSClientImpl(int waitTime){
		this.pool = LinkedQueueTrackerPool.getPoolInstance();
		this.waitTime = waitTime;
	}

	//上传本地文件开始----------------------------------------------
	@Override
	public String upload(File file) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(file2Byte(file),
					getFileTypeName(file.getName()), null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	@Override
	public String upload_file(String local_filename, String file_ext_name)
			throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(local_filename,file_ext_name, null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	@Override
	public String upload(File file, NameValuePair... metaList) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			//System.out.println(ts);
			return client1.upload_file1(file2Byte(file),
					getFileTypeName(file.getName()), metaList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	@Override
	public String upload_file(String local_filename, String file_ext_name,
			NameValuePair[] meta_list) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(local_filename,file_ext_name, meta_list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	@Override
	public String upload_file(String group_name, String local_filename,
			String file_ext_name, NameValuePair[] meta_list) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(group_name,local_filename,file_ext_name, meta_list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	//上传本地文件结束----------------------------------------------
	
	
	//上传远程文件开始----------------------------------------------
	@Override
	public String upload_file(byte[] file_buff, String file_ext_name)
			throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(file_buff,file_ext_name,null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	@Override
	public String upload_file(byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(file_buff,file_ext_name,meta_list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	@Override
	public String upload_file(String group_name, byte[] file_buff,
			String file_ext_name, NameValuePair[] meta_list) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(group_name,file_buff,file_ext_name,meta_list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}

	//主从文件方法开始--------------------------------------------------
	@Override
	public String upload_file(String master_filename,
			String prefix_name, byte[] file_buff, String file_ext_name,
			NameValuePair[] meta_list) throws Exception {
		
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(master_filename,prefix_name,file_buff,file_ext_name,meta_list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}
	
	
	@Override
	public String upload_file(String master_filename,
			String prefix_name, String local_filename, String file_ext_name,
			NameValuePair[] meta_list) throws Exception {
		
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			//System.out.println(ts);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.upload_file1(master_filename,prefix_name,local_filename,file_ext_name,meta_list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return null;
	}
	//主从文件方法结束--------------------------------------------------
	

	@Override
	public byte[] download_file(String remote_filename) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.download_file1(remote_filename);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
	}

	@Override
	public File download(String fileName, String localPath) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return this.byte2File(client1.download_file1(fileName), localPath,
					UUID.randomUUID().toString() + "."
							+ getFileTypeName(fileName));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
	}

	@Override
	public int download_file(String remote_filename, String local_filename)
			throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.download_file1(remote_filename, local_filename);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.pool.close(ts);
		}
		return 0;
	}

	@Override
	public boolean delete_file(String group_name,String remote_filename)
			throws Exception {
		boolean result = false;
		TrackerServer ts = null;
		try {
			ts = this.pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			//result = client1.delete_file1(remote_filename) == 0 ? true : false;
			result = client1.delete_file(group_name, remote_filename)== 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
		return result;
	}

	@Override
	public NameValuePair[] getFileMate(String fileName) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.get_metadata1(fileName);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
	}

	@Override
	public int set_metadata(String remote_filename,
			NameValuePair[] meta_list, byte op_flag) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.set_metadata1(remote_filename, meta_list, op_flag);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
	}

	@Override
	public FileInfo get_file_info(String remote_filename)
			throws Exception {
	
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.get_file_info1(remote_filename);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
	}

	@Override
	public FileInfo query_file_info(String remote_filename)
			throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.query_file_info1(remote_filename);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
	}

	@Override
	public String getSourceIpAddr(String remote_filename) throws Exception {
		TrackerServer ts = null;
		try {
			ts = pool.geTrackerServer(waitTime);
			StorageClient1 client1 = new StorageClient1(ts, null);
			return client1.get_file_info1(remote_filename).getSourceIpAddr();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			this.pool.close(ts);
		}
	}

}
