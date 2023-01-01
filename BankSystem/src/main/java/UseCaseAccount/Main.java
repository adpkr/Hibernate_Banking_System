package UseCaseAccount;

import java.util.Scanner;

import com.Dao.AccontDao;
import com.Dao.AccountDaoImp;
import com.Modul.Account;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press 1 for Create new account :");
		System.out.println("Press 2 for Delete account:");
		System.out.println("Press 3 for Account update :");
		System.out.println("Press 4 for find Account :");
		System.out.println("Press 5 for deposit amount :");
		System.out.println("Press 6 for withdrow amount:");
		
		
		AccontDao dao = new AccountDaoImp();
		
		int q = sc.nextInt();
		
		switch (q) {
		
		case 1:
			
			System.out.println("Enter your name:");
			String n = sc.next();
			System.out.println("Enter your balance:");
			int b = sc.nextInt();
			
			Account ac = new Account();
			ac.setName(n);
			ac.setBalance(b);
			
			
			boolean flag = dao.createAccount(ac);
			System.out.println(flag);
			System.out.println("Account created sucessfully... "+n);
			
			break;
			
			
			case 2:
				System.out.println("Enter bank acc :");
				int ac2 = sc.nextInt();
				
			    boolean flag2 = dao.deleteAccount(ac2);
			    System.out.println(flag2);
			    System.out.println("Delete account sucessfully.....");
			    
			    break;
			    
			    
			case 3:
				
				Account a = new Account();
				System.out.println("Enter Update acoo");
				int ac1 = sc.nextInt();
				
				
				System.out.println("Enter update name:");
				String name = sc.next();
				
				System.out.println("Enter update Balance:");
				int b1 = sc.nextInt();
				a.setAccno(ac1);
				a.setName(name);
				a.setBalance(b1);
				
				boolean flag3 = dao.updateAccount(a);
				System.out.println(flag3);
				System.out.println("Account sucessfully..... "+name);
				
				break;
				
				
			case 4:
				
				System.out.println("Enter Account Nob:");
				int a1 = sc.nextInt();
				
				Account acc = dao.findAccount(a1);
				System.out.println(acc);
				
				break;
				
				
			case 5:
				System.out.println("Enter Account Nob :");
				int ac3 = sc.nextInt();
				
				boolean f = dao.depositAmount(ac3);
				System.out.println(f);
				System.out.println("Deposit amount sucessfully....");
				
				break;
				
				
				
				
			case 6:
				System.out.println("Enter Account Nob :");
				int ac4 = sc.nextInt();
				
				boolean flag1 = dao.withdrowAmount(ac4);
				System.out.println(flag1);
				
				break;
				
				
			
		default:
			break;
		}
		
	}

}
