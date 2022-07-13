package com.logicbig.controller;

import com.logicbig.model.Bus;
import com.logicbig.model.Stations;
import com.logicbig.repository.BussesRepository;
import com.logicbig.repository.StationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    public StationsRepository stationsRepository;

    @Autowired
    public BussesRepository bussesRepository;

    @GetMapping("/api/station")
    @ResponseBody
    public String getStation() {
        Pageable pageableRequest = PageRequest.of(0, 1);
        return stationsRepository.findAll(pageableRequest).stream().findAny().get().get_id();
    }

    @GetMapping("/api/bus")
    @ResponseBody
    public String getBus() {
        Pageable pageableRequest = PageRequest.of(0, 1);
        return bussesRepository.findAll(pageableRequest).stream().findAny().get().get_id();
    }

    @PostMapping("/api/stations")
    @ResponseBody
    public String postStations(@RequestBody List<Stations> stationsList) {
        stationsRepository.deleteAll();
        stationsRepository.saveAll(stationsList);
        return "ok";
    }

    @PostMapping("/api/busses")
    @ResponseBody
    public String postBusses(@RequestBody List<Bus> bussesList) {
        bussesRepository.deleteAll();
        bussesRepository.saveAll(bussesList);
        return "ok";
    }
}
