package hotel.reservation.customer;

import hotel.reservation.hotel.Hotel;

import java.util.Date;

public class RewardsCustomer extends Customer {

	@Override
	public int getRate(Hotel hotel, Date date) {
		return hotel.getRewardsRates(date);
	}

}
