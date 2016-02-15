package com.wangku.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wangku.entity.Company;
import com.wangku.entity.User;
import com.wangku.jdbc.DataSource;
import com.wangku.util.Page;
/**
 * 
 * @author zsl
 * 2015-6-18上午9:45:15
 * 类描述：投票会员服务接口
 */
public interface VoteCompanyService {
	/**
	 * 
	 * @author： zsl  2015-6-18 上午9:43:44
	 * @方法名： getCompanyListByPage
	 * @方法描述：分页查询投票会员列表
	 * @param:
	 * @返回值：List<Company>
	 *
	 */
	@DataSource("slave")
	public Page<Company> queryByPage(String keyWord,int currentNum,User user) throws Exception;
	
	/**
	 * 
	 * @author： zsl  2015-6-18 下午1:37:13
	 * @方法名： deleteCompany
	 * @方法描述：删除投票会员数据
	 * @param: idList：数据id集合
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void removeCompany(List<Long> idList,HttpServletRequest request)throws Exception;
	/**
	 * 
	 * @author： zsl  2015-6-25 上午11:08:46
	 * @方法名： modifyCompanyStatus
	 * @方法描述：信息推荐
	 * @param:
	 * @返回值：void
	 *
	 */
	@DataSource("master")
	public void modifyCompanyStatus(Long voteId,List<Long> idList,int status)throws Exception;
	/**
	 * 
	 * @author： zsl  2015-6-23 上午11:02:37
	 * @方法名： queryById
	 * @方法描述：根据ID查询数据
	 * @param: id:记录ID
	 * @返回值：Company
	 *
	 */
	@DataSource("slave")
	public Company queryById(Long id)throws Exception;
	/**
	 * 
	 * @author： zsl  2015-6-23 上午11:08:21
	 * @方法名： saveCompany
	 * @方法描述：保存会员信息
	 * @param: 会员信息对象
	 * @返回值：String
	 *
	 */
	@DataSource("master")
	public String saveCompany(Company company,HttpServletRequest req,int status)throws Exception;
	/**
	 * 
	 * @author： zsl  2015-6-24 下午1:15:35
	 * @方法名： modifyCompany
	 * @方法描述：修改会员信息
	 * @param:会员信息对象
	 * @返回值：String
	 *
	 */
	@DataSource("master")
	public String modifyCompany(Company company,HttpServletRequest req)throws Exception;
	
}
