package com.mickey.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用於産生隨機驗證碼圖片的Servlet
 */
@WebServlet(urlPatterns = { "/09_02_test" }, initParams = { @WebInitParam(name = "09_02_test", value = "09_02_test") })
public class T09_VaildCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageHeight = 60;
		int pageWidth = 150;
		// 在内存中生成一张空的图片，宽为150px，高为60px，类型是RGB
		BufferedImage bi = new BufferedImage(pageWidth, pageHeight, BufferedImage.TYPE_INT_RGB);
		// 在畫板上畫之前必須要先設定畫筆
		Graphics graphics = bi.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, 200, 100);// 從哪個坐標開始填充，後兩個參數代表這個矩型的大小
		graphics.setColor(Color.BLUE);
		// 生成亂數並將生成的驗證碼內容放到畫布中
		StringBuffer codeStr = new StringBuffer();
		Random random = new Random();
		for (int i = 1; i <= 5; i++) {
			String str = Integer.toString(random.nextInt(10));
			codeStr.append(str);
			int fontSize = random.nextInt(25)+20;
			graphics.setFont(new Font(null, Font.BOLD, fontSize));
			graphics.drawString(str.toString(), 20 * i, random.nextInt(pageHeight-fontSize)+fontSize);// 在圖片上寫字，橫軸為20，縱軸(高度)為50
		}
		//隨機畫驗證碼圖上的線
		int lineNum = random.nextInt(5)+3;
		for(int i = 1;i<=lineNum;i++) {
			graphics.setColor(Color.BLACK);
			graphics.drawLine(0, random.nextInt(pageHeight), pageWidth, random.nextInt(pageHeight));
		}
		//把驗證碼放入session中
		HttpSession session = request.getSession();
		session.setAttribute("code", codeStr.toString());

		// 獲取Servlet的輸出流
		ServletOutputStream os = response.getOutputStream();
		// 工具類，裝image放入流中(哪張圖片，設定格式，往哪個流放)
		ImageIO.write(bi, "jpg", os);

	}

}
