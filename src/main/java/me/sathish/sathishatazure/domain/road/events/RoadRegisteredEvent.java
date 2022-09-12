package me.sathish.sathishatazure.domain.road.events;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.sathish.sathishatazure.domain.road.data.Road;

@Data
public class RoadRegisteredEvent {
    private final Road registeredRoad;
}
