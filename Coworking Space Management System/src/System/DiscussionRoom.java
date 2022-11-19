package System;

public class DiscussionRoom extends SpaceType {
	private static final DiscussionRoom instance = new DiscussionRoom();
	
	public DiscussionRoom() {
		super(6, "DiscussionRoom");
	}
	
	public static DiscussionRoom getInstance() {
		return instance;
	}
}
