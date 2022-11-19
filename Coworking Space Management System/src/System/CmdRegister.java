package System;

public class CmdRegister implements Command {
	public CmdRegister() {}
	public void execute(Role role, String[] cmdList) {
		if(cmdList.length != 1) {
			System.out.println("The parameters number is incorrect.");
			return;
		}
		if(role.canRegister()) {
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			managementPortal.register();
		}
		else {
			System.out.println("Sorry logged in user cannot register.");
		}	
	}
}
