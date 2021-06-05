package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LandSlotTerrainOverviewResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = 6951271457373122915L;
	private String terrainType;
	private boolean hasPlant;
	private int infestationLevel;
	private int weedingLevel;
	private int irrigationLevel;

	public LandSlotTerrainOverviewResponse(long id, long respondingTo, String terrainType, boolean hasPlant, int infestationLevel, int weedingLevel, int irrigationLevel) {
		super(id, respondingTo);
		this.terrainType = terrainType;
		this.hasPlant = hasPlant;
		this.infestationLevel = infestationLevel;
		this.weedingLevel = weedingLevel;
		this.irrigationLevel = irrigationLevel;
	}

	public String getTerrainType() {
		return terrainType;
	}

	public boolean isHasPlant() {
		return hasPlant;
	}

	public int getInfestationLevel() {
		return infestationLevel;
	}

	public int getWeedingLevel() {
		return weedingLevel;
	}

	public int getIrrigationLevel() {
		return irrigationLevel;
	}

	@Override
	public String getDescription() {
		return "\n=====Terrain=====\n"
				+ "Terrain type: " + terrainType
				+ "\nHas plant: " + hasPlant
				+ "\nInfestation Level: " + infestationLevel
				+ "\nWeeding Level: " + weedingLevel
				+ "\nIrrigation Level: " + irrigationLevel
				+ "=================";
	}

}
