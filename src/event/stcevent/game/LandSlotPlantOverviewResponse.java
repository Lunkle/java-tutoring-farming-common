package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LandSlotPlantOverviewResponse extends STCEvent implements Serializable {

	private static final long serialVersionUID = -4454796821747924108L;
	private String plantType;
	private int approximateTimeUntilHarvestable;

	public LandSlotPlantOverviewResponse(long id, long respondingTo, String plantType, int approximateTimeUntilHarvestable) {
		super(id, respondingTo);
		this.plantType = plantType;
		this.approximateTimeUntilHarvestable = approximateTimeUntilHarvestable;
	}

	public String getPlantType() {
		return plantType;
	}

	public int getApproximateTimeUntilHarvestable() {
		return approximateTimeUntilHarvestable;
	}

	@Override
	public String getDescription() {
		String string = "\n====Plant====\n"
				+ "Plant type: " + plantType + "\nHarvestable";
		if (approximateTimeUntilHarvestable != 0) {
			string += " in " + approximateTimeUntilHarvestable + "s";
		}
		string += "\n=============";
		return string;
	}

}
