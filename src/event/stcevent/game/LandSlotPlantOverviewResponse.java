package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LandSlotPlantOverviewResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -9180974157532158963L;
	private String plantType;
	private int approximateTimeUntilHarvestable;

	public LandSlotPlantOverviewResponse(long respondingTo, long id, String plantType, int approximateTimeUntilHarvestable) {
		super(id, respondingTo);
		this.plantType = plantType;
		this.approximateTimeUntilHarvestable = approximateTimeUntilHarvestable;
	}

	@Override
	public String getDescription() {
		if (approximateTimeUntilHarvestable == 0) {
			return plantType + ", harvestable";
		}
		return plantType + ", harvestable in " + approximateTimeUntilHarvestable + " seconds";
	}

}
