package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class FarmLandOverviewResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -4770847606385112672L;
	private String[][] terrainType;
	private boolean[][] hasPlant;

	public FarmLandOverviewResponse(long respondingTo, long id, String[][] terrainType, boolean[][] hasPlant) {
		super(id, respondingTo);
		this.terrainType = terrainType;
		this.hasPlant = hasPlant;
	}

	public String[][] getTerrainType() {
		return terrainType;
	}

	public boolean[][] getHasPlant() {
		return hasPlant;
	}

	@Override
	public String getDescription() {
		String string = "==FarmLand==\n";
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				string += '[';
				if (hasPlant[row][col]) {
					string += '+';
				} else {
					string += ' ';
				}
				string += ']';
			}
			string += "\n";
		}
		string += "============";
		return string;
	}

}
