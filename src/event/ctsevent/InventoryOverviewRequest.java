package event.ctsevent;

import java.io.Serializable;

public class InventoryOverviewRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = -7168225191244421995L;

	public InventoryOverviewRequest(long id) {
		super(id);
	}

	@Override
	public String getDescription() {
		return "Fetching inventory overview";
	}

}
