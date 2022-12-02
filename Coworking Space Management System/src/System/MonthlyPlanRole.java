package System;

public class MonthlyPlanRole extends Role implements PermissionScheme {
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
	public boolean canSignIn() {
		return false;
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
	@Override
	public boolean canReserveDiscussionRoom() {
		return true;
	}
	@Override
	public boolean canCancelReserve() {
		return true;
	}
	@Override
	public boolean canCheckPersonalReserveHistory() {
		return true;
	}
	@Override
	public boolean canCheckGlobalUserInfo() {
		return false;
	}
	@Override
	public boolean canCheckGlobalReserveHistory() {
		return false;
	}
	@Override
	public boolean canCheckGlobalPaymentHistory() {
		return false;
	}
	@Override
	public boolean canRefund() {
		return false;
	}
	@Override
	public boolean canChangeGlobalUserInfo() {
		return true;
	}
}
