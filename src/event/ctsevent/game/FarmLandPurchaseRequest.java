package event.ctsevent.game;

import java.io.Serializable;

import event.ctsevent.CTSEvent;

public class FarmLandPurchaseRequest extends CTSEvent implements Serializable {

	private static final long serialVersionUID = 5362730547724738891L;
	private int x;
	private int y;

	public FarmLandPurchaseRequest(long id, int x, int y) {
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
		return "Purchasing farmland at (" + x + ", " + y + ")";
	}

}
