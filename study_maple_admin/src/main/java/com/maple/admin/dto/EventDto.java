package com.maple.admin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class EventDto {

	@Data
	public static class EventSaveDto {
		private Integer eventno;
		private String even_code;
		private String even_name;
		private String even_stardate;
		private String even_enddate;
		private String even_contents;
		private String even_viewcnt;
	}
}
