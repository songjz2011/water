package hotel.reservation.customer;

import static org.junit.Assert.assertEquals;
import hotel.reservation.data.builder.CustomerBuilder;
import hotel.reservation.data.builder.DateBuilder;
import hotel.reservation.data.builder.HotelBuilder;
import hotel.reservation.hotel.Hotel;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class RegularCustomerTest {
	private static DateBuilder dateBuilder;

	private static Customer regularCustomer;
	
	private static Hotel lakewoodHotel;
	private static Hotel bridgewoodHotel;
	private static Hotel ridgewoodHotel;

	@BeforeClass
	public static void beforeClass() {
		dateBuilder = new DateBuilder();

		CustomerBuilder customerBuilder = new CustomerBuilder();
		regularCustomer = customerBuilder.getRegularCustomer();

		HotelBuilder hotelBuilder = new HotelBuilder();
		lakewoodHotel = hotelBuilder.getLakewoodHotel();
		bridgewoodHotel = hotelBuilder.getBridgewoodHotel();
		ridgewoodHotel = hotelBuilder.getRidgewoodHotel();
	}

	@Test
	public void lakewoodhotel_weekend_rate() {
		Date date = dateBuilder.getSunday();
		assertEquals(90, regularCustomer.getRate(lakewoodHotel, date));
	}

	@Test
	public void lakewoodhotel_notweekend_rate() {
		Date date = dateBuilder.getMonday();
		assertEquals(110, regularCustomer.getRate(lakewoodHotel, date));
	}

	@Test
	public void bridgewoodHotel_weekend_rate() {
		Date date = dateBuilder.getSunday();
		assertEquals(60, regularCustomer.getRate(bridgewoodHotel, date));
	}

	@Test
	public void bridgewoodHotel_notweekend_rate() {
		Date date = dateBuilder.getMonday();
		assertEquals(160, regularCustomer.getRate(bridgewoodHotel, date));
	}
	
	@Test
	public void ridgewoodHotel_weekend_rate() {
		Date date = dateBuilder.getSunday();
		assertEquals(150, regularCustomer.getRate(ridgewoodHotel, date));
	}

	@Test
	public void ridgewoodHotel_notweekend_rate() {
		Date date = dateBuilder.getMonday();
		assertEquals(220, regularCustomer.getRate(ridgewoodHotel, date));
	}
}
