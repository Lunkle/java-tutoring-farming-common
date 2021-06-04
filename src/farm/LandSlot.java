package farm;

import java.io.Serializable;
import java.util.List;

import farm.item.Item;
import farm.item.ItemSlot;
import farm.plant.Plant;

public class LandSlot implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2965393520718926587L;
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

	public List<ItemSlot<Item>> harvest() {
		return plant.harvest();
	}

}
