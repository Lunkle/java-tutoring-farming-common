package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ShopSellRequest extends CTSEvent {

	private static final long serialVersionUID = -7388115637557654817L;
	private int row;
	private int col;
	private String itemName;
	private int amount;

	public ShopSellRequest(long id, int row, int col, String itemName, int amount) {
		super(id);
		this.row = row;
		this.col = col;
		this.itemName = itemName;
		this.amount = amount;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public String getItemName() {
		return itemName;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	protected String doGetDescription() {
		return "Selling " + amount + "x " + itemName
				+ " at shop slot (" + row + ", " + col + ")";
	}

}
