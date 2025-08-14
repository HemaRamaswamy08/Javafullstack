package com.dyashin.springboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("User-response")
public class UserResponse {

	@JsonProperty("statusCode")
	private int statusCode;

	@JsonProperty("msg")
	private String msg;

	@JsonProperty("description")
	private String description;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Music> getBeans() {
		return beans;
	}

	public void setBeans(List<Music> beans) {
		this.beans = beans;
	}

	List<Music> beans;

}
