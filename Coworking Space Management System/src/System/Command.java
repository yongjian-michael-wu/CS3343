package System;

public interface Command {
	public void execute(Role role, String[] paramList);
	public String[] getParamList();
}
