package event.stcevent.game;

import event.stcevent.STCEvent;

public class ShopInspectResponse extends STCEvent {

	private static final long serialVersionUID = 7575652991145747380L;
	private static final int MS_PER_MINUTE = 60000;
	private static final int MS_PER_HOUR = 3600000;
	private String itemName;
	private int amount;
	private long soldIn;

	public ShopInspectResponse(long id, long respondingTo, String itemName, int amount, long soldIn) {
		super(id, respondingTo);
		this.itemName = itemName;
		this.amount = amount;
		this.soldIn = soldIn;
	}

	public String getItemName() {
		return itemName;
	}

	public int getAmount() {
		return amount;
	}

	public long getSoldIn() {
		return soldIn;
	}

	@Override
	protected String doGetDescription() {
		String string = "\n===Shop Inspect============="
				+ "\nSelling: " + amount + "x " + itemName;

		if (soldIn == 0) {
			string += "\nSold!";
		} else {
			string += "\nSold in: " + formatDuration(soldIn);
		}
		string += "\n============================";
		return string;
	}

	private String formatDuration(long millis) {
		return millis / MS_PER_HOUR + "h "
				+ (millis % MS_PER_HOUR) / MS_PER_MINUTE + "m "
				+ (millis % MS_PER_MINUTE) / 1000 + "s";
	}

}
