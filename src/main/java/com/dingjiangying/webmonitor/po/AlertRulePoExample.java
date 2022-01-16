package com.dingjiangying.webmonitor.po;

import java.util.ArrayList;
import java.util.List;

public class AlertRulePoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlertRulePoExample() {
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

        public Criteria andAlertIdIsNull() {
            addCriterion("alert_id is null");
            return (Criteria) this;
        }

        public Criteria andAlertIdIsNotNull() {
            addCriterion("alert_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlertIdEqualTo(Integer value) {
            addCriterion("alert_id =", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdNotEqualTo(Integer value) {
            addCriterion("alert_id <>", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdGreaterThan(Integer value) {
            addCriterion("alert_id >", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("alert_id >=", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdLessThan(Integer value) {
            addCriterion("alert_id <", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdLessThanOrEqualTo(Integer value) {
            addCriterion("alert_id <=", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdIn(List<Integer> values) {
            addCriterion("alert_id in", values, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdNotIn(List<Integer> values) {
            addCriterion("alert_id not in", values, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdBetween(Integer value1, Integer value2) {
            addCriterion("alert_id between", value1, value2, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdNotBetween(Integer value1, Integer value2) {
            addCriterion("alert_id not between", value1, value2, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertNameIsNull() {
            addCriterion("alert_name is null");
            return (Criteria) this;
        }

        public Criteria andAlertNameIsNotNull() {
            addCriterion("alert_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlertNameEqualTo(String value) {
            addCriterion("alert_name =", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameNotEqualTo(String value) {
            addCriterion("alert_name <>", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameGreaterThan(String value) {
            addCriterion("alert_name >", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameGreaterThanOrEqualTo(String value) {
            addCriterion("alert_name >=", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameLessThan(String value) {
            addCriterion("alert_name <", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameLessThanOrEqualTo(String value) {
            addCriterion("alert_name <=", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameLike(String value) {
            addCriterion("alert_name like", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameNotLike(String value) {
            addCriterion("alert_name not like", value, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameIn(List<String> values) {
            addCriterion("alert_name in", values, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameNotIn(List<String> values) {
            addCriterion("alert_name not in", values, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameBetween(String value1, String value2) {
            addCriterion("alert_name between", value1, value2, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertNameNotBetween(String value1, String value2) {
            addCriterion("alert_name not between", value1, value2, "alertName");
            return (Criteria) this;
        }

        public Criteria andAlertTypeIsNull() {
            addCriterion("alert_type is null");
            return (Criteria) this;
        }

        public Criteria andAlertTypeIsNotNull() {
            addCriterion("alert_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlertTypeEqualTo(Integer value) {
            addCriterion("alert_type =", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeNotEqualTo(Integer value) {
            addCriterion("alert_type <>", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeGreaterThan(Integer value) {
            addCriterion("alert_type >", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("alert_type >=", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeLessThan(Integer value) {
            addCriterion("alert_type <", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeLessThanOrEqualTo(Integer value) {
            addCriterion("alert_type <=", value, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeIn(List<Integer> values) {
            addCriterion("alert_type in", values, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeNotIn(List<Integer> values) {
            addCriterion("alert_type not in", values, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeBetween(Integer value1, Integer value2) {
            addCriterion("alert_type between", value1, value2, "alertType");
            return (Criteria) this;
        }

        public Criteria andAlertTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("alert_type not between", value1, value2, "alertType");
            return (Criteria) this;
        }

        public Criteria andTaskCountIsNull() {
            addCriterion("task_count is null");
            return (Criteria) this;
        }

        public Criteria andTaskCountIsNotNull() {
            addCriterion("task_count is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCountEqualTo(Integer value) {
            addCriterion("task_count =", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotEqualTo(Integer value) {
            addCriterion("task_count <>", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountGreaterThan(Integer value) {
            addCriterion("task_count >", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_count >=", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountLessThan(Integer value) {
            addCriterion("task_count <", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountLessThanOrEqualTo(Integer value) {
            addCriterion("task_count <=", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountIn(List<Integer> values) {
            addCriterion("task_count in", values, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotIn(List<Integer> values) {
            addCriterion("task_count not in", values, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountBetween(Integer value1, Integer value2) {
            addCriterion("task_count between", value1, value2, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotBetween(Integer value1, Integer value2) {
            addCriterion("task_count not between", value1, value2, "taskCount");
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