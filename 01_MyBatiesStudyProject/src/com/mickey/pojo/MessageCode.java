package com.mickey.pojo;

public enum MessageCode{
		ERROR_001("ERROR_001", "�Τ�αK�X���~"),
		ERROR_002("ERROR_002", "�L����b�Τ�"),
		ERROR_003("ERROR_003", "�E�B����"),
		ERROR_004("ERROR_004", "�������~"),
		ERROR_005("ERROR_005", "�����ƥ���"),
		SUCCESS("SUCCESS", "�ާ@���\");
		
		private final String errorNum;
		private final String message;
		
		private MessageCode(final String errorNum, final String message) {
			this.errorNum = errorNum;
			this.message = message;
		}

		public String getErrorNum() {
			return errorNum;
		}

		public String getMessage() {
			return message;
		}

}
