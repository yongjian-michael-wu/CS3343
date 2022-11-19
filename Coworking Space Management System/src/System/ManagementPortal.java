package System;

import java.util.ArrayList;
import java.util.Scanner;

import org.hamcrest.core.IsInstanceOf;

public class ManagementPortal {
	
	private static final ManagementPortal instance = new ManagementPortal();
	private User currentUser;
	private boolean isLoggedIn;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private ArrayList<Space> spaceList = new ArrayList<Space>();
	
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
	
	public void printUserInfo() {
		System.out.print(this.currentUser.getInfo());
	}
	
	
	/*
	 * This section is 1-to-1 mapped with commands.
	 * Each method corresponds to one command's execute method.
	 */
	
	// for CmdRegister class
	public void register(String username, String password) {
		this.currentUser = new Customer(username, password);
		customerList.add((Customer)this.currentUser);
		this.isLoggedIn = true;
	}
	
	// for CmdChangeUserPlan class
	public void changeUserPlan(String[] paramList) {
//		System.out.print("You are currently " + this.currentUser.getRole().toString() + "role.\n"
//				+ "Please choose the user plan you want to change to (type number to choose). \n"
//				+ "1. Basic Plan;\n"
//				+ "2. Package Plan;\n"
//				+ "3. Monthly Plan;\n");
		Scanner in = new Scanner(System.in);
		String userPlanIndex = paramList[0];
		Customer currentCustomer = (Customer) this.currentUser;
		switch(userPlanIndex) {
			case "1":
				currentCustomer.convertUserPlan("Basic", 0);
				break;
			case "2":
//				System.out.print("Please choose the package size: (type number to choose)\n"
//						+ "1. 120 HKD for 10 hours;\n"
//						+ "2. 315 HKD for 30 hours;\n"
//						+ "3. 450 HKD for 50 hours;\n");
				String packageSizeIndex = paramList[1];
				switch(packageSizeIndex) {
					case "1":
						if(currentCustomer.getWallet().pay(120, "10 hours package payment.")) {
							currentCustomer.convertUserPlan("Package", 10);
						}
						else {
							System.out.println("Sorry your balance is insufficient for 10 hours package.");
						}
						break;
					case "2":
						if(currentCustomer.getWallet().pay(315, "30 hours package payment.")) {
							currentCustomer.convertUserPlan("Package", 30);
						}
						else {
							System.out.println("Sorry your balance is insufficient for 30 hours package.");
						}
						break;
					case "3":
						if(currentCustomer.getWallet().pay(450, "50 hours package payment.")) {
							currentCustomer.convertUserPlan("Package", 50);
						}
						else {
							System.out.println("Sorry your balance is insufficient for 50 hours package.");
						}
						break;
					default:
						System.out.println("Cannot recognize the number you typed.");
						break;
				}
				break;
			case "3":
				System.out.print("Please choose the space type you prefer: (type number to choose)\n"
						+ "1. Common slot - 900 HKD / month;\n"
						+ "2. Private slot - 1800 HKD / month.\n");
				int spaceTypeIndex = in.nextInt();
				switch(spaceTypeIndex) {
					case 1:
//						currentCustomer.convertUserPlan("Monthly");
						Customer currentCustomer = (Customer) currentUser;
						double price = 0;
						if(currentCustomer.getPlan().getRemainHour()<=200) {
							price = 1800*(1-currentCustomer.getPlan().getRemainHour()/200);
						}
						else {
							currentCustomer.getPlan().consumeRemainHour(200);
							price = 0;
						}
						if(currentCustomer.getWallet().pay(price,"Monthly private slot payment.")) {
							return s;
						}
						else {
							System.out.println("Sorry your balance is insufficient for a monthly private slot.");
//							return null;
						}
						break;
				}
				break;
		}
	}
	
	public void printOpeningMessage() {
		System.out.print(this.currentUser.getOpeningMessage());
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
	
	public void signOut() {
		
	}
}

















