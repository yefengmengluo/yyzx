package com.wangku.entity;

import org.apache.ibatis.type.Alias;

@Alias("VoteSequence")
public class VoteSequence {
    private String seqName;

    private Long seqCurrentVal;

    private Integer seqIncreFactor;

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName == null ? null : seqName.trim();
    }

    public Long getSeqCurrentVal() {
        return seqCurrentVal;
    }

    public void setSeqCurrentVal(Long seqCurrentVal) {
        this.seqCurrentVal = seqCurrentVal;
    }

    public Integer getSeqIncreFactor() {
        return seqIncreFactor;
    }

    public void setSeqIncreFactor(Integer seqIncreFactor) {
        this.seqIncreFactor = seqIncreFactor;
    }

	/**
	 * @author： 谢虹英  2015-6-18 上午11:12:30
	 * @方法名： toString
	 * @方法描述：
	 * @param:
	 * @返回值：
	 */
	@Override
	public String toString() {
		return "VoteSequence [seqName=" + seqName + ", seqCurrentVal="
				+ seqCurrentVal + ", seqIncreFactor=" + seqIncreFactor + "]";
	}
}