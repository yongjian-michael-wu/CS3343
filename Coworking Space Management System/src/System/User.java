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
}