package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TagEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**  */
	private Integer tagId;
	/** 属性名称 */
	private String name;

	
	public Integer getTagId() {
		return this.tagId;
	}
	
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getTableName() {

		return "mdf_tags";
	}
	
}
