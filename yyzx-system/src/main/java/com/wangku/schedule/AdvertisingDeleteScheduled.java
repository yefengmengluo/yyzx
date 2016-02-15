package com.wangku.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.wangku.entity.Advertising;
import com.wangku.service.AdvertisingService;

/**
 * 此类用于定时清理数据表中无效的广告位表及其相关的图文信息记录和文件目录中相关的图片
 * 
 * 说明：删除主题时，为提高用户响应时间，未级联删除主题关联的广告位和图文信息记录 使用这个类，用于闲时清理无效数据
 * 
 * @author xuguohui
 * @version 2015-7-3
 * 
 */

@Component
public class AdvertisingDeleteScheduled {

	@Autowired
	private AdvertisingService advertisingService;

	//设置自动清理时间为每天的零点
	@Scheduled(cron = "0 0 0 * * ?")
	public void deleteAdv() {
		List<Advertising> advertisings;
		try {
			advertisings = advertisingService.selectInvalidAdvs();
		
		if (!CollectionUtils.isEmpty(advertisings)) {
			for (Advertising advertising : advertisings) {
				advertisingService.removeAdvertising(advertising.getAdvId());
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
