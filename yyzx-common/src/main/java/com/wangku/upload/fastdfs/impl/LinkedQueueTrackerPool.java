package com.wangku.upload.fastdfs.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.ProtoCommon;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerGroup;
import org.csource.fastdfs.TrackerServer;

import com.wangku.upload.fastdfs.ITrackerServerPool;
import com.wangku.util.ConfigProperties;


/** 
 * @ClassName: LinkedQueueTrackerPool 
 * @Description: TODO(使用jdk1.5新增的并发库LinkedBlockingQueue实现连接池) 
 */ 

public class LinkedQueueTrackerPool implements ITrackerServerPool{

	private LinkedBlockingQueue<TrackerServer> tspool = null;   
    private int poolSize =3;  
    
    private static LinkedQueueTrackerPool pool = null;
    
    private  LinkedQueueTrackerPool(){  
        initClientGlobal();
        init();  
    }  
    
    public static LinkedQueueTrackerPool getPoolInstance(){
    	if(pool == null){
    		pool = new LinkedQueueTrackerPool();
    	}
    	return pool;
    }
    
	 /** 
	  * @Description: TODO(使用远DFSAPI来保持长连接，轮询，开销小于创建一个新连接) 
	  */  
    private void keepingPool() {  
        Timer timer = new Timer();  
        timer.schedule(new TimerTask() {  
            @Override  
            public void run() {  
                for(TrackerServer ts : tspool){  
                    try {  
                        ProtoCommon.activeTest(ts.getSocket());  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }, 30*1000, 30*1000);  
    }
    
    /** 
     *  
     * @Description: TODO(初始化方法) 
     *  @throws IOException 
     *  @throws InterruptedException  void 
     */  
    private void init(){  
       try {
			this.tspool = new LinkedBlockingQueue<TrackerServer>(this.poolSize);  
	        for(int i=0;i<this.poolSize;i++){  
	            TrackerClient tc = new TrackerClient();  
	            TrackerServer ts = tc.getConnection();  
	            ProtoCommon.activeTest(ts.getSocket());  
	            this.tspool.put(ts);  
	        }  
	        keepingPool(); 
		} catch (Exception e) {
			
		} 
    }  
    
    private void initClientGlobal(){
    	//初始化poolSize
    	String psize = ConfigProperties.getProperties("poolSize");
    	if(psize != null && psize != ""){
    		poolSize = Integer.parseInt(psize);
    	}
    	
    	String ip[] = ConfigProperties.getProperties("tracker_server").split(",");
    	if(ip.length >0 && ip != null){
    		
	    	InetSocketAddress[] trackerServers = new InetSocketAddress[ip.length];
	    	for(int i = 0; i<ip.length; i++){
	    		String tem[] = ip[i].split(":");
	    		trackerServers[i] = new InetSocketAddress(tem[0], Integer.parseInt(tem[1]));   
	    	}
			
			ClientGlobal.setG_tracker_group(new TrackerGroup(trackerServers));    
			// 连接超时的时限，单位为毫秒    
			ClientGlobal.setG_connect_timeout(2000);   
			// 网络超时的时限，单位为毫秒    
			ClientGlobal.setG_network_timeout(30000);   
			ClientGlobal.setG_anti_steal_token(false);   
			// 字符集   
			ClientGlobal.setG_charset("UTF-8");   
			ClientGlobal.setG_secret_key(null);
    	}
    }

    @Override  
    public TrackerServer geTrackerServer() throws Exception {  
        return this.tspool.poll();  
    }  

    @Override  
    public TrackerServer geTrackerServer(long timeout) throws Exception {  
        TrackerServer ts = this.geTrackerServer();  
        if(ts == null){  
            return this.tspool.poll(timeout, TimeUnit.SECONDS);  
        }  
        return ts;  
    }  

    @Override  
    public boolean close(TrackerServer server) throws Exception {  
        if(server != null){  
            this.tspool.put(server);  
            return true;  
        }  
        return false;  
    }  

    @Override  
    public void reset() throws Exception {  
        this.init();  
    }

	@Override
	public void distroy() throws Exception {
		for(TrackerServer server:this.tspool){
			server.close();
		}
		this.tspool = null;
	}  

}
