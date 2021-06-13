package event.ctsevent.game;

import event.ctsevent.CTSEvent;

public class SowSeedRequest extends CTSEvent {

	private static final long serialVersionUID = 4526352448249553065L;
	private int farmLandX;
	private int farmLandY;
	private int row;
	private int col;
	private String seedName;

	public SowSeedRequest(long id, int farmLandX, int farmLandY, int row, int col, String seedName) {
		super(id);
		this.farmLandX = farmLandX;
		this.farmLandY = farmLandY;
		this.row = row;
		this.col = col;
		this.seedName = seedName;
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

	public String getSeedName() {
		return seedName;
	}

	@Override
	protected String doGetDescription() {
		return "Sowing " + seedName + " at (row: " + row + ", col: " + col + ") of farm land (" + farmLandX + ", " + farmLandY + ")";
	}

}
