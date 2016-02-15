package com.wangku.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author zsl
 * 2015年8月7日上午10:40:38
 * 类描述：用于广告联盟网站显示所封装的实体类
 */
public class LeaguePageShowModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2702469098774139717L;
	
	private String pageWidth;//网站页面的宽度
	private List<LeagueDataModel> dataList;//图片广告集合
	private List<LeagueAdvWord> wordList;//文字广告集合
	public String getPageWidth() {
		return pageWidth;
	}
	public void setPageWidth(String pageWidth) {
		this.pageWidth = pageWidth;
	}
	public List<LeagueDataModel> getDataList() {
		return dataList;
	}
	public void setDataList(List<LeagueDataModel> dataList) {
		this.dataList = dataList;
	}
	public List<LeagueAdvWord> getWordList() {
		return wordList;
	}
	public void setWordList(List<LeagueAdvWord> wordList) {
		this.wordList = wordList;
	}
	@Override
	public String toString() {
		return "LeaguePageShowModel [pageWidth=" + pageWidth + ", dataList="
				+ dataList + ", wordList=" + wordList + "]";
	}
	
}
