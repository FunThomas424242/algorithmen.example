package gh.funthomas424242.algorithmen.datum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTime;
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
	final protected int erwarteteMonate;
	final protected int erwarteteTage;

	

	public ZeitRaumTest(final int startTag, final int startMonat,
			final int startJahr, final int endeTag, final int endeMonat,
			final int endeJahr, final int erwarteteMonate,
			final int erwarteteTage) {

		this.startJahr = startJahr;
		this.startMonat = startMonat;
		this.startTag = startTag;
		//
		this.endeJahr = endeJahr;
		this.endeMonat = endeMonat;
		this.endeTag = endeTag;
		//
		this.erwarteteMonate = erwarteteMonate;
		this.erwarteteTage = erwarteteTage;
	}

	

	@Test
	public void testDifferenzBerechnungNormal() {
		
		final Calendar calStart = Calendar.getInstance(ZEITZONE, LOCALE);
		calStart.clear();
		calStart.set(startJahr, startMonat-1, startTag);
		final Calendar calEnde = Calendar.getInstance(ZEITZONE, LOCALE);
		calEnde.clear();
		calEnde.set(endeJahr, endeMonat-1, endeTag);

		final DateTime startDatum = new DateTime(calStart.getTimeInMillis());
		final DateTime endeDatum = new DateTime(calEnde.getTimeInMillis());

		System.out.println("Start: " + startDatum + " Ende: " + endeDatum);

		final ZeitRaum zeitraum = new ZeitRaum(startDatum.toDate(),
				endeDatum.toDate());
		final Abstand zeitAbstand = zeitraum
				.berechneAbstandVonStartBisEndeDatum();
		System.out.println(zeitraum.toString());
		assertEquals(erwarteteMonate, zeitAbstand.getMonate());
		assertEquals(erwarteteTage, zeitAbstand.getTage());

	}
	
	@Test
	public void testStartEndeVertauscht() {
		
		final Calendar calStart = Calendar.getInstance(ZEITZONE, LOCALE);
		calStart.clear();
		calStart.set(startJahr, startMonat-1, startTag);
		final Calendar calEnde = Calendar.getInstance(ZEITZONE, LOCALE);
		calEnde.clear();
		calEnde.set(endeJahr, endeMonat-1, endeTag);

		final DateTime endeDatum = new DateTime(calStart.getTimeInMillis());
		final DateTime startDatum = new DateTime(calEnde.getTimeInMillis());

		System.out.println("Start: " + startDatum + " Ende: " + endeDatum);

		final ZeitRaum zeitraum = new ZeitRaum(startDatum.toDate(),
				endeDatum.toDate());
		final Abstand zeitAbstand = zeitraum
				.berechneAbstandVonStartBisEndeDatum();
		System.out.println(zeitraum.toString());
		assertEquals(erwarteteMonate, zeitAbstand.getMonate());
		assertEquals(erwarteteTage, zeitAbstand.getTage());

	}

	@Parameters
	public static Collection<Object[]> testCases() {
		Collection<Object[]> parameters = new ArrayList<Object[]>();
		parameters.add(new Object[] { 1, 1, 2014, 1, 2, 2014, 1, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 3, 2014, 2, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 2, 3, 2014, 2, 1 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 4, 2014, 3, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 5, 2014, 4, 0 });
		parameters.add(new Object[] { 1, 1, 2014, 1, 5, 2015, 4, 0 });
		parameters.add(new Object[] {31,1, 2014, 28,2, 2014, 1, 0 });
		parameters.add(new Object[] {31,1, 2014, 31,3, 2014, 2, 0 });
		parameters.add(new Object[] {31,1, 2014, 30,4, 2014, 3, 0 });
		parameters.add(new Object[] {31,1, 2014, 31,5, 2014, 4, 0 });
		parameters.add(new Object[] {31,1, 2014, 31,5, 2015, 4, 0 });
		return parameters;
	}

}
