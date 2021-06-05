package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class SowSeedRequest extends CTSEvent {

	private static final long serialVersionUID = -5841568669622746294L;
	private int farmLandX;
	private int farmLandY;
	private int row;
	private int col;
	private String plantName;

	public SowSeedRequest(long id, int farmLandX, int farmLandY, int row, int col, String plantName) {
		super(id);
		this.farmLandX = farmLandX;
		this.farmLandY = farmLandY;
		this.row = row;
		this.col = col;
		this.plantName = plantName;
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

	public String getPlantName() {
		return plantName;
	}

	@Override
	public String getDescription() {
		return "Sowing " + plantName + " seed at (row: " + row + ", col: " + col + ") of farm land (" + farmLandX + ", " + farmLandY + ")";
	}

}
