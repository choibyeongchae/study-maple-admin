package com.maple.admin.util;

import lombok.Getter;

@Getter
public class SuccessResponse {

	private Integer code;
	private String message;
	private Object obj;
	
	public SuccessResponse(Integer code, String message, Object obj) {
		this.code = code;
		this.message = message;
		this.obj = obj;
	}
}
