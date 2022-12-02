package System;

public class Role implements PermissionScheme {
	private String name;
	public Role(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
	public boolean canRegister() {
		return false;
	}
	public boolean canChangePlan() {
		return false;
	}
	public boolean canSignOut() {
		return false;
	}
	public boolean canSignIn() {
		return false;
	}
	public boolean canTopUp() {
		return false;
	}
	public boolean canCheckUserInfo() {
		return true;
	}
	public boolean canCheckPersonalPaymentHistory() {
		return false;
	}
	public boolean canReserveIndividualSpace() {
		return false;
	}
	public boolean canBuyPackage() {
		return false; 
	}
	public boolean canReserveDiscussionRoom() {
		return false;
	}
	public boolean canCancelReserve() {
		return false;
	}
	public boolean canCheckPersonalReserveHistory() {
		return false;
	}
	public boolean canCheckGlobalUserInfo() {
		return false;
	}
	public boolean canCheckGlobalReserveHistory() {
		return false;
	}
	public boolean canCheckGlobalPaymentHistory() {
		return false;
	}
	public boolean canRefund() {
		return false;
	}
	public boolean canChangeGlobalUserInfo() {
		return false;
	}
}
