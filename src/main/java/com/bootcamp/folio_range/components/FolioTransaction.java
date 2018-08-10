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
}
