package com.mickey.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mickey.pojo.User;
import com.mickey.service.UserService;

@Controller
public class UserController {
	@Resource
	UserService userServiceImpl;

	/**
	 * 查詢用戶
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("selectAllUser")
	public String selectAllUser(HttpServletRequest request) {
		List<User> users = userServiceImpl.selectAllUser();
		request.setAttribute("users", users);
		return "selectAllUser";
	}

	/**
	 * 建立新用戶
	 * 
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping("createUser")
	public String insertUser(HttpServletRequest request, MultipartFile file) {
		String page = "error";// 要進入頁面名
		String photo = file.getOriginalFilename();// 用戶上傳文件名
		String suffix = photo.substring(photo.lastIndexOf("."));// 取得後綴
		if (suffix.equalsIgnoreCase(".png") || suffix.equalsIgnoreCase("jpg")) {// 符合圖片格式
			String uuid = UUID.randomUUID().toString();
			// 取得服務器images文件夾的絕對路徑
			String path = request.getServletContext().getRealPath("images");
			photo = uuid + suffix;// 使用亂數重新定義文件名，避免文件重覆
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path + "\\" + photo));
			} catch (IOException e) {
				e.printStackTrace();
				return page;
			}
			// 將要存入數據庫的值放入pojo類
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setPhoto(photo);
			int insertNum = userServiceImpl.insertUser(user);
			if (insertNum == 1) {// 新增成功後轉至查詢頁面
				System.out.println("insert sussecc");
				page = "redirect:/selectAllUser";
			} else {// 新增失敗進入error頁面
				System.out.println("insert fail");
			}
		}
		return page;
	}

	/**
	 * 下載文件
	 * 
	 * @param fileName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("doDownloadFile")
	public void doDownloadFile(String fileName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 文件下載響應頭
		String path = request.getServletContext().getRealPath("images");
		response.setHeader("Content-Disposition", "attachment;filename=" + path + fileName);
		try {
			ServletOutputStream sos = response.getOutputStream();// 取得服務器images文件夾的絕對路徑
			File file = new File(path, fileName);
			byte[] bytes = FileUtils.readFileToByteArray(file);
			sos.write(bytes);
			sos.flush();
			// 更新數據庫數據
			int updateNum = userServiceImpl.doDownloadFile(fileName);
			if (updateNum == 1) {// 更新成功
				System.out.println("download update num success");
			} else {
				System.out.println("download update num fail");
			}
		} catch (IOException e) {// 如果找無文件就跳到error頁面
			e.printStackTrace();
			response.sendRedirect("/23_SpringMvcPractice_02/error.jsp");
		}
	}

	@RequestMapping("doLogin")
	public String doLogin(HttpServletRequest request) {
		String page = "error";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		User user = userServiceImpl.doLogin(username, password);
		System.out.println(user.toString());
		if (user != null) {// 如果有此用戶轉到登入成功頁面
			page = "loginSuccess";
		}
		return page;
	}

}
