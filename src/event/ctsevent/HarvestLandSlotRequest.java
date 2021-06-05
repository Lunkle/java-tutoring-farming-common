package event.ctsevent;

import java.io.Serializable;

public class HarvestLandSlotRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = -4732150038573153244L;
	private int farmLandX;
	private int farmLandY;
	private int x;
	private int y;

	public HarvestLandSlotRequest(long id, int farmLandX, int farmLandY, int x, int y) {
		super(id);
		this.farmLandX = farmLandX;
		this.farmLandY = farmLandY;
		this.x = x;
		this.y = y;
	}

	@Override
	public String getDescription() {
		return "Harvesting land slot plant (" + x + ", " + y + ") of farm land (" + farmLandX + ", " + farmLandY + ")";
	}

}
