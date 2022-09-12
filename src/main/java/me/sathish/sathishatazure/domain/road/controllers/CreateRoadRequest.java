package me.sathish.sathishatazure.domain.road.controllers;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
@Setter
@Getter
public class CreateRoadRequest {
    @NotEmpty(message = "Title should not be empty")
    private String roadName;
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @NotEmpty(message = "State cannot be empty")
    private String state;
}
