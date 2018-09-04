package datenbank;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.healthmarketscience.jackcess.*;
import Person.Person;
import Person.Resultat;
import Stammdaten.altersKategorie;
import Stammdaten.limiten;
import converter.KategorieConverter;
import converter.LimitenConverter;
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
	 * @throws Exception
	 */

	public static ArrayList<altersKategorie> loadKat() throws Exception {

		ArrayList<altersKategorie> alterskat = new ArrayList<altersKategorie>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblAlerKat");

		for (Row row : table) {
			KategorieConverter converter = new KategorieConverter();
			altersKategorie k = converter.dbToModelK(row);
			alterskat.add(k);

		}

		return alterskat;
	}

	/**
	 * Verbindung zu MS Access DB aufbauen und Inhalt der Tabelle Limiten laden
	 * 
	 * @author Rudolf Broger
	 * @throws Exception
	 */

	public static ArrayList<limiten> loadLim() throws Exception {

		ArrayList<limiten> limite = new ArrayList<limiten>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblLimitenBU");

		for (Row row : table) {
			LimitenConverter converter = new LimitenConverter();
			limiten l = converter.dbToModelL(row);
			limite.add(l);

		}

		return limite;
	}

	public void saveData() throws Exception {
		
		ArrayList<Person> personen = new ArrayList<Person>();

		Database db = DatabaseBuilder.open(new File(getDataFile()));

		Table table = db.getTable("tblAdressen");
	    try {
	        

	        // Wrapping our person data.
	        PersonListWrapper wrapper = new PersonListWrapper();
	        wrapper.setPersons(personData);

	        // Marshalling and saving XML to the file.
	        m.marshal(wrapper, file);

	        // Save the file path to the registry.
	        setPersonFilePath(file);
	    } catch (Exception e) { // catches ANY exception
	        Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setHeaderText("Could not save data");
	        alert.setContentText("Could not save data to file:\n" + file.getPath());

	        alert.showAndWait();
	    }


		

	}

	public static String getDataFile() {

		return "C:/Users/u117089/OneDrive/Wirtschaftsinformatik/FH/Kalaidos/Softwareentwickklung-Daten-K28480/Versuch1307/MSV_be.accdb";
	}
}
