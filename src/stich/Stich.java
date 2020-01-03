package stich;
/**
 * 
 * Klasse zum Bilden von Stichen
 * 
 * @author Rudolf Broger
 *
 */

public class Stich {
	
	private int stch_id;
	private String stchName;

	public Stich (int stch_id, String stchName) {
		this.setStch_id(stch_id);
		this.setStchName(stchName);
	}

	public int getStch_id() {
		return stch_id;
	}

	public void setStch_id(int stch_id) {
		this.stch_id = stch_id;
	}
	
	public void stichErstellen() {
		
	}

	public String getStchName() {
		return stchName;
	}

	public void setStchName(String stchName) {
		this.stchName = stchName;
	}

}
