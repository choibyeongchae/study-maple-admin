package com.maple.admin.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

public class MainBannerDto {

	@Data
	public static class MainBannerSave {
		MultipartFile benner_image;
		String benner_title;
		String benner_stardate;
		String benner_endate;
		String benner_type;
		String banner_restype;
		String imgnm;
	}
}
