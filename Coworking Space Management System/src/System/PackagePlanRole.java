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
}
