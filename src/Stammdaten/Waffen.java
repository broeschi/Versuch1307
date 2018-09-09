package Stammdaten;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * Klasse zum Bilden der Waffenkategorien
 * 
 * @author Rudolf Broger
 *
 */
public class Waffen {
	private final IntegerProperty waf_id;
	private final SimpleStringProperty wafName;
	private final StringProperty wafAbk;
	private final StringProperty wafKat;

	/**
	 * vollständiger Konstruktor des Datenmodells für Waffen
	 * 
	 * @param waf_id
	 * @param wafName
	 * @param wafAbk
	 * @param wafKat
	 */
	public Waffen(Integer waf_id, String wafName, String wafAbk, String wafKat) {
		this.waf_id = new SimpleIntegerProperty(waf_id);
		this.wafName = new SimpleStringProperty(wafName);
		this.wafAbk = new SimpleStringProperty(wafAbk);
		this.wafKat = new SimpleStringProperty(wafKat);
	}

	public IntegerProperty getWaf_id() {
		return waf_id;
	}

	public SimpleStringProperty getWafName() {
		return wafName;
	}

	public StringProperty getWafAbk() {
		return wafAbk;
	}

	public StringProperty getWafKat() {
		return wafKat;
	}

}
