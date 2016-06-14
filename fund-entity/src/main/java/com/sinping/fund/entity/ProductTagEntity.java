package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProductTagEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**  */
	private Integer productId;
	/**  */
	private Integer tagId;

	
	public Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getTagId() {
		return this.tagId;
	}
	
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTableName() {

		return "mdf_product_tags";
	}
	
}
