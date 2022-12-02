package System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ManagementPortal managementPortal = ManagementPortal.getInstance();
		boolean onGoing = true;
		Scanner in = new Scanner(System.in);
		while (onGoing) {
			managementPortal.printOpeningMessage();
			System.out.println("Please input command:");
			String command = in.nextLine();
			String[] cmdList = command.split(" ");
			if (cmdList[0].equals("Reg")) {
				CmdRegister cmd = new CmdRegister();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("Info")) {
				CmdCheckUserInfo cmd = new CmdCheckUserInfo();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("ChngPlan")) {
				CmdChangeUserPlan cmd = new CmdChangeUserPlan();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("PayHis")) {
				CmdCheckPersonalPaymentHistory cmd = new CmdCheckPersonalPaymentHistory();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("ResHis")) {
				CmdCheckPersonalReserveHistory cmd = new CmdCheckPersonalReserveHistory();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("SignOut")) {
				CmdSignOut cmd = new CmdSignOut();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("TopUp")) {
				CmdTopUp cmd = new CmdTopUp();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("ResInd")) {
				CmdReserveIndividualSpace cmd = new CmdReserveIndividualSpace();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("ResDis")) {
				CmdReserveDiscussionRoom cmd = new CmdReserveDiscussionRoom();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("CanRes")) {
				CmdCancelReserveRecord cmd = new CmdCancelReserveRecord();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("BuyPac")) {
				CmdBuyPackage cmd = new CmdBuyPackage();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("PayGlbHis")) {
				CmdCheckGlobalPaymentHistory cmd = new CmdCheckGlobalPaymentHistory();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("ResGlbHis")) {
				CmdCheckGlobalReserveHistory cmd = new CmdCheckGlobalReserveHistory();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("ChngGlbInfo")) {
				CmdChangeGlobalUserInfo cmd = new CmdChangeGlobalUserInfo();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("SignIn")) {
				CmdSignIn cmd = new CmdSignIn();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("GlbInfo")) {
				CmdCheckGlobalUserInfo cmd = new CmdCheckGlobalUserInfo();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("Refund")) {
				CmdRefund cmd = new CmdRefund();
				String[] paramList = cmd.getParamList();
				cmd.execute(managementPortal.getCurrentUserRole(), paramList);
			}
			else if(cmdList[0].equals("Exit")) {
				onGoing=false;
			}
			else {
				System.out.print("Sorry your command abbreviation cannot be recognized.\n"
						+ "Please make sure it's exactly the same with the abbreviation name.\n");
			}
		}
		System.out.println("Exit sucessfully!");
	}

}
