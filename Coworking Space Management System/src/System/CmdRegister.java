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
		if(paramList==null) {
			return;
		}
		else if(role.canRegister()) {
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			managementPortal.register(paramList[0], paramList[1]);
		}
		else {
			System.out.println("Sorry logged in user cannot register.");
		}	
	}
}
