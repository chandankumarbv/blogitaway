package com.cisco.cbv.blogitaway.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Blog {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String content;
	private String createdAt;
	@ManyToOne(cascade=CascadeType.ALL)
	private User owner;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comments;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Tag> tags;
	private int votes;
	private boolean reportAbuse;
	private boolean published;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

}
