package System;

public class PrivateSlot extends SpaceType {
	private static final PrivateSlot instance = new PrivateSlot();
	
	public PrivateSlot() {
		super(1, "Private Slot");
	}
	
	public static PrivateSlot getInstance() {
		return instance;
	}
}
