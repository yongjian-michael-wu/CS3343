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
	public boolean canReserveIndividualSpace() {
		return true;
	}
	@Override
	public boolean canBuyPackage() {
		return true; 
	}
}
