package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserProductEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**  */
	private Integer userId;
	/**  */
	private Integer productId;
	/**  */
	private Integer count;
	/** 当前用户产品的状态 ---- 锁定之类的状态 */
	private Integer statu;
	/** 锁定数量 */
	private Integer lockCount;
	/** 收费方式 */
	private Integer chargeType;
	/** 分红方式 */
	private Integer dividendType;

	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getCount() {
		return this.count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Integer getStatu() {
		return this.statu;
	}
	
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	
	public Integer getLockCount() {
		return this.lockCount;
	}
	
	public void setLockCount(Integer lockCount) {
		this.lockCount = lockCount;
	}
	
	public Integer getChargeType() {
		return this.chargeType;
	}
	
	public void setChargeType(Integer chargeType) {
		this.chargeType = chargeType;
	}
	
	public Integer getDividendType() {
		return this.dividendType;
	}
	
	public void setDividendType(Integer dividendType) {
		this.dividendType = dividendType;
	}

	public String getTableName() {

		return "mdf_user_products";
	}
	
}
