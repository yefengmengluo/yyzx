package com.wangku.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PropurchaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PropurchaseExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
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

        public Criteria andDeliveryAddrIsNull() {
            addCriterion("delivery_addr is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIsNotNull() {
            addCriterion("delivery_addr is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrEqualTo(String value) {
            addCriterion("delivery_addr =", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrNotEqualTo(String value) {
            addCriterion("delivery_addr <>", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrGreaterThan(String value) {
            addCriterion("delivery_addr >", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_addr >=", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrLessThan(String value) {
            addCriterion("delivery_addr <", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrLessThanOrEqualTo(String value) {
            addCriterion("delivery_addr <=", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrLike(String value) {
            addCriterion("delivery_addr like", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrNotLike(String value) {
            addCriterion("delivery_addr not like", value, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrIn(List<String> values) {
            addCriterion("delivery_addr in", values, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrNotIn(List<String> values) {
            addCriterion("delivery_addr not in", values, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrBetween(String value1, String value2) {
            addCriterion("delivery_addr between", value1, value2, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryAddrNotBetween(String value1, String value2) {
            addCriterion("delivery_addr not between", value1, value2, "deliveryAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIsNull() {
            addCriterion("supplier_addr is null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIsNotNull() {
            addCriterion("supplier_addr is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrEqualTo(String value) {
            addCriterion("supplier_addr =", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotEqualTo(String value) {
            addCriterion("supplier_addr <>", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrGreaterThan(String value) {
            addCriterion("supplier_addr >", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrGreaterThanOrEqualTo(String value) {
            addCriterion("supplier_addr >=", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLessThan(String value) {
            addCriterion("supplier_addr <", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLessThanOrEqualTo(String value) {
            addCriterion("supplier_addr <=", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrLike(String value) {
            addCriterion("supplier_addr like", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotLike(String value) {
            addCriterion("supplier_addr not like", value, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrIn(List<String> values) {
            addCriterion("supplier_addr in", values, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotIn(List<String> values) {
            addCriterion("supplier_addr not in", values, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrBetween(String value1, String value2) {
            addCriterion("supplier_addr between", value1, value2, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andSupplierAddrNotBetween(String value1, String value2) {
            addCriterion("supplier_addr not between", value1, value2, "supplierAddr");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNull() {
            addCriterion("requirement is null");
            return (Criteria) this;
        }

        public Criteria andRequirementIsNotNull() {
            addCriterion("requirement is not null");
            return (Criteria) this;
        }

        public Criteria andRequirementEqualTo(String value) {
            addCriterion("requirement =", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotEqualTo(String value) {
            addCriterion("requirement <>", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThan(String value) {
            addCriterion("requirement >", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementGreaterThanOrEqualTo(String value) {
            addCriterion("requirement >=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThan(String value) {
            addCriterion("requirement <", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLessThanOrEqualTo(String value) {
            addCriterion("requirement <=", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementLike(String value) {
            addCriterion("requirement like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotLike(String value) {
            addCriterion("requirement not like", value, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementIn(List<String> values) {
            addCriterion("requirement in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotIn(List<String> values) {
            addCriterion("requirement not in", values, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementBetween(String value1, String value2) {
            addCriterion("requirement between", value1, value2, "requirement");
            return (Criteria) this;
        }

        public Criteria andRequirementNotBetween(String value1, String value2) {
            addCriterion("requirement not between", value1, value2, "requirement");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andShowContactIsNull() {
            addCriterion("show_contact is null");
            return (Criteria) this;
        }

        public Criteria andShowContactIsNotNull() {
            addCriterion("show_contact is not null");
            return (Criteria) this;
        }

        public Criteria andShowContactEqualTo(Boolean value) {
            addCriterion("show_contact =", value, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactNotEqualTo(Boolean value) {
            addCriterion("show_contact <>", value, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactGreaterThan(Boolean value) {
            addCriterion("show_contact >", value, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactGreaterThanOrEqualTo(Boolean value) {
            addCriterion("show_contact >=", value, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactLessThan(Boolean value) {
            addCriterion("show_contact <", value, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactLessThanOrEqualTo(Boolean value) {
            addCriterion("show_contact <=", value, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactIn(List<Boolean> values) {
            addCriterion("show_contact in", values, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactNotIn(List<Boolean> values) {
            addCriterion("show_contact not in", values, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactBetween(Boolean value1, Boolean value2) {
            addCriterion("show_contact between", value1, value2, "showContact");
            return (Criteria) this;
        }

        public Criteria andShowContactNotBetween(Boolean value1, Boolean value2) {
            addCriterion("show_contact not between", value1, value2, "showContact");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andQuoteTimesIsNull() {
            addCriterion("quote_times is null");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesIsNotNull() {
            addCriterion("quote_times is not null");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesEqualTo(Integer value) {
            addCriterion("quote_times =", value, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesNotEqualTo(Integer value) {
            addCriterion("quote_times <>", value, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesGreaterThan(Integer value) {
            addCriterion("quote_times >", value, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("quote_times >=", value, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesLessThan(Integer value) {
            addCriterion("quote_times <", value, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("quote_times <=", value, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesIn(List<Integer> values) {
            addCriterion("quote_times in", values, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesNotIn(List<Integer> values) {
            addCriterion("quote_times not in", values, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesBetween(Integer value1, Integer value2) {
            addCriterion("quote_times between", value1, value2, "quoteTimes");
            return (Criteria) this;
        }

        public Criteria andQuoteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("quote_times not between", value1, value2, "quoteTimes");
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

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIsNull() {
            addCriterion("purchase_amount is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIsNotNull() {
            addCriterion("purchase_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountEqualTo(BigDecimal value) {
            addCriterion("purchase_amount =", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotEqualTo(BigDecimal value) {
            addCriterion("purchase_amount <>", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountGreaterThan(BigDecimal value) {
            addCriterion("purchase_amount >", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_amount >=", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountLessThan(BigDecimal value) {
            addCriterion("purchase_amount <", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_amount <=", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIn(List<BigDecimal> values) {
            addCriterion("purchase_amount in", values, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotIn(List<BigDecimal> values) {
            addCriterion("purchase_amount not in", values, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_amount between", value1, value2, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_amount not between", value1, value2, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitIsNull() {
            addCriterion("purchase_amount_unit is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitIsNotNull() {
            addCriterion("purchase_amount_unit is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitEqualTo(String value) {
            addCriterion("purchase_amount_unit =", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitNotEqualTo(String value) {
            addCriterion("purchase_amount_unit <>", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitGreaterThan(String value) {
            addCriterion("purchase_amount_unit >", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitGreaterThanOrEqualTo(String value) {
            addCriterion("purchase_amount_unit >=", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitLessThan(String value) {
            addCriterion("purchase_amount_unit <", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitLessThanOrEqualTo(String value) {
            addCriterion("purchase_amount_unit <=", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitLike(String value) {
            addCriterion("purchase_amount_unit like", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitNotLike(String value) {
            addCriterion("purchase_amount_unit not like", value, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitIn(List<String> values) {
            addCriterion("purchase_amount_unit in", values, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitNotIn(List<String> values) {
            addCriterion("purchase_amount_unit not in", values, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitBetween(String value1, String value2) {
            addCriterion("purchase_amount_unit between", value1, value2, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountUnitNotBetween(String value1, String value2) {
            addCriterion("purchase_amount_unit not between", value1, value2, "purchaseAmountUnit");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestIsNull() {
            addCriterion("invoice_request is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestIsNotNull() {
            addCriterion("invoice_request is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestEqualTo(String value) {
            addCriterion("invoice_request =", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestNotEqualTo(String value) {
            addCriterion("invoice_request <>", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestGreaterThan(String value) {
            addCriterion("invoice_request >", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_request >=", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestLessThan(String value) {
            addCriterion("invoice_request <", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestLessThanOrEqualTo(String value) {
            addCriterion("invoice_request <=", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestLike(String value) {
            addCriterion("invoice_request like", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestNotLike(String value) {
            addCriterion("invoice_request not like", value, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestIn(List<String> values) {
            addCriterion("invoice_request in", values, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestNotIn(List<String> values) {
            addCriterion("invoice_request not in", values, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestBetween(String value1, String value2) {
            addCriterion("invoice_request between", value1, value2, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andInvoiceRequestNotBetween(String value1, String value2) {
            addCriterion("invoice_request not between", value1, value2, "invoiceRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestIsNull() {
            addCriterion("sample_request is null");
            return (Criteria) this;
        }

        public Criteria andSampleRequestIsNotNull() {
            addCriterion("sample_request is not null");
            return (Criteria) this;
        }

        public Criteria andSampleRequestEqualTo(String value) {
            addCriterion("sample_request =", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestNotEqualTo(String value) {
            addCriterion("sample_request <>", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestGreaterThan(String value) {
            addCriterion("sample_request >", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestGreaterThanOrEqualTo(String value) {
            addCriterion("sample_request >=", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestLessThan(String value) {
            addCriterion("sample_request <", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestLessThanOrEqualTo(String value) {
            addCriterion("sample_request <=", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestLike(String value) {
            addCriterion("sample_request like", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestNotLike(String value) {
            addCriterion("sample_request not like", value, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestIn(List<String> values) {
            addCriterion("sample_request in", values, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestNotIn(List<String> values) {
            addCriterion("sample_request not in", values, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestBetween(String value1, String value2) {
            addCriterion("sample_request between", value1, value2, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andSampleRequestNotBetween(String value1, String value2) {
            addCriterion("sample_request not between", value1, value2, "sampleRequest");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIsNull() {
            addCriterion("tel_area_code is null");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIsNotNull() {
            addCriterion("tel_area_code is not null");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeEqualTo(String value) {
            addCriterion("tel_area_code =", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotEqualTo(String value) {
            addCriterion("tel_area_code <>", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeGreaterThan(String value) {
            addCriterion("tel_area_code >", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tel_area_code >=", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLessThan(String value) {
            addCriterion("tel_area_code <", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("tel_area_code <=", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeLike(String value) {
            addCriterion("tel_area_code like", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotLike(String value) {
            addCriterion("tel_area_code not like", value, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeIn(List<String> values) {
            addCriterion("tel_area_code in", values, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotIn(List<String> values) {
            addCriterion("tel_area_code not in", values, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeBetween(String value1, String value2) {
            addCriterion("tel_area_code between", value1, value2, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelAreaCodeNotBetween(String value1, String value2) {
            addCriterion("tel_area_code not between", value1, value2, "telAreaCode");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberIsNull() {
            addCriterion("tel_fixed_number is null");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberIsNotNull() {
            addCriterion("tel_fixed_number is not null");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberEqualTo(String value) {
            addCriterion("tel_fixed_number =", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberNotEqualTo(String value) {
            addCriterion("tel_fixed_number <>", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberGreaterThan(String value) {
            addCriterion("tel_fixed_number >", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberGreaterThanOrEqualTo(String value) {
            addCriterion("tel_fixed_number >=", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberLessThan(String value) {
            addCriterion("tel_fixed_number <", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberLessThanOrEqualTo(String value) {
            addCriterion("tel_fixed_number <=", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberLike(String value) {
            addCriterion("tel_fixed_number like", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberNotLike(String value) {
            addCriterion("tel_fixed_number not like", value, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberIn(List<String> values) {
            addCriterion("tel_fixed_number in", values, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberNotIn(List<String> values) {
            addCriterion("tel_fixed_number not in", values, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberBetween(String value1, String value2) {
            addCriterion("tel_fixed_number between", value1, value2, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andTelFixedNumberNotBetween(String value1, String value2) {
            addCriterion("tel_fixed_number not between", value1, value2, "telFixedNumber");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(Byte value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(Byte value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(Byte value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(Byte value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(Byte value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<Byte> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<Byte> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(Byte value1, Byte value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andIsPushIsNull() {
            addCriterion("is_push is null");
            return (Criteria) this;
        }

        public Criteria andIsPushIsNotNull() {
            addCriterion("is_push is not null");
            return (Criteria) this;
        }

        public Criteria andIsPushEqualTo(Byte value) {
            addCriterion("is_push =", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushNotEqualTo(Byte value) {
            addCriterion("is_push <>", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushGreaterThan(Byte value) {
            addCriterion("is_push >", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_push >=", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushLessThan(Byte value) {
            addCriterion("is_push <", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushLessThanOrEqualTo(Byte value) {
            addCriterion("is_push <=", value, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushIn(List<Byte> values) {
            addCriterion("is_push in", values, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushNotIn(List<Byte> values) {
            addCriterion("is_push not in", values, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushBetween(Byte value1, Byte value2) {
            addCriterion("is_push between", value1, value2, "isPush");
            return (Criteria) this;
        }

        public Criteria andIsPushNotBetween(Byte value1, Byte value2) {
            addCriterion("is_push not between", value1, value2, "isPush");
            return (Criteria) this;
        }

        public Criteria andPushCountIsNull() {
            addCriterion("push_count is null");
            return (Criteria) this;
        }

        public Criteria andPushCountIsNotNull() {
            addCriterion("push_count is not null");
            return (Criteria) this;
        }

        public Criteria andPushCountEqualTo(Integer value) {
            addCriterion("push_count =", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountNotEqualTo(Integer value) {
            addCriterion("push_count <>", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountGreaterThan(Integer value) {
            addCriterion("push_count >", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("push_count >=", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountLessThan(Integer value) {
            addCriterion("push_count <", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountLessThanOrEqualTo(Integer value) {
            addCriterion("push_count <=", value, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountIn(List<Integer> values) {
            addCriterion("push_count in", values, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountNotIn(List<Integer> values) {
            addCriterion("push_count not in", values, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountBetween(Integer value1, Integer value2) {
            addCriterion("push_count between", value1, value2, "pushCount");
            return (Criteria) this;
        }

        public Criteria andPushCountNotBetween(Integer value1, Integer value2) {
            addCriterion("push_count not between", value1, value2, "pushCount");
            return (Criteria) this;
        }

        public Criteria andIsContactIsNull() {
            addCriterion("is_contact is null");
            return (Criteria) this;
        }

        public Criteria andIsContactIsNotNull() {
            addCriterion("is_contact is not null");
            return (Criteria) this;
        }

        public Criteria andIsContactEqualTo(Byte value) {
            addCriterion("is_contact =", value, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactNotEqualTo(Byte value) {
            addCriterion("is_contact <>", value, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactGreaterThan(Byte value) {
            addCriterion("is_contact >", value, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_contact >=", value, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactLessThan(Byte value) {
            addCriterion("is_contact <", value, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactLessThanOrEqualTo(Byte value) {
            addCriterion("is_contact <=", value, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactIn(List<Byte> values) {
            addCriterion("is_contact in", values, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactNotIn(List<Byte> values) {
            addCriterion("is_contact not in", values, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactBetween(Byte value1, Byte value2) {
            addCriterion("is_contact between", value1, value2, "isContact");
            return (Criteria) this;
        }

        public Criteria andIsContactNotBetween(Byte value1, Byte value2) {
            addCriterion("is_contact not between", value1, value2, "isContact");
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