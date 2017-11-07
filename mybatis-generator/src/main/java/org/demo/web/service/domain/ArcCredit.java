package org.demo.web.service.domain;

import java.math.BigDecimal;

public class ArcCredit {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户标识,对应cl_user.id
     */
    private Long consumerNo;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 额度类型
     */
    private String creditType;

    /**
     * 评分
     */
    private Double grade;

    /**
     * 已使用额度
     */
    private BigDecimal used;

    /**
     * 可使用额度
     */
    private BigDecimal unuse;

    /**
     * 状态 10 -正常 20-冻结
     */
    private String state;

    /**
     * 扩展字段
     */
    private String reqExt;

    /**
     * 百融评分
     */
    private Double grade1;

    /**
     * 同盾
     */
    private Double grade2;

    /**
     * 芝麻信用
     */
    private Double grade3;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户标识,对应cl_user.id
     * @return consumer_no 用户标识,对应cl_user.id
     */
    public Long getConsumerNo() {
        return consumerNo;
    }

    /**
     * 用户标识,对应cl_user.id
     * @param consumerNo 用户标识,对应cl_user.id
     */
    public void setConsumerNo(Long consumerNo) {
        this.consumerNo = consumerNo;
    }

    /**
     * 总额度
     * @return total 总额度
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * 总额度
     * @param total 总额度
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * 额度类型
     * @return credit_type 额度类型
     */
    public String getCreditType() {
        return creditType;
    }

    /**
     * 额度类型
     * @param creditType 额度类型
     */
    public void setCreditType(String creditType) {
        this.creditType = creditType == null ? null : creditType.trim();
    }

    /**
     * 评分
     * @return grade 评分
     */
    public Double getGrade() {
        return grade;
    }

    /**
     * 评分
     * @param grade 评分
     */
    public void setGrade(Double grade) {
        this.grade = grade;
    }

    /**
     * 已使用额度
     * @return used 已使用额度
     */
    public BigDecimal getUsed() {
        return used;
    }

    /**
     * 已使用额度
     * @param used 已使用额度
     */
    public void setUsed(BigDecimal used) {
        this.used = used;
    }

    /**
     * 可使用额度
     * @return unuse 可使用额度
     */
    public BigDecimal getUnuse() {
        return unuse;
    }

    /**
     * 可使用额度
     * @param unuse 可使用额度
     */
    public void setUnuse(BigDecimal unuse) {
        this.unuse = unuse;
    }

    /**
     * 状态 10 -正常 20-冻结
     * @return state 状态 10 -正常 20-冻结
     */
    public String getState() {
        return state;
    }

    /**
     * 状态 10 -正常 20-冻结
     * @param state 状态 10 -正常 20-冻结
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * 扩展字段
     * @return req_ext 扩展字段
     */
    public String getReqExt() {
        return reqExt;
    }

    /**
     * 扩展字段
     * @param reqExt 扩展字段
     */
    public void setReqExt(String reqExt) {
        this.reqExt = reqExt == null ? null : reqExt.trim();
    }

    /**
     * 百融评分
     * @return grade1 百融评分
     */
    public Double getGrade1() {
        return grade1;
    }

    /**
     * 百融评分
     * @param grade1 百融评分
     */
    public void setGrade1(Double grade1) {
        this.grade1 = grade1;
    }

    /**
     * 同盾
     * @return grade2 同盾
     */
    public Double getGrade2() {
        return grade2;
    }

    /**
     * 同盾
     * @param grade2 同盾
     */
    public void setGrade2(Double grade2) {
        this.grade2 = grade2;
    }

    /**
     * 芝麻信用
     * @return grade3 芝麻信用
     */
    public Double getGrade3() {
        return grade3;
    }

    /**
     * 芝麻信用
     * @param grade3 芝麻信用
     */
    public void setGrade3(Double grade3) {
        this.grade3 = grade3;
    }
}