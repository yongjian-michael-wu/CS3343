package System;

public class CmdTopUp implements Command {
	public CmdTopUp() {}
	
	public void execute(Role role, String[] cmdList) {
		if(cmdList.length != 2) {
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
