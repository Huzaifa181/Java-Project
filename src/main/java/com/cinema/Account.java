package com.cinema;

public final class Account {
	static final String accountNo="PK02MEZN390209090000";
	static int price;
	public Account(int pri) {
		Account.price=pri;
	}
	public String getAccountNo()
    {
        return accountNo;
    }
   
    public int getPrice()
    {
        return price;
    }
}
