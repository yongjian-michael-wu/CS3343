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
	
}
