package com.mickey.pojo;

public class ResultMessage {
	enum ErrorCode{
		ERROR_001("ERROR_001", "�Τ�αK�X���~"),
		ERROR_002("ERROR_002", "�L����b�Τ�"),
		ERROR_003("ERROR_003", "�E�B����");
		
		private final String errorNum;
		private final String message;
		
		private ErrorCode(final String errorNum, final String message) {
			this.errorNum = errorNum;
			this.message = message;
		}
		
		
		
		
	}
}
