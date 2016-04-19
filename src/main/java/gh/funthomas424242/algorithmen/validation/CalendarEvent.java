package gh.funthomas424242.algorithmen.validation;

import java.util.Date;

import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(lang = "groovy", script = "_this.startDate.before(_this.endDate)")
public class CalendarEvent {

	private final String title;

	private final Date startDate;

	private final Date endDate;

	public CalendarEvent(final String title, final Date startDate,
			final Date endDate) {

		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

}