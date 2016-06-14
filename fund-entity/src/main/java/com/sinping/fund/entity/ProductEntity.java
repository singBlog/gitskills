package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ProductEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** 关联product_type表 */
	private Integer productTypeId;
	/** 
基金名称 */
	private String name;
	/** 基金代码 */
	private String code;
	/** 单位净值 */
	private Double unitValue;
	/** 日涨幅 */
	private Double increaseDay;
	/** 近一月涨幅 */
	private Double increaseMonth;
	/** 近三月涨幅 */
	private Double increaseThreeMonth;
	/** 半年涨幅 */
	private Double increaseSixMonth;
	/** 今年以来涨幅 */
	private Double increaseYear;
	/** 主题推荐（实现机制就是根据时间倒序来排序，最后推荐的时间值最大在最前面） */
	private Date recommandAt;
	/** 产品状态 */
	private Integer statu;
	/** 风险等级 */
	private Integer riskLevel;
	/** 最小购买额 */
	private Integer buyMinPrice;
	/** 申购费率 */
	private Double buyRate;
	/** 收费方式 */
	private Integer chargeType;
	/** 分红方式 */
	private Integer dividendType;

	
	public Integer getProductTypeId() {
		return this.productTypeId;
	}
	
	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public void setCode(String code) {
		this.code = code;
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
	
	public Double getIncreaseMonth() {
		return this.increaseMonth;
	}
	
	public void setIncreaseMonth(Double increaseMonth) {
		this.increaseMonth = increaseMonth;
	}
	
	public Double getIncreaseThreeMonth() {
		return this.increaseThreeMonth;
	}
	
	public void setIncreaseThreeMonth(Double increaseThreeMonth) {
		this.increaseThreeMonth = increaseThreeMonth;
	}
	
	public Double getIncreaseSixMonth() {
		return this.increaseSixMonth;
	}
	
	public void setIncreaseSixMonth(Double increaseSixMonth) {
		this.increaseSixMonth = increaseSixMonth;
	}
	
	public Double getIncreaseYear() {
		return this.increaseYear;
	}
	
	public void setIncreaseYear(Double increaseYear) {
		this.increaseYear = increaseYear;
	}
	
	public Date getRecommandAt() {
		return this.recommandAt;
	}
	
	public void setRecommandAt(Date recommandAt) {
		this.recommandAt = recommandAt;
	}
	
	public Integer getStatu() {
		return this.statu;
	}
	
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	
	public Integer getRiskLevel() {
		return this.riskLevel;
	}
	
	public void setRiskLevel(Integer riskLevel) {
		this.riskLevel = riskLevel;
	}
	
	public Integer getBuyMinPrice() {
		return this.buyMinPrice;
	}
	
	public void setBuyMinPrice(Integer buyMinPrice) {
		this.buyMinPrice = buyMinPrice;
	}
	
	public Double getBuyRate() {
		return this.buyRate;
	}
	
	public void setBuyRate(Double buyRate) {
		this.buyRate = buyRate;
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

		return "mdf_products";
	}
	
}
