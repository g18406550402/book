package com.briup.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="cms_comment")
@Api
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(value="评论ID")
	private Integer id;
	@ApiModelProperty(value="评论内容")
	private String content;
	@ApiModelProperty(value="评论发表日期")
	@Column(name="publishDate")
	private Date publishDate;
	@Column(name="article_id")
	private Integer articleId;
	public Comment() {
		super();
	}
	public Comment(Integer id, String content, Date publishDate) {
		super();
		this.id = id;
		this.content = content;
		this.publishDate = publishDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", publishDate=" + publishDate + "]";
	}
	
	
}
