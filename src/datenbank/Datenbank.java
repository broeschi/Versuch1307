package datenbank;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.healthmarketscience.jackcess.*;
import Person.Person;
import converter.PersonConverter;



public class Datenbank {

	  
	  
   
    /**
     * Verbindung zu MS Access DB aufbauen und Inhalt laden
     * 
     * @author Rudolf Broger
     * @throws Exception
     */
    public static ArrayList <Person> loadData() throws Exception {

    	ArrayList<Person> personen = new ArrayList<Person>(); 
    	
    	 Database db = DatabaseBuilder.open(new File("C:/Users/u117089/OneDrive/Wirtschaftsinformatik/FH/Kalaidos/Softwareentwickklung-Daten-K28480/Versuch1307/MSV_be.accdb"));
    	 //Database db = DatabaseBuilder.open(new File("C:/Users/Rudolf Broger/Documents/Schützenverwaltung/MSV_be.accdb"));

    	 Table table = db.getTable("tblAdressen");
		 

		 for(Row row : table) {
			 PersonConverter converter = new PersonConverter();
			Person p = converter.dbToModel(row);
    		personen.add(p);
    		 
    	 }
    	 
    	return personen;
    	     
    }
      
    
    public static void saveData() {
    	// Todo
    }
  }
