package datenbank;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.healthmarketscience.jackcess.*;

import converter.KategorieConverter;
import converter.LimitenConverter;
import converter.PersonConverter;
import converter.ResultatConverter;
import converter.WaffenConverter;
import person.Person;
import person.Resultat;
import converter.ScheibenConverter;
import scheibe.Scheibe;
import stammdaten.Waffen;
import stammdaten.AltersKategorie;
import stammdaten.Limiten;

public class Datenbank {

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle Adressen laden
	 * 
	 * @author Rudolf Broger
	 * @throws Exception Fehler
	 */
	public static ArrayList<Person> loadData() throws Exception {

		ArrayList<Person> personen = new ArrayList<Person>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblAdressen");

		for (Row row : table) {
			PersonConverter converter = new PersonConverter();
			Person p = converter.dbToModelP(row);
			personen.add(p);
		}
		return personen;

	}

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle ResultatBU laden
	 * 
	 * @author Rudolf Broger
	 * @param person Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle ResultatBU laden
	 * @throws Exception Fehler
	 */
	public static ArrayList<Resultat> loadRes(Person person) throws Exception {

		ArrayList<Resultat> resultate = new ArrayList<Resultat>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblResultateBU");

		for (Row row : table) {
			ResultatConverter converter = new ResultatConverter();
			Resultat r = converter.dbToModelR(row);
			if (r.getResAdrref().getValue().longValue() == person.getAdrId()) {

				resultate.add(r);
			}
		}

		return resultate;
	}

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle Alterskategorien
	 * laden
	 * 
	 * @author Rudolf Broger
	 * @throws Exception Fehler
	 */
	public static ArrayList<AltersKategorie> loadKat() throws Exception {

		ArrayList<AltersKategorie> alterskat = new ArrayList<AltersKategorie>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblAlterKat");

		for (Row row : table) {
			KategorieConverter converter = new KategorieConverter();
			AltersKategorie k = converter.dbToModelK(row);
			alterskat.add(k);

		}

		return alterskat;
	}

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle Limiten laden
	 * 
	 * @author Rudolf Broger
	 * @throws Exception Fehler
	 */
	public static ArrayList<Limiten> loadLim() throws Exception {

		ArrayList<Limiten> limite = new ArrayList<Limiten>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblLimitenBU");

		for (Row row : table) {
			LimitenConverter converter = new LimitenConverter();
			Limiten l = converter.dbToModelL(row);
			limite.add(l);

		}

		return limite;
	}

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle Limiten laden
	 * 
	 * @author Rudolf Broger
	 * @throws Exception Fehler
	 */
	public static ArrayList<Waffen> loadWaf() throws Exception {

		ArrayList<Waffen> waffen = new ArrayList<Waffen>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblWaffe");

		for (Row row : table) {
			WaffenConverter converter = new WaffenConverter();
			Waffen w = converter.dbToModelW(row);
			waffen.add(w);

		}

		return waffen;
	}

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle Scheibe laden
	 * 
	 * @author Rudolf Broger
	 * @throws Exception Fehler
	 */
	public static ArrayList<Scheibe> loadScheibe() throws Exception {

		ArrayList<Scheibe> scheibe = new ArrayList<Scheibe>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblScheibe");

		for (Row row : table) {
			ScheibenConverter converter = new ScheibenConverter();
			Scheibe s = converter.dbToModelS(row);
			scheibe.add(s);

		}

		return scheibe;

	}

	/**
	 * neu erfasste person in DB Format konvertieren und speichern
	 * 
	 * @param tempPerson neue Person erfassen
	 * @throws Exception Fehler
	 */ 
	public static void saveDataP(Person tempPerson) throws Exception {

		Map<String, Object> map = PersonConverter.convertToMap(tempPerson);

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblAdressen");
		table.addRowFromMap(map);
		db.close();

	}

	/**
	 * Dateipfad und Dateiname der MS Access DB
	 * 
	 * @return Dateipfad zur DB
	 */
	public static String getDataFile() {

		return "C:/Eclipse/Versuch1307/MSV_be2.accdb";
	}

	/**
	 * bestehender Eintrag einer Person mit änderungen in DB Format konvertieren und
	 * diese in der DB speichern
	 * 
	 * @param selectedPerson Ausgewählte Person
	 * @throws IOException Kein Datensatz gefunden
	 */
	public static void updateDataP(Person selectedPerson) throws IOException {
		Map<String, Object> map = PersonConverter.convertToMap(selectedPerson);
		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblAdressen");
		Row row = CursorBuilder.findRowByPrimaryKey(table, selectedPerson.getAdrId());
		if (row != null) {
			row.putAll(map);
			table.updateRow(row);
		} else {
			System.out.println("Es wurde kein Datensatz gefunden.");
		}

		db.close();
	}

	/**
	 * neue Reihe in der Resultattabelle erfassen den Fremdschlüssel zum
	 * referenzieren der Adresstabelle mitgeben und das berechnete Alter mitgeben
	 * Daten in DB Format konvertieren und auf DB speichern
	 * 
	 * @param selectedPerson ausgewählte Person
	 * @param alter Alter ausgewählter Person in Datenbank speichern
	 * @throws IOException Fehler
	 */
	public static void saveDataR(Person selectedPerson, int alter) throws IOException {
		Resultat r = new Resultat(selectedPerson.getAdrId());
		Integer a = new Integer(alter);

		Map<String, Object> map = ResultatConverter.convertToMap(r, a);

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblResultateBU");

		table.addRowFromMap(map);

		db.close();

	}

	/**
	 * bestehender Eintrag in der Resultattabelle ändern und dieses zur Speicherung
	 * in das DB Format konverieren
	 * 
	 * @param selectedResultat ausgewähltes Resultat
	 * @throws IOException Kein Datensatz gefunden
	 */
	public static void updateDataR(Resultat selectedResultat) throws IOException {

		Map<String, Object> map = ResultatConverter.convertToMap(selectedResultat);
		Database db = DatabaseBuilder.open(new File(getDataFile()));
		Table table = db.getTable("tblResultateBU");

		Row row = CursorBuilder.findRowByPrimaryKey(table, selectedResultat.getRes_id());
		if (row != null) {
			row.putAll(map);
			table.updateRow(row);
		} else {
			System.out.println("Es wurde kein Datensatz gefunden.");
		}

		db.close();

	}

}