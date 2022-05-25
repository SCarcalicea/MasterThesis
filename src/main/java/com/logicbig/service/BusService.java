package com.logicbig.service;

import com.logicbig.model.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class BusService {

    @Autowired
    RestTemplate restTemplate;

    public void getRoutes() {
        List<Routes> routes = restTemplate.getForObject("https://rt.api.opentransport.ro/api/v1/key/f78a2e9a/agency/ro.stpt/command/routes?format=json", List.class);
    }
}
