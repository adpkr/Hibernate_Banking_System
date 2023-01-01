package com.Dao;

import com.Modul.Account;

public interface AccontDao {
	
	public boolean createAccount(Account acc);
	
	public boolean deleteAccount(int acc);
	
	public boolean updateAccount(Account acc);
	
	public Account findAccount(int acc); 
	
	public boolean depositAmount(int acc);
	
	public boolean withdrowAmount(int acc);

}
