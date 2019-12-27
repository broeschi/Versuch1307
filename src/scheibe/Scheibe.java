package scheibe;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Scheibe {
	private IntegerProperty schId;
	private StringProperty schName;
	private StringProperty schScheibent;
	private IntegerProperty schWert;

	public Scheibe(Integer schId, String schName, String schScheibent, Integer schWert) {
		this.schId = new SimpleIntegerProperty(schId);
		this.schName = new SimpleStringProperty(schName);
		this.schScheibent = new SimpleStringProperty(schScheibent);
		this.schWert = new SimpleIntegerProperty(schWert);
	}

	public IntegerProperty getSchId() {
		return schId;
	}

	public StringProperty getSchName() {
		return schName;
	}

	public StringProperty getSchScheibent() {
		return schScheibent;
	}

	public IntegerProperty getSchWert() {
		return schWert;
	}

	public void setSchId(IntegerProperty schId) {
		this.schId = schId;
	}

	public void setSchName(StringProperty schName) {
		this.schName = schName;
	}

	public void setSchScheibent(StringProperty schScheibent) {
		this.schScheibent = schScheibent;
	}

	public void setSchWert(IntegerProperty schWert) {
		this.schWert = schWert;
	}

}
