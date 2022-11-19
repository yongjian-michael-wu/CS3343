package System;


public class CmdChangeUserPlan implements Command {
	public CmdChangeUserPlan() {}
	
	public void execute(Role role, String[] cmdList) {
		if(cmdList.length != 2) {
			System.out.println("The parameters number is incorrect.");
			return;
		}
		if(role.canChangePlan()) {
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			managementPortal.changeUserPlan();
		}
		else {
			return;
		}
	}
}
