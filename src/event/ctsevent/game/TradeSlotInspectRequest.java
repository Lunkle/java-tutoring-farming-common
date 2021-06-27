package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class TradeSlotInspectRequest extends CTSEvent {

	private static final long serialVersionUID = -601352504355792134L;
	private int row;
	private int col;

	public TradeSlotInspectRequest(long id, int row, int col) {
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
		return "Inspecting trade posting at slot (" + row + ", " + col + ")";
	}

}
