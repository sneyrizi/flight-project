package com.travix.medusa.busyflights.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.CollectFlightsService;
import com.travix.medusa.busyflights.domain.toughjet.*;
import com.travix.medusa.busyflights.domain.busyflights.*;
import com.travix.medusa.busyflights.domain.crazyair.*;

public class CollectFlightsServiceImpl implements CollectFlightsService{
    public List<BusyFlightsResponse> collectFlights(BusyFlightsRequest req){
        //from the req we call the WS of CrazyAirs and ToughJet 
        
        //call WS of CrazyAirs
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<CrazyAirResponse>> crazyResponse =restTemplate.exchange("http://crazyairs/ws/crazyairs/flights?origin=RMF&destination=LND",
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<CrazyAirResponse>>() {
                    });
        List<CrazyAirResponse> crazyFlights = crazyResponse.getBody();
        
        //call WS of ToughJet
        ResponseEntity<List<ToughJetResponse>> thoughtResponse =restTemplate.exchange("http://thoughtjet/ws/thoughtjet/flights?origin=RMF&destination=LND",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<ToughJetResponse>>() {
        });        
        List<ToughJetResponse> toughJetFlights=thoughtResponse.getBody();
        
        
        List<BusyFlightsResponse> allFlights=new ArrayList<BusyFlightsResponse>();
        
        
        //now we must adapt the different format of the responses and create a list of BusyFlightsResponse        
        for(CrazyAirResponse crazyFlight : crazyFlights){
            BusyFlightsResponse busyFlightsFlight=new BusyFlightsResponse();
            busyFlightsFlight.setOrigin(crazyFlight.getDepartureAirportCode());
            
            allFlights.add(busyFlightsFlight);
        }

        for(ToughJetResponse thoughtFlight : toughJetFlights){
            BusyFlightsResponse busyFlightsFlight=new BusyFlightsResponse();
            busyFlightsFlight.setOrigin(thoughtFlight.getDepartureAirportName());
            
            allFlights.add(busyFlightsFlight);
        }
        
        //sort by fare
        allFlights.sort(new BusyFlightsComparator());
        
        
        return allFlights;
    }
}
