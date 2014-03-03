package hotel.reservation.customer;

import static org.junit.Assert.*;

import java.util.Date;

import hotel.reservation.data.builder.CustomerBuilder;
import hotel.reservation.data.builder.DateBuilder;
import hotel.reservation.data.builder.HotelBuilder;
import hotel.reservation.hotel.Hotel;

import org.junit.BeforeClass;
import org.junit.Test;

public class RewardsCustomerTest {
	private static DateBuilder dateBuilder;

	private static Customer rewardsCustomer;
	
	private static Hotel lakewoodHotel;
	private static Hotel bridgewoodHotel;
	private static Hotel ridgewoodHotel;

	@BeforeClass
	public static void beforeClass() {
		dateBuilder = new DateBuilder();

		CustomerBuilder customerBuilder = new CustomerBuilder();
		rewardsCustomer = customerBuilder.getRewardsCustomer();

		HotelBuilder hotelBuilder = new HotelBuilder();
		lakewoodHotel = hotelBuilder.getLakewoodHotel();
		bridgewoodHotel = hotelBuilder.getBridgewoodHotel();
		ridgewoodHotel = hotelBuilder.getRidgewoodHotel();
	}

	@Test
	public void lakewoodhotel_weekend_rate() {
		Date date = dateBuilder.getSunday();
		assertEquals(80, rewardsCustomer.getRate(lakewoodHotel, date));
	}

	@Test
	public void lakewoodhotel_notweekend_rate() {
		Date date = dateBuilder.getMonday();
		assertEquals(80, rewardsCustomer.getRate(lakewoodHotel, date));
	}

	@Test
	public void bridgewoodHotel_weekend_rate() {
		Date date = dateBuilder.getSunday();
		assertEquals(50, rewardsCustomer.getRate(bridgewoodHotel, date));
	}

	@Test
	public void bridgewoodHotel_notweekend_rate() {
		Date date = dateBuilder.getMonday();
		assertEquals(110, rewardsCustomer.getRate(bridgewoodHotel, date));
	}
	
	@Test
	public void ridgewoodHotel_weekend_rate() {
		Date date = dateBuilder.getSunday();
		assertEquals(40, rewardsCustomer.getRate(ridgewoodHotel, date));
	}

	@Test
	public void ridgewoodHotel_notweekend_rate() {
		Date date = dateBuilder.getMonday();
		assertEquals(100, rewardsCustomer.getRate(ridgewoodHotel, date));
	}
}
