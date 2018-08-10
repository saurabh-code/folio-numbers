package com.bootcamp.folio_range.components;

public class FolioTransaction {

	private int start;
	private int end;
	private String statusCode;
	private int transactionCode;
	
	public FolioTransaction(int start, int end, String statusCode, int transactionCode) {
		this.start = start;
		this.end = end;
		this.statusCode = statusCode;
		this.transactionCode = transactionCode;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public int getTransactionCode() {	
		return transactionCode;
	}

	@Override
	public String toString() {
		return "FolioTransaction [start=" + start + ", end=" + end + ", statusCode=" + statusCode + ", transactionCode="
				+ transactionCode + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FolioTransaction other = (FolioTransaction) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		if (statusCode == null) {
			if (other.statusCode != null)
				return false;
		} else if (!statusCode.equals(other.statusCode))
			return false;
		if (transactionCode != other.transactionCode)
			return false;
		return true;
	}
	
	
}
