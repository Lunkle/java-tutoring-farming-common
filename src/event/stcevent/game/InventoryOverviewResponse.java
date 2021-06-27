package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class InventoryOverviewResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = 3034395966129180076L;
	private String[] items;
	private int[] amounts;

	public InventoryOverviewResponse(long id, long respondingTo, String[] items, int[] amount) {
		super(id, respondingTo);
		this.items = items;
		this.amounts = amount;
	}

	public String[] getItems() {
		return items;
	}

	public int[] getAmounts() {
		return amounts;
	}

	@Override
	protected String doGetDescription() {
		String string = "\n===Inventory=========\n";
		for (int i = 0; i < items.length; i++) {
			string += amounts[i] + "x " + items[i] + '\n';
		}
		string += "=====================";
		return string;
	}

}
