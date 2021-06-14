package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ShopInspectRequest extends CTSEvent {

	private static final long serialVersionUID = 4924271848253436179L;
	private int row;
	private int col;

	public ShopInspectRequest(long id, int row, int col) {
		super(id);
		this.row = row;
		this.col = col;
	}

	@Override
	protected String doGetDescription() {
		return "Inspecting sale at shop slot (" + row + ", " + col + ")";
	}

}
