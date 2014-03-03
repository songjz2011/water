package hotel.reservation.hotel;

import hotel.reservation.util.DateUtil;

import java.util.Date;

public class LakewoodHotel extends Hotel {

	@Override
	public String getName() {
		return "Lakewood";
	}

	@Override
	public int getRating() {
		return 3;
	}

	@Override
	public int getRegularRates(Date date) {
		if (DateUtil.isWeekEnd(date)) {
			return 90;
		}
		return 110;
	}

	@Override
	public int getRewardsRates(Date date) {
		return 80;
	}
}
