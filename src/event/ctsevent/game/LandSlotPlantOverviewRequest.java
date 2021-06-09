package event.ctsevent.game;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class LandSlotPlantOverviewRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = 1679840402323365016L;
	private int farmLandX;
	private int farmLandY;
	private int row;
	private int col;

	public LandSlotPlantOverviewRequest(long id, int farmLandX, int farmLandY, int row, int col) {
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
	public String doGetDescription() {
		return "Fetching land slot plant overview (row: " + row + ", col: " + col + ") of farm land (" + farmLandX + ", " + farmLandY + ")";
	}

}
