package com.wangku.service;

import java.util.List;

import com.wangku.entity.Supply;
import com.wangku.jdbc.DataSource;

public interface ProductSupplyService {
	@DataSource("slaveWkSysBus")
	public List<Supply> queryByPrimaryKey(List<Long> ids);
	
}
