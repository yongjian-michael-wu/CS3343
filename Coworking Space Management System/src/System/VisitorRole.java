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
}
