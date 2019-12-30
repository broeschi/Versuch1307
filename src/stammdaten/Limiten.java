package stammdaten;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * Klasse zum Bilden der Limiten zur Differenzierung der erforderlichen Limiten
 * auf Grund der Alterskategorie
 * 
 * @author Rudolf Broger
 *
 */
public class Limiten {
	private final IntegerProperty lim_id;
	private final IntegerProperty limKatRef;
	private final StringProperty limAltKat;
	private final IntegerProperty limOpErfuellt;
	private final IntegerProperty limOpMax0;
	private final IntegerProperty limOpKarte;
	private final IntegerProperty limFsKarte;
	private final IntegerProperty limFsKranz;
	private final IntegerProperty limFsFigur;

	/**
	 * vollständiger Konstruktor des Datenmodells für die Limiten
	 * 
	 * @param lim_id Primärschlüssel für Limite
	 * @param limKatRef Fremdschlüssel für Alterskategorie
	 * @param limAltKat Abkürzung der Alterskategorie
	 * @param limOpErfuellt Minimale Punktzahl zum erfüllen des OP
	 * @param limOpMax0 maximale Anzahl erlauber Nuller "0"
	 * @param limOpKarte Minimale Punktzahl zum Erstellen der OP-Anerkennungskarte
	 * @param limFsKarte Minimale Punktzahl zum Erstellen der FS-Anerkennungskarte
	 * @param limFsKranz Minimale Punktzahl zum Erstellen des FS-Anerkennungskranz
	 * @param limFsFigur Anzahl der Figurentreffer beim FS
	 */
	public Limiten(int lim_id, int limKatRef, String limAltKat, int limOpErfuellt, int limOpMax0, int limOpKarte,
			int limFsKarte, int limFsKranz, int limFsFigur) {
		this.lim_id = new SimpleIntegerProperty(lim_id);
		this.limKatRef = new SimpleIntegerProperty(limKatRef);
		this.limAltKat = new SimpleStringProperty(limAltKat);
		this.limOpErfuellt = new SimpleIntegerProperty(limOpErfuellt);
		this.limOpMax0 = new SimpleIntegerProperty(limOpMax0);
		this.limOpKarte = new SimpleIntegerProperty(limOpKarte);
		this.limFsKarte = new SimpleIntegerProperty(limFsKarte);
		this.limFsKranz = new SimpleIntegerProperty(limFsKranz);
		this.limFsFigur = new SimpleIntegerProperty(limFsFigur);
	}

	public IntegerProperty getLim_id() {
		return lim_id;
	}

	public IntegerProperty getLimKatRef() {
		return limKatRef;
	}

	public StringProperty getLimAltKat() {
		return limAltKat;
	}

	public IntegerProperty getLimOpErfuellt() {
		return limOpErfuellt;
	}

	public IntegerProperty getLimOpMax0() {
		return limOpMax0;
	}

	public IntegerProperty getLimOpKarte() {
		return limOpKarte;
	}

	public IntegerProperty getLimFsKarte() {
		return limFsKarte;
	}

	public IntegerProperty getLimFsKranz() {
		return limFsKranz;
	}

	public IntegerProperty getLimFsFigur() {
		return limFsFigur;
	}

}
