package hotel.reservation.data.builder;

import hotel.reservation.customer.RegularCustomer;
import hotel.reservation.customer.RewardsCustomer;

public class CustomerBuilder {

	public RegularCustomer getRegularCustomer() {
		return new RegularCustomer();
	}
	
	public RewardsCustomer getRewardsCustomer() {
		return new RewardsCustomer();
	}

}
