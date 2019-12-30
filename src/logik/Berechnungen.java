package logik;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import datenbank.Datenbank;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import stammdaten.Waffen;
import stammdaten.AltersKategorie;
import start.MainApp;

public class Berechnungen {

	/**
	 * aktuelles Alter berechnen die Genauigkeit bezieht sich auf den Jahrgang der
	 * person
	 * 
	 * @param objectProperty Alter des Sch�tzen berechnen
	 * @return Alter des Sch�tzen
	 */
	public static int alterSetzen(ObjectProperty<LocalDate> objectProperty) {
		LocalDate GebJahr = objectProperty.getValue();

		int gebJahr = util.DateUtil.getBirthYear(GebJahr);
		int aktJahr = util.DateUtil.getYear();
		int alter = aktJahr - gebJahr;
		return alter;
	}

	/**
	 * Auf Grund des Alters wird der person in der Resultattabelle die aktuelle
	 * Alterskategorie zugeordnet
	 * 
	 * @param alter Auf Grund des Alters die Alterskategorie festlegen
	 * @return Referenz auf die ALterskategorie
	 * @throws Exception Fehler
	 */
	public static int alterKategorieSetzen(int alter) throws Exception {
		Integer katId = 0;
		Integer a = new Integer(alter);
		ObservableList<AltersKategorie> katData = FXCollections.observableArrayList();
		katData = MainApp.getKatData();
		// if (a >= ((AltersKategorie) katData).getKatAlterMin().intValue() & a <
		// ((AltersKategorie) katData).getKatAlterMax().intValue()) {
		// ((AltersKategorie) katData).getKat_id().getValue();
		// katId = stammdaten.AltersKategorie.getKat_id().intValue();
		// }
		return katId;

	}

	/**
	 * Es wird berechnet, ob die person mit der erreichten Resultat die
	 * Schiesspflicht f�r das aktuelle Jahr erf�llt hat
	 */
	public void schiesspflichtErfuellt() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Es wird berechnet, ob die person auf Grund des geschossenen Resultats und
	 * ihres Alters(Kategorie) die Anerkennungskarte f�r das Obligatorische Programm
	 * erh�lt
	 */
	public void karteOpErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Es wird berechnet, ob die person auf Grund des geschossenen Resultats und
	 * ihres Alters(Kategorie) die Anerkennungskarte f�r das Feldschiessen erh�lt
	 */
	public void karteFsErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Es wird berechnet, ob die person auf Grund des geschossenen Resultats und
	 * ihres Alters(Kategorie) den Kranz als Auszeichung f�r das Feldschiessen
	 * erh�lt
	 */
	public void kranzFsErreicht() {
		// alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
