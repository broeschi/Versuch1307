package util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Helper functions for handling dates.
 * 
 * @author Marco Jakob
 */
public class DateUtil {

	/** The date pattern that is used for conversion. Change as you wish. */
	private static final String DATE_PATTERN = "dd.MM.yyyy";

	/** The date formatter. */
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	/**
	 * Returns the given date as a well formatted String. The above defined
	 * {@link DateUtil#DATE_PATTERN} is used.
	 * 
	 * @param date the date to be returned as a string
	 * @return formatted string
	 */
	public static String format(LocalDate date) {
		if (date == null) {
			return null;
		}
		return DATE_FORMATTER.format(date);
	}

	/**
	 * Converts a String in the format of the defined {@link DateUtil#DATE_PATTERN}
	 * to a {@link LocalDate} object.
	 * 
	 * Returns null if the String could not be converted.
	 * 
	 * @param dateString the date as String
	 * @return the date object or null if it could not be converted
	 */
	public static LocalDate parse(String dateString) {
		try {
			return DATE_FORMATTER.parse(dateString, LocalDate::from);
		} catch (DateTimeParseException e) {
			return null;
		}
	}

	/**
	 * Checks the String whether it is a valid date.
	 * 
	 * @param dateString
	 * @return true if the String is a valid date
	 */
	public static boolean validDate(String dateString) {
		// Try to parse the String.
		return DateUtil.parse(dateString) != null;
	}

	/**
	 * Konvertiert das LocalDate in einen Instanzwert
	 * 
	 * @param dateToConvert
	 * @return
	 */
	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		if (dateToConvert == null) {
			return null;
		}
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * kovertiert das Datum in einen Sekundenwert
	 * 
	 * @param l
	 * @return
	 */
	public static Long convertToMsEpoch(LocalDate l) {
		ZoneId zoneId = ZoneId.systemDefault();
		return l.atStartOfDay(zoneId).toEpochSecond();
	}

	/**
	 * Ermittelt das das aktuelle Jahr, basierend auf dem Systemdatumg
	 * 
	 * @return
	 */
	public static int getYear() {
		Calendar date = new GregorianCalendar();
		int year = date.get(Calendar.YEAR);
		return year;

	}

	/**
	 * ermittelt das Geburtsjahr der Person auf Grund des Erfassten Geburtsdatums
	 * 
	 * @param gebJahr
	 * @return
	 */
	public static int getBirthYear(LocalDate gebJahr) {
		int year = gebJahr.getYear();
		return year;
	}

}