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
	@ApiModelProperty(value="文章点击次数",hidden=true)
	private Integer clickTimes;
	@ApiModelProperty(value="文章简介")
	private String intro;
	@ApiModelProperty(value="文章更新时间",hidden=true)
	private Date updateDate;
	@ApiModelProperty(value="文章标题")
	private String title;
	@ApiModelProperty(value="文章状态")
	private String state;
	@ApiModelProperty(value="文章字数（万字）")
	private Integer words;
	
	@ApiModelProperty(value="文章所在栏目")
	private String categoryNmae;
	public ArticleAndCategoryName() {
	}

	public ArticleAndCategoryName(Integer id, String author, Integer clickTimes, String intro, Date updateDate,
			String title, String state, Integer words, String categoryNmae) {
		super();
		this.id = id;
		this.author = author;
		this.clickTimes = clickTimes;
		this.intro = intro;
		this.updateDate = updateDate;
		this.title = title;
		this.state = state;
		this.words = words;
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategoryNmae() {
		return categoryNmae;
	}
	
	
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getWords() {
		return words;
	}

	public void setWords(Integer words) {
		this.words = words;
	}

	public void setCategoryNmae(String categoryNmae) {
		this.categoryNmae = categoryNmae;
	}

	@Override
	public String toString() {
		return "ArticleAndCategoryName [id=" + id + ", author=" + author + ", clickTimes=" + clickTimes + ", intro="
				+ intro + ", updateDate=" + updateDate + ", title=" + title + ", state=" + state + ", words=" + words
				+ ", categoryNmae=" + categoryNmae + "]";
	}
	
	
}
