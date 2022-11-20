package System;

public class MonthlyPlanRole extends Role {
	private static final MonthlyPlanRole instance = new MonthlyPlanRole();
	
	public MonthlyPlanRole() {
		super("Monthly");
	}
	
	public static MonthlyPlanRole getInstance() {
		return instance;
	}
	@Override
	public boolean canRegister() {
		return false;
	}
	@Override
	public boolean canChangePlan() {
		return false;
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
		return false;
	}
	@Override
	public boolean canBuyPackage() {
		return false; 
	}
}
