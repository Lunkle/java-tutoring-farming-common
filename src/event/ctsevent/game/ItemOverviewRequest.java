package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ItemOverviewRequest extends CTSEvent {

	private static final long serialVersionUID = 4526352448249553065L;
	private String itemName;

	public ItemOverviewRequest(long id, String itemName) {
		super(id);
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	@Override
	protected String doGetDescription() {
		return "Asking about a " + itemName;
	}

}
