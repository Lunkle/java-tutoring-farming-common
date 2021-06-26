package event.stcevent.game;

import event.stcevent.STCEvent;

public class CraftItemSuccessResponse extends STCEvent {

	private static final long serialVersionUID = 1276653459813505505L;

	private String itemName;
	private int itemAmount;

	public CraftItemSuccessResponse(long id, long respondingTo, String itemName, int itemAmount) {
		super(id, respondingTo);
		this.itemName = itemName;
		this.itemAmount = itemAmount;
	}

	@Override
	protected String doGetDescription() {
		return "===Crafted===\n" + itemAmount + "x " + itemName + "\n=============";
	}

}
