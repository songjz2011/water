package hotel.reservation.hotel;

import hotel.reservation.util.DateUtil;

import java.util.Date;

public class RidgewoodHotel extends Hotel {

	@Override
	public String getName() {
		return "Ridgewood";
	}

	@Override
	public int getRating() {
		return 5;
	}

	@Override
	public int getRegularRates(Date date) {
		if (DateUtil.isWeekEnd(date)) {
			return 150;
		}
		return 220;
	}

	@Override
	public int getRewardsRates(Date date) {
		if (DateUtil.isWeekEnd(date)) {
			return 40;
		}
		return 100;
	}

}
