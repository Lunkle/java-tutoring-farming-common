package event.ctsevent;

import java.io.Serializable;

public class FarmLandOverviewRequest extends CTSEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5736056546837007817L;
	private int coordinateX;

	private int coordinateY;

	public FarmLandOverviewRequest(long id, int coordinateX, int coordinateY) {
		super(id);
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
	}

	protected int getCoordinateX() {
		return coordinateX;
	}

	protected int getCoordinateY() {
		return coordinateY;
	}

	@Override
	public String getDescription() {
		return "Fetching farmland overview (" + coordinateX + ", " + coordinateY + ")";
	}

}
