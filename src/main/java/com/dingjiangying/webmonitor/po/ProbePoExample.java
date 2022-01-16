package com.dingjiangying.webmonitor.po;

import java.util.ArrayList;
import java.util.List;

public class ProbePoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProbePoExample() {
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

        public Criteria andProbeNameIsNull() {
            addCriterion("probe_name is null");
            return (Criteria) this;
        }

        public Criteria andProbeNameIsNotNull() {
            addCriterion("probe_name is not null");
            return (Criteria) this;
        }

        public Criteria andProbeNameEqualTo(String value) {
            addCriterion("probe_name =", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameNotEqualTo(String value) {
            addCriterion("probe_name <>", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameGreaterThan(String value) {
            addCriterion("probe_name >", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameGreaterThanOrEqualTo(String value) {
            addCriterion("probe_name >=", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameLessThan(String value) {
            addCriterion("probe_name <", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameLessThanOrEqualTo(String value) {
            addCriterion("probe_name <=", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameLike(String value) {
            addCriterion("probe_name like", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameNotLike(String value) {
            addCriterion("probe_name not like", value, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameIn(List<String> values) {
            addCriterion("probe_name in", values, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameNotIn(List<String> values) {
            addCriterion("probe_name not in", values, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameBetween(String value1, String value2) {
            addCriterion("probe_name between", value1, value2, "probeName");
            return (Criteria) this;
        }

        public Criteria andProbeNameNotBetween(String value1, String value2) {
            addCriterion("probe_name not between", value1, value2, "probeName");
            return (Criteria) this;
        }

        public Criteria andSshPwdIsNull() {
            addCriterion("ssh_pwd is null");
            return (Criteria) this;
        }

        public Criteria andSshPwdIsNotNull() {
            addCriterion("ssh_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andSshPwdEqualTo(String value) {
            addCriterion("ssh_pwd =", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdNotEqualTo(String value) {
            addCriterion("ssh_pwd <>", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdGreaterThan(String value) {
            addCriterion("ssh_pwd >", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdGreaterThanOrEqualTo(String value) {
            addCriterion("ssh_pwd >=", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdLessThan(String value) {
            addCriterion("ssh_pwd <", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdLessThanOrEqualTo(String value) {
            addCriterion("ssh_pwd <=", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdLike(String value) {
            addCriterion("ssh_pwd like", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdNotLike(String value) {
            addCriterion("ssh_pwd not like", value, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdIn(List<String> values) {
            addCriterion("ssh_pwd in", values, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdNotIn(List<String> values) {
            addCriterion("ssh_pwd not in", values, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdBetween(String value1, String value2) {
            addCriterion("ssh_pwd between", value1, value2, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andSshPwdNotBetween(String value1, String value2) {
            addCriterion("ssh_pwd not between", value1, value2, "sshPwd");
            return (Criteria) this;
        }

        public Criteria andProbeTypeIsNull() {
            addCriterion("probe_type is null");
            return (Criteria) this;
        }

        public Criteria andProbeTypeIsNotNull() {
            addCriterion("probe_type is not null");
            return (Criteria) this;
        }

        public Criteria andProbeTypeEqualTo(Integer value) {
            addCriterion("probe_type =", value, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeNotEqualTo(Integer value) {
            addCriterion("probe_type <>", value, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeGreaterThan(Integer value) {
            addCriterion("probe_type >", value, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("probe_type >=", value, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeLessThan(Integer value) {
            addCriterion("probe_type <", value, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("probe_type <=", value, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeIn(List<Integer> values) {
            addCriterion("probe_type in", values, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeNotIn(List<Integer> values) {
            addCriterion("probe_type not in", values, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeBetween(Integer value1, Integer value2) {
            addCriterion("probe_type between", value1, value2, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("probe_type not between", value1, value2, "probeType");
            return (Criteria) this;
        }

        public Criteria andProbeStatusIsNull() {
            addCriterion("probe_status is null");
            return (Criteria) this;
        }

        public Criteria andProbeStatusIsNotNull() {
            addCriterion("probe_status is not null");
            return (Criteria) this;
        }

        public Criteria andProbeStatusEqualTo(Integer value) {
            addCriterion("probe_status =", value, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusNotEqualTo(Integer value) {
            addCriterion("probe_status <>", value, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusGreaterThan(Integer value) {
            addCriterion("probe_status >", value, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("probe_status >=", value, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusLessThan(Integer value) {
            addCriterion("probe_status <", value, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("probe_status <=", value, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusIn(List<Integer> values) {
            addCriterion("probe_status in", values, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusNotIn(List<Integer> values) {
            addCriterion("probe_status not in", values, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusBetween(Integer value1, Integer value2) {
            addCriterion("probe_status between", value1, value2, "probeStatus");
            return (Criteria) this;
        }

        public Criteria andProbeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("probe_status not between", value1, value2, "probeStatus");
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

        public Criteria andTaskListIsNull() {
            addCriterion("task_list is null");
            return (Criteria) this;
        }

        public Criteria andTaskListIsNotNull() {
            addCriterion("task_list is not null");
            return (Criteria) this;
        }

        public Criteria andTaskListEqualTo(String value) {
            addCriterion("task_list =", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListNotEqualTo(String value) {
            addCriterion("task_list <>", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListGreaterThan(String value) {
            addCriterion("task_list >", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListGreaterThanOrEqualTo(String value) {
            addCriterion("task_list >=", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListLessThan(String value) {
            addCriterion("task_list <", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListLessThanOrEqualTo(String value) {
            addCriterion("task_list <=", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListLike(String value) {
            addCriterion("task_list like", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListNotLike(String value) {
            addCriterion("task_list not like", value, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListIn(List<String> values) {
            addCriterion("task_list in", values, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListNotIn(List<String> values) {
            addCriterion("task_list not in", values, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListBetween(String value1, String value2) {
            addCriterion("task_list between", value1, value2, "taskList");
            return (Criteria) this;
        }

        public Criteria andTaskListNotBetween(String value1, String value2) {
            addCriterion("task_list not between", value1, value2, "taskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListIsNull() {
            addCriterion("active_task_list is null");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListIsNotNull() {
            addCriterion("active_task_list is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListEqualTo(String value) {
            addCriterion("active_task_list =", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListNotEqualTo(String value) {
            addCriterion("active_task_list <>", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListGreaterThan(String value) {
            addCriterion("active_task_list >", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListGreaterThanOrEqualTo(String value) {
            addCriterion("active_task_list >=", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListLessThan(String value) {
            addCriterion("active_task_list <", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListLessThanOrEqualTo(String value) {
            addCriterion("active_task_list <=", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListLike(String value) {
            addCriterion("active_task_list like", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListNotLike(String value) {
            addCriterion("active_task_list not like", value, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListIn(List<String> values) {
            addCriterion("active_task_list in", values, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListNotIn(List<String> values) {
            addCriterion("active_task_list not in", values, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListBetween(String value1, String value2) {
            addCriterion("active_task_list between", value1, value2, "activeTaskList");
            return (Criteria) this;
        }

        public Criteria andActiveTaskListNotBetween(String value1, String value2) {
            addCriterion("active_task_list not between", value1, value2, "activeTaskList");
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