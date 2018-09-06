package logik;

import datenbank.Datenbank;

public class Berechnungen {
	
		
	public void alterSetzen() {
		try {
			Datenbank.loadKat();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void alterKategorieSetzen() {
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void schiesspflichtSetzen() {
		alterSetzen();
		
		
	}
	
	public void schiesspflichtErfuellt() {
		alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public void karteOpErreicht() {
		alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void karteFsErreicht() {
		alterSetzen();
		try {
			Datenbank.loadLim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
