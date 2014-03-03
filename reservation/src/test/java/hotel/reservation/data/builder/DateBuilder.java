package hotel.reservation.data.builder;

import java.util.Calendar;
import java.util.Date;

public class DateBuilder {

	public Date getMonday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 2, 16);
		return calendar.getTime();
	}

	public Date getTuesday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 2, 17);
		return calendar.getTime();
	}

	public Date getWednesday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 2, 18);
		return calendar.getTime();
	}

	public Date getThursday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 2, 19);
		return calendar.getTime();
	}

	public Date getFriday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 2, 20);
		return calendar.getTime();
	}

	public Date getSaturday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 2, 21);
		return calendar.getTime();
	}

	public Date getSunday() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2009, 2, 22);
		return calendar.getTime();
	}
}
