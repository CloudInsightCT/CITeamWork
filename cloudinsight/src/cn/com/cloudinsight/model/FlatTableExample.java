package cn.com.cloudinsight.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FlatTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlatTableExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andTimeEqualTo(Date value) {
            addCriterionForJDBCDate("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterionForJDBCDate("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterionForJDBCDate("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNull() {
            addCriterion("specification is null");
            return (Criteria) this;
        }

        public Criteria andSpecificationIsNotNull() {
            addCriterion("specification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecificationEqualTo(String value) {
            addCriterion("specification =", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotEqualTo(String value) {
            addCriterion("specification <>", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThan(String value) {
            addCriterion("specification >", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationGreaterThanOrEqualTo(String value) {
            addCriterion("specification >=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThan(String value) {
            addCriterion("specification <", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLessThanOrEqualTo(String value) {
            addCriterion("specification <=", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationLike(String value) {
            addCriterion("specification like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotLike(String value) {
            addCriterion("specification not like", value, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationIn(List<String> values) {
            addCriterion("specification in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotIn(List<String> values) {
            addCriterion("specification not in", values, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationBetween(String value1, String value2) {
            addCriterion("specification between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andSpecificationNotBetween(String value1, String value2) {
            addCriterion("specification not between", value1, value2, "specification");
            return (Criteria) this;
        }

        public Criteria andCoremarkIsNull() {
            addCriterion("coremark is null");
            return (Criteria) this;
        }

        public Criteria andCoremarkIsNotNull() {
            addCriterion("coremark is not null");
            return (Criteria) this;
        }

        public Criteria andCoremarkEqualTo(BigDecimal value) {
            addCriterion("coremark =", value, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkNotEqualTo(BigDecimal value) {
            addCriterion("coremark <>", value, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkGreaterThan(BigDecimal value) {
            addCriterion("coremark >", value, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coremark >=", value, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkLessThan(BigDecimal value) {
            addCriterion("coremark <", value, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coremark <=", value, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkIn(List<BigDecimal> values) {
            addCriterion("coremark in", values, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkNotIn(List<BigDecimal> values) {
            addCriterion("coremark not in", values, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coremark between", value1, value2, "coremark");
            return (Criteria) this;
        }

        public Criteria andCoremarkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coremark not between", value1, value2, "coremark");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeIsNull() {
            addCriterion("scimark_1_composite is null");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeIsNotNull() {
            addCriterion("scimark_1_composite is not null");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeEqualTo(BigDecimal value) {
            addCriterion("scimark_1_composite =", value, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeNotEqualTo(BigDecimal value) {
            addCriterion("scimark_1_composite <>", value, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeGreaterThan(BigDecimal value) {
            addCriterion("scimark_1_composite >", value, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_1_composite >=", value, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeLessThan(BigDecimal value) {
            addCriterion("scimark_1_composite <", value, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_1_composite <=", value, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeIn(List<BigDecimal> values) {
            addCriterion("scimark_1_composite in", values, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeNotIn(List<BigDecimal> values) {
            addCriterion("scimark_1_composite not in", values, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_1_composite between", value1, value2, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark1CompositeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_1_composite not between", value1, value2, "scimark1Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeIsNull() {
            addCriterion("scimark_2_composite is null");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeIsNotNull() {
            addCriterion("scimark_2_composite is not null");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeEqualTo(BigDecimal value) {
            addCriterion("scimark_2_composite =", value, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeNotEqualTo(BigDecimal value) {
            addCriterion("scimark_2_composite <>", value, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeGreaterThan(BigDecimal value) {
            addCriterion("scimark_2_composite >", value, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_2_composite >=", value, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeLessThan(BigDecimal value) {
            addCriterion("scimark_2_composite <", value, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_2_composite <=", value, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeIn(List<BigDecimal> values) {
            addCriterion("scimark_2_composite in", values, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeNotIn(List<BigDecimal> values) {
            addCriterion("scimark_2_composite not in", values, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_2_composite between", value1, value2, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark2CompositeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_2_composite not between", value1, value2, "scimark2Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeIsNull() {
            addCriterion("scimark_3_composite is null");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeIsNotNull() {
            addCriterion("scimark_3_composite is not null");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeEqualTo(BigDecimal value) {
            addCriterion("scimark_3_composite =", value, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeNotEqualTo(BigDecimal value) {
            addCriterion("scimark_3_composite <>", value, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeGreaterThan(BigDecimal value) {
            addCriterion("scimark_3_composite >", value, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_3_composite >=", value, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeLessThan(BigDecimal value) {
            addCriterion("scimark_3_composite <", value, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_3_composite <=", value, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeIn(List<BigDecimal> values) {
            addCriterion("scimark_3_composite in", values, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeNotIn(List<BigDecimal> values) {
            addCriterion("scimark_3_composite not in", values, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_3_composite between", value1, value2, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark3CompositeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_3_composite not between", value1, value2, "scimark3Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeIsNull() {
            addCriterion("scimark_4_composite is null");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeIsNotNull() {
            addCriterion("scimark_4_composite is not null");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeEqualTo(BigDecimal value) {
            addCriterion("scimark_4_composite =", value, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeNotEqualTo(BigDecimal value) {
            addCriterion("scimark_4_composite <>", value, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeGreaterThan(BigDecimal value) {
            addCriterion("scimark_4_composite >", value, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_4_composite >=", value, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeLessThan(BigDecimal value) {
            addCriterion("scimark_4_composite <", value, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("scimark_4_composite <=", value, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeIn(List<BigDecimal> values) {
            addCriterion("scimark_4_composite in", values, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeNotIn(List<BigDecimal> values) {
            addCriterion("scimark_4_composite not in", values, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_4_composite between", value1, value2, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andScimark4CompositeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("scimark_4_composite not between", value1, value2, "scimark4Composite");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100IsNull() {
            addCriterion("hpcc_random100 is null");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100IsNotNull() {
            addCriterion("hpcc_random100 is not null");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100EqualTo(BigDecimal value) {
            addCriterion("hpcc_random100 =", value, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100NotEqualTo(BigDecimal value) {
            addCriterion("hpcc_random100 <>", value, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100GreaterThan(BigDecimal value) {
            addCriterion("hpcc_random100 >", value, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_random100 >=", value, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100LessThan(BigDecimal value) {
            addCriterion("hpcc_random100 <", value, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100LessThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_random100 <=", value, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100In(List<BigDecimal> values) {
            addCriterion("hpcc_random100 in", values, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100NotIn(List<BigDecimal> values) {
            addCriterion("hpcc_random100 not in", values, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_random100 between", value1, value2, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccRandom100NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_random100 not between", value1, value2, "hpccRandom100");
            return (Criteria) this;
        }

        public Criteria andHpccCopyIsNull() {
            addCriterion("hpcc_copy is null");
            return (Criteria) this;
        }

        public Criteria andHpccCopyIsNotNull() {
            addCriterion("hpcc_copy is not null");
            return (Criteria) this;
        }

        public Criteria andHpccCopyEqualTo(BigDecimal value) {
            addCriterion("hpcc_copy =", value, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyNotEqualTo(BigDecimal value) {
            addCriterion("hpcc_copy <>", value, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyGreaterThan(BigDecimal value) {
            addCriterion("hpcc_copy >", value, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_copy >=", value, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyLessThan(BigDecimal value) {
            addCriterion("hpcc_copy <", value, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_copy <=", value, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyIn(List<BigDecimal> values) {
            addCriterion("hpcc_copy in", values, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyNotIn(List<BigDecimal> values) {
            addCriterion("hpcc_copy not in", values, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_copy between", value1, value2, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccCopyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_copy not between", value1, value2, "hpccCopy");
            return (Criteria) this;
        }

        public Criteria andHpccScaleIsNull() {
            addCriterion("hpcc_scale is null");
            return (Criteria) this;
        }

        public Criteria andHpccScaleIsNotNull() {
            addCriterion("hpcc_scale is not null");
            return (Criteria) this;
        }

        public Criteria andHpccScaleEqualTo(BigDecimal value) {
            addCriterion("hpcc_scale =", value, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleNotEqualTo(BigDecimal value) {
            addCriterion("hpcc_scale <>", value, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleGreaterThan(BigDecimal value) {
            addCriterion("hpcc_scale >", value, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_scale >=", value, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleLessThan(BigDecimal value) {
            addCriterion("hpcc_scale <", value, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_scale <=", value, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleIn(List<BigDecimal> values) {
            addCriterion("hpcc_scale in", values, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleNotIn(List<BigDecimal> values) {
            addCriterion("hpcc_scale not in", values, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_scale between", value1, value2, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccScaleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_scale not between", value1, value2, "hpccScale");
            return (Criteria) this;
        }

        public Criteria andHpccAddIsNull() {
            addCriterion("hpcc_add is null");
            return (Criteria) this;
        }

        public Criteria andHpccAddIsNotNull() {
            addCriterion("hpcc_add is not null");
            return (Criteria) this;
        }

        public Criteria andHpccAddEqualTo(BigDecimal value) {
            addCriterion("hpcc_add =", value, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddNotEqualTo(BigDecimal value) {
            addCriterion("hpcc_add <>", value, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddGreaterThan(BigDecimal value) {
            addCriterion("hpcc_add >", value, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_add >=", value, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddLessThan(BigDecimal value) {
            addCriterion("hpcc_add <", value, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_add <=", value, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddIn(List<BigDecimal> values) {
            addCriterion("hpcc_add in", values, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddNotIn(List<BigDecimal> values) {
            addCriterion("hpcc_add not in", values, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_add between", value1, value2, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccAddNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_add not between", value1, value2, "hpccAdd");
            return (Criteria) this;
        }

        public Criteria andHpccTriadIsNull() {
            addCriterion("hpcc_triad is null");
            return (Criteria) this;
        }

        public Criteria andHpccTriadIsNotNull() {
            addCriterion("hpcc_triad is not null");
            return (Criteria) this;
        }

        public Criteria andHpccTriadEqualTo(BigDecimal value) {
            addCriterion("hpcc_triad =", value, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadNotEqualTo(BigDecimal value) {
            addCriterion("hpcc_triad <>", value, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadGreaterThan(BigDecimal value) {
            addCriterion("hpcc_triad >", value, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_triad >=", value, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadLessThan(BigDecimal value) {
            addCriterion("hpcc_triad <", value, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hpcc_triad <=", value, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadIn(List<BigDecimal> values) {
            addCriterion("hpcc_triad in", values, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadNotIn(List<BigDecimal> values) {
            addCriterion("hpcc_triad not in", values, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_triad between", value1, value2, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andHpccTriadNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hpcc_triad not between", value1, value2, "hpccTriad");
            return (Criteria) this;
        }

        public Criteria andPingMinIsNull() {
            addCriterion("ping_min is null");
            return (Criteria) this;
        }

        public Criteria andPingMinIsNotNull() {
            addCriterion("ping_min is not null");
            return (Criteria) this;
        }

        public Criteria andPingMinEqualTo(BigDecimal value) {
            addCriterion("ping_min =", value, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinNotEqualTo(BigDecimal value) {
            addCriterion("ping_min <>", value, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinGreaterThan(BigDecimal value) {
            addCriterion("ping_min >", value, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_min >=", value, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinLessThan(BigDecimal value) {
            addCriterion("ping_min <", value, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_min <=", value, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinIn(List<BigDecimal> values) {
            addCriterion("ping_min in", values, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinNotIn(List<BigDecimal> values) {
            addCriterion("ping_min not in", values, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_min between", value1, value2, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_min not between", value1, value2, "pingMin");
            return (Criteria) this;
        }

        public Criteria andPingAverageIsNull() {
            addCriterion("ping_average is null");
            return (Criteria) this;
        }

        public Criteria andPingAverageIsNotNull() {
            addCriterion("ping_average is not null");
            return (Criteria) this;
        }

        public Criteria andPingAverageEqualTo(BigDecimal value) {
            addCriterion("ping_average =", value, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageNotEqualTo(BigDecimal value) {
            addCriterion("ping_average <>", value, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageGreaterThan(BigDecimal value) {
            addCriterion("ping_average >", value, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_average >=", value, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageLessThan(BigDecimal value) {
            addCriterion("ping_average <", value, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_average <=", value, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageIn(List<BigDecimal> values) {
            addCriterion("ping_average in", values, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageNotIn(List<BigDecimal> values) {
            addCriterion("ping_average not in", values, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_average between", value1, value2, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingAverageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_average not between", value1, value2, "pingAverage");
            return (Criteria) this;
        }

        public Criteria andPingMaxIsNull() {
            addCriterion("ping_max is null");
            return (Criteria) this;
        }

        public Criteria andPingMaxIsNotNull() {
            addCriterion("ping_max is not null");
            return (Criteria) this;
        }

        public Criteria andPingMaxEqualTo(BigDecimal value) {
            addCriterion("ping_max =", value, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxNotEqualTo(BigDecimal value) {
            addCriterion("ping_max <>", value, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxGreaterThan(BigDecimal value) {
            addCriterion("ping_max >", value, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_max >=", value, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxLessThan(BigDecimal value) {
            addCriterion("ping_max <", value, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_max <=", value, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxIn(List<BigDecimal> values) {
            addCriterion("ping_max in", values, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxNotIn(List<BigDecimal> values) {
            addCriterion("ping_max not in", values, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_max between", value1, value2, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_max not between", value1, value2, "pingMax");
            return (Criteria) this;
        }

        public Criteria andPingStdIsNull() {
            addCriterion("ping_std is null");
            return (Criteria) this;
        }

        public Criteria andPingStdIsNotNull() {
            addCriterion("ping_std is not null");
            return (Criteria) this;
        }

        public Criteria andPingStdEqualTo(BigDecimal value) {
            addCriterion("ping_std =", value, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdNotEqualTo(BigDecimal value) {
            addCriterion("ping_std <>", value, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdGreaterThan(BigDecimal value) {
            addCriterion("ping_std >", value, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_std >=", value, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdLessThan(BigDecimal value) {
            addCriterion("ping_std <", value, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ping_std <=", value, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdIn(List<BigDecimal> values) {
            addCriterion("ping_std in", values, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdNotIn(List<BigDecimal> values) {
            addCriterion("ping_std not in", values, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_std between", value1, value2, "pingStd");
            return (Criteria) this;
        }

        public Criteria andPingStdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ping_std not between", value1, value2, "pingStd");
            return (Criteria) this;
        }

        public Criteria andIperfInternalIsNull() {
            addCriterion("iperf_internal is null");
            return (Criteria) this;
        }

        public Criteria andIperfInternalIsNotNull() {
            addCriterion("iperf_internal is not null");
            return (Criteria) this;
        }

        public Criteria andIperfInternalEqualTo(BigDecimal value) {
            addCriterion("iperf_internal =", value, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalNotEqualTo(BigDecimal value) {
            addCriterion("iperf_internal <>", value, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalGreaterThan(BigDecimal value) {
            addCriterion("iperf_internal >", value, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("iperf_internal >=", value, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalLessThan(BigDecimal value) {
            addCriterion("iperf_internal <", value, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("iperf_internal <=", value, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalIn(List<BigDecimal> values) {
            addCriterion("iperf_internal in", values, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalNotIn(List<BigDecimal> values) {
            addCriterion("iperf_internal not in", values, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iperf_internal between", value1, value2, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfInternalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iperf_internal not between", value1, value2, "iperfInternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalIsNull() {
            addCriterion("iperf_external is null");
            return (Criteria) this;
        }

        public Criteria andIperfExternalIsNotNull() {
            addCriterion("iperf_external is not null");
            return (Criteria) this;
        }

        public Criteria andIperfExternalEqualTo(BigDecimal value) {
            addCriterion("iperf_external =", value, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalNotEqualTo(BigDecimal value) {
            addCriterion("iperf_external <>", value, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalGreaterThan(BigDecimal value) {
            addCriterion("iperf_external >", value, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("iperf_external >=", value, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalLessThan(BigDecimal value) {
            addCriterion("iperf_external <", value, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("iperf_external <=", value, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalIn(List<BigDecimal> values) {
            addCriterion("iperf_external in", values, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalNotIn(List<BigDecimal> values) {
            addCriterion("iperf_external not in", values, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iperf_external between", value1, value2, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andIperfExternalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("iperf_external not between", value1, value2, "iperfExternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalIsNull() {
            addCriterion("netperf_tcp_rr_internal is null");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalIsNotNull() {
            addCriterion("netperf_tcp_rr_internal is not null");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_rr_internal =", value, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalNotEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_rr_internal <>", value, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalGreaterThan(BigDecimal value) {
            addCriterion("netperf_tcp_rr_internal >", value, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_rr_internal >=", value, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalLessThan(BigDecimal value) {
            addCriterion("netperf_tcp_rr_internal <", value, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_rr_internal <=", value, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalIn(List<BigDecimal> values) {
            addCriterion("netperf_tcp_rr_internal in", values, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalNotIn(List<BigDecimal> values) {
            addCriterion("netperf_tcp_rr_internal not in", values, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_tcp_rr_internal between", value1, value2, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpRrInternalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_tcp_rr_internal not between", value1, value2, "netperfTcpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalIsNull() {
            addCriterion("netperf_tcp_crr_internal is null");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalIsNotNull() {
            addCriterion("netperf_tcp_crr_internal is not null");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_crr_internal =", value, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalNotEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_crr_internal <>", value, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalGreaterThan(BigDecimal value) {
            addCriterion("netperf_tcp_crr_internal >", value, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_crr_internal >=", value, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalLessThan(BigDecimal value) {
            addCriterion("netperf_tcp_crr_internal <", value, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_crr_internal <=", value, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalIn(List<BigDecimal> values) {
            addCriterion("netperf_tcp_crr_internal in", values, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalNotIn(List<BigDecimal> values) {
            addCriterion("netperf_tcp_crr_internal not in", values, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_tcp_crr_internal between", value1, value2, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpCrrInternalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_tcp_crr_internal not between", value1, value2, "netperfTcpCrrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalIsNull() {
            addCriterion("netperf_tcp_stream_internal is null");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalIsNotNull() {
            addCriterion("netperf_tcp_stream_internal is not null");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_stream_internal =", value, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalNotEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_stream_internal <>", value, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalGreaterThan(BigDecimal value) {
            addCriterion("netperf_tcp_stream_internal >", value, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_stream_internal >=", value, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalLessThan(BigDecimal value) {
            addCriterion("netperf_tcp_stream_internal <", value, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_tcp_stream_internal <=", value, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalIn(List<BigDecimal> values) {
            addCriterion("netperf_tcp_stream_internal in", values, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalNotIn(List<BigDecimal> values) {
            addCriterion("netperf_tcp_stream_internal not in", values, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_tcp_stream_internal between", value1, value2, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfTcpStreamInternalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_tcp_stream_internal not between", value1, value2, "netperfTcpStreamInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalIsNull() {
            addCriterion("netperf_udp_rr_internal is null");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalIsNotNull() {
            addCriterion("netperf_udp_rr_internal is not null");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalEqualTo(BigDecimal value) {
            addCriterion("netperf_udp_rr_internal =", value, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalNotEqualTo(BigDecimal value) {
            addCriterion("netperf_udp_rr_internal <>", value, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalGreaterThan(BigDecimal value) {
            addCriterion("netperf_udp_rr_internal >", value, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_udp_rr_internal >=", value, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalLessThan(BigDecimal value) {
            addCriterion("netperf_udp_rr_internal <", value, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("netperf_udp_rr_internal <=", value, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalIn(List<BigDecimal> values) {
            addCriterion("netperf_udp_rr_internal in", values, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalNotIn(List<BigDecimal> values) {
            addCriterion("netperf_udp_rr_internal not in", values, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_udp_rr_internal between", value1, value2, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andNetperfUdpRrInternalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("netperf_udp_rr_internal not between", value1, value2, "netperfUdpRrInternal");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthIsNull() {
            addCriterion("fio_sequential_write_bandwidth is null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthIsNotNull() {
            addCriterion("fio_sequential_write_bandwidth is not null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_bandwidth =", value, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthNotEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_bandwidth <>", value, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthGreaterThan(BigDecimal value) {
            addCriterion("fio_sequential_write_bandwidth >", value, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_bandwidth >=", value, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthLessThan(BigDecimal value) {
            addCriterion("fio_sequential_write_bandwidth <", value, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_bandwidth <=", value, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_write_bandwidth in", values, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthNotIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_write_bandwidth not in", values, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_write_bandwidth between", value1, value2, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteBandwidthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_write_bandwidth not between", value1, value2, "fioSequentialWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthIsNull() {
            addCriterion("fio_sequential_read_bandwidth is null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthIsNotNull() {
            addCriterion("fio_sequential_read_bandwidth is not null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_bandwidth =", value, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthNotEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_bandwidth <>", value, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthGreaterThan(BigDecimal value) {
            addCriterion("fio_sequential_read_bandwidth >", value, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_bandwidth >=", value, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthLessThan(BigDecimal value) {
            addCriterion("fio_sequential_read_bandwidth <", value, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_bandwidth <=", value, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_read_bandwidth in", values, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthNotIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_read_bandwidth not in", values, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_read_bandwidth between", value1, value2, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadBandwidthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_read_bandwidth not between", value1, value2, "fioSequentialReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthIsNull() {
            addCriterion("fio_random_write_bandwidth is null");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthIsNotNull() {
            addCriterion("fio_random_write_bandwidth is not null");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_bandwidth =", value, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthNotEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_bandwidth <>", value, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthGreaterThan(BigDecimal value) {
            addCriterion("fio_random_write_bandwidth >", value, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_bandwidth >=", value, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthLessThan(BigDecimal value) {
            addCriterion("fio_random_write_bandwidth <", value, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_bandwidth <=", value, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthIn(List<BigDecimal> values) {
            addCriterion("fio_random_write_bandwidth in", values, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthNotIn(List<BigDecimal> values) {
            addCriterion("fio_random_write_bandwidth not in", values, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_write_bandwidth between", value1, value2, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteBandwidthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_write_bandwidth not between", value1, value2, "fioRandomWriteBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthIsNull() {
            addCriterion("fio_random_read_bandwidth is null");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthIsNotNull() {
            addCriterion("fio_random_read_bandwidth is not null");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_bandwidth =", value, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthNotEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_bandwidth <>", value, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthGreaterThan(BigDecimal value) {
            addCriterion("fio_random_read_bandwidth >", value, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_bandwidth >=", value, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthLessThan(BigDecimal value) {
            addCriterion("fio_random_read_bandwidth <", value, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_bandwidth <=", value, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthIn(List<BigDecimal> values) {
            addCriterion("fio_random_read_bandwidth in", values, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthNotIn(List<BigDecimal> values) {
            addCriterion("fio_random_read_bandwidth not in", values, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_read_bandwidth between", value1, value2, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadBandwidthNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_read_bandwidth not between", value1, value2, "fioRandomReadBandwidth");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyIsNull() {
            addCriterion("fio_sequential_write_latency is null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyIsNotNull() {
            addCriterion("fio_sequential_write_latency is not null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_latency =", value, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyNotEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_latency <>", value, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyGreaterThan(BigDecimal value) {
            addCriterion("fio_sequential_write_latency >", value, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_latency >=", value, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyLessThan(BigDecimal value) {
            addCriterion("fio_sequential_write_latency <", value, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_latency <=", value, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_write_latency in", values, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyNotIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_write_latency not in", values, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_write_latency between", value1, value2, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteLatencyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_write_latency not between", value1, value2, "fioSequentialWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyIsNull() {
            addCriterion("fio_sequential_read_latency is null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyIsNotNull() {
            addCriterion("fio_sequential_read_latency is not null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_latency =", value, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyNotEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_latency <>", value, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyGreaterThan(BigDecimal value) {
            addCriterion("fio_sequential_read_latency >", value, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_latency >=", value, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyLessThan(BigDecimal value) {
            addCriterion("fio_sequential_read_latency <", value, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_latency <=", value, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_read_latency in", values, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyNotIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_read_latency not in", values, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_read_latency between", value1, value2, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadLatencyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_read_latency not between", value1, value2, "fioSequentialReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyIsNull() {
            addCriterion("fio_random_write_latency is null");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyIsNotNull() {
            addCriterion("fio_random_write_latency is not null");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_latency =", value, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyNotEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_latency <>", value, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyGreaterThan(BigDecimal value) {
            addCriterion("fio_random_write_latency >", value, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_latency >=", value, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyLessThan(BigDecimal value) {
            addCriterion("fio_random_write_latency <", value, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_latency <=", value, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyIn(List<BigDecimal> values) {
            addCriterion("fio_random_write_latency in", values, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyNotIn(List<BigDecimal> values) {
            addCriterion("fio_random_write_latency not in", values, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_write_latency between", value1, value2, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteLatencyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_write_latency not between", value1, value2, "fioRandomWriteLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyIsNull() {
            addCriterion("fio_random_read_latency is null");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyIsNotNull() {
            addCriterion("fio_random_read_latency is not null");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_latency =", value, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyNotEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_latency <>", value, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyGreaterThan(BigDecimal value) {
            addCriterion("fio_random_read_latency >", value, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_latency >=", value, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyLessThan(BigDecimal value) {
            addCriterion("fio_random_read_latency <", value, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_latency <=", value, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyIn(List<BigDecimal> values) {
            addCriterion("fio_random_read_latency in", values, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyNotIn(List<BigDecimal> values) {
            addCriterion("fio_random_read_latency not in", values, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_read_latency between", value1, value2, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadLatencyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_read_latency not between", value1, value2, "fioRandomReadLatency");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsIsNull() {
            addCriterion("fio_sequential_write_iops is null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsIsNotNull() {
            addCriterion("fio_sequential_write_iops is not null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_iops =", value, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsNotEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_iops <>", value, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsGreaterThan(BigDecimal value) {
            addCriterion("fio_sequential_write_iops >", value, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_iops >=", value, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsLessThan(BigDecimal value) {
            addCriterion("fio_sequential_write_iops <", value, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_write_iops <=", value, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_write_iops in", values, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsNotIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_write_iops not in", values, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_write_iops between", value1, value2, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialWriteIopsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_write_iops not between", value1, value2, "fioSequentialWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsIsNull() {
            addCriterion("fio_sequential_read_iops is null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsIsNotNull() {
            addCriterion("fio_sequential_read_iops is not null");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_iops =", value, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsNotEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_iops <>", value, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsGreaterThan(BigDecimal value) {
            addCriterion("fio_sequential_read_iops >", value, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_iops >=", value, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsLessThan(BigDecimal value) {
            addCriterion("fio_sequential_read_iops <", value, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_sequential_read_iops <=", value, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_read_iops in", values, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsNotIn(List<BigDecimal> values) {
            addCriterion("fio_sequential_read_iops not in", values, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_read_iops between", value1, value2, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioSequentialReadIopsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_sequential_read_iops not between", value1, value2, "fioSequentialReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsIsNull() {
            addCriterion("fio_random_write_iops is null");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsIsNotNull() {
            addCriterion("fio_random_write_iops is not null");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_iops =", value, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsNotEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_iops <>", value, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsGreaterThan(BigDecimal value) {
            addCriterion("fio_random_write_iops >", value, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_iops >=", value, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsLessThan(BigDecimal value) {
            addCriterion("fio_random_write_iops <", value, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_write_iops <=", value, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsIn(List<BigDecimal> values) {
            addCriterion("fio_random_write_iops in", values, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsNotIn(List<BigDecimal> values) {
            addCriterion("fio_random_write_iops not in", values, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_write_iops between", value1, value2, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomWriteIopsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_write_iops not between", value1, value2, "fioRandomWriteIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsIsNull() {
            addCriterion("fio_random_read_iops is null");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsIsNotNull() {
            addCriterion("fio_random_read_iops is not null");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_iops =", value, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsNotEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_iops <>", value, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsGreaterThan(BigDecimal value) {
            addCriterion("fio_random_read_iops >", value, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_iops >=", value, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsLessThan(BigDecimal value) {
            addCriterion("fio_random_read_iops <", value, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fio_random_read_iops <=", value, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsIn(List<BigDecimal> values) {
            addCriterion("fio_random_read_iops in", values, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsNotIn(List<BigDecimal> values) {
            addCriterion("fio_random_read_iops not in", values, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_read_iops between", value1, value2, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andFioRandomReadIopsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fio_random_read_iops not between", value1, value2, "fioRandomReadIops");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexIsNull() {
            addCriterion("unixbench_index is null");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexIsNotNull() {
            addCriterion("unixbench_index is not null");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexEqualTo(BigDecimal value) {
            addCriterion("unixbench_index =", value, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexNotEqualTo(BigDecimal value) {
            addCriterion("unixbench_index <>", value, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexGreaterThan(BigDecimal value) {
            addCriterion("unixbench_index >", value, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unixbench_index >=", value, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexLessThan(BigDecimal value) {
            addCriterion("unixbench_index <", value, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unixbench_index <=", value, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexIn(List<BigDecimal> values) {
            addCriterion("unixbench_index in", values, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexNotIn(List<BigDecimal> values) {
            addCriterion("unixbench_index not in", values, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unixbench_index between", value1, value2, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andUnixbenchIndexNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unixbench_index not between", value1, value2, "unixbenchIndex");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpIsNull() {
            addCriterion("sysbench_oltp is null");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpIsNotNull() {
            addCriterion("sysbench_oltp is not null");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpEqualTo(BigDecimal value) {
            addCriterion("sysbench_oltp =", value, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpNotEqualTo(BigDecimal value) {
            addCriterion("sysbench_oltp <>", value, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpGreaterThan(BigDecimal value) {
            addCriterion("sysbench_oltp >", value, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sysbench_oltp >=", value, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpLessThan(BigDecimal value) {
            addCriterion("sysbench_oltp <", value, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sysbench_oltp <=", value, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpIn(List<BigDecimal> values) {
            addCriterion("sysbench_oltp in", values, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpNotIn(List<BigDecimal> values) {
            addCriterion("sysbench_oltp not in", values, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sysbench_oltp between", value1, value2, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andSysbenchOltpNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sysbench_oltp not between", value1, value2, "sysbenchOltp");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputAIsNull() {
            addCriterion("ycsb_throughput_a is null");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputAIsNotNull() {
            addCriterion("ycsb_throughput_a is not null");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputAEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_a =", value, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputANotEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_a <>", value, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputAGreaterThan(BigDecimal value) {
            addCriterion("ycsb_throughput_a >", value, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputAGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_a >=", value, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputALessThan(BigDecimal value) {
            addCriterion("ycsb_throughput_a <", value, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputALessThanOrEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_a <=", value, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputAIn(List<BigDecimal> values) {
            addCriterion("ycsb_throughput_a in", values, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputANotIn(List<BigDecimal> values) {
            addCriterion("ycsb_throughput_a not in", values, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputABetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ycsb_throughput_a between", value1, value2, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputANotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ycsb_throughput_a not between", value1, value2, "ycsbThroughputA");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBIsNull() {
            addCriterion("ycsb_throughput_b is null");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBIsNotNull() {
            addCriterion("ycsb_throughput_b is not null");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_b =", value, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBNotEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_b <>", value, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBGreaterThan(BigDecimal value) {
            addCriterion("ycsb_throughput_b >", value, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_b >=", value, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBLessThan(BigDecimal value) {
            addCriterion("ycsb_throughput_b <", value, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ycsb_throughput_b <=", value, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBIn(List<BigDecimal> values) {
            addCriterion("ycsb_throughput_b in", values, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBNotIn(List<BigDecimal> values) {
            addCriterion("ycsb_throughput_b not in", values, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ycsb_throughput_b between", value1, value2, "ycsbThroughputB");
            return (Criteria) this;
        }

        public Criteria andYcsbThroughputBNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ycsb_throughput_b not between", value1, value2, "ycsbThroughputB");
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