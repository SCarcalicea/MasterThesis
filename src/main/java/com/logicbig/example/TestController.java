package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

@Controller
public class TestController {

    @Autowired
    public CoordinatesRepository coordinatesRepository;

    @GetMapping("/api/get")
    @ResponseBody
    public String getObject() {
        Pageable pageableRequest = PageRequest.of(0, 1);
        return coordinatesRepository.findAll(pageableRequest).stream().findAny().get().getId();
    }

    @PostMapping("/api/put")
    @ResponseBody
    public String putObject() {
        Coordinates coord = new Coordinates();
        coord.setId(UUID.randomUUID().toString());
        coord.setCoodrName("testingName");
        coordinatesRepository.save(coord);

        return "ok";
    }
}
