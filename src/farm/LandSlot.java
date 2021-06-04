package farm;

import java.io.Serializable;

import farm.plant.Plant;

public class LandSlot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4998964525083025541L;
	private boolean irrigated;
	private Plant plant;

	public boolean isIrrigated() {
		return irrigated;
	}

	public void setIrrigated(boolean irrigated) {
		this.irrigated = irrigated;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

}
