package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopCollectSuccessResponse extends STCEvent {

	private static final long serialVersionUID = -1999185593286483632L;
	private String itemName;
	private int amount;
	private int value;

	public ShopCollectSuccessResponse(long id, long respondingTo, String itemName, int amount, int value) {
		super(id, respondingTo);
		this.itemName = itemName;
		this.amount = amount;
		this.value = value;
	}

	public String getItemName() {
		return itemName;
	}

	public int getAmount() {
		return amount;
	}

	public int getValue() {
		return value;
	}

	@Override
	protected String doGetDescription() {
		return "\n===Sold Items============"
				+ "\nSold: " + amount + "x " + itemName
				+ "\nReceived: " + value + " gold coins"
				+ "\n=========================";
	}

}
