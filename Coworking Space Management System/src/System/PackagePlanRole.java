package System;

public class PackagePlanRole extends Role implements PermissionScheme {
	private static final PackagePlanRole instance = new PackagePlanRole();
	public PackagePlanRole() {
		super("Package");
	}
	public static PackagePlanRole getInstance() {
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
		return true;
	}
	@Override
	public boolean canBuyPackage() {
		return true; 
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
