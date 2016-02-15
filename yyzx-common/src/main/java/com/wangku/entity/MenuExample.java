package com.wangku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MenuExample() {
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

        public Criteria andMenuIdIsNull() {
            addCriterion("menu_id is null");
            return (Criteria) this;
        }

        public Criteria andMenuIdIsNotNull() {
            addCriterion("menu_id is not null");
            return (Criteria) this;
        }

        public Criteria andMenuIdEqualTo(Integer value) {
            addCriterion("menu_id =", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotEqualTo(Integer value) {
            addCriterion("menu_id <>", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThan(Integer value) {
            addCriterion("menu_id >", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("menu_id >=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThan(Integer value) {
            addCriterion("menu_id <", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdLessThanOrEqualTo(Integer value) {
            addCriterion("menu_id <=", value, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdIn(List<Integer> values) {
            addCriterion("menu_id in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotIn(List<Integer> values) {
            addCriterion("menu_id not in", values, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdBetween(Integer value1, Integer value2) {
            addCriterion("menu_id between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("menu_id not between", value1, value2, "menuId");
            return (Criteria) this;
        }

        public Criteria andMenunnameIsNull() {
            addCriterion("menuNname is null");
            return (Criteria) this;
        }

        public Criteria andMenunnameIsNotNull() {
            addCriterion("menuNname is not null");
            return (Criteria) this;
        }

        public Criteria andMenunnameEqualTo(String value) {
            addCriterion("menuNname =", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameNotEqualTo(String value) {
            addCriterion("menuNname <>", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameGreaterThan(String value) {
            addCriterion("menuNname >", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameGreaterThanOrEqualTo(String value) {
            addCriterion("menuNname >=", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameLessThan(String value) {
            addCriterion("menuNname <", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameLessThanOrEqualTo(String value) {
            addCriterion("menuNname <=", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameLike(String value) {
            addCriterion("menuNname like", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameNotLike(String value) {
            addCriterion("menuNname not like", value, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameIn(List<String> values) {
            addCriterion("menuNname in", values, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameNotIn(List<String> values) {
            addCriterion("menuNname not in", values, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameBetween(String value1, String value2) {
            addCriterion("menuNname between", value1, value2, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenunnameNotBetween(String value1, String value2) {
            addCriterion("menuNname not between", value1, value2, "menunname");
            return (Criteria) this;
        }

        public Criteria andMenucodeIsNull() {
            addCriterion("menuCode is null");
            return (Criteria) this;
        }

        public Criteria andMenucodeIsNotNull() {
            addCriterion("menuCode is not null");
            return (Criteria) this;
        }

        public Criteria andMenucodeEqualTo(String value) {
            addCriterion("menuCode =", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeNotEqualTo(String value) {
            addCriterion("menuCode <>", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeGreaterThan(String value) {
            addCriterion("menuCode >", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeGreaterThanOrEqualTo(String value) {
            addCriterion("menuCode >=", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeLessThan(String value) {
            addCriterion("menuCode <", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeLessThanOrEqualTo(String value) {
            addCriterion("menuCode <=", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeLike(String value) {
            addCriterion("menuCode like", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeNotLike(String value) {
            addCriterion("menuCode not like", value, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeIn(List<String> values) {
            addCriterion("menuCode in", values, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeNotIn(List<String> values) {
            addCriterion("menuCode not in", values, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeBetween(String value1, String value2) {
            addCriterion("menuCode between", value1, value2, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenucodeNotBetween(String value1, String value2) {
            addCriterion("menuCode not between", value1, value2, "menucode");
            return (Criteria) this;
        }

        public Criteria andMenudescribeIsNull() {
            addCriterion("menuDescribe is null");
            return (Criteria) this;
        }

        public Criteria andMenudescribeIsNotNull() {
            addCriterion("menuDescribe is not null");
            return (Criteria) this;
        }

        public Criteria andMenudescribeEqualTo(String value) {
            addCriterion("menuDescribe =", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeNotEqualTo(String value) {
            addCriterion("menuDescribe <>", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeGreaterThan(String value) {
            addCriterion("menuDescribe >", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeGreaterThanOrEqualTo(String value) {
            addCriterion("menuDescribe >=", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeLessThan(String value) {
            addCriterion("menuDescribe <", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeLessThanOrEqualTo(String value) {
            addCriterion("menuDescribe <=", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeLike(String value) {
            addCriterion("menuDescribe like", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeNotLike(String value) {
            addCriterion("menuDescribe not like", value, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeIn(List<String> values) {
            addCriterion("menuDescribe in", values, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeNotIn(List<String> values) {
            addCriterion("menuDescribe not in", values, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeBetween(String value1, String value2) {
            addCriterion("menuDescribe between", value1, value2, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andMenudescribeNotBetween(String value1, String value2) {
            addCriterion("menuDescribe not between", value1, value2, "menudescribe");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addTime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andFlagonIsNull() {
            addCriterion("flagOn is null");
            return (Criteria) this;
        }

        public Criteria andFlagonIsNotNull() {
            addCriterion("flagOn is not null");
            return (Criteria) this;
        }

        public Criteria andFlagonEqualTo(String value) {
            addCriterion("flagOn =", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonNotEqualTo(String value) {
            addCriterion("flagOn <>", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonGreaterThan(String value) {
            addCriterion("flagOn >", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonGreaterThanOrEqualTo(String value) {
            addCriterion("flagOn >=", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonLessThan(String value) {
            addCriterion("flagOn <", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonLessThanOrEqualTo(String value) {
            addCriterion("flagOn <=", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonLike(String value) {
            addCriterion("flagOn like", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonNotLike(String value) {
            addCriterion("flagOn not like", value, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonIn(List<String> values) {
            addCriterion("flagOn in", values, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonNotIn(List<String> values) {
            addCriterion("flagOn not in", values, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonBetween(String value1, String value2) {
            addCriterion("flagOn between", value1, value2, "flagon");
            return (Criteria) this;
        }

        public Criteria andFlagonNotBetween(String value1, String value2) {
            addCriterion("flagOn not between", value1, value2, "flagon");
            return (Criteria) this;
        }

        public Criteria andMenuorderIsNull() {
            addCriterion("menuOrder is null");
            return (Criteria) this;
        }

        public Criteria andMenuorderIsNotNull() {
            addCriterion("menuOrder is not null");
            return (Criteria) this;
        }

        public Criteria andMenuorderEqualTo(Integer value) {
            addCriterion("menuOrder =", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderNotEqualTo(Integer value) {
            addCriterion("menuOrder <>", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderGreaterThan(Integer value) {
            addCriterion("menuOrder >", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuOrder >=", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderLessThan(Integer value) {
            addCriterion("menuOrder <", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderLessThanOrEqualTo(Integer value) {
            addCriterion("menuOrder <=", value, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderIn(List<Integer> values) {
            addCriterion("menuOrder in", values, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderNotIn(List<Integer> values) {
            addCriterion("menuOrder not in", values, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderBetween(Integer value1, Integer value2) {
            addCriterion("menuOrder between", value1, value2, "menuorder");
            return (Criteria) this;
        }

        public Criteria andMenuorderNotBetween(Integer value1, Integer value2) {
            addCriterion("menuOrder not between", value1, value2, "menuorder");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
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