package com.wangku.service;

import java.util.List;

import com.wangku.entity.FootPrints;
import com.wangku.jdbc.DataSource;

public interface FootprintsService {
	@DataSource("master")
	public List<Long> queryByKey(FootPrints footPrint,int offset,int pageSize);
	@DataSource("master")
	public void addFootprints(FootPrints footprints);
	/*@DataSource("master")
	public void modifyFootprints(FootPrints footprints);*/
	@DataSource("master")
	public void removeFootprints(long id);
	@DataSource("master")
	public int countByExample(FootPrints footprints);
	

}
