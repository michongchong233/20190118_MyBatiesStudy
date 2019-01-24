package com.mickey.pojo;

import java.time.LocalDateTime;

public class TransferLog {
	private int transfer_id;
	private String out_account;
	private String in_account;
	private double transfer_money;
	private LocalDateTime transfer_datetime;

	public int getTransfer_id() {
		return transfer_id;
	}

	public void setTransfer_id(int transfer_id) {
		this.transfer_id = transfer_id;
	}

	public String getOut_account() {
		return out_account;
	}

	public void setOut_account(String out_account) {
		this.out_account = out_account;
	}

	public String getIn_account() {
		return in_account;
	}

	public void setIn_account(String in_account) {
		this.in_account = in_account;
	}

	public double getTransfer_money() {
		return transfer_money;
	}

	public void setTransfer_money(double transfer_money) {
		this.transfer_money = transfer_money;
	}

	public LocalDateTime getTransfer_datetime() {
		return transfer_datetime;
	}

	public void setTransfer_datetime(LocalDateTime transfer_datetime) {
		this.transfer_datetime = transfer_datetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((in_account == null) ? 0 : in_account.hashCode());
		result = prime * result + ((out_account == null) ? 0 : out_account.hashCode());
		result = prime * result + ((transfer_datetime == null) ? 0 : transfer_datetime.hashCode());
		result = prime * result + transfer_id;
		long temp;
		temp = Double.doubleToLongBits(transfer_money);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferLog other = (TransferLog) obj;
		if (in_account == null) {
			if (other.in_account != null)
				return false;
		} else if (!in_account.equals(other.in_account))
			return false;
		if (out_account == null) {
			if (other.out_account != null)
				return false;
		} else if (!out_account.equals(other.out_account))
			return false;
		if (transfer_datetime == null) {
			if (other.transfer_datetime != null)
				return false;
		} else if (!transfer_datetime.equals(other.transfer_datetime))
			return false;
		if (transfer_id != other.transfer_id)
			return false;
		if (Double.doubleToLongBits(transfer_money) != Double.doubleToLongBits(other.transfer_money))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransferLog [transfer_id=" + transfer_id + ", out_account=" + out_account + ", in_account=" + in_account
				+ ", transfer_money=" + transfer_money + ", transfer_datetime=" + transfer_datetime + "]";
	}

	public TransferLog(int transfer_id, String out_account, String in_account, double transfer_money,
			LocalDateTime transfer_datetime) {
		super();
		this.transfer_id = transfer_id;
		this.out_account = out_account;
		this.in_account = in_account;
		this.transfer_money = transfer_money;
		this.transfer_datetime = transfer_datetime;
	}

	public TransferLog() {
		super();
	}

}
