package me.sathish.sathishatazure.domain.road.service;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.road.Exception.RoadDataException;
import me.sathish.sathishatazure.domain.road.data.Road;
import me.sathish.sathishatazure.domain.road.events.RoadRegisteredEvent;
import me.sathish.sathishatazure.domain.road.repo.RoadRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

@RequiredArgsConstructor
public class RoadService {
    private final RoadRepository roadRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public List<Road> getAllRoads() {
        return roadRepository.findAll();
    }

    @Transactional
    public Road createRoad(Road road) {
        roadRepository.save(road);
        publisher.publishEvent(new RoadRegisteredEvent(road));
        return road;
    }

    @Transactional
    public Road getRoadById(Long id) {
        return roadRepository.findById(id)
                .orElseThrow(() -> new RoadDataException(id));
    }
}
