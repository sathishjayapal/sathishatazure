package me.sathish.sathishatazure.domain.Exception;

public class RoadDataException extends RuntimeException {
    public RoadDataException(Long roadID) {
        super("Road with id=" + roadID + " not found");
    }
}

