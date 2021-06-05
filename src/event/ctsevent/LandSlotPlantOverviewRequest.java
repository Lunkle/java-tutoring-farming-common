package event.ctsevent;

import java.io.Serializable;

public class LandSlotPlantOverviewRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = 1679840402323365016L;
	private int farmLandX;
	private int farmLandY;
	private int x;
	private int y;

	public LandSlotPlantOverviewRequest(long id, int farmLandX, int farmLandY, int x, int y) {
		super(id);
		this.farmLandX = farmLandX;
		this.farmLandY = farmLandY;
		this.x = x;
		this.y = y;
	}

	public int getFarmLandX() {
		return farmLandX;
	}

	public int getFarmLandY() {
		return farmLandY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String getDescription() {
		return "Fetching land slot plant overview (" + x + ", " + y + ") of farm land (" + farmLandX + ", " + farmLandY + ")";
	}

}
