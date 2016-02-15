package com.wangku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberBasicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberBasicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andCorporationNameIsNull() {
            addCriterion("corporation_name is null");
            return (Criteria) this;
        }

        public Criteria andCorporationNameIsNotNull() {
            addCriterion("corporation_name is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationNameEqualTo(String value) {
            addCriterion("corporation_name =", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameNotEqualTo(String value) {
            addCriterion("corporation_name <>", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameGreaterThan(String value) {
            addCriterion("corporation_name >", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameGreaterThanOrEqualTo(String value) {
            addCriterion("corporation_name >=", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameLessThan(String value) {
            addCriterion("corporation_name <", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameLessThanOrEqualTo(String value) {
            addCriterion("corporation_name <=", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameLike(String value) {
            addCriterion("corporation_name like", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameNotLike(String value) {
            addCriterion("corporation_name not like", value, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameIn(List<String> values) {
            addCriterion("corporation_name in", values, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameNotIn(List<String> values) {
            addCriterion("corporation_name not in", values, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameBetween(String value1, String value2) {
            addCriterion("corporation_name between", value1, value2, "corporationName");
            return (Criteria) this;
        }

        public Criteria andCorporationNameNotBetween(String value1, String value2) {
            addCriterion("corporation_name not between", value1, value2, "corporationName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNull() {
            addCriterion("site_id is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("site_id is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(Integer value) {
            addCriterion("site_id =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(Integer value) {
            addCriterion("site_id <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(Integer value) {
            addCriterion("site_id >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("site_id >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(Integer value) {
            addCriterion("site_id <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("site_id <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<Integer> values) {
            addCriterion("site_id in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<Integer> values) {
            addCriterion("site_id not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(Integer value1, Integer value2) {
            addCriterion("site_id between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("site_id not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNull() {
            addCriterion("modify_time is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIsNotNull() {
            addCriterion("modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeEqualTo(Date value) {
            addCriterion("modify_time =", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotEqualTo(Date value) {
            addCriterion("modify_time <>", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThan(Date value) {
            addCriterion("modify_time >", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time >=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThan(Date value) {
            addCriterion("modify_time <", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("modify_time <=", value, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeIn(List<Date> values) {
            addCriterion("modify_time in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotIn(List<Date> values) {
            addCriterion("modify_time not in", values, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeBetween(Date value1, Date value2) {
            addCriterion("modify_time between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("modify_time not between", value1, value2, "modifyTime");
            return (Criteria) this;
        }

        public Criteria andLogoIsNull() {
            addCriterion("logo is null");
            return (Criteria) this;
        }

        public Criteria andLogoIsNotNull() {
            addCriterion("logo is not null");
            return (Criteria) this;
        }

        public Criteria andLogoEqualTo(String value) {
            addCriterion("logo =", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotEqualTo(String value) {
            addCriterion("logo <>", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThan(String value) {
            addCriterion("logo >", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoGreaterThanOrEqualTo(String value) {
            addCriterion("logo >=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThan(String value) {
            addCriterion("logo <", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLessThanOrEqualTo(String value) {
            addCriterion("logo <=", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoLike(String value) {
            addCriterion("logo like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotLike(String value) {
            addCriterion("logo not like", value, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoIn(List<String> values) {
            addCriterion("logo in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotIn(List<String> values) {
            addCriterion("logo not in", values, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoBetween(String value1, String value2) {
            addCriterion("logo between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andLogoNotBetween(String value1, String value2) {
            addCriterion("logo not between", value1, value2, "logo");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("fax is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("fax is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("fax =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("fax <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("fax >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("fax >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("fax <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("fax <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("fax like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("fax not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("fax in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("fax not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("fax between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("fax not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andEnrollIdIsNull() {
            addCriterion("enroll_id is null");
            return (Criteria) this;
        }

        public Criteria andEnrollIdIsNotNull() {
            addCriterion("enroll_id is not null");
            return (Criteria) this;
        }

        public Criteria andEnrollIdEqualTo(String value) {
            addCriterion("enroll_id =", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotEqualTo(String value) {
            addCriterion("enroll_id <>", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdGreaterThan(String value) {
            addCriterion("enroll_id >", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdGreaterThanOrEqualTo(String value) {
            addCriterion("enroll_id >=", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdLessThan(String value) {
            addCriterion("enroll_id <", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdLessThanOrEqualTo(String value) {
            addCriterion("enroll_id <=", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdLike(String value) {
            addCriterion("enroll_id like", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotLike(String value) {
            addCriterion("enroll_id not like", value, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdIn(List<String> values) {
            addCriterion("enroll_id in", values, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotIn(List<String> values) {
            addCriterion("enroll_id not in", values, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdBetween(String value1, String value2) {
            addCriterion("enroll_id between", value1, value2, "enrollId");
            return (Criteria) this;
        }

        public Criteria andEnrollIdNotBetween(String value1, String value2) {
            addCriterion("enroll_id not between", value1, value2, "enrollId");
            return (Criteria) this;
        }

        public Criteria andDealInIdIsNull() {
            addCriterion("deal_in_id is null");
            return (Criteria) this;
        }

        public Criteria andDealInIdIsNotNull() {
            addCriterion("deal_in_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealInIdEqualTo(String value) {
            addCriterion("deal_in_id =", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdNotEqualTo(String value) {
            addCriterion("deal_in_id <>", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdGreaterThan(String value) {
            addCriterion("deal_in_id >", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdGreaterThanOrEqualTo(String value) {
            addCriterion("deal_in_id >=", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdLessThan(String value) {
            addCriterion("deal_in_id <", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdLessThanOrEqualTo(String value) {
            addCriterion("deal_in_id <=", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdLike(String value) {
            addCriterion("deal_in_id like", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdNotLike(String value) {
            addCriterion("deal_in_id not like", value, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdIn(List<String> values) {
            addCriterion("deal_in_id in", values, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdNotIn(List<String> values) {
            addCriterion("deal_in_id not in", values, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdBetween(String value1, String value2) {
            addCriterion("deal_in_id between", value1, value2, "dealInId");
            return (Criteria) this;
        }

        public Criteria andDealInIdNotBetween(String value1, String value2) {
            addCriterion("deal_in_id not between", value1, value2, "dealInId");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNull() {
            addCriterion("category_code is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNotNull() {
            addCriterion("category_code is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeEqualTo(String value) {
            addCriterion("category_code =", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotEqualTo(String value) {
            addCriterion("category_code <>", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThan(String value) {
            addCriterion("category_code >", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("category_code >=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThan(String value) {
            addCriterion("category_code <", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("category_code <=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLike(String value) {
            addCriterion("category_code like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotLike(String value) {
            addCriterion("category_code not like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIn(List<String> values) {
            addCriterion("category_code in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotIn(List<String> values) {
            addCriterion("category_code not in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeBetween(String value1, String value2) {
            addCriterion("category_code between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("category_code not between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("summary is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("summary is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("summary =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("summary <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("summary >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("summary >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("summary <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("summary <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("summary like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("summary not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(List<String> values) {
            addCriterion("summary in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(List<String> values) {
            addCriterion("summary not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("summary between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("summary not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNull() {
            addCriterion("picture_url is null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIsNotNull() {
            addCriterion("picture_url is not null");
            return (Criteria) this;
        }

        public Criteria andPictureUrlEqualTo(String value) {
            addCriterion("picture_url =", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotEqualTo(String value) {
            addCriterion("picture_url <>", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThan(String value) {
            addCriterion("picture_url >", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlGreaterThanOrEqualTo(String value) {
            addCriterion("picture_url >=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThan(String value) {
            addCriterion("picture_url <", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLessThanOrEqualTo(String value) {
            addCriterion("picture_url <=", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlLike(String value) {
            addCriterion("picture_url like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotLike(String value) {
            addCriterion("picture_url not like", value, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlIn(List<String> values) {
            addCriterion("picture_url in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotIn(List<String> values) {
            addCriterion("picture_url not in", values, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlBetween(String value1, String value2) {
            addCriterion("picture_url between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andPictureUrlNotBetween(String value1, String value2) {
            addCriterion("picture_url not between", value1, value2, "pictureUrl");
            return (Criteria) this;
        }

        public Criteria andRegNumberIsNull() {
            addCriterion("reg_number is null");
            return (Criteria) this;
        }

        public Criteria andRegNumberIsNotNull() {
            addCriterion("reg_number is not null");
            return (Criteria) this;
        }

        public Criteria andRegNumberEqualTo(String value) {
            addCriterion("reg_number =", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberNotEqualTo(String value) {
            addCriterion("reg_number <>", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberGreaterThan(String value) {
            addCriterion("reg_number >", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberGreaterThanOrEqualTo(String value) {
            addCriterion("reg_number >=", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberLessThan(String value) {
            addCriterion("reg_number <", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberLessThanOrEqualTo(String value) {
            addCriterion("reg_number <=", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberLike(String value) {
            addCriterion("reg_number like", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberNotLike(String value) {
            addCriterion("reg_number not like", value, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberIn(List<String> values) {
            addCriterion("reg_number in", values, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberNotIn(List<String> values) {
            addCriterion("reg_number not in", values, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberBetween(String value1, String value2) {
            addCriterion("reg_number between", value1, value2, "regNumber");
            return (Criteria) this;
        }

        public Criteria andRegNumberNotBetween(String value1, String value2) {
            addCriterion("reg_number not between", value1, value2, "regNumber");
            return (Criteria) this;
        }

        public Criteria andHelpIdIsNull() {
            addCriterion("help_id is null");
            return (Criteria) this;
        }

        public Criteria andHelpIdIsNotNull() {
            addCriterion("help_id is not null");
            return (Criteria) this;
        }

        public Criteria andHelpIdEqualTo(String value) {
            addCriterion("help_id =", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdNotEqualTo(String value) {
            addCriterion("help_id <>", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdGreaterThan(String value) {
            addCriterion("help_id >", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdGreaterThanOrEqualTo(String value) {
            addCriterion("help_id >=", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdLessThan(String value) {
            addCriterion("help_id <", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdLessThanOrEqualTo(String value) {
            addCriterion("help_id <=", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdLike(String value) {
            addCriterion("help_id like", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdNotLike(String value) {
            addCriterion("help_id not like", value, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdIn(List<String> values) {
            addCriterion("help_id in", values, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdNotIn(List<String> values) {
            addCriterion("help_id not in", values, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdBetween(String value1, String value2) {
            addCriterion("help_id between", value1, value2, "helpId");
            return (Criteria) this;
        }

        public Criteria andHelpIdNotBetween(String value1, String value2) {
            addCriterion("help_id not between", value1, value2, "helpId");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNull() {
            addCriterion("en_name is null");
            return (Criteria) this;
        }

        public Criteria andEnNameIsNotNull() {
            addCriterion("en_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnNameEqualTo(String value) {
            addCriterion("en_name =", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotEqualTo(String value) {
            addCriterion("en_name <>", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThan(String value) {
            addCriterion("en_name >", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameGreaterThanOrEqualTo(String value) {
            addCriterion("en_name >=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThan(String value) {
            addCriterion("en_name <", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLessThanOrEqualTo(String value) {
            addCriterion("en_name <=", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameLike(String value) {
            addCriterion("en_name like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotLike(String value) {
            addCriterion("en_name not like", value, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameIn(List<String> values) {
            addCriterion("en_name in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotIn(List<String> values) {
            addCriterion("en_name not in", values, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameBetween(String value1, String value2) {
            addCriterion("en_name between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andEnNameNotBetween(String value1, String value2) {
            addCriterion("en_name not between", value1, value2, "enName");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberIsNull() {
            addCriterion("accredit_number is null");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberIsNotNull() {
            addCriterion("accredit_number is not null");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberEqualTo(String value) {
            addCriterion("accredit_number =", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberNotEqualTo(String value) {
            addCriterion("accredit_number <>", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberGreaterThan(String value) {
            addCriterion("accredit_number >", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberGreaterThanOrEqualTo(String value) {
            addCriterion("accredit_number >=", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberLessThan(String value) {
            addCriterion("accredit_number <", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberLessThanOrEqualTo(String value) {
            addCriterion("accredit_number <=", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberLike(String value) {
            addCriterion("accredit_number like", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberNotLike(String value) {
            addCriterion("accredit_number not like", value, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberIn(List<String> values) {
            addCriterion("accredit_number in", values, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberNotIn(List<String> values) {
            addCriterion("accredit_number not in", values, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberBetween(String value1, String value2) {
            addCriterion("accredit_number between", value1, value2, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andAccreditNumberNotBetween(String value1, String value2) {
            addCriterion("accredit_number not between", value1, value2, "accreditNumber");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIcpIsNull() {
            addCriterion("icp is null");
            return (Criteria) this;
        }

        public Criteria andIcpIsNotNull() {
            addCriterion("icp is not null");
            return (Criteria) this;
        }

        public Criteria andIcpEqualTo(String value) {
            addCriterion("icp =", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpNotEqualTo(String value) {
            addCriterion("icp <>", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpGreaterThan(String value) {
            addCriterion("icp >", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpGreaterThanOrEqualTo(String value) {
            addCriterion("icp >=", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpLessThan(String value) {
            addCriterion("icp <", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpLessThanOrEqualTo(String value) {
            addCriterion("icp <=", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpLike(String value) {
            addCriterion("icp like", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpNotLike(String value) {
            addCriterion("icp not like", value, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpIn(List<String> values) {
            addCriterion("icp in", values, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpNotIn(List<String> values) {
            addCriterion("icp not in", values, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpBetween(String value1, String value2) {
            addCriterion("icp between", value1, value2, "icp");
            return (Criteria) this;
        }

        public Criteria andIcpNotBetween(String value1, String value2) {
            addCriterion("icp not between", value1, value2, "icp");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonIsNull() {
            addCriterion("artificial_person is null");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonIsNotNull() {
            addCriterion("artificial_person is not null");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonEqualTo(String value) {
            addCriterion("artificial_person =", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonNotEqualTo(String value) {
            addCriterion("artificial_person <>", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonGreaterThan(String value) {
            addCriterion("artificial_person >", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonGreaterThanOrEqualTo(String value) {
            addCriterion("artificial_person >=", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonLessThan(String value) {
            addCriterion("artificial_person <", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonLessThanOrEqualTo(String value) {
            addCriterion("artificial_person <=", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonLike(String value) {
            addCriterion("artificial_person like", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonNotLike(String value) {
            addCriterion("artificial_person not like", value, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonIn(List<String> values) {
            addCriterion("artificial_person in", values, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonNotIn(List<String> values) {
            addCriterion("artificial_person not in", values, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonBetween(String value1, String value2) {
            addCriterion("artificial_person between", value1, value2, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andArtificialPersonNotBetween(String value1, String value2) {
            addCriterion("artificial_person not between", value1, value2, "artificialPerson");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlIsNull() {
            addCriterion("traffic_url is null");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlIsNotNull() {
            addCriterion("traffic_url is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlEqualTo(String value) {
            addCriterion("traffic_url =", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlNotEqualTo(String value) {
            addCriterion("traffic_url <>", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlGreaterThan(String value) {
            addCriterion("traffic_url >", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlGreaterThanOrEqualTo(String value) {
            addCriterion("traffic_url >=", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlLessThan(String value) {
            addCriterion("traffic_url <", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlLessThanOrEqualTo(String value) {
            addCriterion("traffic_url <=", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlLike(String value) {
            addCriterion("traffic_url like", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlNotLike(String value) {
            addCriterion("traffic_url not like", value, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlIn(List<String> values) {
            addCriterion("traffic_url in", values, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlNotIn(List<String> values) {
            addCriterion("traffic_url not in", values, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlBetween(String value1, String value2) {
            addCriterion("traffic_url between", value1, value2, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficUrlNotBetween(String value1, String value2) {
            addCriterion("traffic_url not between", value1, value2, "trafficUrl");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoIsNull() {
            addCriterion("traffic_Info is null");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoIsNotNull() {
            addCriterion("traffic_Info is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoEqualTo(String value) {
            addCriterion("traffic_Info =", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotEqualTo(String value) {
            addCriterion("traffic_Info <>", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoGreaterThan(String value) {
            addCriterion("traffic_Info >", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoGreaterThanOrEqualTo(String value) {
            addCriterion("traffic_Info >=", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoLessThan(String value) {
            addCriterion("traffic_Info <", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoLessThanOrEqualTo(String value) {
            addCriterion("traffic_Info <=", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoLike(String value) {
            addCriterion("traffic_Info like", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotLike(String value) {
            addCriterion("traffic_Info not like", value, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoIn(List<String> values) {
            addCriterion("traffic_Info in", values, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotIn(List<String> values) {
            addCriterion("traffic_Info not in", values, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoBetween(String value1, String value2) {
            addCriterion("traffic_Info between", value1, value2, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andTrafficInfoNotBetween(String value1, String value2) {
            addCriterion("traffic_Info not between", value1, value2, "trafficInfo");
            return (Criteria) this;
        }

        public Criteria andDealInAddressIsNull() {
            addCriterion("deal_in_address is null");
            return (Criteria) this;
        }

        public Criteria andDealInAddressIsNotNull() {
            addCriterion("deal_in_address is not null");
            return (Criteria) this;
        }

        public Criteria andDealInAddressEqualTo(String value) {
            addCriterion("deal_in_address =", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressNotEqualTo(String value) {
            addCriterion("deal_in_address <>", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressGreaterThan(String value) {
            addCriterion("deal_in_address >", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressGreaterThanOrEqualTo(String value) {
            addCriterion("deal_in_address >=", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressLessThan(String value) {
            addCriterion("deal_in_address <", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressLessThanOrEqualTo(String value) {
            addCriterion("deal_in_address <=", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressLike(String value) {
            addCriterion("deal_in_address like", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressNotLike(String value) {
            addCriterion("deal_in_address not like", value, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressIn(List<String> values) {
            addCriterion("deal_in_address in", values, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressNotIn(List<String> values) {
            addCriterion("deal_in_address not in", values, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressBetween(String value1, String value2) {
            addCriterion("deal_in_address between", value1, value2, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAddressNotBetween(String value1, String value2) {
            addCriterion("deal_in_address not between", value1, value2, "dealInAddress");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeIsNull() {
            addCriterion("deal_in_Area_code is null");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeIsNotNull() {
            addCriterion("deal_in_Area_code is not null");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeEqualTo(String value) {
            addCriterion("deal_in_Area_code =", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeNotEqualTo(String value) {
            addCriterion("deal_in_Area_code <>", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeGreaterThan(String value) {
            addCriterion("deal_in_Area_code >", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("deal_in_Area_code >=", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeLessThan(String value) {
            addCriterion("deal_in_Area_code <", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("deal_in_Area_code <=", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeLike(String value) {
            addCriterion("deal_in_Area_code like", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeNotLike(String value) {
            addCriterion("deal_in_Area_code not like", value, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeIn(List<String> values) {
            addCriterion("deal_in_Area_code in", values, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeNotIn(List<String> values) {
            addCriterion("deal_in_Area_code not in", values, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeBetween(String value1, String value2) {
            addCriterion("deal_in_Area_code between", value1, value2, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andDealInAreaCodeNotBetween(String value1, String value2) {
            addCriterion("deal_in_Area_code not between", value1, value2, "dealInAreaCode");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Date value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Date value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Date value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Date value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Date value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Date value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Date> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Date> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Date value1, Date value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Date value1, Date value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Boolean value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Boolean value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Boolean value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Boolean value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Boolean> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Boolean> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andOrgWebIsNull() {
            addCriterion("org_web is null");
            return (Criteria) this;
        }

        public Criteria andOrgWebIsNotNull() {
            addCriterion("org_web is not null");
            return (Criteria) this;
        }

        public Criteria andOrgWebEqualTo(String value) {
            addCriterion("org_web =", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotEqualTo(String value) {
            addCriterion("org_web <>", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebGreaterThan(String value) {
            addCriterion("org_web >", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebGreaterThanOrEqualTo(String value) {
            addCriterion("org_web >=", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebLessThan(String value) {
            addCriterion("org_web <", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebLessThanOrEqualTo(String value) {
            addCriterion("org_web <=", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebLike(String value) {
            addCriterion("org_web like", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotLike(String value) {
            addCriterion("org_web not like", value, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebIn(List<String> values) {
            addCriterion("org_web in", values, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotIn(List<String> values) {
            addCriterion("org_web not in", values, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebBetween(String value1, String value2) {
            addCriterion("org_web between", value1, value2, "orgWeb");
            return (Criteria) this;
        }

        public Criteria andOrgWebNotBetween(String value1, String value2) {
            addCriterion("org_web not between", value1, value2, "orgWeb");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}