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
	public boolean canTopUp() {
		return false;
	}
	public boolean canCheckUserInfo() {
		return true;
	}
	public boolean canCheckPersonalPaymentHistory() {
		return false;
	}
	public boolean canReserver() {
		return false;
	}
}
