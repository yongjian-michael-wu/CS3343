package System;

import java.util.UUID;

public class User {
	private UUID id;
	private Role role;
	
	public User() {
		this.id = UUID.randomUUID();
		this.role = VisitorRole.getInstance();
	}
	
	public UUID getId() {
		return this.id;
	}
	public Role getRole() {
		return this.role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	public String getInfo() {
		return "User ID: "+this.getId().toString()+";\nRole: "+this.getRole().toString()+"\n";
	}
	public String getOpeningMessage() {
		return "\nHi dear user, this is the management portal for our coworking space.\n"
				+ "Please type the abbreviation to select one of the following commands.\n"
				+ "Abbreviation:\tCommand:\n"
				+ "SignIn\t\tSign in;\n"
				+ "Reg\t\tRegister;\n"
				+ "Info\t\tView the user information;\n"
				+ "Exit\t\tExit.\n";
	}
}