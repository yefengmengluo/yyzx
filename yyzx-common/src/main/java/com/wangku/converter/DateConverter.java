package com.wangku.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;




/**
 * 
 * @author 谢虹英
 * 2015-5-13下午2:32:05
 * 类描述：转换类
 */
public class DateConverter implements Converter<String, Date> {
	/**
	 * 
	 * @author： 谢虹英  2015-5-13 下午2:27:58
	 * @方法名： convert
	 * @方法描述：日期转换
	 * @param: 要转换是字符串
	 * @返回值：java.util.Date;
	 *
	 */
	public Date convert(String value) {// 2015-01-05
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
