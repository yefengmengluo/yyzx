package com.wangku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyExample() {
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

        public Criteria andCopIdIsNull() {
            addCriterion("cop_id is null");
            return (Criteria) this;
        }

        public Criteria andCopIdIsNotNull() {
            addCriterion("cop_id is not null");
            return (Criteria) this;
        }

        public Criteria andCopIdEqualTo(Long value) {
            addCriterion("cop_id =", value, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdNotEqualTo(Long value) {
            addCriterion("cop_id <>", value, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdGreaterThan(Long value) {
            addCriterion("cop_id >", value, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cop_id >=", value, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdLessThan(Long value) {
            addCriterion("cop_id <", value, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdLessThanOrEqualTo(Long value) {
            addCriterion("cop_id <=", value, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdIn(List<Long> values) {
            addCriterion("cop_id in", values, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdNotIn(List<Long> values) {
            addCriterion("cop_id not in", values, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdBetween(Long value1, Long value2) {
            addCriterion("cop_id between", value1, value2, "copId");
            return (Criteria) this;
        }

        public Criteria andCopIdNotBetween(Long value1, Long value2) {
            addCriterion("cop_id not between", value1, value2, "copId");
            return (Criteria) this;
        }

        public Criteria andCopNameIsNull() {
            addCriterion("cop_name is null");
            return (Criteria) this;
        }

        public Criteria andCopNameIsNotNull() {
            addCriterion("cop_name is not null");
            return (Criteria) this;
        }

        public Criteria andCopNameEqualTo(String value) {
            addCriterion("cop_name =", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotEqualTo(String value) {
            addCriterion("cop_name <>", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameGreaterThan(String value) {
            addCriterion("cop_name >", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameGreaterThanOrEqualTo(String value) {
            addCriterion("cop_name >=", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameLessThan(String value) {
            addCriterion("cop_name <", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameLessThanOrEqualTo(String value) {
            addCriterion("cop_name <=", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameLike(String value) {
            addCriterion("cop_name like", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotLike(String value) {
            addCriterion("cop_name not like", value, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameIn(List<String> values) {
            addCriterion("cop_name in", values, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotIn(List<String> values) {
            addCriterion("cop_name not in", values, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameBetween(String value1, String value2) {
            addCriterion("cop_name between", value1, value2, "copName");
            return (Criteria) this;
        }

        public Criteria andCopNameNotBetween(String value1, String value2) {
            addCriterion("cop_name not between", value1, value2, "copName");
            return (Criteria) this;
        }

        public Criteria andCopBrandIsNull() {
            addCriterion("cop_brand is null");
            return (Criteria) this;
        }

        public Criteria andCopBrandIsNotNull() {
            addCriterion("cop_brand is not null");
            return (Criteria) this;
        }

        public Criteria andCopBrandEqualTo(String value) {
            addCriterion("cop_brand =", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandNotEqualTo(String value) {
            addCriterion("cop_brand <>", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandGreaterThan(String value) {
            addCriterion("cop_brand >", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandGreaterThanOrEqualTo(String value) {
            addCriterion("cop_brand >=", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandLessThan(String value) {
            addCriterion("cop_brand <", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandLessThanOrEqualTo(String value) {
            addCriterion("cop_brand <=", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandLike(String value) {
            addCriterion("cop_brand like", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandNotLike(String value) {
            addCriterion("cop_brand not like", value, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandIn(List<String> values) {
            addCriterion("cop_brand in", values, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandNotIn(List<String> values) {
            addCriterion("cop_brand not in", values, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandBetween(String value1, String value2) {
            addCriterion("cop_brand between", value1, value2, "copBrand");
            return (Criteria) this;
        }

        public Criteria andCopBrandNotBetween(String value1, String value2) {
            addCriterion("cop_brand not between", value1, value2, "copBrand");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(Integer value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(Integer value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(Integer value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(Integer value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(Integer value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(Integer value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<Integer> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<Integer> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(Integer value1, Integer value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(Integer value1, Integer value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andCopUrlIsNull() {
            addCriterion("cop_url is null");
            return (Criteria) this;
        }

        public Criteria andCopUrlIsNotNull() {
            addCriterion("cop_url is not null");
            return (Criteria) this;
        }

        public Criteria andCopUrlEqualTo(String value) {
            addCriterion("cop_url =", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlNotEqualTo(String value) {
            addCriterion("cop_url <>", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlGreaterThan(String value) {
            addCriterion("cop_url >", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlGreaterThanOrEqualTo(String value) {
            addCriterion("cop_url >=", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlLessThan(String value) {
            addCriterion("cop_url <", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlLessThanOrEqualTo(String value) {
            addCriterion("cop_url <=", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlLike(String value) {
            addCriterion("cop_url like", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlNotLike(String value) {
            addCriterion("cop_url not like", value, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlIn(List<String> values) {
            addCriterion("cop_url in", values, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlNotIn(List<String> values) {
            addCriterion("cop_url not in", values, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlBetween(String value1, String value2) {
            addCriterion("cop_url between", value1, value2, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopUrlNotBetween(String value1, String value2) {
            addCriterion("cop_url not between", value1, value2, "copUrl");
            return (Criteria) this;
        }

        public Criteria andCopAddressIsNull() {
            addCriterion("cop_address is null");
            return (Criteria) this;
        }

        public Criteria andCopAddressIsNotNull() {
            addCriterion("cop_address is not null");
            return (Criteria) this;
        }

        public Criteria andCopAddressEqualTo(String value) {
            addCriterion("cop_address =", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressNotEqualTo(String value) {
            addCriterion("cop_address <>", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressGreaterThan(String value) {
            addCriterion("cop_address >", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressGreaterThanOrEqualTo(String value) {
            addCriterion("cop_address >=", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressLessThan(String value) {
            addCriterion("cop_address <", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressLessThanOrEqualTo(String value) {
            addCriterion("cop_address <=", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressLike(String value) {
            addCriterion("cop_address like", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressNotLike(String value) {
            addCriterion("cop_address not like", value, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressIn(List<String> values) {
            addCriterion("cop_address in", values, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressNotIn(List<String> values) {
            addCriterion("cop_address not in", values, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressBetween(String value1, String value2) {
            addCriterion("cop_address between", value1, value2, "copAddress");
            return (Criteria) this;
        }

        public Criteria andCopAddressNotBetween(String value1, String value2) {
            addCriterion("cop_address not between", value1, value2, "copAddress");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryIsNull() {
            addCriterion("brand_industry is null");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryIsNotNull() {
            addCriterion("brand_industry is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryEqualTo(String value) {
            addCriterion("brand_industry =", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryNotEqualTo(String value) {
            addCriterion("brand_industry <>", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryGreaterThan(String value) {
            addCriterion("brand_industry >", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("brand_industry >=", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryLessThan(String value) {
            addCriterion("brand_industry <", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryLessThanOrEqualTo(String value) {
            addCriterion("brand_industry <=", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryLike(String value) {
            addCriterion("brand_industry like", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryNotLike(String value) {
            addCriterion("brand_industry not like", value, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryIn(List<String> values) {
            addCriterion("brand_industry in", values, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryNotIn(List<String> values) {
            addCriterion("brand_industry not in", values, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryBetween(String value1, String value2) {
            addCriterion("brand_industry between", value1, value2, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andBrandIndustryNotBetween(String value1, String value2) {
            addCriterion("brand_industry not between", value1, value2, "brandIndustry");
            return (Criteria) this;
        }

        public Criteria andCopSummaryIsNull() {
            addCriterion("cop_summary is null");
            return (Criteria) this;
        }

        public Criteria andCopSummaryIsNotNull() {
            addCriterion("cop_summary is not null");
            return (Criteria) this;
        }

        public Criteria andCopSummaryEqualTo(String value) {
            addCriterion("cop_summary =", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryNotEqualTo(String value) {
            addCriterion("cop_summary <>", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryGreaterThan(String value) {
            addCriterion("cop_summary >", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("cop_summary >=", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryLessThan(String value) {
            addCriterion("cop_summary <", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryLessThanOrEqualTo(String value) {
            addCriterion("cop_summary <=", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryLike(String value) {
            addCriterion("cop_summary like", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryNotLike(String value) {
            addCriterion("cop_summary not like", value, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryIn(List<String> values) {
            addCriterion("cop_summary in", values, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryNotIn(List<String> values) {
            addCriterion("cop_summary not in", values, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryBetween(String value1, String value2) {
            addCriterion("cop_summary between", value1, value2, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopSummaryNotBetween(String value1, String value2) {
            addCriterion("cop_summary not between", value1, value2, "copSummary");
            return (Criteria) this;
        }

        public Criteria andCopEventsIsNull() {
            addCriterion("cop_events is null");
            return (Criteria) this;
        }

        public Criteria andCopEventsIsNotNull() {
            addCriterion("cop_events is not null");
            return (Criteria) this;
        }

        public Criteria andCopEventsEqualTo(String value) {
            addCriterion("cop_events =", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsNotEqualTo(String value) {
            addCriterion("cop_events <>", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsGreaterThan(String value) {
            addCriterion("cop_events >", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsGreaterThanOrEqualTo(String value) {
            addCriterion("cop_events >=", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsLessThan(String value) {
            addCriterion("cop_events <", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsLessThanOrEqualTo(String value) {
            addCriterion("cop_events <=", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsLike(String value) {
            addCriterion("cop_events like", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsNotLike(String value) {
            addCriterion("cop_events not like", value, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsIn(List<String> values) {
            addCriterion("cop_events in", values, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsNotIn(List<String> values) {
            addCriterion("cop_events not in", values, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsBetween(String value1, String value2) {
            addCriterion("cop_events between", value1, value2, "copEvents");
            return (Criteria) this;
        }

        public Criteria andCopEventsNotBetween(String value1, String value2) {
            addCriterion("cop_events not between", value1, value2, "copEvents");
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

        public Criteria andWeixinPicIsNull() {
            addCriterion("weixin_pic is null");
            return (Criteria) this;
        }

        public Criteria andWeixinPicIsNotNull() {
            addCriterion("weixin_pic is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinPicEqualTo(String value) {
            addCriterion("weixin_pic =", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicNotEqualTo(String value) {
            addCriterion("weixin_pic <>", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicGreaterThan(String value) {
            addCriterion("weixin_pic >", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_pic >=", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicLessThan(String value) {
            addCriterion("weixin_pic <", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicLessThanOrEqualTo(String value) {
            addCriterion("weixin_pic <=", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicLike(String value) {
            addCriterion("weixin_pic like", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicNotLike(String value) {
            addCriterion("weixin_pic not like", value, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicIn(List<String> values) {
            addCriterion("weixin_pic in", values, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicNotIn(List<String> values) {
            addCriterion("weixin_pic not in", values, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicBetween(String value1, String value2) {
            addCriterion("weixin_pic between", value1, value2, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeixinPicNotBetween(String value1, String value2) {
            addCriterion("weixin_pic not between", value1, value2, "weixinPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicIsNull() {
            addCriterion("weibo_pic is null");
            return (Criteria) this;
        }

        public Criteria andWeiboPicIsNotNull() {
            addCriterion("weibo_pic is not null");
            return (Criteria) this;
        }

        public Criteria andWeiboPicEqualTo(String value) {
            addCriterion("weibo_pic =", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicNotEqualTo(String value) {
            addCriterion("weibo_pic <>", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicGreaterThan(String value) {
            addCriterion("weibo_pic >", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicGreaterThanOrEqualTo(String value) {
            addCriterion("weibo_pic >=", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicLessThan(String value) {
            addCriterion("weibo_pic <", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicLessThanOrEqualTo(String value) {
            addCriterion("weibo_pic <=", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicLike(String value) {
            addCriterion("weibo_pic like", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicNotLike(String value) {
            addCriterion("weibo_pic not like", value, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicIn(List<String> values) {
            addCriterion("weibo_pic in", values, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicNotIn(List<String> values) {
            addCriterion("weibo_pic not in", values, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicBetween(String value1, String value2) {
            addCriterion("weibo_pic between", value1, value2, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andWeiboPicNotBetween(String value1, String value2) {
            addCriterion("weibo_pic not between", value1, value2, "weiboPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicIsNull() {
            addCriterion("erweima_pic is null");
            return (Criteria) this;
        }

        public Criteria andErweimaPicIsNotNull() {
            addCriterion("erweima_pic is not null");
            return (Criteria) this;
        }

        public Criteria andErweimaPicEqualTo(String value) {
            addCriterion("erweima_pic =", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicNotEqualTo(String value) {
            addCriterion("erweima_pic <>", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicGreaterThan(String value) {
            addCriterion("erweima_pic >", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicGreaterThanOrEqualTo(String value) {
            addCriterion("erweima_pic >=", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicLessThan(String value) {
            addCriterion("erweima_pic <", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicLessThanOrEqualTo(String value) {
            addCriterion("erweima_pic <=", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicLike(String value) {
            addCriterion("erweima_pic like", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicNotLike(String value) {
            addCriterion("erweima_pic not like", value, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicIn(List<String> values) {
            addCriterion("erweima_pic in", values, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicNotIn(List<String> values) {
            addCriterion("erweima_pic not in", values, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicBetween(String value1, String value2) {
            addCriterion("erweima_pic between", value1, value2, "erweimaPic");
            return (Criteria) this;
        }

        public Criteria andErweimaPicNotBetween(String value1, String value2) {
            addCriterion("erweima_pic not between", value1, value2, "erweimaPic");
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

        public Criteria andViIdIsNull() {
            addCriterion("vi_id is null");
            return (Criteria) this;
        }

        public Criteria andViIdIsNotNull() {
            addCriterion("vi_id is not null");
            return (Criteria) this;
        }

        public Criteria andViIdEqualTo(Long value) {
            addCriterion("vi_id =", value, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdNotEqualTo(Long value) {
            addCriterion("vi_id <>", value, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdGreaterThan(Long value) {
            addCriterion("vi_id >", value, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdGreaterThanOrEqualTo(Long value) {
            addCriterion("vi_id >=", value, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdLessThan(Long value) {
            addCriterion("vi_id <", value, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdLessThanOrEqualTo(Long value) {
            addCriterion("vi_id <=", value, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdIn(List<Long> values) {
            addCriterion("vi_id in", values, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdNotIn(List<Long> values) {
            addCriterion("vi_id not in", values, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdBetween(Long value1, Long value2) {
            addCriterion("vi_id between", value1, value2, "viId");
            return (Criteria) this;
        }

        public Criteria andViIdNotBetween(Long value1, Long value2) {
            addCriterion("vi_id not between", value1, value2, "viId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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