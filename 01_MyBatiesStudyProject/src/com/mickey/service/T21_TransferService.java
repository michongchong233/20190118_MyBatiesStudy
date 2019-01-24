package com.mickey.service;

import java.io.IOException;
import java.util.List;

import com.mickey.pojo.MessageCode;
import com.mickey.pojo.TransferLog;

public interface T21_TransferService {
	/**
	 * ¥Î¤áÂà±b
	 */
	MessageCode transferAccount(String outAccount_name, String outPassword, double money, String inAccount_name,
			String inName) throws IOException;
	
	List<TransferLog> selectAllLog() throws IOException;
}
