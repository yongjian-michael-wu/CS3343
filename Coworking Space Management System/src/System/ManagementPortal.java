package System;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagementPortal {
	
	private static final ManagementPortal instance = new ManagementPortal();
	private User currentUser;
	private boolean isLoggedIn;
	private ArrayList<Space> spaceList;
	
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
	
	public Role getRole() {
		return this.currentUser.getRole();
	}
	
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	public void register() {
		Scanner in = new Scanner(System.in);
		System.out.print("Username:");
		String username = in.nextLine();
		System.out.print("Password:");
		String password = in.nextLine();
		this.currentUser = CustomerManager.getInstance().AddCustomer(username, password);
		this.isLoggedIn = true;
		in.close();
	}
	
	public void changeUserPlan() {
		System.out.print("You are currently " + this.currentUser.getRole().toString() + "role.\n"
				+ "Please choose the user plan you want to change to (type number to choose). \n"
				+ "1. Basic Plan;\n"
				+ "2. Package Plan;\n"
				+ "3. Monthly Plan;\n");
		Scanner in = new Scanner(System.in);
		int userPlanIndex = in.nextInt();
		Customer currentCustomer = (Customer) this.currentUser;
		switch(userPlanIndex) {
			case 1:
				currentCustomer.convertUserPlan("Basic", 0);
				break;
			case 2:
				System.out.print("Please choose the package size: (type number to choose)\n"
						+ "1. 120 HKD for 10 hours;\n"
						+ "2. 315 HKD for 30 hours;\n"
						+ "3. 450 HKD for 50 hours;\n");
				int packageIndex = in.nextInt();
				switch(packageIndex) {
					case 1:
						if(currentCustomer.getWallet().pay(120)) {
							currentCustomer.convertUserPlan("Package", 10);
						}
						break;
					case 2:
						if(currentCustomer.getWallet().pay(315)) {
							currentCustomer.convertUserPlan("Package", 30);
						}
						break;
					case 3:
						if(currentCustomer.getWallet().pay(450)) {
							currentCustomer.convertUserPlan("Package", 50);
						}
						break;
					default:
						System.out.println("Cannot recognize the number you typed.");
						break;
				}
				break;
			case 3:
				System.out.print("Please choose the space type you prefer: (type number to choose)\n"
						+ "1. Common slot - 900 HKD / month;\n"
						+ "2. Private slot - 1800 HKD / month.\n");
				int spaceTypeIndex = in.nextInt();
				switch(spaceTypeIndex) {
					case 1:
						currentCustomer.convertUserPlan("Monthly");
						break;
				}
			default:
				System.out.println("Cannot recognize the number you typed.");
				break;
		}
		in.close();
	}
	
	public Space checkMonthlyAvailability(boolean isPrivate) {
		if(isPrivate) {
			
		}
	}
}

















