package System;

public class BasicPlanRole extends Role {
	private static final BasicPlanRole instance = new BasicPlanRole();
	
	public BasicPlanRole() {
		super("Basic");
	}
	
	public static BasicPlanRole getInstance() {
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
