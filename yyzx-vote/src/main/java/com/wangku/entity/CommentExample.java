package com.wangku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(Long value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(Long value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(Long value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(Long value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(Long value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(Long value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<Long> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<Long> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(Long value1, Long value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(Long value1, Long value2) {
            addCriterion("com_id not between", value1, value2, "comId");
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

        public Criteria andComContentIsNull() {
            addCriterion("com_content is null");
            return (Criteria) this;
        }

        public Criteria andComContentIsNotNull() {
            addCriterion("com_content is not null");
            return (Criteria) this;
        }

        public Criteria andComContentEqualTo(String value) {
            addCriterion("com_content =", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotEqualTo(String value) {
            addCriterion("com_content <>", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThan(String value) {
            addCriterion("com_content >", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThanOrEqualTo(String value) {
            addCriterion("com_content >=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThan(String value) {
            addCriterion("com_content <", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThanOrEqualTo(String value) {
            addCriterion("com_content <=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLike(String value) {
            addCriterion("com_content like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotLike(String value) {
            addCriterion("com_content not like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentIn(List<String> values) {
            addCriterion("com_content in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotIn(List<String> values) {
            addCriterion("com_content not in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentBetween(String value1, String value2) {
            addCriterion("com_content between", value1, value2, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotBetween(String value1, String value2) {
            addCriterion("com_content not between", value1, value2, "comContent");
            return (Criteria) this;
        }

        public Criteria andComTimeIsNull() {
            addCriterion("com_time is null");
            return (Criteria) this;
        }

        public Criteria andComTimeIsNotNull() {
            addCriterion("com_time is not null");
            return (Criteria) this;
        }

        public Criteria andComTimeEqualTo(Date value) {
            addCriterion("com_time =", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotEqualTo(Date value) {
            addCriterion("com_time <>", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeGreaterThan(Date value) {
            addCriterion("com_time >", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("com_time >=", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeLessThan(Date value) {
            addCriterion("com_time <", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeLessThanOrEqualTo(Date value) {
            addCriterion("com_time <=", value, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeIn(List<Date> values) {
            addCriterion("com_time in", values, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotIn(List<Date> values) {
            addCriterion("com_time not in", values, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeBetween(Date value1, Date value2) {
            addCriterion("com_time between", value1, value2, "comTime");
            return (Criteria) this;
        }

        public Criteria andComTimeNotBetween(Date value1, Date value2) {
            addCriterion("com_time not between", value1, value2, "comTime");
            return (Criteria) this;
        }

        public Criteria andComIpIsNull() {
            addCriterion("com_ip is null");
            return (Criteria) this;
        }

        public Criteria andComIpIsNotNull() {
            addCriterion("com_ip is not null");
            return (Criteria) this;
        }

        public Criteria andComIpEqualTo(String value) {
            addCriterion("com_ip =", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpNotEqualTo(String value) {
            addCriterion("com_ip <>", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpGreaterThan(String value) {
            addCriterion("com_ip >", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpGreaterThanOrEqualTo(String value) {
            addCriterion("com_ip >=", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpLessThan(String value) {
            addCriterion("com_ip <", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpLessThanOrEqualTo(String value) {
            addCriterion("com_ip <=", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpLike(String value) {
            addCriterion("com_ip like", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpNotLike(String value) {
            addCriterion("com_ip not like", value, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpIn(List<String> values) {
            addCriterion("com_ip in", values, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpNotIn(List<String> values) {
            addCriterion("com_ip not in", values, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpBetween(String value1, String value2) {
            addCriterion("com_ip between", value1, value2, "comIp");
            return (Criteria) this;
        }

        public Criteria andComIpNotBetween(String value1, String value2) {
            addCriterion("com_ip not between", value1, value2, "comIp");
            return (Criteria) this;
        }

        public Criteria andComStaticIsNull() {
            addCriterion("com_static is null");
            return (Criteria) this;
        }

        public Criteria andComStaticIsNotNull() {
            addCriterion("com_static is not null");
            return (Criteria) this;
        }

        public Criteria andComStaticEqualTo(Integer value) {
            addCriterion("com_static =", value, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticNotEqualTo(Integer value) {
            addCriterion("com_static <>", value, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticGreaterThan(Integer value) {
            addCriterion("com_static >", value, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticGreaterThanOrEqualTo(Integer value) {
            addCriterion("com_static >=", value, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticLessThan(Integer value) {
            addCriterion("com_static <", value, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticLessThanOrEqualTo(Integer value) {
            addCriterion("com_static <=", value, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticIn(List<Integer> values) {
            addCriterion("com_static in", values, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticNotIn(List<Integer> values) {
            addCriterion("com_static not in", values, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticBetween(Integer value1, Integer value2) {
            addCriterion("com_static between", value1, value2, "comStatic");
            return (Criteria) this;
        }

        public Criteria andComStaticNotBetween(Integer value1, Integer value2) {
            addCriterion("com_static not between", value1, value2, "comStatic");
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

        public Criteria andTopIsNull() {
            addCriterion("top is null");
            return (Criteria) this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("top is not null");
            return (Criteria) this;
        }

        public Criteria andTopEqualTo(Integer value) {
            addCriterion("top =", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotEqualTo(Integer value) {
            addCriterion("top <>", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThan(Integer value) {
            addCriterion("top >", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("top >=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThan(Integer value) {
            addCriterion("top <", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThanOrEqualTo(Integer value) {
            addCriterion("top <=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopIn(List<Integer> values) {
            addCriterion("top in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotIn(List<Integer> values) {
            addCriterion("top not in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopBetween(Integer value1, Integer value2) {
            addCriterion("top between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotBetween(Integer value1, Integer value2) {
            addCriterion("top not between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andDroopIsNull() {
            addCriterion("droop is null");
            return (Criteria) this;
        }

        public Criteria andDroopIsNotNull() {
            addCriterion("droop is not null");
            return (Criteria) this;
        }

        public Criteria andDroopEqualTo(Integer value) {
            addCriterion("droop =", value, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopNotEqualTo(Integer value) {
            addCriterion("droop <>", value, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopGreaterThan(Integer value) {
            addCriterion("droop >", value, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopGreaterThanOrEqualTo(Integer value) {
            addCriterion("droop >=", value, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopLessThan(Integer value) {
            addCriterion("droop <", value, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopLessThanOrEqualTo(Integer value) {
            addCriterion("droop <=", value, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopIn(List<Integer> values) {
            addCriterion("droop in", values, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopNotIn(List<Integer> values) {
            addCriterion("droop not in", values, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopBetween(Integer value1, Integer value2) {
            addCriterion("droop between", value1, value2, "droop");
            return (Criteria) this;
        }

        public Criteria andDroopNotBetween(Integer value1, Integer value2) {
            addCriterion("droop not between", value1, value2, "droop");
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