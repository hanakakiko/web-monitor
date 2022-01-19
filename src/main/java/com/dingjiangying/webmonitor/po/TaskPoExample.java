package com.dingjiangying.webmonitor.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskPoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskPoExample() {
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

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIsNull() {
            addCriterion("task_url is null");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIsNotNull() {
            addCriterion("task_url is not null");
            return (Criteria) this;
        }

        public Criteria andTaskUrlEqualTo(String value) {
            addCriterion("task_url =", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotEqualTo(String value) {
            addCriterion("task_url <>", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlGreaterThan(String value) {
            addCriterion("task_url >", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlGreaterThanOrEqualTo(String value) {
            addCriterion("task_url >=", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLessThan(String value) {
            addCriterion("task_url <", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLessThanOrEqualTo(String value) {
            addCriterion("task_url <=", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlLike(String value) {
            addCriterion("task_url like", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotLike(String value) {
            addCriterion("task_url not like", value, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlIn(List<String> values) {
            addCriterion("task_url in", values, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotIn(List<String> values) {
            addCriterion("task_url not in", values, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlBetween(String value1, String value2) {
            addCriterion("task_url between", value1, value2, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andTaskUrlNotBetween(String value1, String value2) {
            addCriterion("task_url not between", value1, value2, "taskUrl");
            return (Criteria) this;
        }

        public Criteria andCityListIsNull() {
            addCriterion("city_list is null");
            return (Criteria) this;
        }

        public Criteria andCityListIsNotNull() {
            addCriterion("city_list is not null");
            return (Criteria) this;
        }

        public Criteria andCityListEqualTo(String value) {
            addCriterion("city_list =", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListNotEqualTo(String value) {
            addCriterion("city_list <>", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListGreaterThan(String value) {
            addCriterion("city_list >", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListGreaterThanOrEqualTo(String value) {
            addCriterion("city_list >=", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListLessThan(String value) {
            addCriterion("city_list <", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListLessThanOrEqualTo(String value) {
            addCriterion("city_list <=", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListLike(String value) {
            addCriterion("city_list like", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListNotLike(String value) {
            addCriterion("city_list not like", value, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListIn(List<String> values) {
            addCriterion("city_list in", values, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListNotIn(List<String> values) {
            addCriterion("city_list not in", values, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListBetween(String value1, String value2) {
            addCriterion("city_list between", value1, value2, "cityList");
            return (Criteria) this;
        }

        public Criteria andCityListNotBetween(String value1, String value2) {
            addCriterion("city_list not between", value1, value2, "cityList");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andHasHuddledIsNull() {
            addCriterion("has_huddled is null");
            return (Criteria) this;
        }

        public Criteria andHasHuddledIsNotNull() {
            addCriterion("has_huddled is not null");
            return (Criteria) this;
        }

        public Criteria andHasHuddledEqualTo(Integer value) {
            addCriterion("has_huddled =", value, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledNotEqualTo(Integer value) {
            addCriterion("has_huddled <>", value, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledGreaterThan(Integer value) {
            addCriterion("has_huddled >", value, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_huddled >=", value, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledLessThan(Integer value) {
            addCriterion("has_huddled <", value, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledLessThanOrEqualTo(Integer value) {
            addCriterion("has_huddled <=", value, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledIn(List<Integer> values) {
            addCriterion("has_huddled in", values, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledNotIn(List<Integer> values) {
            addCriterion("has_huddled not in", values, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledBetween(Integer value1, Integer value2) {
            addCriterion("has_huddled between", value1, value2, "hasHuddled");
            return (Criteria) this;
        }

        public Criteria andHasHuddledNotBetween(Integer value1, Integer value2) {
            addCriterion("has_huddled not between", value1, value2, "hasHuddled");
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

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAlertIdIsNull() {
            addCriterion("alert_id is null");
            return (Criteria) this;
        }

        public Criteria andAlertIdIsNotNull() {
            addCriterion("alert_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlertIdEqualTo(String value) {
            addCriterion("alert_id =", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdNotEqualTo(String value) {
            addCriterion("alert_id <>", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdGreaterThan(String value) {
            addCriterion("alert_id >", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdGreaterThanOrEqualTo(String value) {
            addCriterion("alert_id >=", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdLessThan(String value) {
            addCriterion("alert_id <", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdLessThanOrEqualTo(String value) {
            addCriterion("alert_id <=", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdLike(String value) {
            addCriterion("alert_id like", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdNotLike(String value) {
            addCriterion("alert_id not like", value, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdIn(List<String> values) {
            addCriterion("alert_id in", values, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdNotIn(List<String> values) {
            addCriterion("alert_id not in", values, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdBetween(String value1, String value2) {
            addCriterion("alert_id between", value1, value2, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertIdNotBetween(String value1, String value2) {
            addCriterion("alert_id not between", value1, value2, "alertId");
            return (Criteria) this;
        }

        public Criteria andAlertCountIsNull() {
            addCriterion("alert_count is null");
            return (Criteria) this;
        }

        public Criteria andAlertCountIsNotNull() {
            addCriterion("alert_count is not null");
            return (Criteria) this;
        }

        public Criteria andAlertCountEqualTo(Integer value) {
            addCriterion("alert_count =", value, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountNotEqualTo(Integer value) {
            addCriterion("alert_count <>", value, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountGreaterThan(Integer value) {
            addCriterion("alert_count >", value, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("alert_count >=", value, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountLessThan(Integer value) {
            addCriterion("alert_count <", value, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountLessThanOrEqualTo(Integer value) {
            addCriterion("alert_count <=", value, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountIn(List<Integer> values) {
            addCriterion("alert_count in", values, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountNotIn(List<Integer> values) {
            addCriterion("alert_count not in", values, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountBetween(Integer value1, Integer value2) {
            addCriterion("alert_count between", value1, value2, "alertCount");
            return (Criteria) this;
        }

        public Criteria andAlertCountNotBetween(Integer value1, Integer value2) {
            addCriterion("alert_count not between", value1, value2, "alertCount");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeIsNull() {
            addCriterion("umpdate_time is null");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeIsNotNull() {
            addCriterion("umpdate_time is not null");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeEqualTo(Date value) {
            addCriterion("umpdate_time =", value, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeNotEqualTo(Date value) {
            addCriterion("umpdate_time <>", value, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeGreaterThan(Date value) {
            addCriterion("umpdate_time >", value, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("umpdate_time >=", value, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeLessThan(Date value) {
            addCriterion("umpdate_time <", value, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("umpdate_time <=", value, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeIn(List<Date> values) {
            addCriterion("umpdate_time in", values, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeNotIn(List<Date> values) {
            addCriterion("umpdate_time not in", values, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeBetween(Date value1, Date value2) {
            addCriterion("umpdate_time between", value1, value2, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andUmpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("umpdate_time not between", value1, value2, "umpdateTime");
            return (Criteria) this;
        }

        public Criteria andScriptPathIsNull() {
            addCriterion("script_path is null");
            return (Criteria) this;
        }

        public Criteria andScriptPathIsNotNull() {
            addCriterion("script_path is not null");
            return (Criteria) this;
        }

        public Criteria andScriptPathEqualTo(String value) {
            addCriterion("script_path =", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathNotEqualTo(String value) {
            addCriterion("script_path <>", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathGreaterThan(String value) {
            addCriterion("script_path >", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathGreaterThanOrEqualTo(String value) {
            addCriterion("script_path >=", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathLessThan(String value) {
            addCriterion("script_path <", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathLessThanOrEqualTo(String value) {
            addCriterion("script_path <=", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathLike(String value) {
            addCriterion("script_path like", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathNotLike(String value) {
            addCriterion("script_path not like", value, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathIn(List<String> values) {
            addCriterion("script_path in", values, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathNotIn(List<String> values) {
            addCriterion("script_path not in", values, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathBetween(String value1, String value2) {
            addCriterion("script_path between", value1, value2, "scriptPath");
            return (Criteria) this;
        }

        public Criteria andScriptPathNotBetween(String value1, String value2) {
            addCriterion("script_path not between", value1, value2, "scriptPath");
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