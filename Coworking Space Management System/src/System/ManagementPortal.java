package System;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;


public class ManagementPortal {
	
	private static final ManagementPortal instance = new ManagementPortal();
	private User currentUser;
	private boolean isLoggedIn;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Space> spaceList = new ArrayList<Space>();
	private ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private ArrayList<ReserveRecord> reserveRecordList = new ArrayList<ReserveRecord>();
	
	private ManagementPortal() {
		this.currentUser = new User();
		this.isLoggedIn = false;
		initSpace();
	}
	
	
	
	private void initSpace() { 
		for(int i = 0; i < 4; i++) {
			spaceList.add(new Space(DiscussionRoom.getInstance(), i));
		}
		for(int i = 0; i < 10; i++) {
			spaceList.add(new Space(PrivateSlot.getInstance(), i));
		}
		for(int i = 0; i < 20; i++) {
			spaceList.add(new Space(CommonSlot.getInstance(), i));
		}
	}
	
	public static ManagementPortal getInstance() {
		return instance;
	}
	
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	public Role getCurrentUserRole() {
		return this.currentUser.getRole();
	}
	
	
	
	/*
	 * This section is 1-to-1 mapped with commands.
	 * Each method corresponds to one command's execute method.
	 */
	
	// for CmdCheckUserInfo class
	public void printUserInfo() {
		System.out.print(this.currentUser.getInfo());
	}
	
	// for CmdRegister class
	public void register(String[] paramList) {
		String username = paramList[0];
		String password = paramList[1];
		if(isExist(username)!=null) {
			this.currentUser = new Customer(username, password);
			customerList.add((Customer)this.currentUser);
			this.isLoggedIn = true;
		}
		else {
			System.out.print("This username has been used.\n");
		}
	}
	
	// for CmdSignIn
	public void signIn(String[] paramList) {
		String username = paramList[0];
		String password = paramList[1];
		// check whether administrator account
		if(username.equals("admin")&&password.equals("qwertyui")) {
			this.currentUser = new Admin();
			this.isLoggedIn = true;
			return;
		}
		Customer customer = isExist(username);
		if(customer!=null&&customer.getPassword().equals(password)) {
			this.currentUser = customer;
			this.isLoggedIn = true;
		}
		else if(customer==null) {
			System.out.print("The username does not exist.\n");
		}
		else {
			System.out.print("The password is wrong.\n");
		}
	}
	
	// for CmdSignOut class
	public void signOut() {
		this.currentUser = new User();
		this.isLoggedIn = false;
	}
	
