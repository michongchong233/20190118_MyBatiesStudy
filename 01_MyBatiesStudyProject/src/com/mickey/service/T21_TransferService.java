package com.mickey.service;

import java.io.IOException;

import com.mickey.pojo.MessageCode;

public interface T21_TransferService {
	/**
	 * �Τ���b
	 * @return 
	 * @throws IOException 
	 */
	MessageCode transferAccount(String outAccount_name, String outPassword, double money, String inAccount_name, String inName)
			throws IOException;
}
