package event.stcevent.game;

import event.stcevent.STCEvent;

public class FarmLandOverviewResponse extends STCEvent {

	private static final long serialVersionUID = 4876235866866219112L;

	public static void main(String[] args) {
		boolean[][] hasPlant = new boolean[][] { { true, true, true, true }, { false, true, true, true }, { false, false, true, true }, { true, false, true, true } };
		System.out.println(new FarmLandOverviewResponse(1, null, hasPlant).getDescription());
	}

	private String[][] terrainType;
	private boolean[][] hasPlant;

	public FarmLandOverviewResponse(long id, String[][] terrainType, boolean[][] hasPlant) {
		super(id);
		this.terrainType = terrainType;
		this.hasPlant = hasPlant;
	}

	protected String[][] getTerrainType() {
		return terrainType;
	}

	protected boolean[][] getHasPlant() {
		return hasPlant;
	}

	@Override
	public String getDescription() {
		String string = "============\n";
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
