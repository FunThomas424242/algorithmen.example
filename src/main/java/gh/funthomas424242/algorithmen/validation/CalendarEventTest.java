package gh.funthomas424242.algorithmen.validation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalendarEventTest {

	private static Validator validator;

	private static Date startDate;

	private static Date endDate;

	@BeforeClass
	public static void setUpValidatorAndDates() {

		validator = Validation.buildDefaultValidatorFactory().getValidator();

		startDate = new GregorianCalendar(2009, 8, 20).getTime();
		endDate = new GregorianCalendar(2009, 8, 21).getTime();
	}

	@Test
	public void validCalendarEvent() {

		final CalendarEvent testEvent = new CalendarEvent("Team meeting",
				startDate, endDate);

		assertTrue(validator.validate(testEvent).isEmpty());
	}

	@Test
	public void invalidCalendarEvent() {

		final CalendarEvent testEvent = new CalendarEvent("Team meeting",
				endDate, startDate);

		final Set<ConstraintViolation<CalendarEvent>> constraintViolations = validator
				.validate(testEvent);

		assertEquals(1, constraintViolations.size());
		Assert.assertNotEquals(
				"Script statement \"_this.startDate.before(_this.endDate)\" didn't evaluate to TRUE.",
				constraintViolations.iterator().next().getMessage());
	}

}