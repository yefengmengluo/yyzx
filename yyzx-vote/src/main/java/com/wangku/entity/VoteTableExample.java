package com.wangku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoteTableExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVSubjectIsNull() {
            addCriterion("v_subject is null");
            return (Criteria) this;
        }

        public Criteria andVSubjectIsNotNull() {
            addCriterion("v_subject is not null");
            return (Criteria) this;
        }

        public Criteria andVSubjectEqualTo(String value) {
            addCriterion("v_subject =", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectNotEqualTo(String value) {
            addCriterion("v_subject <>", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectGreaterThan(String value) {
            addCriterion("v_subject >", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("v_subject >=", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectLessThan(String value) {
            addCriterion("v_subject <", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectLessThanOrEqualTo(String value) {
            addCriterion("v_subject <=", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectLike(String value) {
            addCriterion("v_subject like", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectNotLike(String value) {
            addCriterion("v_subject not like", value, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectIn(List<String> values) {
            addCriterion("v_subject in", values, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectNotIn(List<String> values) {
            addCriterion("v_subject not in", values, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectBetween(String value1, String value2) {
            addCriterion("v_subject between", value1, value2, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSubjectNotBetween(String value1, String value2) {
            addCriterion("v_subject not between", value1, value2, "vSubject");
            return (Criteria) this;
        }

        public Criteria andVSummaryIsNull() {
            addCriterion("v_summary is null");
            return (Criteria) this;
        }

        public Criteria andVSummaryIsNotNull() {
            addCriterion("v_summary is not null");
            return (Criteria) this;
        }

        public Criteria andVSummaryEqualTo(String value) {
            addCriterion("v_summary =", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryNotEqualTo(String value) {
            addCriterion("v_summary <>", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryGreaterThan(String value) {
            addCriterion("v_summary >", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("v_summary >=", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryLessThan(String value) {
            addCriterion("v_summary <", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryLessThanOrEqualTo(String value) {
            addCriterion("v_summary <=", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryLike(String value) {
            addCriterion("v_summary like", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryNotLike(String value) {
            addCriterion("v_summary not like", value, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryIn(List<String> values) {
            addCriterion("v_summary in", values, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryNotIn(List<String> values) {
            addCriterion("v_summary not in", values, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryBetween(String value1, String value2) {
            addCriterion("v_summary between", value1, value2, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVSummaryNotBetween(String value1, String value2) {
            addCriterion("v_summary not between", value1, value2, "vSummary");
            return (Criteria) this;
        }

        public Criteria andVForeverIsNull() {
            addCriterion("v_forever is null");
            return (Criteria) this;
        }

        public Criteria andVForeverIsNotNull() {
            addCriterion("v_forever is not null");
            return (Criteria) this;
        }

        public Criteria andVForeverEqualTo(Byte value) {
            addCriterion("v_forever =", value, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverNotEqualTo(Byte value) {
            addCriterion("v_forever <>", value, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverGreaterThan(Byte value) {
            addCriterion("v_forever >", value, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverGreaterThanOrEqualTo(Byte value) {
            addCriterion("v_forever >=", value, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverLessThan(Byte value) {
            addCriterion("v_forever <", value, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverLessThanOrEqualTo(Byte value) {
            addCriterion("v_forever <=", value, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverIn(List<Byte> values) {
            addCriterion("v_forever in", values, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverNotIn(List<Byte> values) {
            addCriterion("v_forever not in", values, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverBetween(Byte value1, Byte value2) {
            addCriterion("v_forever between", value1, value2, "vForever");
            return (Criteria) this;
        }

        public Criteria andVForeverNotBetween(Byte value1, Byte value2) {
            addCriterion("v_forever not between", value1, value2, "vForever");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
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

        public Criteria andDataStatusIsNull() {
            addCriterion("data_status is null");
            return (Criteria) this;
        }

        public Criteria andDataStatusIsNotNull() {
            addCriterion("data_status is not null");
            return (Criteria) this;
        }

        public Criteria andDataStatusEqualTo(Byte value) {
            addCriterion("data_status =", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotEqualTo(Byte value) {
            addCriterion("data_status <>", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThan(Byte value) {
            addCriterion("data_status >", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("data_status >=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThan(Byte value) {
            addCriterion("data_status <", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusLessThanOrEqualTo(Byte value) {
            addCriterion("data_status <=", value, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusIn(List<Byte> values) {
            addCriterion("data_status in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotIn(List<Byte> values) {
            addCriterion("data_status not in", values, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusBetween(Byte value1, Byte value2) {
            addCriterion("data_status between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("data_status not between", value1, value2, "dataStatus");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeIsNull() {
            addCriterion("data_add_time is null");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeIsNotNull() {
            addCriterion("data_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeEqualTo(Date value) {
            addCriterion("data_add_time =", value, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeNotEqualTo(Date value) {
            addCriterion("data_add_time <>", value, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeGreaterThan(Date value) {
            addCriterion("data_add_time >", value, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("data_add_time >=", value, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeLessThan(Date value) {
            addCriterion("data_add_time <", value, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("data_add_time <=", value, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeIn(List<Date> values) {
            addCriterion("data_add_time in", values, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeNotIn(List<Date> values) {
            addCriterion("data_add_time not in", values, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeBetween(Date value1, Date value2) {
            addCriterion("data_add_time between", value1, value2, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("data_add_time not between", value1, value2, "dataAddTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeIsNull() {
            addCriterion("data_modify_time is null");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeIsNotNull() {
            addCriterion("data_modify_time is not null");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeEqualTo(Date value) {
            addCriterion("data_modify_time =", value, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeNotEqualTo(Date value) {
            addCriterion("data_modify_time <>", value, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeGreaterThan(Date value) {
            addCriterion("data_modify_time >", value, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("data_modify_time >=", value, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeLessThan(Date value) {
            addCriterion("data_modify_time <", value, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("data_modify_time <=", value, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeIn(List<Date> values) {
            addCriterion("data_modify_time in", values, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeNotIn(List<Date> values) {
            addCriterion("data_modify_time not in", values, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeBetween(Date value1, Date value2) {
            addCriterion("data_modify_time between", value1, value2, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andDataModifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("data_modify_time not between", value1, value2, "dataModifyTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNull() {
            addCriterion("limit_time is null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIsNotNull() {
            addCriterion("limit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLimitTimeEqualTo(Date value) {
            addCriterion("limit_time =", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotEqualTo(Date value) {
            addCriterion("limit_time <>", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThan(Date value) {
            addCriterion("limit_time >", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("limit_time >=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThan(Date value) {
            addCriterion("limit_time <", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeLessThanOrEqualTo(Date value) {
            addCriterion("limit_time <=", value, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeIn(List<Date> values) {
            addCriterion("limit_time in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotIn(List<Date> values) {
            addCriterion("limit_time not in", values, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeBetween(Date value1, Date value2) {
            addCriterion("limit_time between", value1, value2, "limitTime");
            return (Criteria) this;
        }

        public Criteria andLimitTimeNotBetween(Date value1, Date value2) {
            addCriterion("limit_time not between", value1, value2, "limitTime");
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