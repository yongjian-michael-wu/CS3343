//package System;
//
//import java.util.Scanner;
//
//public class CmdChangeUserPlan implements Command {
//	public CmdChangeUserPlan() {}
//	
//	public String[] getParamList() {
//		Scanner in = new Scanner(System.in);
//		System.out.println("If you choose to change user plan, system will convert your remaing unused hours to money and top up to your wallet.");
//		System.out.println("Please type yes to approve or any other key to refuse.");
//		String response = in.next();
//		if(!response.equals("yes")) {
//			System.out.println("Successfully refused.");
//			return null;
//		}
//		String[] paramList = new String[2];
//		ManagementPortal managementPortal = ManagementPortal.getInstance();
//		System.out.print("You are currently " + managementPortal.getCurrentUserRole().toString() + "role.\n"
//				+ "Please choose the user plan you want to change to (type number to choose). \n"
//				+ "1. Basic Plan;\n"
//				+ "2. Package Plan;\n"
//				+ "3. Monthly Plan;\n");
//		String userPlanIndex = in.next();
//		paramList[0] = userPlanIndex;
//		switch(userPlanIndex) {
//			case "1":
//				break;
//			case "2":
//				System.out.print("Please choose the package size: (type number to choose)\n"
//						+ "1. 120 HKD for 10 hours;\n"
//						+ "2. 315 HKD for 30 hours;\n"
//						+ "3. 450 HKD for 50 hours.\n");
//				String packageIndex = in.next();
//				switch(packageIndex) {
//					case "1":
//						paramList[1] = packageIndex;
//						break;
//					case "2":
//						paramList[1] = packageIndex;
//						break;
//					case "3":
//						paramList[1] = packageIndex;
//						break;
//					default:
//						System.out.println("Cannot recognize the number you typed.");
//						return null;
//				}
//				break;
//			case "3":
//				System.out.print("Please choose the space type you prefer: (type number to choose)\n"
//						+ "1. Common slot - 900 HKD / month;\n"
//						+ "2. Private slot - 1800 HKD / month.\n");
//				String spaceTypeIndex = in.next();
//				switch(spaceTypeIndex) {
//					case "1":
//						paramList[1] = spaceTypeIndex; 
//						break;
//					case "2":
//						paramList[1] = spaceTypeIndex; 
//						break;
//					default:
//						System.out.println("Cannot recognize the number you typed.");
//						return null;
//				}
//			default:
//				System.out.println("Cannot recognize the number you typed.");
//				return null;
//		}
//		return paramList;
//	}
//	
//	public void execute(Role role, String[] paramList) {
//		if(paramList==null) {
//			return;
//		}
//		else if(role.canChangePlan()) {
//			ManagementPortal managementPortal = ManagementPortal.getInstance();
//			managementPortal.changeUserPlan();
//		}
//		else {
//			return;
//		}
//	}
//}
