package event.stcevent.game;

import event.stcevent.STCEvent;

public class CraftItemSuccessResponse extends STCEvent {

	private static final long serialVersionUID = 7065433269019683875L;
	private String itemName;
	private String itemAmount;

	public CraftItemSuccessResponse(long id, long respondingTo, String itemName, String itemAmount) {
		super(id, respondingTo);
		this.itemName = itemName;
		this.itemAmount = itemAmount;
	}

	@Override
	protected String doGetDescription() {
		return "===Crafted===\n" + itemAmount + "x " + itemName + "\n=============";
	}

}
