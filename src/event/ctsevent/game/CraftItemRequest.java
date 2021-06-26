package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class CraftItemRequest extends CTSEvent {

	private static final long serialVersionUID = 5482423529963333693L;
	private String itemName;

	public CraftItemRequest(long id, String itemName) {
		super(id);
		this.itemName = itemName;
	}

	@Override
	protected String doGetDescription() {
		return "Crafting " + itemName;
	}

	public String getItemName() {
		return itemName;
	}

}
