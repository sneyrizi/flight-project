package com.travix.medusa.busyflights.ws;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;

@RestController(value="/crazyairs")
public class CrazyAirWS {
	
	
	@RequestMapping(value="/flights",method = RequestMethod.GET)
	public List<CrazyAirResponse> getFlights(CrazyAirRequest req){
		
		List<CrazyAirResponse> list=new ArrayList<>();
		
		CrazyAirResponse flight1=new CrazyAirResponse();
		flight1.setAirline("airline1");
		flight1.setPrice(45.0);
		list.add(flight1);
		
		CrazyAirResponse flight2=new CrazyAirResponse();
		flight2.setAirline("airline1");
		flight2.setPrice(55.0);
		list.add(flight2);
		
		
		return list;
	}

}
