/**
 * @author 谢虹英
 * 2015-7-8上午11:03:45
 * 类描述：
 */

package com.wangku.jdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 谢虹英
 * 2015-7-8上午11:03:45
 * 类描述：自定义注解：DataSource("master/slave")
 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface DataSource {
	    String value();
	}
