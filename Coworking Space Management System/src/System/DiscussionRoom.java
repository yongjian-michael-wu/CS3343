package System;

public class DiscussionRoom extends SpaceType {
	private static final DiscussionRoom instance = new DiscussionRoom();
	
	public DiscussionRoom() {
		super(6, "Discussion Room");
	}
	
	public static DiscussionRoom getInstance() {
		return instance;
	}
}
