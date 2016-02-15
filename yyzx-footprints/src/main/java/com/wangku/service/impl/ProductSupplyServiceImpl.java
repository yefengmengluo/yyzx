package com.wangku.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangku.entity.Supply;
import com.wangku.mapper.SupplyMapper;
import com.wangku.service.ProductSupplyService;


/**
 * vote服务实现。
 * 
 */
@Service
public class ProductSupplyServiceImpl implements ProductSupplyService {
	
	@Autowired
	private SupplyMapper mapper;
	
	public List<Supply> queryByPrimaryKey(List<Long> ids){
		StringBuffer str=new StringBuffer();
		if(ids==null){
			return null;
		}
		for(int i=0;i<ids.size();i++){
			if(i>0){
				str.append(",");
			}
			str.append(ids.get(i));
		}
		List<Supply> list=mapper.selectByPrimaryKey(ids,str.toString());
		return list;
	}
	
	
}
