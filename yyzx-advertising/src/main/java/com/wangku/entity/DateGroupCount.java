package com.wangku.entity;
/**
 * 
 * @author zsl
 * 2015年9月24日上午10:19:03
 * 类描述：日期分组查询流量统计model，辅助走势图
 */
public class DateGroupCount {
	private String dateStr;//日期字符串
	private Integer num;//指定日期下的流量
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
