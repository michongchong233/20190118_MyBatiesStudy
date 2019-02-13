package com.mickey.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class T13_DownloadController {
	// class 13，文件下載
	@RequestMapping("downloadFile")
	public void downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		PrintWriter out = response.getWriter();//字符流
		// 設置文件下載的響應頭
		response.setHeader("Content-Disposition", "attachment;filename=T13_FileDownload_rename.txt");
		// 將二進制文件放入響應體中
		ServletOutputStream os = response.getOutputStream();
		String path = request.getServletContext().getRealPath("file");
		File file = new File(path, fileName);// 字節流
		byte[] bytes = FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
	}

	// class 14，文件上傳
	@RequestMapping("uploadFile")
	// class 14，文件上傳
	public String uploadFile(String name, MultipartFile file) {
		System.out.println("name: " + name);
		return "index";
	}
}
