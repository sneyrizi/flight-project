package com.travix.medusa.busyflights.domain.busyflights;

import java.util.Comparator;

public class BusyFlightsComparator implements Comparator<BusyFlightsResponse> {

	@Override
	public int compare(BusyFlightsResponse f1, BusyFlightsResponse f2) {

		if (f1.getFare() == f2.getFare())
			return 0;
		if (f1.getFare() > f2.getFare())
			return 1;
		else
			return -1;

	}

}
