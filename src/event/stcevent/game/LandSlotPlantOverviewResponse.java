package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LandSlotPlantOverviewResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -9180974157532158963L;
	private String plantType;
	private int approximateTimeUntilHarvestable;

	public LandSlotPlantOverviewResponse(long id, long respondingTo, String plantType, int approximateTimeUntilHarvestable) {
		super(id, respondingTo);
		this.plantType = plantType;
		this.approximateTimeUntilHarvestable = approximateTimeUntilHarvestable;
	}

	@Override
	public String getDescription() {
		String string = "\n====Plant====\n"
				+ "Plant type: " + plantType + "\nHarvestable\n";
		if (approximateTimeUntilHarvestable != 0) {
			string += " in " + approximateTimeUntilHarvestable + "s\n";
		}
		string += "=============";
		return string;
	}

}
