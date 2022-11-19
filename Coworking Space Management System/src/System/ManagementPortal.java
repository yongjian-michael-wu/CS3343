package System;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;


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
	public void register(String username, String password) {
		this.currentUser = new Customer(username, password);
		customerList.add((Customer)this.currentUser);
		this.isLoggedIn = true;
	}
	
	// for CmdSignOut class
	public void signOut() {
		this.currentUser = new User();
		this.isLoggedIn = false;
	}
	
	// for CmdChangeUserPlan class
//	public void changeUserPlan(String[] paramList) {
//		Scanner in = new Scanner(System.in);
//		String userPlanIndex = paramList[0];
//		Customer currentCustomer = (Customer) this.currentUser;
//		switch(userPlanIndex) {
//			case "1":
//				currentCustomer.convertUserPlan("Basic", 0);
//				break;
//			case "2":
//				String packageSizeIndex = paramList[1];
//				switch(packageSizeIndex) {
//					case "1":
//						if(currentCustomer.getWallet().pay(120, "10 hours package payment.")) {
//							currentCustomer.convertUserPlan("Package", 10);
//						}
//						else {
//							System.out.println("Sorry your balance is insufficient for 10 hours package.");
//						}
//						break;
//					case "2":
//						if(currentCustomer.getWallet().pay(315, "30 hours package payment.")) {
//							currentCustomer.convertUserPlan("Package", 30);
//						}
//						else {
//							System.out.println("Sorry your balance is insufficient for 30 hours package.");
//						}
//						break;
//					case "3":
//						if(currentCustomer.getWallet().pay(450, "50 hours package payment.")) {
//							currentCustomer.convertUserPlan("Package", 50);
//						}
//						else {
//							System.out.println("Sorry your balance is insufficient for 50 hours package.");
//						}
//						break;
//					default:
//						System.out.println("Cannot recognize the number you typed.");
//						break;
//				}
//				break;
//			case "3":
////				System.out.print("Please choose the space type you prefer: (type number to choose)\n"
////						+ "1. Common slot - 900 HKD / month;\n"
////						+ "2. Private slot - 1800 HKD / month.\n");
//				String spaceTypeIndex = paramList[1];
//				switch(spaceTypeIndex) {
//					case "1":
//						double price = 0;
//						if(currentCustomer.getPlan().getRemainHour()<=200) {
//							price = 1800*(1-currentCustomer.getPlan().getRemainHour()/200);
//						}
//						else {
//							currentCustomer.getPlan().consumeRemainHour(200);
//							price = 0;
//						}
//						if(currentCustomer.getWallet().pay(price,"Monthly private slot payment.")) {
//							currentCustomer.convertUserPlan(packageSizeIndex, spaceTypeIndex);
//						}
//						else {
//							System.out.println("Sorry your balance is insufficient for a monthly private slot.");
////							return null;
//						}
//						break;
//					case "2":
//						
//				}
//				break;
//		}
//	}
	
	public void printOpeningMessage() {
		System.out.print(this.currentUser.getOpeningMessage());
	}
	
//	public void reserve(String[] paramList) {
//		LocalDate date = LocalDate.parse(paramList[0]);
//		LocalTime start = LocalTime.of(Integer.parseInt(paramList[1]),00);
//		LocalTime end = LocalTime.of(Integer.parseInt(paramList[2]),00);
//		LocalDateTime startTime = LocalDateTime.of(date,start);
//		LocalDateTime endTime = LocalDateTime.of(date,end);
//		Customer currentCustomer = (Customer) currentUser;
//		if(!currentCustomer.checkReseveConflict(startTime, endTime)) {
//			System.out.println("Reservation failed. The session you selected is overlaping with another reservation you made.");
//			return;
//		}
//		if(paramList[3]=="1") {
//			boolean isAvailable = false;
//			for(Space s:spaceList) {
//				if(s.getTypeName().equals("Common Slot") && s.checkReserveConflict(startTime, endTime)) {
//					isAvailable = true;
//					if(currentCustomer.getWallet().pay(0, null))
//					ReserveRecord reserveRecord = new ReserveRecord(startTime, endTime);
//					break;
//				}
//			}
//			if(!isAvailable) {
//				System.out.println("Reservation failed. No available slot for this session.");
//			}
//		}
//	}
	

	/*
	 * This section is for payment management.
	 */
	public void addPayment(Payment payment) {
		this.paymentList.add(payment);
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
				if(s.getTypeName().equals("Private Slot") && s.checkNextMonthAvailability()) {
					return s;
				}
			}
		}
		return null;
	}
	
	
}

















