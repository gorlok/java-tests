package com.example.netty;

class ResponseData {
	private int intValue;

	int getIntValue() {
		return intValue;
	}

	void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	@Override
	public String toString() {
		return "ResponseData{" + "intValue=" + intValue + '}';
	}
}