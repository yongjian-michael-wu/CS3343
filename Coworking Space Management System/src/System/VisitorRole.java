package System;

public class VisitorRole extends Role implements PermissionScheme {
	private static final VisitorRole instance = new VisitorRole();
	
	public VisitorRole() {
		super("Visitor");
		}
	
	public static VisitorRole getInstance() {
		return instance;
	}
	
	@Override
	public boolean canRegister() {
		return true;
	}
	@Override
	public boolean canChangePlan() {
		return false;
	}
	@Override
	public boolean canSignOut() {
		return false;
	}
	@Override
	public boolean canTopUp() {
		return false;
	}
	@Override
	public boolean canCheckPersonalPaymentHistory() {
		return false;
	}
	@Override
	public boolean canReserveIndividualSpace() {
		return false;
	}
	@Override
	public boolean canBuyPackage() {
		return false; 
	}
}
