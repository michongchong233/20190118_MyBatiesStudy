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
	 * �d�ߥΤ�
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
	 * �إ߷s�Τ�
	 * 
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping("createUser")
	public String insertUser(HttpServletRequest request, MultipartFile file) {
		String page = "error";// �n�i�J�����W
		String photo = file.getOriginalFilename();// �Τ�W�Ǥ��W
		String suffix = photo.substring(photo.lastIndexOf("."));// ���o���
		if (suffix.equalsIgnoreCase(".png") || suffix.equalsIgnoreCase("jpg")) {// �ŦX�Ϥ��榡
			String uuid = UUID.randomUUID().toString();
			// ���o�A�Ⱦ�images��󧨪�������|
			String path = request.getServletContext().getRealPath("images");
			photo = uuid + suffix;// �ϥζüƭ��s�w�q���W�A�קK�����
			try {
				FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path + "\\" + photo));
			} catch (IOException e) {
				e.printStackTrace();
				return page;
			}
			// �N�n�s�J�ƾڮw���ȩ�Jpojo��
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setPhoto(photo);
			int insertNum = userServiceImpl.insertUser(user);
			if (insertNum == 1) {// �s�W���\����ܬd�߭���
				System.out.println("insert sussecc");
				page = "redirect:/selectAllUser";
			} else {// �s�W���Ѷi�Jerror����
				System.out.println("insert fail");
			}
		}
		return page;
	}

	/**
	 * �U�����
	 * 
	 * @param fileName
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("doDownloadFile")
	public void doDownloadFile(String fileName, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// ���U���T���Y
		String path = request.getServletContext().getRealPath("images");
		response.setHeader("Content-Disposition", "attachment;filename=" + path + fileName);
		try {
			ServletOutputStream sos = response.getOutputStream();// ���o�A�Ⱦ�images��󧨪�������|
			File file = new File(path, fileName);
			byte[] bytes = FileUtils.readFileToByteArray(file);
			sos.write(bytes);
			sos.flush();
			// ��s�ƾڮw�ƾ�
			int updateNum = userServiceImpl.doDownloadFile(fileName);
			if (updateNum == 1) {// ��s���\
				System.out.println("download update num success");
			} else {
				System.out.println("download update num fail");
			}
		} catch (IOException e) {// �p�G��L���N����error����
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
		if (user != null) {// �p�G�����Τ����n�J���\����
			page = "loginSuccess";
		}
		return page;
	}

}
