package com.wangku.jdbc;  
 import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;    

 /**
  * 
  * @author 谢虹英
  * 2015-7-8上午10:41:43
  * 类描述：动态获取数据源  继承AbstractRoutingDataSource类
  */
 public class DynamicDataSource extends AbstractRoutingDataSource{  
     /*(non-Javadoc) 
      *@see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey() 
      *@author wenc 
      */  
     /* protected Object determineCurrentLookupKey() {  
        // return JdbcContextHolder.getJdbcType();  
    	  return DynamicDataSourceHolder.getDataSouce();
      } */ 
      /* 
       * (non-Javadoc) 
       * @see javax.sql.CommonDataSource#getParentLogger() 
       */  
	/* @Override  
     public Logge getParentLogger() throws SQLFeatureNotSupportedException {  
         // TODO Auto-generated method stub  
         return null;  
     } */ 
    
      /** 
       *  
       * override determineCurrentLookupKey 
       * <p> 
       * Title: determineCurrentLookupKey 
       * </p> 
       * <p> 
       * Description: 自动查找datasource 
       * </p> 
       *  
       * @return 
       */  
      @Override  
      protected Object determineCurrentLookupKey() {  
          return DynamicDataSourceHolder.getDataSouce();  
      }  
    
 } 
