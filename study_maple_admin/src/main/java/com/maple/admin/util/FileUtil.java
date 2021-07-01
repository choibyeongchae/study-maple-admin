package com.maple.admin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static Map<String, Object> uploadImage(MultipartFile file) throws Exception {
		String uuid = UUID.randomUUID().toString();
		String rootPath = System.getProperty("user.dir");
		String basePath = rootPath + "/src/main/resources/static/upload";
		String copyDir = rootPath.substring(0,rootPath.indexOf("/maple-admin")) + "/maple-front/study_maple_front/src/main/resources/static/upload";
		String filePath = basePath + "/" + uuid+file.getOriginalFilename();
		
		File dest = new File(filePath);
		file.transferTo(dest);
		
		String filePath2 = copyDir + "/" + uuid+file.getOriginalFilename();
		
		FileUtil.copyFile(filePath, filePath2);
		
		String savePath = "/static/upload/" + uuid+file.getOriginalFilename();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("savePath", savePath);
		map.put("imageName", uuid+file.getOriginalFilename());
		
		return map;
		
	}
	
	public static void copyFile(String readFilePath, String copyFilepath) {
		File readFile = new File(readFilePath);
		File copyFile = new File(copyFilepath);
		
		try {
			FileInputStream fis = new FileInputStream(readFile);
			FileOutputStream fos  = new FileOutputStream(copyFile);
			
			int fileByte = 0;
			
			while ((fileByte = fis.read()) != -1) {
				fos.write(fileByte);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
