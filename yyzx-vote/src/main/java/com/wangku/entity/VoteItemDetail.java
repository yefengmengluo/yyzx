package com.wangku.entity;

import java.io.Serializable;
/**
 * 
 * @author zsl
 * 2015-6-24上午8:56:14
 * 类描述：品牌detail对应的实体，为了与前端封装好的json对应上而设计
 */
public class VoteItemDetail implements Serializable{

	private static final long serialVersionUID = 374258981394197295L;
		private String vi_brand;//所属品牌
	    private Integer vi_industry;//所属行业
	    private String vi_companyurl;//公司官网
	    private String vi_address;//公司地址
	    private String vi_summary;//公司简介
	    private String vi_logo;//公司logo
	    private String vi_wexin;//微信二维码
	    private String vi_erweima;//二维码
		public String getVi_brand() {
			return vi_brand;
		}
		public void setVi_brand(String vi_brand) {
			this.vi_brand = vi_brand;
		}
		public Integer getVi_industry() {
			return vi_industry;
		}
		public void setVi_industry(Integer vi_industry) {
			this.vi_industry = vi_industry;
		}
		public String getVi_companyurl() {
			return vi_companyurl;
		}
		public void setVi_companyurl(String vi_companyurl) {
			this.vi_companyurl = vi_companyurl;
		}
		public String getVi_address() {
			return vi_address;
		}
		public void setVi_address(String vi_address) {
			this.vi_address = vi_address;
		}
		public String getVi_summary() {
			return vi_summary;
		}
		public void setVi_summary(String vi_summary) {
			this.vi_summary = vi_summary;
		}
		public String getVi_logo() {
			return vi_logo;
		}
		public void setVi_logo(String vi_logo) {
			this.vi_logo = vi_logo;
		}
		public String getVi_wexin() {
			return vi_wexin;
		}
		public void setVi_wexin(String vi_wexin) {
			this.vi_wexin = vi_wexin;
		}
		public String getVi_erweima() {
			return vi_erweima;
		}
		public void setVi_erweima(String vi_erweima) {
			this.vi_erweima = vi_erweima;
		}
		@Override
		public String toString() {
			return "VoteItemDetail [vi_brand=" + vi_brand + ", vi_industry="
					+ vi_industry + ", vi_companyurl=" + vi_companyurl
					+ ", vi_address=" + vi_address + ", vi_summary="
					+ vi_summary + ", vi_logo=" + vi_logo + ", vi_wexin="
					+ vi_wexin + ", vi_erweima=" + vi_erweima + "]";
		}


}
