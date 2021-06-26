package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class ShovelLandRequest extends CTSEvent {
	
	private static final long serialVersionUID = -6188683588363366227L;
	private int farmLandX;
	private int farmLandY;
	private int row;
	private int col;
	
	public ShovelLandRequest(long id, int farmLandX, int farmLandY, int row, int col) {
		super(id);
		this.farmLandX = farmLandX;
		this.farmLandY = farmLandY;
		this.row = row;
		this.col = col;
	}
	
	public int getFarmLandX() {
		return farmLandX;
	}

	public int getFarmLandY() {
		return farmLandY;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	@Override
	protected String doGetDescription() {
		return "Removes any plants growing at (row: " + row + ", col: " + col + ") of farm land (" + farmLandX + ", " + farmLandY + ")";
	}
}
