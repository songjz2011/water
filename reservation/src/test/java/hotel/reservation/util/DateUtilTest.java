package hotel.reservation.util;

import static org.junit.Assert.*;
import hotel.reservation.data.builder.DateBuilder;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class DateUtilTest {

	private static DateBuilder dateBuilder;

	@BeforeClass
	public static void beforeClass() {
		dateBuilder = new DateBuilder();
	}

	@Test
	public void monday_shuldnotbe_weekend() {
		Date monday = dateBuilder.getMonday();
		assertFalse(DateUtil.isWeekEnd(monday));
	}

	@Test
	public void tuesday_shuldnotbe_weekend() {
		Date tuesday = dateBuilder.getTuesday();
		assertFalse(DateUtil.isWeekEnd(tuesday));
	}

	@Test
	public void wednesday_shuldnotbe_weekend() {
		Date wednesday = dateBuilder.getWednesday();
		assertFalse(DateUtil.isWeekEnd(wednesday));
	}

	@Test
	public void thursday_shuldnotbe_weekend() {
		Date thursday = dateBuilder.getThursday();
		assertFalse(DateUtil.isWeekEnd(thursday));
	}

	@Test
	public void friday_shuldnotbe_weekend() {
		Date friday = dateBuilder.getFriday();
		assertFalse(DateUtil.isWeekEnd(friday));
	}

	@Test
	public void saturday_shuldbe_weekend() {
		Date saturday = dateBuilder.getSaturday();
		assertTrue(DateUtil.isWeekEnd(saturday));
	}

	@Test
	public void sunday_shuldbe_weekend() {
		Date sunday = dateBuilder.getSunday();
		assertTrue(DateUtil.isWeekEnd(sunday));
	}
}
