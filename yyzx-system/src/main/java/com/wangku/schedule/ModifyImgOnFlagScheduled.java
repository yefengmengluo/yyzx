package com.wangku.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wangku.service.LeagueAdvInfoService;

/**
 * 用于轮询广告联盟-图片广告的启用状态，根据发布时间、结束时间、当前时间进行状态的定时修改
 * @author xuguohui
 * @version 2015-8-7
 * 
 */

@Component
public class ModifyImgOnFlagScheduled {

	@Autowired
	private LeagueAdvInfoService leagueAdvInfoService;

	//设置自动修改状态的时间为每天的零点2秒
	@Scheduled(cron = "2 0 0 * * ?")
	public void updateOnFlag() {
		try {
			leagueAdvInfoService.modifyOnFlag();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
