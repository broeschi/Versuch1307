package Person;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 * Klasse für Resultate
 * @author Ruedi Broger
 *
 */
public class resultat {
	private final LongProperty res_id;
	private final IntegerProperty resJahr;
	
	
	public resultat(long res_id, int resJahr) {
		this.res_id = new SimpleLongProperty(res_id);
		this.resJahr = new SimpleIntegerProperty(resJahr);
	}
	

}
