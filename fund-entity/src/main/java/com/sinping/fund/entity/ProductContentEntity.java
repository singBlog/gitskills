package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductContentEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**  */
	private Integer productId;
	/**  */
	private String content;

	
	public Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getTableName() {

		return "mdf_product_contents";
	}
	
}
