package hotel.reservation.customer;

import hotel.reservation.hotel.Hotel;

import java.util.Date;

public abstract class Customer {

	public abstract int getRate(Hotel hotel, Date date);

}
