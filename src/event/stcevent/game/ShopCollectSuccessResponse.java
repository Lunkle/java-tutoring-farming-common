package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopCollectSuccessResponse extends STCEvent {

	private static final long serialVersionUID = -1999185593286483632L;
	private String itemName;
	private int amount;
	private int value;

	public static void main(String[] args) {
		System.out.println(new ShopCollectSuccessResponse(0, 0, "Pig heart", 5, 2289).getDescription());
	}

	public ShopCollectSuccessResponse(long id, long respondingTo, String itemName, int amount, int value) {
		super(id, respondingTo);
		this.itemName = itemName;
		this.amount = amount;
		this.value = value;
	}

	@Override
	protected String doGetDescription() {
		return "\n===Sold Items============"
				+ "\nSold: " + amount + "x " + itemName
				+ "\nReceived: " + value + " gold coins"
				+ "\n=========================";
	}

}
