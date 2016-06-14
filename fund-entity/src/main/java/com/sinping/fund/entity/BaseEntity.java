package com.sinping.fund.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseEntity implements Serializable {

	/**
	 * 定义公共类的公有属性和方法
	 */
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** 表前缀 */
	public final String PRE_TABLE = "zx_";

	/** entity对应的表名字 ---- 便于日后做分表功能 */
	public String tableName = "";

	/** id */
	private Integer id;
	/** 生成时间 */
	private Date createdAt;
	/** 更新时间 */
	private Date updatedAt;
	/** 删除时间 */
	private Date deletedAt;

	private ArrayList<Integer> ids;

	/** 每页记录数 */
	public Integer perPage = 40;

	/** 当前页面数 */
	private Integer page = 1;

	/** 当前起始记录数 */
	private Integer startRecord = 0;

	/** 总记录数 */
	private Integer recordCount = 0;

	/** 记录页面数 */
	private Integer pageCount = 0;

	public BaseEntity() {}
	public BaseEntity(Integer page, Integer recordCount, Integer perPage){
		this.page = page;
		this.recordCount = recordCount;
		this.perPage = perPage;
		getPageCount();
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedAt() {

		this.createdAt = this.getDateTime();
	}

	public Date getUpdatedAt() {
		return this.updatedAt;

	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;

	}

	public void setUpdatedAt() {
		this.updatedAt = this.getDateTime();
	}

	public Date getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public void setDeletedAt() {
		this.deletedAt = this.getDateTime();
	}

	public ArrayList<Integer> getIds() {
		return ids;
	}

	public void setIds(ArrayList<Integer> ids) {
		this.ids = ids;
	}

	public void setIds(String idStr) {

		logger.info("BaseEntity.setIds idStr is : " + idStr);

		ArrayList<Integer> ids = new ArrayList<Integer>();
		String[] idStrArr = idStr.split(",");

		for (String strId : idStrArr) {
			Integer id = Integer.parseInt(strId.trim());
			ids.add(id);
		}

		this.ids = ids;
	}

	/**
	 * @return the perPage
	 */
	public Integer getPerPage() {
		return this.perPage;
	}

	/**
	 * @param perPage
	 *            the perPage to set
	 */
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
		this.setStartRecord((page - 1) * perPage);
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return this.page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Integer page) {
		this.page = page < 0 ? 0 : page;
		this.setStartRecord((page - 1) * perPage);
	}

	/**
	 * @return the startRecord
	 */
	public Integer getStartRecord() {
		return this.startRecord;
	}

	/**
	 * @param startRecord
	 *            the startRecord to set
	 */
	public void setStartRecord(Integer startRecord) {
		this.startRecord = startRecord;
	}

	public Integer getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	public Integer getPageCount() {

		if(recordCount%perPage==0) {  
			pageCount = recordCount/perPage;  
        } else {  
        	pageCount = recordCount/perPage + 1;  
        }  
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/** 获取当前时间的字符串格式 */
	protected Date getDateTime() {

		Date date = new Date();

		return date;
	}

	public String getTableName() {

		return null;
	}
}
