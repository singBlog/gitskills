package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductStatisticEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** 产品id */
	private Integer productId;
	/** 单位净值 */
	private Double unitValue;
	/** 日涨幅 */
	private Double increaseDay;
	/** 近一月涨幅 */
	private Double increaseDay30;
	/** 近三月涨幅 */
	private Double increaseDay90;
	/** 半年涨幅 */
	private Double increaseDay180;
	/** 今年以来涨幅 */
	private Double increaseDay365;

	
	public Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Double getUnitValue() {
		return this.unitValue;
	}
	
	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}
	
	public Double getIncreaseDay() {
		return this.increaseDay;
	}
	
	public void setIncreaseDay(Double increaseDay) {
		this.increaseDay = increaseDay;
	}
	
	public Double getIncreaseDay30() {
		return this.increaseDay30;
	}
	
	public void setIncreaseDay30(Double increaseDay30) {
		this.increaseDay30 = increaseDay30;
	}
	
	public Double getIncreaseDay90() {
		return this.increaseDay90;
	}
	
	public void setIncreaseDay90(Double increaseDay90) {
		this.increaseDay90 = increaseDay90;
	}
	
	public Double getIncreaseDay180() {
		return this.increaseDay180;
	}
	
	public void setIncreaseDay180(Double increaseDay180) {
		this.increaseDay180 = increaseDay180;
	}
	
	public Double getIncreaseDay365() {
		return this.increaseDay365;
	}
	
	public void setIncreaseDay365(Double increaseDay365) {
		this.increaseDay365 = increaseDay365;
	}

	public String getTableName() {

		return "mdf_product_statistics";
	}
	
}
