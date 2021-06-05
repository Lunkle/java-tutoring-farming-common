package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class InventoryOverviewResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -5686526908456880540L;
	private long respondingTo;
	private String[] items;
	private int[] amounts;

	public InventoryOverviewResponse(long respondingTo, long id, String[] items, int[] amount) {
		super(id);
		this.respondingTo = respondingTo;
		this.items = items;
		this.amounts = amount;
	}

	public long getRespondingTo() {
		return respondingTo;
	}

	public String[] getItems() {
		return items;
	}

	public int[] getAmounts() {
		return amounts;
	}

	@Override
	public String getDescription() {
		String string = "=Inventory==\n";
		for (int i = 0; i < items.length; i++) {
			string += items[i] + ' ' + amounts[i];
		}
		string += "============";
		return string;
	}

}
