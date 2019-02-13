package com.mickey.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class T13_DownloadController {
	// class 13�A���U��
	@RequestMapping("downloadFile")
	public void downloadFile(String fileName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
//		PrintWriter out = response.getWriter();//�r�Ŭy
		// �]�m���U�����T���Y
		response.setHeader("Content-Disposition", "attachment;filename=T13_FileDownload_rename.txt");
		// �N�G�i�����J�T���餤
		ServletOutputStream os = response.getOutputStream();
		String path = request.getServletContext().getRealPath("file");
		File file = new File(path, fileName);// �r�`�y
		byte[] bytes = FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
	}

	// class 14�A���W��
	@RequestMapping("uploadFile")
	public String uploadFile(String name, MultipartFile file) throws IOException {
		System.out.println("name: " + name);
		String fileName = file.getOriginalFilename();//������W
		String suffix = fileName.substring(fileName.lastIndexOf("."));//������W��
		if(suffix.equalsIgnoreCase(".png")) {//�P�_���W������
			String uuid = UUID.randomUUID().toString();//�H�����W
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File("D:/"+uuid+suffix));
			return "T01_index";
		}else {
			return "T14_Error";
		}
	}
}
