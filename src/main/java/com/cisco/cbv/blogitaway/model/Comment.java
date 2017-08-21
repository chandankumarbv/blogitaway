package com.cisco.cbv.blogitaway.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity
public class Comment {

	@Id
	private int commentId;
	@Reference
	private User owner;
	@Reference
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
