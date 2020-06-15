package stich;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * Klasse zum Bilden von Stichen
 * 
 * @author Rudolf Broger
 *
 */

public class Stich {
	
	private SimpleIntegerProperty stch_id;
	private final StringProperty stchName;

	public Stich (Integer stch_id, String stchName) {
		this.stch_id = new SimpleIntegerProperty(stch_id);
		this.stchName = new SimpleStringProperty(stchName);
	}

	public int getStch_id() {
		return stch_id.get();
	}

	public void setStch_id(int stch_id) {
		this.stch_id.set(stch_id);
	}
	
	public void stichErstellen() {
		
	}

	public StringProperty getStchName() {
		return stchName;
	}

	public void setStchName(String stchName) {
		this.stchName.set(stchName);
	}

	public StringProperty StichNameProperty() {
		return stchName;
	}

}
