package com.wangku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wangku.entity.FootPrints;

public interface FootPrintsMapper {
    int countByExample(FootPrints footPrint);

    int deleteByPrimaryId(long id);

    int insert(FootPrints record);

    List<FootPrints> selectByExample(@Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize,@Param("footPrint") FootPrints footPrint);

    /**
     * 
     * @author： 谢虹英  2015-7-15 下午1:51:21
     * @方法名： updateCount
     * @方法描述：若此supplyId与memberId/Ip此记录已存在，则count+1
     * @param:FootPrints对象
     * @返回值：int
     *
     */
    int updateCount(FootPrints record);
}