	// for CmdChangeUserPlan class
	public void changeUserPlan(String[] paramList) {
		String userPlanIndex = paramList[0];
		Customer currentCustomer = (Customer) this.currentUser;
		switch(userPlanIndex) {
			case "1":
				if(currentCustomer.getRole().toString().equals("Package")) {
					System.out.print("You are already in package plan.\n");
					return;
				}
				else {
					MonthlyPlan currentPlan = (MonthlyPlan) currentCustomer.getPlan();
					double consumeRatio = LocalDate.now().getDayOfMonth()/LocalDate.now().lengthOfMonth();
					int additionalHour = (int) ((currentPlan.getPrivate()?200:100)*(1-consumeRatio));
					currentCustomer.updateUserPlan("Package", additionalHour);
				}
				break;
			case "2":
				if(currentCustomer.getRole().toString().equals("Monthly")) {
					System.out.print("You are already in monthly plan.\n");
					return;
				}
				else {
					String spaceTypeIndex = paramList[1];
					Space space;
					Payment payment;
					switch(spaceTypeIndex) {
						case "1":
							space = getAvailableMonthlySlot(false);
							if(space!=null) {
								payment = currentCustomer.getWallet().pay(900,"Monthly common slot payment.");
								if(payment!=null) {
									LocalDateTime startTime = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).atStartOfDay();
									LocalDateTime endTime = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).plusMonths(1).plusDays(-1).atTime(LocalTime.MAX);
									ReserveRecord reserveRecord = new ReserveRecord(startTime, endTime, payment, currentCustomer,space);
									reserveRecordList.add(reserveRecord);
									currentCustomer.addReserveRecord(reserveRecord);
									space.addReserveRecord(reserveRecord);
									currentCustomer.updateUserPlan("Monthly",1);
								}
								else {
									System.out.print("Sorry you don't have enough money.\n");
									return;
								}
							}
							else {
								System.out.print("Sorry no available monthly common slot for next month.\n");
								return;
							}
							break;
						case "2":
							space = getAvailableMonthlySlot(true);
							if(space!=null) {
								payment = currentCustomer.getWallet().pay(1800,"Monthly private slot payment.");
								if(payment!=null) {
									LocalDateTime startTime = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).atStartOfDay();
									LocalDateTime endTime = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth()).plusMonths(1).plusDays(-1).atTime(LocalTime.MAX);
									ReserveRecord reserveRecord = new ReserveRecord(startTime, endTime, payment, currentCustomer,space);
									reserveRecordList.add(reserveRecord);
									currentCustomer.addReserveRecord(reserveRecord);
									space.addReserveRecord(reserveRecord);
									currentCustomer.updateUserPlan("Monthly",2);
								}
								else {
									System.out.print("Sorry you don't have enough money.\n");
									return;
								}
							}
							else {
								System.out.println("Sorry no available monthly common slot for next month.");
								return;
							}
							break;
					}
				}
				break;
		}
	}
	
	public Customer getCustomer() {

		Customer customer = (Customer) this.currentUser;
		return customer;
	}
	
	// for CmdBuyPackage class
	public void buyPackage(String[] paramList) {
		Customer currentCustomer = (Customer) this.currentUser;
		String packageIndex = paramList[0];
		switch(packageIndex) {
		case "1":
			if(currentCustomer.getWallet().pay(120, "10 hours package payment.")!=null) {
				currentCustomer.topUpPackage(10);
			}
			else {
				System.out.print("Sorry your balance is insufficient for 10 hours package.\n");
			}
			break;
		case "2":
			if(currentCustomer.getWallet().pay(315, "30 hours package payment.")!=null) {
				currentCustomer.topUpPackage(30);
			}
			else {
				System.out.print("Sorry your balance is insufficient for 30 hours package.\n");
			}
			break;
		case "3":
			if(currentCustomer.getWallet().pay(450, "50 hours package payment.")!=null) {
				currentCustomer.topUpPackage(50);
			}
			else {
				System.out.print("Sorry your balance is insufficient for 50 hours package.\n");
			}
			break;
		}
	}
	
	// for CmdCancelReserveRecord class
	public void cancelReserveRecord(String[] paramList) {
		UUID id = UUID.fromString(paramList[0]);
		ReserveRecord reserveRecord = searchReserveRecordById(id);
		if(reserveRecord!=null && reserveRecord.getStartTime().isAfter(LocalDateTime.now())) {
			Customer customer = reserveRecord.getCustomer();
			this.reserveRecordList.remove(reserveRecord);
			customer.removeReserveRecord(reserveRecord);
			Space space = reserveRecord.getSpace();
			space.removeReserveRecord(reserveRecord);
			System.out.print("Removed successfully.\n");
		}
		else if(reserveRecord.getStartTime().isBefore(LocalDateTime.now())) {
			System.out.println("You cannot cancel an outdated order.");
		}
		else {
			System.out.print("Cannot find the record by the id provided.\n");
		}
	}
	
	// for CmdTopUp class
	public void topUp(String[] paramList) {
		double amount = Double.parseDouble(paramList[0]);
		Customer currentCustomer = getCustomer();
		currentCustomer.getWallet().topUp(amount, "Top up "+amount+"HKD");
	}
	
	public void printOpeningMessage() {
		System.out.print(this.currentUser.getOpeningMessage());
	}
	
	// for CmdReserveIndividualSpace class
	public void reserveSpace(String[] paramList) {
		LocalDate date = LocalDate.parse(paramList[0]);
		int duration = Integer.parseInt(paramList[2])-Integer.parseInt(paramList[1]);
		LocalTime start = LocalTime.of(Integer.parseInt(paramList[1]),00);
		LocalTime end = LocalTime.of(Integer.parseInt(paramList[2]),00);
		LocalDateTime startTime = LocalDateTime.of(date,start);
		LocalDateTime endTime = LocalDateTime.of(date,end);
		if(startTime.isBefore(LocalDateTime.now())) { 
			System.out.print("You cannot reserve a past session.\n");
			return;
		}
		Customer currentCustomer = (Customer) currentUser;
		if(!currentCustomer.checkReseveConflict(startTime, endTime)) {
			System.out.println("Reservation failed. Cannot make more than two reservation at a time.");
			return;
		}
		boolean isAvailable = false;
		for(Space s:spaceList) {
			switch(paramList[3]) {
			case "1":
				if(s.getTypeName().equals("Common Slot") && s.checkReserveConflict(startTime, endTime)) {
					isAvailable = true;
					if(currentCustomer.getPlan().consumeRemainHour(duration)) {
						System.out.println("Reseveation succeeds.");
						ReserveRecord reserveRecord = new ReserveRecord(startTime, endTime, null, currentCustomer, s);
						reserveRecordList.add(reserveRecord);
						currentCustomer.addReserveRecord(reserveRecord);
						s.addReserveRecord(reserveRecord);
						return;
					}
					else {
						Payment payment = currentCustomer.getWallet().pay(duration*15, "Common slot reservation");
						if(payment!=null) {
							ReserveRecord reserveRecord = new ReserveRecord(startTime, endTime, payment, currentCustomer, s);
							reserveRecordList.add(reserveRecord);
							currentCustomer.addReserveRecord(reserveRecord);
							s.addReserveRecord(reserveRecord);
							return;
						}
						else {
							System.out.println("Insufficient balance. Payment failed.");
							return;
						}
					}
				}
				break;
			case "2":
				if(s.getTypeName().equals("Discussion Room") && s.checkReserveConflict(startTime, endTime)) {
					isAvailable = true;
					Payment payment = currentCustomer.getWallet().pay(duration*60, "Common slot reservation");
					if(payment!=null) {
						ReserveRecord reserveRecord = new ReserveRecord(startTime, endTime, payment, currentCustomer, s);
						reserveRecordList.add(reserveRecord);
						currentCustomer.addReserveRecord(reserveRecord);
						s.addReserveRecord(reserveRecord);
						return;
					}
					else {
						System.out.println("Insufficient balance. Payment failed.");
						return;
					}
				}
				break;
			}
		}
		if(!isAvailable) {
			System.out.println("Reservation failed. No available slot for this session.");
		}
	}

	// for CmdCheckGlobalUserInfo class
	public void printGlobalUserInfo() {
		System.out.print("Here's all customers.\n");
		for(Customer c: customerList) {
			System.out.print("--------------------------\n");
			System.out.print(this.currentUser.getInfo());
		}
	}
	
	// for CmdChangeGlobalUserInfo class
	public void changeUserInfo(String[] paramList) {
		UUID id = UUID.fromString(paramList[0]);
		Customer customer = searchCustomerById(id);
		if(customer!=null) {
			String property = paramList[1];
			String newValue = paramList[2];
			switch(property) {
			case "1":
				if(isExist(newValue)!=null) {
					System.out.print("The new username has already existed.\n");
					return;
				}
				customer.setUsername(newValue);
				break;
			case "2":
				customer.setPassword(newValue);
				break;
			};
			System.out.print("Changed successfully.\n");
		}
		else {
			System.out.print("Cannot find the customer by the id provided.\n");
		}
	}
	
	// for CmdCheckGlobalReserveHitory class
	public void printGlobalReserveHistory() {
		System.out.print("Here're all past reservation record: \n");
		for(ReserveRecord r: reserveRecordList) {
			System.out.print("--------------------------\n");
			System.out.print(r.toString());
		}
	}
	
	// for CmdCheckGlobalPaymentHistory class
	public void printGlobalPaymentHistory() {
		System.out.print("Here're all past global reservation record: \n");
		for(ReserveRecord r: reserveRecordList) {
			System.out.print("--------------------------\n");
			System.out.print(r.toString());
		}
	}
	
	// for CmdRefund class
	public void refund(String[] paramList) {
		UUID id = UUID.fromString(paramList[0]);
		Payment payment = searchPaymentById(id);
		if(payment!=null) {
			Customer customer = payment.getOwner();
			double amount = payment.getAmount();
			customer.getWallet().setBalance(customer.getWallet().getBalance()+amount);
			payment.setAmount(0);
			System.out.print("Refund successfully.\n");
		}
		else {
			System.out.print("Cannot find the record by the id provided.\n");
		}
	}
	
	
	/*
	 * This section is for payment management.
	 */
	// add
	public void addPayment(Payment payment) {
		this.paymentList.add(payment);
	}	
	
	public Payment searchPaymentById(UUID id) {
		for(Payment p: paymentList) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	/*
	 * This section is for reservation record management.
	 */
	public void addReserveRecord(ReserveRecord reserveRecord) {
		this.reserveRecordList.add(reserveRecord);
	}
	
	public ReserveRecord searchReserveRecordById(UUID id) {
		for(ReserveRecord r:reserveRecordList) {
			if(r.getId().equals(id)) {
				return r;
			} 
		}
		return null;
	}
	
	/*
	 * This section is for space management.
	 */
	public Space getAvailableMonthlySlot(boolean isPrivate) {
		if(isPrivate) {
			for(Space s:spaceList) {
				if(s.getTypeName().equals("Private Slot") && s.checkNextMonthAvailability()) {
					return s;
				}
			}
		}
		else {
			for(Space s:spaceList) {
				if(s.getTypeName().equals("Common Slot") && s.checkNextMonthAvailability()) {
					return s;
				}
			}
		}
		return null;
	}
	
	/**
	 * This section is for customer management.
	 */
	public Customer isExist(String username) {
		for(Customer c: customerList) {
			if(c.getUserName().equals(username)) {
				return c;
			}
		}
		return null;
	}

	public Customer searchCustomerById(UUID id) {
		for(Customer c: customerList) { 
			if(c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}
}

















