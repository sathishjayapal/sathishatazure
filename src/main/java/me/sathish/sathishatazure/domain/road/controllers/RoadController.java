package me.sathish.sathishatazure.domain.road.controllers;

import lombok.AllArgsConstructor;
import me.sathish.sathishatazure.domain.road.data.Road;
import me.sathish.sathishatazure.domain.road.service.RoadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RoadController {
    private static final Logger logger = LoggerFactory.getLogger(RoadController.class);
    RoadService roadService;

    @GetMapping
    public List<Road> index() {
        logger.debug("Coming to index");
        List<Road> allRoads = roadService.getAllRoads();
        System.out.println("The all roads are " + allRoads.size());
        return allRoads;
    }

    @PostMapping("/createRoad")
    @ResponseStatus(HttpStatus.CREATED)
    public Road createRoad(@RequestBody @Valid Road request) {
        return roadService.createRoad(request);
    }

}
