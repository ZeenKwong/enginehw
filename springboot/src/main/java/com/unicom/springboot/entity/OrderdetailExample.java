package com.unicom.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderdetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderdetailExample() {
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

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Integer value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Integer value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Integer value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Integer value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Integer value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Integer> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Integer> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Integer value1, Integer value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidIsNull() {
            addCriterion("detail_orderid is null");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidIsNotNull() {
            addCriterion("detail_orderid is not null");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidEqualTo(Integer value) {
            addCriterion("detail_orderid =", value, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidNotEqualTo(Integer value) {
            addCriterion("detail_orderid <>", value, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidGreaterThan(Integer value) {
            addCriterion("detail_orderid >", value, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_orderid >=", value, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidLessThan(Integer value) {
            addCriterion("detail_orderid <", value, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidLessThanOrEqualTo(Integer value) {
            addCriterion("detail_orderid <=", value, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidIn(List<Integer> values) {
            addCriterion("detail_orderid in", values, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidNotIn(List<Integer> values) {
            addCriterion("detail_orderid not in", values, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidBetween(Integer value1, Integer value2) {
            addCriterion("detail_orderid between", value1, value2, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailOrderidNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_orderid not between", value1, value2, "detailOrderid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidIsNull() {
            addCriterion("detail_itemid is null");
            return (Criteria) this;
        }

        public Criteria andDetailItemidIsNotNull() {
            addCriterion("detail_itemid is not null");
            return (Criteria) this;
        }

        public Criteria andDetailItemidEqualTo(Integer value) {
            addCriterion("detail_itemid =", value, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidNotEqualTo(Integer value) {
            addCriterion("detail_itemid <>", value, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidGreaterThan(Integer value) {
            addCriterion("detail_itemid >", value, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_itemid >=", value, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidLessThan(Integer value) {
            addCriterion("detail_itemid <", value, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidLessThanOrEqualTo(Integer value) {
            addCriterion("detail_itemid <=", value, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidIn(List<Integer> values) {
            addCriterion("detail_itemid in", values, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidNotIn(List<Integer> values) {
            addCriterion("detail_itemid not in", values, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidBetween(Integer value1, Integer value2) {
            addCriterion("detail_itemid between", value1, value2, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemidNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_itemid not between", value1, value2, "detailItemid");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumIsNull() {
            addCriterion("detail_itemNum is null");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumIsNotNull() {
            addCriterion("detail_itemNum is not null");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumEqualTo(String value) {
            addCriterion("detail_itemNum =", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumNotEqualTo(String value) {
            addCriterion("detail_itemNum <>", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumGreaterThan(String value) {
            addCriterion("detail_itemNum >", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumGreaterThanOrEqualTo(String value) {
            addCriterion("detail_itemNum >=", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumLessThan(String value) {
            addCriterion("detail_itemNum <", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumLessThanOrEqualTo(String value) {
            addCriterion("detail_itemNum <=", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumLike(String value) {
            addCriterion("detail_itemNum like", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumNotLike(String value) {
            addCriterion("detail_itemNum not like", value, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumIn(List<String> values) {
            addCriterion("detail_itemNum in", values, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumNotIn(List<String> values) {
            addCriterion("detail_itemNum not in", values, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumBetween(String value1, String value2) {
            addCriterion("detail_itemNum between", value1, value2, "detailItemnum");
            return (Criteria) this;
        }

        public Criteria andDetailItemnumNotBetween(String value1, String value2) {
            addCriterion("detail_itemNum not between", value1, value2, "detailItemnum");
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