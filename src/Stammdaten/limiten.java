package Stammdaten;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class limiten {
	private final IntegerProperty lim_id;
	private final IntegerProperty limKatRef;
	private final StringProperty limAltKat;
	private final IntegerProperty limOpErfuellt;
	private final IntegerProperty limOpMax0;
	private final IntegerProperty limOpKarte;
	private final IntegerProperty limFsKarte;
	private final IntegerProperty limFsKranz;
	private final IntegerProperty limFsFigur;

	public limiten(int lim_id, int limKatRef, String limAltKat, int limOpErfuellt, int limOpMax0, int limOpKarte,
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
