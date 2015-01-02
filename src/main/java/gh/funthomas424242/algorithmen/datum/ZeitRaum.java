package gh.funthomas424242.algorithmen.datum;

import java.util.Date;

import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class ZeitRaum {

	protected Boolean liegtEndeVormAnfang;

	protected Date startDatum;

	protected Date endeDatum;

	public ZeitRaum(final Date startDatum, final Date endeDatum) {
		if (startDatum == null || endeDatum == null) {
			throw new IllegalArgumentException("Parameters must not be null.");
		}
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
		final LocalDate startDatumOhneZeitzone= new LocalDate(startDatum.getTime());
		final LocalDate endeDatumOhneZeitzone=new LocalDate(endeDatum.getTime());
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
