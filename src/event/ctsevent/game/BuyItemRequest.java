package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class BuyItemRequest extends CTSEvent {

	private static final long serialVersionUID = -6899921187965016785L;
	private String itemName;
	private int itemAmount;

	public BuyItemRequest(long id, String itemName, int itemAmount) {
		super(id);
		this.itemName = itemName;
		this.itemAmount = itemAmount;
	}

	@Override
	public String doGetDescription() {
		return "Buying " + itemAmount + "x " + itemName;
	}

}
