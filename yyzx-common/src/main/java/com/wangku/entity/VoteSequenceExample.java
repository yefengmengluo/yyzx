package com.wangku.entity;

import java.util.ArrayList;
import java.util.List;

public class VoteSequenceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VoteSequenceExample() {
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

        public Criteria andSeqNameIsNull() {
            addCriterion("seq_name is null");
            return (Criteria) this;
        }

        public Criteria andSeqNameIsNotNull() {
            addCriterion("seq_name is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNameEqualTo(String value) {
            addCriterion("seq_name =", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotEqualTo(String value) {
            addCriterion("seq_name <>", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameGreaterThan(String value) {
            addCriterion("seq_name >", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameGreaterThanOrEqualTo(String value) {
            addCriterion("seq_name >=", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameLessThan(String value) {
            addCriterion("seq_name <", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameLessThanOrEqualTo(String value) {
            addCriterion("seq_name <=", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameLike(String value) {
            addCriterion("seq_name like", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotLike(String value) {
            addCriterion("seq_name not like", value, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameIn(List<String> values) {
            addCriterion("seq_name in", values, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotIn(List<String> values) {
            addCriterion("seq_name not in", values, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameBetween(String value1, String value2) {
            addCriterion("seq_name between", value1, value2, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqNameNotBetween(String value1, String value2) {
            addCriterion("seq_name not between", value1, value2, "seqName");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValIsNull() {
            addCriterion("seq_current_val is null");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValIsNotNull() {
            addCriterion("seq_current_val is not null");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValEqualTo(Long value) {
            addCriterion("seq_current_val =", value, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValNotEqualTo(Long value) {
            addCriterion("seq_current_val <>", value, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValGreaterThan(Long value) {
            addCriterion("seq_current_val >", value, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValGreaterThanOrEqualTo(Long value) {
            addCriterion("seq_current_val >=", value, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValLessThan(Long value) {
            addCriterion("seq_current_val <", value, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValLessThanOrEqualTo(Long value) {
            addCriterion("seq_current_val <=", value, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValIn(List<Long> values) {
            addCriterion("seq_current_val in", values, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValNotIn(List<Long> values) {
            addCriterion("seq_current_val not in", values, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValBetween(Long value1, Long value2) {
            addCriterion("seq_current_val between", value1, value2, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqCurrentValNotBetween(Long value1, Long value2) {
            addCriterion("seq_current_val not between", value1, value2, "seqCurrentVal");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorIsNull() {
            addCriterion("seq_incre_factor is null");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorIsNotNull() {
            addCriterion("seq_incre_factor is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorEqualTo(Short value) {
            addCriterion("seq_incre_factor =", value, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorNotEqualTo(Short value) {
            addCriterion("seq_incre_factor <>", value, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorGreaterThan(Short value) {
            addCriterion("seq_incre_factor >", value, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorGreaterThanOrEqualTo(Short value) {
            addCriterion("seq_incre_factor >=", value, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorLessThan(Short value) {
            addCriterion("seq_incre_factor <", value, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorLessThanOrEqualTo(Short value) {
            addCriterion("seq_incre_factor <=", value, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorIn(List<Short> values) {
            addCriterion("seq_incre_factor in", values, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorNotIn(List<Short> values) {
            addCriterion("seq_incre_factor not in", values, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorBetween(Short value1, Short value2) {
            addCriterion("seq_incre_factor between", value1, value2, "seqIncreFactor");
            return (Criteria) this;
        }

        public Criteria andSeqIncreFactorNotBetween(Short value1, Short value2) {
            addCriterion("seq_incre_factor not between", value1, value2, "seqIncreFactor");
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