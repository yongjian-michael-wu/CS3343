package System;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {
	private String username;
	private String password;
	private Wallet wallet;
	private UserPlan plan;
	private ArrayList<ReserveRecord> reserveHistory;
	
	public Customer(String username, String password) {
		super();
		super.setRole(BasicPlanRole.getInstance());
		this.plan = new BasicPlan();
		this.username = username;
		this.password = password;
		this.wallet = new Wallet();
		this.reserveHistory = new ArrayList<ReserveRecord>();
	}

	public Wallet getWallet() {
		return this.wallet;
	}
	
	

	public void convertUserPlan(String planName, int param) {
		if(planName.equals(this.plan.getType())) {
			System.out.println("Cannot change to the same plan.");
			return;
		}
		int remainHour = this.plan.getRemainHour();
		if(planName.equals("Basic")) {
			this.plan = new BasicPlan(remainHour);
			this.setRole(BasicPlanRole.getInstance());
		}
		else if(planName.equals("Package")) {
			this.plan = new PackagePlan(param);
			this.setRole(PackagePlanRole.getInstant());
		}
		else if(planName.equals("Monthly")) {
			this.plan = new MonthlyPlan();
		}
	}
}
