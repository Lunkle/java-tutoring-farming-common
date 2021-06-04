package event.ctsevent;

public class HarvestLandSlotRequest extends CTSEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -884813565888890245L;
	private int index;

	public HarvestLandSlotRequest(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String getDescription() {
		return "Harvesting land slot " + index;
	}

}
