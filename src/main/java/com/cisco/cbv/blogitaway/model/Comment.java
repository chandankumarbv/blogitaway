package com.cisco.cbv.blogitaway.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private int commentId;
	@OneToOne
	private User owner;
	@ManyToOne(cascade=CascadeType.ALL)
	private Blog blog;
	private String createdAt;
	private int votes;
	private boolean reportAbuse;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public boolean isReportAbuse() {
		return reportAbuse;
	}

	public void setReportAbuse(boolean reportAbuse) {
		this.reportAbuse = reportAbuse;
	}

}
