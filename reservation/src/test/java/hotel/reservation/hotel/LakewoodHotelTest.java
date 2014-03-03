package hotel.reservation.hotel;

import static org.junit.Assert.assertEquals;
import hotel.reservation.customer.RegularCustomer;
import hotel.reservation.customer.RewardsCustomer;
import hotel.reservation.data.builder.CustomerBuilder;
import hotel.reservation.data.builder.DateBuilder;
import hotel.reservation.data.builder.HotelBuilder;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class LakewoodHotelTest {

	private static DateBuilder dateBuilder;
	private static HotelBuilder hotelBuilder;

	private static LakewoodHotel hotel;
	private static RegularCustomer regularCustomer;
	private static RewardsCustomer rewardsCustomer;

	@BeforeClass
	public static void beforeClass() {
		hotelBuilder = new HotelBuilder();
		dateBuilder = new DateBuilder();

		hotel = hotelBuilder.getLakewoodHotel();

		CustomerBuilder customerBuilder = new CustomerBuilder();
		regularCustomer = customerBuilder.getRegularCustomer();
		rewardsCustomer = customerBuilder.getRewardsCustomer();
	}

	@Test
	public void weekend_regular_rates() {
		Date date = dateBuilder.getSunday();
		int actualValue = hotel.getRegularRates(date);
		assertEquals(90, actualValue);
	}

	@Test
	public void not_weekend_regular_rates() {
		Date date = dateBuilder.getMonday();
		int actualValue = hotel.getRegularRates(date);
		assertEquals(110, actualValue);
	}

	@Test
	public void weekend_rewoards_rates() {
		Date date = dateBuilder.getSunday();
		int actualValue = hotel.getRewardsRates(date);
		assertEquals(80, actualValue);
	}

	@Test
	public void not_weekend_rewoards_rates() {
		Date date = dateBuilder.getMonday();
		int actualValue = hotel.getRewardsRates(date);
		assertEquals(80, actualValue);
	}

	@Test
	public void two_weekends_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(180, actualValue);
	}

	@Test
	public void two_notweekends_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(220, actualValue);
	}

	@Test
	public void two_weekends_and_one_notweekends_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday(),
				dateBuilder.getFriday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(290, actualValue);
	}

	@Test
	public void two_notweekends_and_one_weekends_tolalamount_regular_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday(),
				dateBuilder.getSaturday() };
		int actualValue = hotel.getTotalAmount(regularCustomer, dates);
		assertEquals(310, actualValue);
	}

	@Test
	public void two_weekends_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(160, actualValue);
	}

	@Test
	public void two_notweekends_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(160, actualValue);
	}

	@Test
	public void two_weekends_and_one_notweekends_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getSaturday(), dateBuilder.getSunday(),
				dateBuilder.getFriday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(240, actualValue);
	}

	@Test
	public void two_notweekends_and_one_weekends_tolalamount_rewards_customer() {
		Date[] dates = { dateBuilder.getFriday(), dateBuilder.getThursday(),
				dateBuilder.getSaturday() };
		int actualValue = hotel.getTotalAmount(rewardsCustomer, dates);
		assertEquals(240, actualValue);
	}

}
