package com.travix.medusa.busyflights.ws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

@RestController(value="/toughJet")
public class ToughtJetWS {
	
		@RequestMapping(value="/flights",method = RequestMethod.GET)
		public List<ToughJetResponse> getFlights(ToughJetRequest req){
			
			List<ToughJetResponse> list=new ArrayList<>();
			
			ToughJetResponse flight1=new ToughJetResponse();
			flight1.setDepartureAirportName("Fiumicino");
			flight1.setArrivalAirportName("Amsterdam Airport Schiphol");
			flight1.setBasePrice(200.00);
			list.add(flight1);
			
			ToughJetResponse flight2=new ToughJetResponse();
			flight2.setDepartureAirportName("Ciampino");
			flight2.setArrivalAirportName("Amsterdam Airport Schiphol");
			flight2.setBasePrice(200.00);
			list.add(flight2);
			
			return list;
		}

	}



