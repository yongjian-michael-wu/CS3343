package System;

public class CommonSlot extends SpaceType {
	private static final CommonSlot instance = new CommonSlot();
	
	public CommonSlot() {
		super(1, "Common Slot");
	}
	
	public static CommonSlot getInstance() {
		return instance;
	}
}
