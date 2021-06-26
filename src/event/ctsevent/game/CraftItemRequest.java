package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class CraftItemRequest extends CTSEvent {

	private static final long serialVersionUID = 75236891257794974L;

	private String itemName;

	public CraftItemRequest(long id, String itemName) {
		super(id);
		this.itemName = itemName;
	}

	@Override
	protected String doGetDescription() {
		return "Crafting " + itemName;
	}

}
