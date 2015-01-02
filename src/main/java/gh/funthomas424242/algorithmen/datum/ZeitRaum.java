package gh.funthomas424242.algorithmen.datum;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.tz.DateTimeZoneBuilder;

public class ZeitRaum {

	protected Boolean liegtEndeVormAnfang;

	protected Date startDatum;
	protected Date endeDatum;
	
	final protected DateTimeZone zeitzone;
	final protected Locale locale;

	public ZeitRaum(final TimeZone zeitzone, final Locale locale, final Date startDatum, final Date endeDatum) {
		if (zeitzone== null || locale == null || startDatum == null || endeDatum == null) {
			throw new IllegalArgumentException("Parameters must not be null.");
		}
		this.zeitzone=DateTimeZone.forTimeZone(zeitzone);
		this.locale=locale;
		
		if (startDatum.after(endeDatum)) {
			this.endeDatum = startDatum;
			this.startDatum = endeDatum;
			this.liegtEndeVormAnfang = Boolean.TRUE;
		} else {
			this.startDatum = startDatum;
			this.endeDatum = endeDatum;
			this.liegtEndeVormAnfang = Boolean.FALSE;
		}
	}

	public Abstand berechneAbstandVonStartBisEndeDatum() {
		
		final LocalDate startDatumOhneZeitzone= new LocalDate(startDatum.getTime(),zeitzone);
		final LocalDate endeDatumOhneZeitzone=new LocalDate(endeDatum.getTime(),zeitzone);
		final Period period=new Period(startDatumOhneZeitzone,endeDatumOhneZeitzone, PeriodType.yearMonthDay() );
		
		final int monate = period.getMonths();
		final int tage=period.getDays();
		
		return new Abstand(monate,tage);

	}

	@Override
	public String toString() {
		final Abstand abstand = berechneAbstandVonStartBisEndeDatum();

		return "Der Zeitraum erstreckt sich über " + abstand.getMonate()
				+ " Monate und " + abstand.getTage() + " Tage.";
	}

}
