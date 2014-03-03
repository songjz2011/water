package hotel.reservation.hotel;

import static org.junit.Assert.assertEquals;
import hotel.reservation.customer.Customer;
import hotel.reservation.data.builder.CustomerBuilder;
import hotel.reservation.data.builder.DateBuilder;
import hotel.reservation.data.builder.HotelBuilder;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class BridgewoodHotelTest {

	private static DateBuilder dateBuilder;
	private static HotelBuilder hotelBuilder;

	private static Hotel hotel;
	private static Customer regularCustomer;
	private static Customer rewardsCustomer;

	@BeforeClass
	public static void beforeClass() {
		dateBuilder = new DateBuilder();

		hotelBuilder = new HotelBuilder();
		hotel = hotelBuilder.getBridgewoodHotel();

		CustomerBuilder customerBuilder = new CustomerBuilder();
		regularCustomer = customerBuilder.getRegularCustomer();
		rewardsCustomer = customerBuilder.getRewardsCustomer();
	}

	@Test
	public void weekend_regular_rates() {
		Date date = dateBuilder.getSunday();
		int actualValue = hotel.getRegularRates(date);
		assertEquals(60, actualValue);
	}

	@Test
	public void not_weekend_regular_rates() {
		Date date = dateBuilder.getMonday();
		int actualValue = hotel.getRegularRates(date);
		assertEquals(160, actualValue);
	}

	@Test
	public void weekend_rewoards_rates() {
		Date date = dateBuilder.getSunday();
		int actualValue = hotel.getRewardsRates(date);
		assertEquals(50, actualValue);
	}

	@Test
	public void not_weekend_rewoards_rates() {
		Date date = dateBuilder.getMonday();
		int actualValue = hotel.getRewardsRates(date);
		assertEquals(110, actualValue);
	}
	
	@Test
	public void two_weekends_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(120, actualValue);
	}

	@Test
	public void two_notweekends_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(320, actualValue);
	}

	@Test
	public void two_weekends_and_one_notweekend_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday(),
				dateBuilder.getFriday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(280, actualValue);
	}

	@Test
	public void two_notweekends_and_one_weekend_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday(),
				dateBuilder.getSaturday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(380, actualValue);
	}

	@Test
	public void two_weekends_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(100, actualValue);
	}

	@Test
	public void two_notweekends_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(220, actualValue);
	}

	@Test
	public void two_weekends_and_one_notweekend_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday(),
				dateBuilder.getFriday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(210, actualValue);
	}

	@Test
	public void two_notweekends_and_one_weekend_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday(),
				dateBuilder.getSaturday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(270, actualValue);
	}

}
