package event.ctsevent.game;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class InventoryOverviewRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = -7168225191244421995L;

	public InventoryOverviewRequest(long id) {
		super(id);
	}

	@Override
	protected String doGetDescription() {
		return "Fetching inventory overview";
	}

}
