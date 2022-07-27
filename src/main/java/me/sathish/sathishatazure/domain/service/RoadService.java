package me.sathish.sathishatazure.domain.service;

import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.Exception.RoadDataException;
import me.sathish.sathishatazure.domain.data.Road;
import me.sathish.sathishatazure.domain.repo.RoadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RoadService {
    private final RoadRepository roadRepository;

    @Transactional(readOnly = true)
    public List<Road> getAllRoads() {
        return roadRepository.findAll();
    }

    public Road createRoad(Road road) {
        return roadRepository.save(road);
    }

    public Road getRoadById(Long id) {
        return roadRepository.findById(id)
                .orElseThrow(() -> new RoadDataException(id));
    }
}
