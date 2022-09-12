package me.sathish.sathishatazure.domain.road.Exception;

public class RoadDataException extends RuntimeException {
    public RoadDataException(Long roadID) {
        super("Road with id=" + roadID + " not found");
    }
}

