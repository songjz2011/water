package hotel.reservation.hotel;

import hotel.reservation.util.DateUtil;

import java.util.Date;

public class BridgewoodHotel extends Hotel {

	@Override
	public String getName() {
		return "Bridgewood";
	}

	@Override
	public int getRating() {
		return 4;
	}

	@Override
	public int getRegularRates(Date date) {
		if(DateUtil.isWeekEnd(date)) {
			return 60;
		}
		return 160;
	}

	@Override
	public int getRewardsRates(Date date) {
		if(DateUtil.isWeekEnd(date)) {
			return 50;
		}
		return 110;
	}
}
