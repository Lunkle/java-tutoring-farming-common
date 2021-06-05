package event.ctsevent;

import java.io.Serializable;

public class FarmLandOverviewRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = 1679840402323365016L;
	private int x;
	private int y;

	public FarmLandOverviewRequest(long id, int x, int y) {
		super(id);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String getDescription() {
		return "Fetching farmland overview (" + x + ", " + y + ")";
	}

}
