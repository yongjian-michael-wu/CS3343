package System;

public class CmdCheckPaymentHistory implements Command {
	private ManagementPortal managementPortal = ManagementPortal.getInstance();
	
	public CmdCheckPaymentHistory() {}
	
	public String[] getParamList() {
		return null;
	}
	public void execute(Role role, String[] paramLst) {
		Customer currentCustomer = (Customer) managementPortal.getCurrentUser()
	}
}
