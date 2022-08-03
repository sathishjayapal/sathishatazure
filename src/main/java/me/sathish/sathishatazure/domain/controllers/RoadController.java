package me.sathish.sathishatazure.domain.controllers;

import lombok.AllArgsConstructor;
import me.sathish.sathishatazure.domain.data.Road;
import me.sathish.sathishatazure.domain.service.RoadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RoadController {
    private static final Logger logger = LoggerFactory.getLogger(RoadController.class);
    RoadService roadService;

    @GetMapping
    public String index() {
        logger.debug("Coming to index");
        List<Road> allRoads = roadService.getAllRoads();
        System.out.println("The all roads are " + allRoads.size());
        return "Greetings from Azure Spring Cloud!";
    }

}
