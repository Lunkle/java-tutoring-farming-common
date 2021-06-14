package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ShopCollectRequest extends CTSEvent {

	private static final long serialVersionUID = 3830109531049676007L;
	private int row;
	private int col;

	public ShopCollectRequest(long id, int row, int col) {
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
		return "Collecting sale at shop slot (" + row + ", " + col + ")";
	}

}
