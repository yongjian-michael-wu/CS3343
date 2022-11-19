package System;

import java.util.Scanner;

public class CmdTopUp implements Command {
	public CmdTopUp() {}
	
	public String[] getParamList() {
		String[] paramList = new String[1];
		Scanner in = new Scanner(System.in);
		System.out.print("Please input the amount you want to top up: ");
		try {
			double amount = in.nextDouble();
			if(amount > 0) {
				paramList[0] = amount+"";
			}
			else {
				System.out.println("Please input a positive number.");
				return null;
			}
		}
		catch(Exception e) {
			System.out.println("Please input a number.");
			return null;
		}
		
		return paramList;
	}
	
	public void execute(Role role, String[] paramList) {
		if(paramList!=null && role.canTopUp()) {
			double amount = Double.parseDouble(paramList[0]);
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			Customer currentCustomer = (Customer) managementPortal.getCurrentUser();
			currentCustomer.getWallet().topUp(amount);
		}
		else {
			System.out.println(role.toString()+" cannot top up.");
		}
	}
}
