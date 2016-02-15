package com.wangku.service;

import java.util.List;

import com.wangku.entity.PrintCount;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;

public interface PrintsCountService {
	void deleteByPrimaryKey(Long supplyId);

	void insert(PrintCount record);
	@DataSource("slave")
    int countBySupplyId();
    @DataSource("slave")
    List<PrintCount> selectByPage(Page<PrintCount> page);
    @DataSource("master")
    PrintCount selectByPrimaryKey(Long supplyId);
    @DataSource("master")
    void updateByPrimaryKey(PrintCount record);

}
