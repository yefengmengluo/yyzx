package com.wangku.upload.fastdfs;

import org.csource.fastdfs.TrackerServer;


/** 
 * @ClassName: ITrackerServerPool 
 * @Description: TODO(连接池的基本接口) 
 */  
public interface ITrackerServerPool {
	
	public TrackerServer geTrackerServer() throws Exception;
	
    public TrackerServer geTrackerServer(long timeout) throws Exception; 
    
    public boolean close(TrackerServer server) throws Exception;  
    
    public void reset() throws Exception; 
    
    public void distroy() throws Exception;

}
