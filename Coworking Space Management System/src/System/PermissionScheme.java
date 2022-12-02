package System;

public interface PermissionScheme {
	public boolean canRegister();
	public boolean canChangePlan();
	public boolean canSignOut();
	public boolean canTopUp();
	public boolean canCheckUserInfo();
	public boolean canCheckPersonalPaymentHistory();
	public boolean canReserveIndividualSpace();
	public boolean canBuyPackage();
	public boolean canReserveDiscussionRoom();
	public boolean canCancelReserve();
	public boolean canCheckPersonalReserveHistory();
//	public boolean CanRegister();
//	public boolean CanRegister();
//	public boolean CanRegister();
}
