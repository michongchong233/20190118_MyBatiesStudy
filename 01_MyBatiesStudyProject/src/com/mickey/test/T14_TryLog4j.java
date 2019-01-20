package com.mickey.test;

import org.apache.log4j.Logger;

public class T14_TryLog4j {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(T14_TryLog4j.class);
		logger.debug("debug message");//一般在方法內容使用
		logger.info("info message");//一般在調用方法使用
		logger.warn("warn message");//一般在需要警告的位置使用
		logger.error("error message");//在catch代碼塊中使用
		logger.fatal("fatal message");//在catch代碼塊中使用
	}
}
