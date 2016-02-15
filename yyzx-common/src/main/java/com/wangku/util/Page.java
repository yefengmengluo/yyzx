package com.wangku.util;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author 谢虹英
 * 2015-5-26上午9:10:44
 * 类描述：分页类、包含 获取偏移量和最大页数方法的获取
 */

public class Page<T> {
	private Integer currentNum=1;//当前页
	private Integer maxPage;//最大页数
	private Integer pageSize=10  ;//每页条数
	private Integer offsetValue;//偏移量。即sql语句中起查值
	private List<T> pageList=new ArrayList<T>();//存放的对象
	public Integer getCurrentNum() {
		return currentNum;
	}

	public void setCurrentNum(Integer currentNum) {
		this.currentNum = currentNum;
	}

	public Integer getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public Integer getOffsetValue() {
		return offsetValue;
	}

	public void setOffsetValue(Integer offsetValue) {
		this.offsetValue = offsetValue;
	}
	



	@Override
	public String toString() {
		return "Page [currentNum=" + currentNum + ", maxPage=" + maxPage
				+ ", pageSize=" + pageSize + ", offsetValue=" + offsetValue
				+ ", pageList=" + pageList + "]";
	}

	/**
	 * 
	 * @author： 谢虹英  2015-5-26 上午10:02:35
	 * @方法名： setSqlPage
	 * @方法描述： 用于sql语句查询时使用，主要对查询语句偏移量的设置，sql语句中可直接使用：偏移量offsetValue和查询条数pageSize
	 * @使用场合：调分页查询前使用
	 * @param: page对象。主要运用：当前页、每页条数量参数
	 * @返回值：Page
	 *
	 */
	@SuppressWarnings("rawtypes")
	public  void setSqlPage(Page page){
		if(page.getCurrentNum()==null){
			page.setOffsetValue(0);
		}else{
			page.setOffsetValue((page.getCurrentNum()-1)*page.getPageSize());
		}
	}
	/**
	 * 
	 * @author： 谢虹英  2015-5-26 上午10:14:11
	 * @方法名： setMaxPage
	 * @方法描述：获取最大页,
	 * @使用场合：该方法用于返回页面前使用，
	 * @方法描述：  返回的Page中应含有currentNum、pageSize、maxPage等参数值
	 * @param:根据条件不含分页查所有返回的对象集合的长度，和有pageSize参数的page对象；
	 * @返回值：Page
	 *
	 */
	@SuppressWarnings("rawtypes")
	public  void setMaxPage(Integer listsize,Page page){
		if(page!=null&&page.getPageSize()!=null){
			Integer maxPage=(listsize-1)/page.getPageSize()+1;
			page.setMaxPage(maxPage);
		}
	}
}
