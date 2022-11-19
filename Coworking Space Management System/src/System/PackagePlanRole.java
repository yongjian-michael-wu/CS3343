package System;

public class PackagePlanRole extends Role {
	private static final PackagePlanRole instance = new PackagePlanRole();
	
	public PackagePlanRole() {
		super("Package");
	}
	
	public static PackagePlanRole getInstant() {
		return instance;
	}
	
	@Override
	public boolean canRegister() {
		return false;
	}
	@Override
	public boolean canChangePlan() {
		return true;
	}
	@Override
	public boolean canSignOut() {
		return true;
	}
	@Override
	public boolean canTopUp() {
		return true;
	}
	@Override
	public boolean canCheckPersonalPaymentHistory() {
		return true;
	}
	@Override
	public boolean canReserver() {
		return true;
	}
}
