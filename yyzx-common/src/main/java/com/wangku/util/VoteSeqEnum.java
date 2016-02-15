package com.wangku.util;

/**
 * 运营后台系统枚举类
 * 
 * @author徐国辉
 * @version 2015-6-19
 */
public interface VoteSeqEnum {

	/**
	 * 
	 * @author zsl 2015-7-8下午4:59:39 类描述：投票系统表名枚举
	 */
	public enum VOTE_SYSTEM_SEQ implements VoteSeqEnum {

		VOTE_ADVERTISING("seq_vote_advertising"), // 投票广告位表
		VOTE_COMMENT("seq_vote_comment"), // 投票评论表
		VOTE_COMPANY("seq_vote_company"), // 投票会员表
		VOTE_ITEM_TABLE("seq_vote_item_table"), // 投票品牌表
		VOTE_PICTURE("seq_vote_picture"), // 投票广告图/文库表
		VOTE_RESULT_TABLE("seq_vote_result_table"), // 投票结果表
		VOTE_TABLE("seq_vote_table"), // 投票主题表
		VOTE_USER("seq_vote_user");// 投票管理员表
		private String value;

		VOTE_SYSTEM_SEQ(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 
	 * @author zsl 2015年7月23日下午5:28:09 类描述：广告联盟系统表名枚举--用于ID的生成
	 */
	public enum LEAGUE_SYS_SEQ implements VoteSeqEnum {

		ADV_PARAM("seq_league_pram"), // 广告联盟参数表
		ADV_SIZE("seq_league_size"), // 广告联盟尺寸表
		ADV_POSITION("seq_league_adv_position"), // 广告联盟-广告位基本信息表
		ADV_INFO("seq_league_adv_info"), // 广告联盟-广告位扩展信息表
		ADV_WORD("seq_league_adv_word"), ADV_TRAFFIC("seq_league_ad_traffic_tab"), // 广告联盟-广告流量表
		ADV_WEBSITE("seq_league_website_tab"), // 广告联盟-行业单品维护表

		LEAGUE_ADV_IMG("league_adv_img");// 广告联盟图片广告命名前缀

		private String value;

		LEAGUE_SYS_SEQ(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 
	 * @author zsl 2015-7-8下午5:09:02 类描述：留言表枚举
	 */
	public enum LIU_YAN_SEQ implements VoteSeqEnum {

		SPECIAL_LIUYAN("seq_special_liuyan"); // 留言表

		private String value;

		LIU_YAN_SEQ(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 
	 * @author 徐国辉
	 * @version 2015年11月6日 类描述：支付信息表枚举
	 */
	public enum PAYMENT_SEQ implements VoteSeqEnum {

		PAYMENT("seq_payment"); // 支付信息表

		private String value;

		PAYMENT_SEQ(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 
	 * @author zsl 2015-7-8下午5:09:02 类描述：权限枚举
	 */
	public enum UPOWER implements VoteSeqEnum {

		ALLPOWER(0), // 超级管理员

		YUNYING_POWER(1), // 运营管理员

		VOTE_POWER(21), // 投票权限

		LEAGUES_POWER(22), // 广告联盟权限

		LIUYAN_POWER(23);// 留言权限

		private Integer value;

		UPOWER(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

	/**
	 * 
	 * @author zsl 2015-7-8下午5:09:02 类描述：权限枚举
	 */
	public enum footprints implements VoteSeqEnum {

		FOOTPRINTS("seq_tbl_footprints"), // 足迹记录表

		PRINTSCOUNT("seq_tbl_prints_count"); // 基地管理员

		private String value;

		footprints(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 
	 * @author zsl 2015年7月23日下午5:28:09 类描述：参数表类型枚举
	 */
	public enum LEAGUE_PARAM_TYPE implements VoteSeqEnum {

		INDUSTRY_TYPE(0), // 行业类型标识
		ADV_TYPE(1);// 广告位类型标识

		private Integer value;

		LEAGUE_PARAM_TYPE(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}

	/**
	 * @author 徐国辉
	 * @version 2015年11月6日 说明：支付状态枚举类
	 */
	public enum PAY_STATUS implements VoteSeqEnum {

		WAIT("wait"), // 待支付
		SUCCESS("success"), // 支付成功
		FAIL("fail"), // 支付失败
		CLOSE("close");// 交易关闭

		private String value;

		PAY_STATUS(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

}
