package event.stcevent.game;

import event.stcevent.STCEvent;

public class OutOfBoundsResponse extends STCEvent {

	private static final long serialVersionUID = 2061962100165988667L;
	private int row;
	private int col;

	public OutOfBoundsResponse(long id, long respondingTo, int row, int col) {
		super(id, respondingTo);
		this.row = row;
		this.col = col;
	}

	@Override
	protected String doGetDescription() {
		return "(row: " + row + ", col: " + col + ") is out of bounds.";
	}
}
