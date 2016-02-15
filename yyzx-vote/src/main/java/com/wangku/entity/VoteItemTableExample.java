package com.wangku.entity;

import java.util.ArrayList;
import java.util.List;

public class VoteItemTableExample {
	   protected String orderByClause;

	    protected boolean distinct;

	    protected List<Criteria> oredCriteria;

	    public VoteItemTableExample() {
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

	        public Criteria andItemSortIsNull() {
	            addCriterion("item_sort is null");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortIsNotNull() {
	            addCriterion("item_sort is not null");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortEqualTo(Integer value) {
	            addCriterion("item_sort =", value, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortNotEqualTo(Integer value) {
	            addCriterion("item_sort <>", value, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortGreaterThan(Integer value) {
	            addCriterion("item_sort >", value, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortGreaterThanOrEqualTo(Integer value) {
	            addCriterion("item_sort >=", value, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortLessThan(Integer value) {
	            addCriterion("item_sort <", value, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortLessThanOrEqualTo(Integer value) {
	            addCriterion("item_sort <=", value, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortIn(List<Integer> values) {
	            addCriterion("item_sort in", values, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortNotIn(List<Integer> values) {
	            addCriterion("item_sort not in", values, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortBetween(Integer value1, Integer value2) {
	            addCriterion("item_sort between", value1, value2, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemSortNotBetween(Integer value1, Integer value2) {
	            addCriterion("item_sort not between", value1, value2, "itemSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortIsNull() {
	            addCriterion("item_last_sort is null");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortIsNotNull() {
	            addCriterion("item_last_sort is not null");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortEqualTo(Integer value) {
	            addCriterion("item_last_sort =", value, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortNotEqualTo(Integer value) {
	            addCriterion("item_last_sort <>", value, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortGreaterThan(Integer value) {
	            addCriterion("item_last_sort >", value, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortGreaterThanOrEqualTo(Integer value) {
	            addCriterion("item_last_sort >=", value, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortLessThan(Integer value) {
	            addCriterion("item_last_sort <", value, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortLessThanOrEqualTo(Integer value) {
	            addCriterion("item_last_sort <=", value, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortIn(List<Integer> values) {
	            addCriterion("item_last_sort in", values, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortNotIn(List<Integer> values) {
	            addCriterion("item_last_sort not in", values, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortBetween(Integer value1, Integer value2) {
	            addCriterion("item_last_sort between", value1, value2, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andItemLastSortNotBetween(Integer value1, Integer value2) {
	            addCriterion("item_last_sort not between", value1, value2, "itemLastSort");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleIsNull() {
	            addCriterion("vd_title is null");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleIsNotNull() {
	            addCriterion("vd_title is not null");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleEqualTo(String value) {
	            addCriterion("vd_title =", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleNotEqualTo(String value) {
	            addCriterion("vd_title <>", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleGreaterThan(String value) {
	            addCriterion("vd_title >", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleGreaterThanOrEqualTo(String value) {
	            addCriterion("vd_title >=", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleLessThan(String value) {
	            addCriterion("vd_title <", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleLessThanOrEqualTo(String value) {
	            addCriterion("vd_title <=", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleLike(String value) {
	            addCriterion("vd_title like", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleNotLike(String value) {
	            addCriterion("vd_title not like", value, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleIn(List<String> values) {
	            addCriterion("vd_title in", values, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleNotIn(List<String> values) {
	            addCriterion("vd_title not in", values, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleBetween(String value1, String value2) {
	            addCriterion("vd_title between", value1, value2, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdTitleNotBetween(String value1, String value2) {
	            addCriterion("vd_title not between", value1, value2, "vdTitle");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountIsNull() {
	            addCriterion("vd_count is null");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountIsNotNull() {
	            addCriterion("vd_count is not null");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountEqualTo(Integer value) {
	            addCriterion("vd_count =", value, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountNotEqualTo(Integer value) {
	            addCriterion("vd_count <>", value, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountGreaterThan(Integer value) {
	            addCriterion("vd_count >", value, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountGreaterThanOrEqualTo(Integer value) {
	            addCriterion("vd_count >=", value, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountLessThan(Integer value) {
	            addCriterion("vd_count <", value, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountLessThanOrEqualTo(Integer value) {
	            addCriterion("vd_count <=", value, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountIn(List<Integer> values) {
	            addCriterion("vd_count in", values, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountNotIn(List<Integer> values) {
	            addCriterion("vd_count not in", values, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountBetween(Integer value1, Integer value2) {
	            addCriterion("vd_count between", value1, value2, "vdCount");
	            return (Criteria) this;
	        }

	        public Criteria andVdCountNotBetween(Integer value1, Integer value2) {
	            addCriterion("vd_count not between", value1, value2, "vdCount");
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