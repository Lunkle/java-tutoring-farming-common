package event.ctsevent.game;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class LandSlotTerrainOverviewRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = 6061905788405085233L;
	private int farmLandX;
	private int farmLandY;
	private int row;
	private int col;

	public LandSlotTerrainOverviewRequest(long id, int farmLandX, int farmLandY, int row, int col) {
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
		return "Fetching land slot terrain overview (row: " + row + ", col: " + col + ") of farm land (" + farmLandX + ", " + farmLandY + ")";
	}

}
