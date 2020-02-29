package com.briup.bean;

import java.util.Date;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api
public class ArticleAndCategoryName {
	
	@ApiModelProperty(value="文章ID")
	private Integer id;
	@ApiModelProperty(value="文章作者")
	private String author;
	@ApiModelProperty(value="点击次数",hidden=true)
	private Integer clickTimes;
	@ApiModelProperty(value="文章内容")
	private String content;
	@ApiModelProperty(value="文章点击次数",hidden=true)
	private Date publishDate;
	@ApiModelProperty(value="文章标题")
	private String title;
	@ApiModelProperty(value="文章所在栏目")
	private String categoryNmae;
	public ArticleAndCategoryName() {
	}
	public ArticleAndCategoryName(Integer id, String author, Integer clickTimes, String content, Date publishDate,
			String title, String categoryNmae) {
		super();
		this.id = id;
		this.author = author;
		this.clickTimes = clickTimes;
		this.content = content;
		this.publishDate = publishDate;
		this.title = title;
		this.categoryNmae = categoryNmae;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getClickTimes() {
		return clickTimes;
	}
	public void setClickTimes(Integer clickTimes) {
		this.clickTimes = clickTimes;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryNmae() {
		return categoryNmae;
	}
	public void setCategoryNmae(String categoryNmae) {
		this.categoryNmae = categoryNmae;
	}
	@Override
	public String toString() {
		return "ArticleAndCategoryName [id=" + id + ", author=" + author + ", clickTimes=" + clickTimes + ", content="
				+ content + ", publishDate=" + publishDate + ", title=" + title + ", categoryNmae=" + categoryNmae
				+ "]";
	}
	
}
