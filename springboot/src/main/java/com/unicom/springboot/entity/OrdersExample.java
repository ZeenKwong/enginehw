package com.unicom.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNull() {
            addCriterion("order_userid is null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIsNotNull() {
            addCriterion("order_userid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUseridEqualTo(Integer value) {
            addCriterion("order_userid =", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotEqualTo(Integer value) {
            addCriterion("order_userid <>", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThan(Integer value) {
            addCriterion("order_userid >", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_userid >=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThan(Integer value) {
            addCriterion("order_userid <", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridLessThanOrEqualTo(Integer value) {
            addCriterion("order_userid <=", value, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridIn(List<Integer> values) {
            addCriterion("order_userid in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotIn(List<Integer> values) {
            addCriterion("order_userid not in", values, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridBetween(Integer value1, Integer value2) {
            addCriterion("order_userid between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("order_userid not between", value1, value2, "orderUserid");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountIsNull() {
            addCriterion("order_goodscount is null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountIsNotNull() {
            addCriterion("order_goodscount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountEqualTo(String value) {
            addCriterion("order_goodscount =", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountNotEqualTo(String value) {
            addCriterion("order_goodscount <>", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountGreaterThan(String value) {
            addCriterion("order_goodscount >", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountGreaterThanOrEqualTo(String value) {
            addCriterion("order_goodscount >=", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountLessThan(String value) {
            addCriterion("order_goodscount <", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountLessThanOrEqualTo(String value) {
            addCriterion("order_goodscount <=", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountLike(String value) {
            addCriterion("order_goodscount like", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountNotLike(String value) {
            addCriterion("order_goodscount not like", value, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountIn(List<String> values) {
            addCriterion("order_goodscount in", values, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountNotIn(List<String> values) {
            addCriterion("order_goodscount not in", values, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountBetween(String value1, String value2) {
            addCriterion("order_goodscount between", value1, value2, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andOrderGoodscountNotBetween(String value1, String value2) {
            addCriterion("order_goodscount not between", value1, value2, "orderGoodscount");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andOrderNoteIsNull() {
            addCriterion("order_note is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoteIsNotNull() {
            addCriterion("order_note is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoteEqualTo(String value) {
            addCriterion("order_note =", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotEqualTo(String value) {
            addCriterion("order_note <>", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteGreaterThan(String value) {
            addCriterion("order_note >", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteGreaterThanOrEqualTo(String value) {
            addCriterion("order_note >=", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteLessThan(String value) {
            addCriterion("order_note <", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteLessThanOrEqualTo(String value) {
            addCriterion("order_note <=", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteLike(String value) {
            addCriterion("order_note like", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotLike(String value) {
            addCriterion("order_note not like", value, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteIn(List<String> values) {
            addCriterion("order_note in", values, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotIn(List<String> values) {
            addCriterion("order_note not in", values, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteBetween(String value1, String value2) {
            addCriterion("order_note between", value1, value2, "orderNote");
            return (Criteria) this;
        }

        public Criteria andOrderNoteNotBetween(String value1, String value2) {
            addCriterion("order_note not between", value1, value2, "orderNote");
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