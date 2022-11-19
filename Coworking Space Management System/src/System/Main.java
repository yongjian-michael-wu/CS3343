package System;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean onGoing = true;
		ManagementPortal managementPortal = ManagementPortal.getInstance();
		Scanner in = new Scanner(System.in);
		while (onGoing) {
			System.out.println("Please Input Command:");
			String command = in.nextLine();
			String[] cmdList = command.split(" ");
			if (cmdList[0].equals("reg")]) {
				CmdRegister cmd = new CmdRegister();
				cmd.execute(ManagementPortal.getInstance().getRole(), command);
			}
			
			
		}
		
		in.close();
	}

}
