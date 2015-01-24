package gh.funthomas424242.algorithmen.datum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ZeitRaumTest {

	final public static TimeZone ZEITZONE = TimeZone
			.getTimeZone("Europe/Berlin");
	final public static Locale LOCALE = new Locale("de", "DE");

	final protected int startJahr;
	final protected int startMonat;
	final protected int startTag;
	//
	final protected int endeJahr;
	final protected int endeMonat;
	final protected int endeTag;
	//
	final protected int erwarteteJahre;
	final protected int erwarteteMonate;
	final protected int erwarteteTage;

	Calendar calStart;
	Calendar calEnde;

	public ZeitRaumTest(final int startTag, final int startMonat,
			final int startJahr, final int endeTag, final int endeMonat,
			final int endeJahr, final int erwarteteJahre,
			final int erwarteteMonate, final int erwarteteTage) {

		this.startJahr = startJahr;
		this.startMonat = startMonat;
		this.startTag = startTag;
		//
		this.endeJahr = endeJahr;
		this.endeMonat = endeMonat;
		this.endeTag = endeTag;
		//
		this.erwarteteJahre = erwarteteJahre;
		this.erwarteteMonate = erwarteteMonate;
		this.erwarteteTage = erwarteteTage;
	}

	@Before
	public void beforeTest() {
		// Initialisiere Start und Ende Datum
		calStart = Calendar.getInstance(ZEITZONE, LOCALE);
		calStart.clear();
		calStart.set(startJahr, startMonat - 1, startTag);
		calEnde = Calendar.getInstance(ZEITZONE, LOCALE);
		calEnde.clear();
		calEnde.set(endeJahr, endeMonat - 1, endeTag);

	}

	@Test
	public void testDifferenzBerechnungNormal() {

		final DateTime startDatum = new DateTime(calStart.getTimeInMillis());
		final DateTime endeDatum = new DateTime(calEnde.getTimeInMillis());

		final Zeitraum zeitraum = new Zeitraum(ZEITZONE, LOCALE,
				startDatum.toDate(), endeDatum.toDate());
		final Zeitdauer zeitdauer = zeitraum
				.berechneAbstandVonStartBisEndeDatum();
		assertEquals(erwarteteJahre, zeitdauer.getJahre());
		assertEquals(erwarteteMonate, zeitdauer.getMonate());
		assertEquals(erwarteteTage, zeitdauer.getTage());

	}

	@Test
	public void testStartEndeVertauscht() {

		final DateTime endeDatum = new DateTime(calStart.getTimeInMillis());
		final DateTime startDatum = new DateTime(calEnde.getTimeInMillis());

		final Zeitraum zeitraum = new Zeitraum(ZEITZONE, LOCALE,
				startDatum.toDate(), endeDatum.toDate());
		final Zeitdauer zeitdauer = zeitraum
				.berechneAbstandVonStartBisEndeDatum();
		assertEquals(erwarteteJahre, zeitdauer.getJahre());
		assertEquals(erwarteteMonate, zeitdauer.getMonate());
		assertEquals(erwarteteTage, zeitdauer.getTage());

	}

	protected static Object[] getTestfallParameter(final DateTime startDatum,
			final int deltaJahre, final int deltaMonate, final int deltaTage) {

		DateTime endeDatum = startDatum.plusYears(deltaJahre);

		endeDatum = endeDatum.plusMonths(deltaMonate);
		endeDatum = endeDatum.plusDays(deltaTage);

		final int startTag = startDatum.getDayOfMonth();
		final int startMonat = startDatum.getMonthOfYear();
		final int startJahr = startDatum.getYear();
		final int endeTag = endeDatum.getDayOfMonth();
		final int endeMonat = endeDatum.getMonthOfYear();
		final int endeJahr = endeDatum.getYear();
		return new Object[] { startTag, startMonat, startJahr, endeTag,
				endeMonat, endeJahr, deltaJahre, deltaMonate, deltaTage };
	}

	@Parameters
	public static Collection<Object[]> testCases() {
		Collection<Object[]> parameters = new ArrayList<Object[]>();
		// Herausgezogene Spezialfälle
		parameters.add(new Object[] { 1, 1, 2014, 1, 2, 2014, 0, 1, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 3, 2014, 0, 2, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 2, 3, 2014, 0, 2, 1 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 4, 2014, 0, 3, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 5, 2014, 0, 4, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 5, 2015, 1, 4, 0 });
		parameters.add(new Object[] { 31, 1, 2014, 28, 2, 2014, 0, 1, 0 });
		parameters.add(new Object[] { 31, 1, 2014, 31, 3, 2014, 0, 2, 0 });
		parameters.add(new Object[] { 31, 1, 2014, 30, 4, 2014, 0, 3, 0 });
		parameters.add(new Object[] { 31, 1, 2014, 31, 5, 2014, 0, 4, 0 });
		parameters.add(new Object[] { 31, 1, 2014, 31, 5, 2015, 1, 4, 0 });
		// Vom Zeitpunkt des Testlaufes abhängige Testfälle
		final DateTime startDatum = new DateTime();
		parameters.add(getTestfallParameter(startDatum, 1, 4, 1));
		parameters.add(getTestfallParameter(startDatum, 0, 3, 1));
		parameters.add(getTestfallParameter(startDatum, 0, 0, 1));
		parameters.add(getTestfallParameter(startDatum, 0, 1, 0));
		parameters.add(getTestfallParameter(startDatum, 1, 0, 0));
		return parameters;
	}

}
