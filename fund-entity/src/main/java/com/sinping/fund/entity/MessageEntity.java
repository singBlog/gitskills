package com.sinping.fund.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class MessageEntity extends BaseEntity {
	
	private static final long serialVersionUID = 4290774380558885855L;

	public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** 回复消息时使用 */
	private Integer messageId;
	/**  */
	private Integer userId;
	/**  */
	private Integer fromUserId;
	/**  */
	private String content;
	/**  */
	private Date readAt;

	
	public Integer getMessageId() {
		return this.messageId;
	}
	
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getFromUserId() {
		return this.fromUserId;
	}
	
	public void setFromUserId(Integer fromUserId) {
		this.fromUserId = fromUserId;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getReadAt() {
		return this.readAt;
	}
	
	public void setReadAt(Date readAt) {
		this.readAt = readAt;
	}

	public String getTableName() {

		return "mdf_messages";
	}
	
}
