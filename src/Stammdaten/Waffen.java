package Stammdaten;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Waffen {
	private final IntegerProperty waf_id;
	private final StringProperty wafName;
	private final StringProperty wafAbk;
	private final StringProperty wafKat;

	public Waffen(Integer waf_id, String wafName, String wafAbk, String wafKat) {
		this.waf_id = new SimpleIntegerProperty(waf_id);
		this.wafName = new SimpleStringProperty(wafName);
		this.wafAbk = new SimpleStringProperty(wafAbk);
		this.wafKat = new SimpleStringProperty(wafKat);
	}

	public IntegerProperty getWaf_id() {
		return waf_id;
	}

	public StringProperty getWafName() {
		return wafName;
	}

	public StringProperty getWafAbk() {
		return wafAbk;
	}

	public StringProperty getWafKat() {
		return wafKat;
	}

}
