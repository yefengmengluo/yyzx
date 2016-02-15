/**
 * @author 谢虹英
 * 2015-7-8上午10:40:39
 * 类描述：
 */

package com.wangku.jdbc;

/**
 * @author 谢虹英
 * 2015-7-8上午10:40:39
 * 类描述：动态获取数据源线程
 */
public class DynamicDataSourceHolder {
	 public static final ThreadLocal<String> holder = new ThreadLocal<String>();
	 public static String DB_TYPE_RW = "master";  
	    public static String DB_TYPE_R = "slave"; 
	    public static void putDataSource(String name) {
	        holder.set(name);
	    }

	    public static String getDataSouce() {
	    	String db= holder.get();
	    	if (db == null) {  
	            db = DB_TYPE_RW;// 默认是读写库  
	        } 
	        return db;
	    }
	    /** 
	     * clearDBType 
	     *  
	     * @Title: clearDBType 
	     * @Description: 清理连接类型 
	     */  
	    public static void clearDBType() {  
	    	holder.remove();  
	    }  
	 /** 
     * 线程threadlocal 
     */  
 /*   private static ThreadLocal<String> contextHolder = new ThreadLocal<>();  
  
    public static String DB_TYPE_RW = "master";  
    public static String DB_TYPE_R = "slave";  
  
    public static String getDbType() {  
        String db = contextHolder.get();  
        if (db == null) {  
            db = DB_TYPE_RW;// 默认是读写库  
        }  
        return db;  
    }  
  
    *//** 
     *  
     * 设置本线程的dbtype 
     *  
     * @param str 
     * @see [相关类/方法](可选) 
     * @since [产品/模块版本](可选) 
     *//*  
    public  static void setDbType(String str) {  
        contextHolder.set(str);  
    }  
  
    /** 
     * clearDBType 
     *  
     * @Title: clearDBType 
     * @Description: 清理连接类型 
     */  
	    /* public static void clearDBType() {  
        contextHolder.remove();  
    }  */
}  
