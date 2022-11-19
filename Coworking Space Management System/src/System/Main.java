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
				cmd.execute(managementPortal.getCurrentUserRole(), cmdList);
			}
			else if(cmdList[0].equals("ChngPlan")) {
				CmdChangeUserPlan cmd = new CmdChangeUserPlan();
				cmd.execute(managementPortal.getCurrentUserRole(), cmdList);
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
