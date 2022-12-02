package System;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Customer extends User {
	private String username;
	private String password;
	private Wallet wallet;
	private UserPlan plan;
	private UserPlan waitingPlan;
	private ArrayList<ReserveRecord> reserveHistory;
	
	public Customer(String username, String password) {
		super();
		super.setRole(PackagePlanRole.getInstance());
		this.plan = new PackagePlan();
		this.username = username;
		this.password = password;
		this.wallet = new Wallet(this);
		this.reserveHistory = new ArrayList<ReserveRecord>();
	}

	public Wallet getWallet() {
		return this.wallet;
	}
	public String getUserName() {
		return this.username;
	}
	public UserPlan getPlan() {
		return this.plan;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void addRemainHour(int amount) {
		this.plan.addRemainHour(amount);
	}
	public ArrayList<ReserveRecord> getReserveHistory() {
		return this.reserveHistory;
	}
	public void addReserveRecord(ReserveRecord reserveRecord) {
		this.reserveHistory.add(reserveRecord);
	}
	public void removeReserveRecord(ReserveRecord reserveRecord) {
		double price = reserveRecord.getPrice();
		this.reserveHistory.remove(reserveRecord);
		getWallet().topUp(price, "Cancellation refund.");
	}
	public ReserveRecord searchReserveRecordById(UUID id) {
		for(ReserveRecord r:reserveHistory) {
			if(r.getId().equals(id)) {
				return r;
			} 
		}
		return null;
	}
	public void updateUserPlan(String planName, int param) {
		if(planName.equals(this.plan.getType())) {
			System.out.print("Cannot change to the same plan.\n");
			return;
		}
		int remainHour = this.plan.getRemainHour();
		if(planName.equals("Package")) {
			this.plan = new PackagePlan(param+remainHour);
			this.setRole(PackagePlanRole.getInstance());
			System.out.print("Convert to package plan successfully.\n");
		}
		else if(planName.equals("Monthly")) {
			boolean isPrivate;
			if(param==1)	isPrivate=false;
			else	isPrivate=true;
			this.waitingPlan = new MonthlyPlan(isPrivate);
			System.out.print("Convert to monthly plan successfully.\n");
		}
	}
	public void topUpPackage(int amount) {
		this.plan.addRemainHour(amount);
	}
	
	@Override
	public String getInfo() {
		return "User ID: "+this.getId().toString()
				+";\nUser Name: "+this.getUserName()
				+";\nRole: "+this.getRole().toString()
				+";\n"+this.getPlan().getInfo()
				+this.getWallet().getInfo();
	}

	@Override
	public String getOpeningMessage() {
		return "\nHi dear "+this.getUserName()+", this is the management portal for our coworking space.\n"
				+ "Please type the abbreviation to select one of the following commands.\n"
				+ "Abbreviation:\tCommand:\n"
				+ "ResInd\t\tReserve common slot;\n"
				+ "ResDis\t\tReserve discussion room;\n"
				+ "CanRes\t\tCancel reservation order;\n"
				+ "PayHis\t\tCheck payment history;\n"
				+ "ResHis\t\tCheck reservation history;\n"
				+ "Info\t\tView the user information;\n"
				+ "ChngPlan\tChange your current user plan;\n"
				+ "ButPac\t\tBuy time package;\n"
				+ "TopUp\t\tTop up.\n"
				+ "SignOut\t\tSign out;\n"
				+ "Exit\t\tExit;\n";
	}
	
	// false when conflict happened
	public boolean checkReseveConflict(LocalDateTime startTime,LocalDateTime endTime) {
		int time = 0;
		for(ReserveRecord r:reserveHistory) {
			if(r.checkOverlap(startTime,endTime)) {
				if(time>=2) {
					return false;
				}
				time+=1;
			}
		}
		return true;
	}
	
	public void printReserveHistory() {
		System.out.print("Here're all past reservation record: \n");
		for(ReserveRecord r: reserveHistory) {
			System.out.print("--------------------------\n");
			System.out.print(r.toString());
		}
	}
}
