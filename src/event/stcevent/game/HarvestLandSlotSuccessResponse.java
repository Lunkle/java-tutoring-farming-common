package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class HarvestLandSlotSuccessResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = 3034395966129180076L;
	private String[] items;
	private int[] amounts;

	public HarvestLandSlotSuccessResponse(long id, long respondingTo, String[] items, int[] amount) {
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
	public String doGetDescription() {
		String string = "\n==Harvest===\n";
		for (int i = 0; i < items.length; i++) {
			string += items[i] + ' ' + amounts[i] + '\n';
		}
		string += "============";
		return string;
	}

}
