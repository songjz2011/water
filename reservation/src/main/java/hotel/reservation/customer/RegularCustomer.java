package hotel.reservation.customer;

import hotel.reservation.hotel.Hotel;

import java.util.Date;

public class RegularCustomer extends Customer {

	@Override
	public int getRate(Hotel hotel, Date date) {
		return hotel.getRegularRates(date);
	}

}
