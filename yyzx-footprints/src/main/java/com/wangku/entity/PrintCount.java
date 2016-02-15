package com.wangku.entity;

import org.apache.ibatis.type.Alias;

@Alias(value="PrintCount")
public class PrintCount {
    private Long supplyId;
    
    private Long countId;

    private Integer count;

    
    public Long getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(Long supplyId) {
        this.supplyId = supplyId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

	/**
	 * @author： 谢虹英  2015-7-14 上午9:42:45
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 */
	@Override
	public String toString() {
		return "PrintCount [supplyId=" + supplyId + ", count=" + count + "]";
	}

	public Long getCountId() {
		return countId;
	}

	public void setCountId(Long countId) {
		this.countId = countId;
	}
    
}