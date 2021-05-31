package com.cinema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SubmitFee {
	//This is just for testing
	//We get deposited amount from backend and fee from input field in the VIEW
	String depositedAmount="10000";
	@Test
	void test() {
		Fee fee=new Fee("2",depositedAmount);
		System.out.println(fee.getFee()+depositedAmount);
	}
}
