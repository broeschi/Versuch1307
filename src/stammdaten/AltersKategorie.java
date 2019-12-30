package stammdaten;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * 
 * Klasse zum Bilden der Alterskategorien
 * 
 * @author Rudolf Broger
 *
 */
public class AltersKategorie {
	private final IntegerProperty kat_id;
	private final StringProperty katAltersKat;
	private final StringProperty katKatName;
	private final IntegerProperty katAlterMin;
	private final IntegerProperty katAlterMax;
	private final IntegerProperty sort;

	/**
	 * volständiger Konstruktor des Datenmodells der Alterskategorien
	 * 
	 * @param kat_id Primärschlüssel der Kategorie
	 * @param katAltersKat Abkürzung
	 * @param katKatName Name der Alterskategorie
	 * @param katAlterMin Mindestalter für Kategoriezuteilung
	 * @param katAlterMax Maximalalter für Kategoriezuteilung
	 * @param sort Sortieren für Ranglisten
	 */
	public AltersKategorie(int kat_id, String katAltersKat, String katKatName, int katAlterMin, int katAlterMax,
			int sort) {
		this.kat_id = new SimpleIntegerProperty(kat_id);
		this.katAltersKat = new SimpleStringProperty(katAltersKat);
		this.katKatName = new SimpleStringProperty(katKatName);
		this.katAlterMin = new SimpleIntegerProperty(katAlterMin);
		this.katAlterMax = new SimpleIntegerProperty(katAlterMax);
		this.sort = new SimpleIntegerProperty(sort);
	}

	public IntegerProperty getKat_id() {
		return kat_id;
	}

	public StringProperty getkatAltersKatProperty() {
		return katAltersKat;
	}

	public StringProperty getKatAltersKat() {
		return katAltersKat;
	}

	public StringProperty getkatKatNameProperty() {
		return katKatName;
	}

	public StringProperty getKatKatName() {
		return katKatName;
	}

	public IntegerProperty getkatAltersMinProperty() {
		return katAlterMin;
	}

	public IntegerProperty getKatAlterMin() {
		return katAlterMin;
	}

	public IntegerProperty getKatAlterMax() {
		return katAlterMax;
	}

	public IntegerProperty getSort() {
		return sort;
	}

}
