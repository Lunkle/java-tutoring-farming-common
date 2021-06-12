package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class SellItemRequest extends CTSEvent {

	private static final long serialVersionUID = -1851244066355059606L;
	private String itemName;
	private int itemAmount;

	public SellItemRequest(long id, String itemName, int itemAmount) {
		super(id);
		this.itemName = itemName;
		this.itemAmount = itemAmount;
	}

	@Override
	public String doGetDescription() {
		return "Selling " + itemAmount + "x " + itemName;
	}

}
