package datenbank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.healthmarketscience.jackcess.CursorBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import Person.Person;
import Person.Resultat;
import converter.PersonConverter;
import converter.ResultatConverter;


public class Datenbank {

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle Adressen laden
	 * 
	 * @author Rudolf Broger
	 * @throws Exception
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
	 * @param person
	 * @throws Exception
	 */
	public static ArrayList<Resultat> loadRes(Person person) throws Exception {

		ArrayList<Resultat> resultate = new ArrayList<Resultat>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblResultateBU");

		for (Row row : table) {
			ResultatConverter converter = new ResultatConverter();
			Resultat r = converter.dbToModelR(row);
			r.setPerson(person);
			if (r.getResAdrref().getValue().longValue() == person.getAdrId()) {

				resultate.add(r);
			}
		}

		return resultate;
	}

	/**
	 * neu erfasste Person in DB Format konvertieren und speichern
	 * 
	 * @param tempPerson
	 * @throws Exception
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
	 * @return
	 */
	public static String getDataFile() {
		return "./MSV_be2.accdb";
	}

	/**
	 * bestehender Eintrag einer Person mit änderungen in DB Format konvertieren und
	 * diese in der DB speichern
	 * 
	 * @param selectedPerson
	 * @throws IOException
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
	 * @param selectedPerson
	 * @param alter
	 * @throws IOException
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
	 * @param selectedResultat
	 * @throws IOException
	 */
	public static void updateDataR(Resultat selectedResultat) throws IOException {

		Map<String, Object> map = ResultatConverter.convertToMap(selectedResultat);
		Database db = DatabaseBuilder.open(new File(getDataFile()));
		Table table = db.getTable("tblResultateBU");

		Row row = CursorBuilder.findRowByPrimaryKey(table, selectedResultat.getRes_id().get());
		if (row != null) {
			row.putAll(map);
			table.updateRow(row);
		} else {
			System.out.println("Es wurde kein Datensatz gefunden.");
		}

		db.close();

	}

}