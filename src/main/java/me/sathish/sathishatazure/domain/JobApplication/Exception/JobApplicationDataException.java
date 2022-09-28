package me.sathish.sathishatazure.domain.JobApplication.Exception;

public class JobApplicationDataException extends RuntimeException {
    public JobApplicationDataException(Long roadID) {
        super("JobApplication with id=" + roadID + " not found");
    }
}

