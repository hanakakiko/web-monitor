package com.dingjiangying.webmonitor.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LogPoExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andProbeIdIsNull() {
            addCriterion("probe_id is null");
            return (Criteria) this;
        }

        public Criteria andProbeIdIsNotNull() {
            addCriterion("probe_id is not null");
            return (Criteria) this;
        }

        public Criteria andProbeIdEqualTo(Integer value) {
            addCriterion("probe_id =", value, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdNotEqualTo(Integer value) {
            addCriterion("probe_id <>", value, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdGreaterThan(Integer value) {
            addCriterion("probe_id >", value, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("probe_id >=", value, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdLessThan(Integer value) {
            addCriterion("probe_id <", value, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdLessThanOrEqualTo(Integer value) {
            addCriterion("probe_id <=", value, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdIn(List<Integer> values) {
            addCriterion("probe_id in", values, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdNotIn(List<Integer> values) {
            addCriterion("probe_id not in", values, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdBetween(Integer value1, Integer value2) {
            addCriterion("probe_id between", value1, value2, "probeId");
            return (Criteria) this;
        }

        public Criteria andProbeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("probe_id not between", value1, value2, "probeId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Integer value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Integer value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Integer value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Integer value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Integer> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Integer> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Integer value1, Integer value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Date value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Date value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Date value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Date value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Date value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Date value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Date> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Date> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Date value1, Date value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Date value1, Date value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andHasHandledIsNull() {
            addCriterion("has_handled is null");
            return (Criteria) this;
        }

        public Criteria andHasHandledIsNotNull() {
            addCriterion("has_handled is not null");
            return (Criteria) this;
        }

        public Criteria andHasHandledEqualTo(Integer value) {
            addCriterion("has_handled =", value, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledNotEqualTo(Integer value) {
            addCriterion("has_handled <>", value, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledGreaterThan(Integer value) {
            addCriterion("has_handled >", value, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_handled >=", value, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledLessThan(Integer value) {
            addCriterion("has_handled <", value, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledLessThanOrEqualTo(Integer value) {
            addCriterion("has_handled <=", value, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledIn(List<Integer> values) {
            addCriterion("has_handled in", values, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledNotIn(List<Integer> values) {
            addCriterion("has_handled not in", values, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledBetween(Integer value1, Integer value2) {
            addCriterion("has_handled between", value1, value2, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andHasHandledNotBetween(Integer value1, Integer value2) {
            addCriterion("has_handled not between", value1, value2, "hasHandled");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNull() {
            addCriterion("total_time is null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIsNotNull() {
            addCriterion("total_time is not null");
            return (Criteria) this;
        }

        public Criteria andTotalTimeEqualTo(Long value) {
            addCriterion("total_time =", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotEqualTo(Long value) {
            addCriterion("total_time <>", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThan(Long value) {
            addCriterion("total_time >", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("total_time >=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThan(Long value) {
            addCriterion("total_time <", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeLessThanOrEqualTo(Long value) {
            addCriterion("total_time <=", value, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeIn(List<Long> values) {
            addCriterion("total_time in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotIn(List<Long> values) {
            addCriterion("total_time not in", values, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeBetween(Long value1, Long value2) {
            addCriterion("total_time between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andTotalTimeNotBetween(Long value1, Long value2) {
            addCriterion("total_time not between", value1, value2, "totalTime");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNull() {
            addCriterion("error_code is null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIsNotNull() {
            addCriterion("error_code is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCodeEqualTo(Integer value) {
            addCriterion("error_code =", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotEqualTo(Integer value) {
            addCriterion("error_code <>", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThan(Integer value) {
            addCriterion("error_code >", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("error_code >=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThan(Integer value) {
            addCriterion("error_code <", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeLessThanOrEqualTo(Integer value) {
            addCriterion("error_code <=", value, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeIn(List<Integer> values) {
            addCriterion("error_code in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotIn(List<Integer> values) {
            addCriterion("error_code not in", values, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeBetween(Integer value1, Integer value2) {
            addCriterion("error_code between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andErrorCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("error_code not between", value1, value2, "errorCode");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathIsNull() {
            addCriterion("script_output_path is null");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathIsNotNull() {
            addCriterion("script_output_path is not null");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathEqualTo(String value) {
            addCriterion("script_output_path =", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathNotEqualTo(String value) {
            addCriterion("script_output_path <>", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathGreaterThan(String value) {
            addCriterion("script_output_path >", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathGreaterThanOrEqualTo(String value) {
            addCriterion("script_output_path >=", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathLessThan(String value) {
            addCriterion("script_output_path <", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathLessThanOrEqualTo(String value) {
            addCriterion("script_output_path <=", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathLike(String value) {
            addCriterion("script_output_path like", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathNotLike(String value) {
            addCriterion("script_output_path not like", value, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathIn(List<String> values) {
            addCriterion("script_output_path in", values, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathNotIn(List<String> values) {
            addCriterion("script_output_path not in", values, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathBetween(String value1, String value2) {
            addCriterion("script_output_path between", value1, value2, "scriptOutputPath");
            return (Criteria) this;
        }

        public Criteria andScriptOutputPathNotBetween(String value1, String value2) {
            addCriterion("script_output_path not between", value1, value2, "scriptOutputPath");
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