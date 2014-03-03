package hotel.reservation;

import hotel.reservation.customer.Customer;
import hotel.reservation.hotel.Hotel;

import java.util.Date;

public class HotelReservation {

	private Hotel[] hotels;

	public HotelReservation(Hotel[] hotels) {
		this.hotels = hotels;
	}

	public Hotel cheapest(Customer customer, Date[] dates) {
		Hotel hotel = hotels[0];
		for (int i = 1; i < hotels.length; i++) {
			if(firstHotelIsCheaper(hotels[i], hotel,customer, dates)) {
				hotel = hotels[i];
			}
		}
		return hotel;
	}

	private boolean firstHotelIsCheaper(Hotel firstHotel, Hotel secondHotel,
			Customer customer, Date[] dates) {
		int totalAmount = firstHotel.getTotalAmount(customer, dates);
		int compareTotalAmount = secondHotel.getTotalAmount(customer, dates);
		if (totalAmount < compareTotalAmount
				|| (totalAmount == compareTotalAmount && firstHotel.getRating() > secondHotel
						.getRating())) {
			return true;
		}
		return false;
	}

}
