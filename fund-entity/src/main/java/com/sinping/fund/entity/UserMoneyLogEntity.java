package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserMoneyLogEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**  */
	private Integer userId;
	/** 支付金钱的订单id */
	private Integer orderId;
	/** 金钱改变值（负数为支出----购买，正数为收益----卖出） */
	private Integer changeValue;
	/**  */
	private String content;

	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getOrderId() {
		return this.orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getChangeValue() {
		return this.changeValue;
	}
	
	public void setChangeValue(Integer changeValue) {
		this.changeValue = changeValue;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getTableName() {

		return "mdf_user_money_logs";
	}
	
}
