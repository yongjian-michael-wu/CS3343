package System;

public class CmdCheckPersonalPaymentHistory implements Command {	
	public CmdCheckPersonalPaymentHistory() {}
	
	public String[] getParamList() {
		return null;
	}
	public void execute(Role role, String[] paramLst) {
		if(role.canCheckPersonalPaymentHistory()) {
			ManagementPortal managementPortal = ManagementPortal.getInstance();
			Customer currentCustomer = (Customer) managementPortal.getCurrentUser();
			currentCustomer.getWallet().printPaymentHistory();
		}
		else {
			System.out.println(role.toString()+" has no payment record.");
		}
	}
}
