package com.logicbig.service;

import com.logicbig.model.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BusService {

    @Autowired
    RestTemplate restTemplate;

    public List<Routes> getRoutes() {

        List<Routes> routes = new ArrayList<>();
        List<Object> responses = null;
        try {
            responses = restTemplate.postForObject("http://localhost:8888/addRoute", null, List.class);
        } catch (Exception e) {
            System.out.println("Server is down, display the default location.");
            routes.add(buildStation("Default",
                    "Defaul",
                    new Double(45.756570386093415),
                    new Double(21.229033228478432)));
            return routes;
        }

        return constructResponse(routes, responses);
    }

    public List<Routes> getBusLocation() {

        List<Routes> routes = new ArrayList<>();
        List<Object> responses = null;
        try {
            responses = restTemplate.postForObject("http://localhost:8888/addVehicle/r1551", null, List.class);
        } catch (Exception e) {
            System.out.println("Server is down, display the default location.");
            return null;
        }

        return constructResponse(routes, responses);
    }

    private Routes buildStation(String id, String name, Double lat, Double lon) {
        Routes route = new Routes();
        route.setId(id);
        route.setName(name);
        route.setLat(lat);
        route.setLon(lon);
        return route;
    }

    private List<Routes> constructResponse(List<Routes> routes, List<Object> responses) {
        for (Object response : responses) {
            Map<String, Object> map = (Map<String, Object>) response;
            routes.add(buildStation((String) map.get("id"),
                    (String) map.get("name"),
                    (Double) map.get("latitude"),
                    (Double) map.get("longitude")));
        }

        return routes;
    }

}
