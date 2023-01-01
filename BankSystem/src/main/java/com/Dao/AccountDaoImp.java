package com.Dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.EmUtil.EmUtil;
import com.Modul.Account;

public class AccountDaoImp implements AccontDao{

	@Override
	public boolean createAccount(Account acc) {
		
		boolean flag = false;
		
		EntityManager em= EmUtil.provideEntityManager();
		
		
//		Account ac = new Account();
//		ac.setName("Addep");
//		ac.setBalance(50000);
		
		em.getTransaction().begin();
		em.persist(acc);
		flag = true;
		;
		em.getTransaction().commit();
		
		
		em.close();
		
		
		return flag;
	}

	@Override
	public boolean deleteAccount(int acc) {
		
		boolean flag = false;
		
		EntityManager em= EmUtil.provideEntityManager();
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter bank acc :");
//		int ac = sc.nextInt();
		
		
		Account a= em.find(Account.class, acc);
		
		if( a != null) {
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			flag = true;
		}
		
		em.close();
		
		return flag;
		
	}

	@Override
	public boolean updateAccount(Account acc) {
		
		boolean flag = false;
		
		EntityManager em =  EmUtil.provideEntityManager();
		
		
//		System.out.println("Enter Update acoo");
//		int ac = sc.nextInt();
//		
		Account a= em.find(Account.class, acc.getAccno());
//		System.out.println("Enter update name:");
//		String name = sc.next();
//		
//		System.out.println("Enter update Balance:");
//		int b = sc.nextInt();
		
//		a.setName(name);
//		a.setBalance(b);
		
		em.getTransaction().begin();
		em.merge(acc);
		em.getTransaction().commit();
		
		flag  =true;
		
		em.close();
		
		
		return flag;
		
	}

	@Override
	public Account findAccount(int acc) {
		
		Account ac = null;
		
		EntityManager em= EmUtil.provideEntityManager();
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter Account Nob:");
//		int a = sc.nextInt();
		
		 ac= em.find(Account.class, acc);
		
		
		
		em.close();
		
		return ac;
		
	}

	@Override
	public boolean depositAmount(int acc) {
		
		boolean flag = false;
		
		
		EntityManager em= EmUtil.provideEntityManager();
		Account a= em.find(Account.class, acc);
		
		em.getTransaction().begin();
		
		if(a != null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Deposit amount :");
			int da = sc.nextInt();
			
			a.setBalance(a.getBalance()+da);
			flag = true;
			
			
		}
		else {
			System.out.println("Account does not exist...");
		}
		
		em.getTransaction().commit();
		
		em.close();
		
		return flag;
		
	}

	@Override
	public boolean withdrowAmount(int acc) {
		
		boolean flag = false;
		
		EntityManager em= EmUtil.provideEntityManager();
		
		Account ac =  em.find(Account.class, acc);
		em.getTransaction().begin();
		
		if(ac!=null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter withdrow amount :");
			int wa = sc.nextInt();
			
			if(wa <= ac.getBalance()) {
				ac.setBalance(ac.getBalance()-wa);
				System.out.println("Widthdraw Sucessfull.....");
				flag = true;
			}
			else {
				System.out.println("Incifisent Balance....");
			}
		}
		
		em.getTransaction().commit();
		em.close();
		
		return flag;
		
	}

}
