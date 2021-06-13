package event.stcevent.game;

import java.io.Serializable;

import event.stcevent.STCEvent;

public class LandSlotPlantOverviewResponse extends STCEvent implements Serializable {

	private static final int MILLISECONDS_PER_MINUTE = 60000;
	private static final int MILLISECONDS_PER_HOUR = 3600000;
	private static final long serialVersionUID = -4454796821747924108L;
	private String plantType;
	private long timeUntilHarvestable;

	public LandSlotPlantOverviewResponse(long id, long respondingTo, String plantType, long timeUntilHarvestable) {
		super(id, respondingTo);
		this.plantType = plantType;
		this.timeUntilHarvestable = timeUntilHarvestable;
	}

	public String getPlantType() {
		return plantType;
	}

	public long getTimeUntilHarvestable() {
		return timeUntilHarvestable;
	}

	@Override
	protected String doGetDescription() {
		String string = "\n====Plant====\n"
				+ "Plant type: " + plantType + "\nHarvestable";
		if (timeUntilHarvestable != 0) {
			string += " in " + timeUntilHarvestable / MILLISECONDS_PER_HOUR + "h "
					+ (timeUntilHarvestable % MILLISECONDS_PER_HOUR) / MILLISECONDS_PER_MINUTE + "m "
					+ (timeUntilHarvestable % MILLISECONDS_PER_MINUTE) / 1000 + "s";
		}
		string += "\n=============";
		return string;
	}

}
