package com.mickey.test;

import org.apache.log4j.Logger;

public class T14_TryLog4j {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(T14_TryLog4j.class);
		logger.debug("debug message");//�@��b��k���e�ϥ�
		logger.info("info message");//�@��b�եΤ�k�ϥ�
		logger.warn("warn message");//�@��b�ݭnĵ�i����m�ϥ�
		logger.error("error message");//�bcatch�N�X�����ϥ�
		logger.fatal("fatal message");//�bcatch�N�X�����ϥ�
	}
}
