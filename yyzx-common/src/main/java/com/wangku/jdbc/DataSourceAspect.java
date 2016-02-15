/**
 * @author 谢虹英
 * 2015-7-8上午10:42:49
 * 类描述：
 */

package com.wangku.jdbc;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @author 谢虹英
 * 2015-7-8上午10:42:49
 * 类描述：spring配置数据库注解 AOP类
 */
public class DataSourceAspect {
	 public void before(JoinPoint point)
	    {
	        Object target = point.getTarget();
	        String method = point.getSignature().getName();

	        Class<?>[] classz = target.getClass().getInterfaces();

	        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
	                .getMethod().getParameterTypes();
	        try {
	            Method m = classz[0].getMethod(method, parameterTypes);
	            if (m != null && m.isAnnotationPresent(DataSource.class)) {
	                DataSource data = m
	                        .getAnnotation(DataSource.class);
	                String value = data.value();
	                DynamicDataSourceHolder.putDataSource(value);
	                System.out.println(data.value());
	            }
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
}
