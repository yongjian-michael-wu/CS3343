package System;

import java.util.Scanner;

public class CmdRegister implements Command {
	public CmdRegister() {}
	
	public String[] getParamList() {
		Scanner in = new Scanner(System.in);
		String[] paramList = new String[2];
		System.out.print("Username:");
		paramList[0] = in.nextLine();
		System.out.print("Password:");
		paramList[1] = in.nextLine();
		return paramList; 
	}
	
	public void execute(Role role, String[] paramList) {
		if(paramList!=null&&role.canRegister()) {
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			managementPortal.register(paramList);
		}
		else if(paramList==null) {}
		else {
			System.out.print("Logged in user cannot register.\n");
		}	
	}
}
