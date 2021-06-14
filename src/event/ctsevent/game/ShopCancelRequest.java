package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ShopCancelRequest extends CTSEvent {

	private static final long serialVersionUID = 715715511936996403L;
	private int row;
	private int col;

	public ShopCancelRequest(long id, int row, int col) {
		super(id);
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	protected String doGetDescription() {
		return "Cancelling sale at shop slot (" + row + ", " + col + ")";
	}

}
