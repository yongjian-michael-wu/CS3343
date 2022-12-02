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
				System.out.print("Please input a positive number.\n");
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
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			managementPortal.topUp(paramList);
		}
		else if(paramList==null) {}
		else {
			System.out.print(role.toString()+" role cannot top up.\n");
		}
	}
}