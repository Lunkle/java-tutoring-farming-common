package event.ctsevent.game;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

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
	protected String doGetDescription() {
		return "Fetching farmland overview (" + x + ", " + y + ")";
	}

}
