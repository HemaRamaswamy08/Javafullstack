package com.dyashin.springcode;

public class FestivalDiscount implements Discount{

	@Override
	public String getDiscount() {
		return "Please contact Customer care";
	}

}
