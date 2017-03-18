package com.model.po;

import java.util.ArrayList;
import java.util.List;

public class DxExchangeListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DxExchangeListExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNull() {
            addCriterion("serial_no is null");
            return (Criteria) this;
        }

        public Criteria andSerialNoIsNotNull() {
            addCriterion("serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andSerialNoEqualTo(String value) {
            addCriterion("serial_no =", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotEqualTo(String value) {
            addCriterion("serial_no <>", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThan(String value) {
            addCriterion("serial_no >", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("serial_no >=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThan(String value) {
            addCriterion("serial_no <", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLessThanOrEqualTo(String value) {
            addCriterion("serial_no <=", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoLike(String value) {
            addCriterion("serial_no like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotLike(String value) {
            addCriterion("serial_no not like", value, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoIn(List<String> values) {
            addCriterion("serial_no in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotIn(List<String> values) {
            addCriterion("serial_no not in", values, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoBetween(String value1, String value2) {
            addCriterion("serial_no between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andSerialNoNotBetween(String value1, String value2) {
            addCriterion("serial_no not between", value1, value2, "serialNo");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEquiNumIsNull() {
            addCriterion("equi_num is null");
            return (Criteria) this;
        }

        public Criteria andEquiNumIsNotNull() {
            addCriterion("equi_num is not null");
            return (Criteria) this;
        }

        public Criteria andEquiNumEqualTo(String value) {
            addCriterion("equi_num =", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumNotEqualTo(String value) {
            addCriterion("equi_num <>", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumGreaterThan(String value) {
            addCriterion("equi_num >", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumGreaterThanOrEqualTo(String value) {
            addCriterion("equi_num >=", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumLessThan(String value) {
            addCriterion("equi_num <", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumLessThanOrEqualTo(String value) {
            addCriterion("equi_num <=", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumLike(String value) {
            addCriterion("equi_num like", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumNotLike(String value) {
            addCriterion("equi_num not like", value, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumIn(List<String> values) {
            addCriterion("equi_num in", values, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumNotIn(List<String> values) {
            addCriterion("equi_num not in", values, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumBetween(String value1, String value2) {
            addCriterion("equi_num between", value1, value2, "equiNum");
            return (Criteria) this;
        }

        public Criteria andEquiNumNotBetween(String value1, String value2) {
            addCriterion("equi_num not between", value1, value2, "equiNum");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNull() {
            addCriterion("result_code is null");
            return (Criteria) this;
        }

        public Criteria andResultCodeIsNotNull() {
            addCriterion("result_code is not null");
            return (Criteria) this;
        }

        public Criteria andResultCodeEqualTo(String value) {
            addCriterion("result_code =", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotEqualTo(String value) {
            addCriterion("result_code <>", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThan(String value) {
            addCriterion("result_code >", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("result_code >=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThan(String value) {
            addCriterion("result_code <", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLessThanOrEqualTo(String value) {
            addCriterion("result_code <=", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeLike(String value) {
            addCriterion("result_code like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotLike(String value) {
            addCriterion("result_code not like", value, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeIn(List<String> values) {
            addCriterion("result_code in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotIn(List<String> values) {
            addCriterion("result_code not in", values, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeBetween(String value1, String value2) {
            addCriterion("result_code between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andResultCodeNotBetween(String value1, String value2) {
            addCriterion("result_code not between", value1, value2, "resultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIsNull() {
            addCriterion("fault_code is null");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIsNotNull() {
            addCriterion("fault_code is not null");
            return (Criteria) this;
        }

        public Criteria andFaultCodeEqualTo(String value) {
            addCriterion("fault_code =", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotEqualTo(String value) {
            addCriterion("fault_code <>", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeGreaterThan(String value) {
            addCriterion("fault_code >", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeGreaterThanOrEqualTo(String value) {
            addCriterion("fault_code >=", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLessThan(String value) {
            addCriterion("fault_code <", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLessThanOrEqualTo(String value) {
            addCriterion("fault_code <=", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeLike(String value) {
            addCriterion("fault_code like", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotLike(String value) {
            addCriterion("fault_code not like", value, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeIn(List<String> values) {
            addCriterion("fault_code in", values, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotIn(List<String> values) {
            addCriterion("fault_code not in", values, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeBetween(String value1, String value2) {
            addCriterion("fault_code between", value1, value2, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultCodeNotBetween(String value1, String value2) {
            addCriterion("fault_code not between", value1, value2, "faultCode");
            return (Criteria) this;
        }

        public Criteria andFaultStringIsNull() {
            addCriterion("fault_string is null");
            return (Criteria) this;
        }

        public Criteria andFaultStringIsNotNull() {
            addCriterion("fault_string is not null");
            return (Criteria) this;
        }

        public Criteria andFaultStringEqualTo(String value) {
            addCriterion("fault_string =", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringNotEqualTo(String value) {
            addCriterion("fault_string <>", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringGreaterThan(String value) {
            addCriterion("fault_string >", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringGreaterThanOrEqualTo(String value) {
            addCriterion("fault_string >=", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringLessThan(String value) {
            addCriterion("fault_string <", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringLessThanOrEqualTo(String value) {
            addCriterion("fault_string <=", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringLike(String value) {
            addCriterion("fault_string like", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringNotLike(String value) {
            addCriterion("fault_string not like", value, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringIn(List<String> values) {
            addCriterion("fault_string in", values, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringNotIn(List<String> values) {
            addCriterion("fault_string not in", values, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringBetween(String value1, String value2) {
            addCriterion("fault_string between", value1, value2, "faultString");
            return (Criteria) this;
        }

        public Criteria andFaultStringNotBetween(String value1, String value2) {
            addCriterion("fault_string not between", value1, value2, "faultString");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNull() {
            addCriterion("err_code is null");
            return (Criteria) this;
        }

        public Criteria andErrCodeIsNotNull() {
            addCriterion("err_code is not null");
            return (Criteria) this;
        }

        public Criteria andErrCodeEqualTo(String value) {
            addCriterion("err_code =", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotEqualTo(String value) {
            addCriterion("err_code <>", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThan(String value) {
            addCriterion("err_code >", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("err_code >=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThan(String value) {
            addCriterion("err_code <", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLessThanOrEqualTo(String value) {
            addCriterion("err_code <=", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeLike(String value) {
            addCriterion("err_code like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotLike(String value) {
            addCriterion("err_code not like", value, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeIn(List<String> values) {
            addCriterion("err_code in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotIn(List<String> values) {
            addCriterion("err_code not in", values, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeBetween(String value1, String value2) {
            addCriterion("err_code between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrCodeNotBetween(String value1, String value2) {
            addCriterion("err_code not between", value1, value2, "errCode");
            return (Criteria) this;
        }

        public Criteria andErrDescIsNull() {
            addCriterion("err_desc is null");
            return (Criteria) this;
        }

        public Criteria andErrDescIsNotNull() {
            addCriterion("err_desc is not null");
            return (Criteria) this;
        }

        public Criteria andErrDescEqualTo(String value) {
            addCriterion("err_desc =", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotEqualTo(String value) {
            addCriterion("err_desc <>", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescGreaterThan(String value) {
            addCriterion("err_desc >", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescGreaterThanOrEqualTo(String value) {
            addCriterion("err_desc >=", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescLessThan(String value) {
            addCriterion("err_desc <", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescLessThanOrEqualTo(String value) {
            addCriterion("err_desc <=", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescLike(String value) {
            addCriterion("err_desc like", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotLike(String value) {
            addCriterion("err_desc not like", value, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescIn(List<String> values) {
            addCriterion("err_desc in", values, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotIn(List<String> values) {
            addCriterion("err_desc not in", values, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescBetween(String value1, String value2) {
            addCriterion("err_desc between", value1, value2, "errDesc");
            return (Criteria) this;
        }

        public Criteria andErrDescNotBetween(String value1, String value2) {
            addCriterion("err_desc not between", value1, value2, "errDesc");
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