package hotel.reservation.data.builder;

import hotel.reservation.hotel.BridgewoodHotel;
import hotel.reservation.hotel.LakewoodHotel;
import hotel.reservation.hotel.RidgewoodHotel;

public class HotelBuilder {

	public LakewoodHotel getLakewoodHotel() {
		return new LakewoodHotel();
	}

	public BridgewoodHotel getBridgewoodHotel() {
		return new BridgewoodHotel();
	}

	public RidgewoodHotel getRidgewoodHotel() {
		return new RidgewoodHotel();
	}

}
