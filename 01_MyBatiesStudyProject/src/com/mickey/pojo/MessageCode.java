package com.mickey.pojo;

public enum MessageCode{
		ERROR_001("ERROR_001", "用戶或密碼錯誤"),
		ERROR_002("ERROR_002", "無此轉帳用戶"),
		ERROR_003("ERROR_003", "余額不足"),
		ERROR_004("ERROR_004", "不明錯誤"),
		ERROR_005("ERROR_005", "獲取資料失敗"),
		SUCCESS("SUCCESS", "操作成功");
		
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
