package hotel.reservation;

import static org.junit.Assert.assertEquals;
import hotel.reservation.customer.Customer;
import hotel.reservation.data.builder.CustomerBuilder;
import hotel.reservation.data.builder.DateBuilder;
import hotel.reservation.data.builder.HotelBuilder;
import hotel.reservation.hotel.BridgewoodHotel;
import hotel.reservation.hotel.Hotel;
import hotel.reservation.hotel.LakewoodHotel;
import hotel.reservation.hotel.RidgewoodHotel;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class HotelReservationTest {
	private static DateBuilder dateBuilder;
	private static HotelBuilder hotelBuilder;

	private static HotelReservation hotelReservation;

	private static Customer regularCustomer;
	private static Customer rewardsCustomer;

	@BeforeClass
	public static void beforeClass() {
		dateBuilder = new DateBuilder();
		hotelBuilder = new HotelBuilder();

		hotelReservation = new HotelReservation(new Hotel[] {
				new LakewoodHotel(), new BridgewoodHotel(),
				new RidgewoodHotel() });

		CustomerBuilder customerBuilder = new CustomerBuilder();
		regularCustomer = customerBuilder.getRegularCustomer();
		rewardsCustomer = customerBuilder.getRewardsCustomer();
	}

	@Test
	public void regularcustomer_three_notweekends_cheapest() {
		Date[] dates = { dateBuilder.getMonday(), dateBuilder.getTuesday(),
				dateBuilder.getWednesday() };
		String expectedValue = hotelBuilder.getLakewoodHotel().getName();
		assertEquals(expectedValue,
				hotelReservation.cheapest(regularCustomer, dates).getName());
	}

	@Test
	public void regularcustomer_two_weekends_and_one_notweedend_cheapest() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getSaturday(),
				dateBuilder.getSunday() };
		String expectedValue = hotelBuilder.getBridgewoodHotel().getName();
		assertEquals(expectedValue,
				hotelReservation.cheapest(regularCustomer, dates).getName());
	}

	@Test
	public void rewardscustomer_two_notweekends_and_one_weedend_cheapest() {
		Date[] dates = { dateBuilder.getThursday(), dateBuilder.getFriday(),
				dateBuilder.getSaturday() };
		String expectedValue = hotelBuilder.getRidgewoodHotel().getName();
		assertEquals(expectedValue,
				hotelReservation.cheapest(rewardsCustomer, dates).getName());
	}
}
