package com.maple.admin.dto;

import lombok.Data;

public class BoardDto {
	
	@Data
	public static class BoardSaveDto {
		private Integer boader_seq;
		private String boader_title;
		private String boader_contents;
	}
}
