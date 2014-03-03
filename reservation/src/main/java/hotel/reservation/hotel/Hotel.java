package hotel.reservation.hotel;

import hotel.reservation.customer.Customer;

import java.util.Date;

public abstract class Hotel {

	public abstract String getName();

	public abstract int getRating();

	public abstract int getRegularRates(Date date);

	public abstract int getRewardsRates(Date date);

	public int getTotalAmount(Customer customer, Date[] dates) {
		int totalAmount = 0;
		for (Date date : dates) {
			totalAmount += customer.getRate(this, date);
		}
		return totalAmount;
	};
}