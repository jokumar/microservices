package com.sample.limitservice;

public class LimitConfiguration {

	
	private String min;
	private String max;
	
	public LimitConfiguration(String m,String n){
		this.min=m;
		this.max=n;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}
	
	
	
}
