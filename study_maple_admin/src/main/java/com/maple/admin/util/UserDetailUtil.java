package com.maple.admin.util;

import com.maple.admin.config.PrincipalDetails;

public class UserDetailUtil {

	PrincipalDetails principalDetails = null;
	
	public void setPrincipalDetails(PrincipalDetails principalDetails) {
		this.principalDetails = principalDetails;
	}
	
	public PrincipalDetails getPrincipalDetails() {
		return this.principalDetails;
	}
	
}
