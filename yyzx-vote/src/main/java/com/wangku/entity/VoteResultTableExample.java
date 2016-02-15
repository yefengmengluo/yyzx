package com.wangku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VoteResultTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoteResultTableExample() {
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

        public Criteria andVIdIsNull() {
            addCriterion("v_id is null");
            return (Criteria) this;
        }

        public Criteria andVIdIsNotNull() {
            addCriterion("v_id is not null");
            return (Criteria) this;
        }

        public Criteria andVIdEqualTo(Long value) {
            addCriterion("v_id =", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotEqualTo(Long value) {
            addCriterion("v_id <>", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThan(Long value) {
            addCriterion("v_id >", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdGreaterThanOrEqualTo(Long value) {
            addCriterion("v_id >=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThan(Long value) {
            addCriterion("v_id <", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdLessThanOrEqualTo(Long value) {
            addCriterion("v_id <=", value, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdIn(List<Long> values) {
            addCriterion("v_id in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotIn(List<Long> values) {
            addCriterion("v_id not in", values, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdBetween(Long value1, Long value2) {
            addCriterion("v_id between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andVIdNotBetween(Long value1, Long value2) {
            addCriterion("v_id not between", value1, value2, "vId");
            return (Criteria) this;
        }

        public Criteria andIpAddIsNull() {
            addCriterion("ip_add is null");
            return (Criteria) this;
        }

        public Criteria andIpAddIsNotNull() {
            addCriterion("ip_add is not null");
            return (Criteria) this;
        }

        public Criteria andIpAddEqualTo(String value) {
            addCriterion("ip_add =", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddNotEqualTo(String value) {
            addCriterion("ip_add <>", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddGreaterThan(String value) {
            addCriterion("ip_add >", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddGreaterThanOrEqualTo(String value) {
            addCriterion("ip_add >=", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddLessThan(String value) {
            addCriterion("ip_add <", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddLessThanOrEqualTo(String value) {
            addCriterion("ip_add <=", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddLike(String value) {
            addCriterion("ip_add like", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddNotLike(String value) {
            addCriterion("ip_add not like", value, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddIn(List<String> values) {
            addCriterion("ip_add in", values, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddNotIn(List<String> values) {
            addCriterion("ip_add not in", values, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddBetween(String value1, String value2) {
            addCriterion("ip_add between", value1, value2, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpAddNotBetween(String value1, String value2) {
            addCriterion("ip_add not between", value1, value2, "ipAdd");
            return (Criteria) this;
        }

        public Criteria andIpNameIsNull() {
            addCriterion("ip_name is null");
            return (Criteria) this;
        }

        public Criteria andIpNameIsNotNull() {
            addCriterion("ip_name is not null");
            return (Criteria) this;
        }

        public Criteria andIpNameEqualTo(String value) {
            addCriterion("ip_name =", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameNotEqualTo(String value) {
            addCriterion("ip_name <>", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameGreaterThan(String value) {
            addCriterion("ip_name >", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameGreaterThanOrEqualTo(String value) {
            addCriterion("ip_name >=", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameLessThan(String value) {
            addCriterion("ip_name <", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameLessThanOrEqualTo(String value) {
            addCriterion("ip_name <=", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameLike(String value) {
            addCriterion("ip_name like", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameNotLike(String value) {
            addCriterion("ip_name not like", value, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameIn(List<String> values) {
            addCriterion("ip_name in", values, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameNotIn(List<String> values) {
            addCriterion("ip_name not in", values, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameBetween(String value1, String value2) {
            addCriterion("ip_name between", value1, value2, "ipName");
            return (Criteria) this;
        }

        public Criteria andIpNameNotBetween(String value1, String value2) {
            addCriterion("ip_name not between", value1, value2, "ipName");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeIsNull() {
            addCriterion("vote_add_time is null");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeIsNotNull() {
            addCriterion("vote_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeEqualTo(Date value) {
            addCriterion("vote_add_time =", value, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeNotEqualTo(Date value) {
            addCriterion("vote_add_time <>", value, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeGreaterThan(Date value) {
            addCriterion("vote_add_time >", value, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("vote_add_time >=", value, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeLessThan(Date value) {
            addCriterion("vote_add_time <", value, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("vote_add_time <=", value, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeIn(List<Date> values) {
            addCriterion("vote_add_time in", values, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeNotIn(List<Date> values) {
            addCriterion("vote_add_time not in", values, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeBetween(Date value1, Date value2) {
            addCriterion("vote_add_time between", value1, value2, "voteAddTime");
            return (Criteria) this;
        }

        public Criteria andVoteAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("vote_add_time not between", value1, value2, "voteAddTime");
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