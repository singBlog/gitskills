package com.server;

import java.util.List;

import persist.article.Article;

public interface ArticleServer {
	/**
	 * 获取所有文章类别
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List getAllArticleType(int userid);
	
	/**
	 * 获取所有评论
	 * @return
	 */
	public int getAllArticleNum(int userid);
	
	public Article getArticleById(int id);
	
	@SuppressWarnings("unchecked")
	public List getArticleCommentById(int id);
	/**
	 * 通过文章类别ID查找文章
	 * @param type_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getArticleByTypeId(Integer type_id);
	public List getArticleByTypeId(Integer type_id, int userid);
	/**
	 * 获取每个类别的一篇最新文章
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getLatestArticleInEachType();
	
	public int addNewArticleType(String articleTypeName,String articleDesc);
	public int addNewArticleType(String articleTypeName,String articleDesc, int userid);
	
	public boolean addNewArticle(String title,String author,String content,int articleType,int userid);

	public boolean editArticle(int id,String title,String author,String content,int articleType);
	@SuppressWarnings("unchecked")
	public List getArticleByPage(int pageNo,int pageSize,int type);
	public List getArticleByPage(int pageNo,int pageSize,int type,int userid);
	@SuppressWarnings("unchecked")
	public List getLatestComment(int top);
	@SuppressWarnings("unchecked")
	public List getLatestArticle(int top,int userid);
	
	public void addNewComment(int id,String user,String comment);

	public void replyComment(int id,String comment);
	
	public void delArticleById(int id);
	
	public void delCommentById(int id);
	
	public void renameArticleType(int id,String typeName);

	public void delArticleTypeById(int id);
	@SuppressWarnings("unchecked")
	public List getSearchResultInArticle(String keyword);
}
