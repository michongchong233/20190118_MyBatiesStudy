package com.mickey.pojo;

public class ResultMessage {
	enum ErrorCode{
		ERROR_001("ERROR_001", "用戶或密碼錯誤"),
		ERROR_002("ERROR_002", "無此轉帳用戶"),
		ERROR_003("ERROR_003", "余額不足");
		
		private final String errorNum;
		private final String message;
		
		private ErrorCode(final String errorNum, final String message) {
			this.errorNum = errorNum;
			this.message = message;
		}
		
		
		
		
	}
}
