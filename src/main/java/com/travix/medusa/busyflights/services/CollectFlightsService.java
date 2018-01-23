package com.travix.medusa.busyflights.services;

import java.util.List;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.*;
import com.travix.medusa.busyflights.domain.busyflights.*;

public interface CollectFlightsService {

	public List<BusyFlightsResponse> collectFlights(BusyFlightsRequest req);

}
