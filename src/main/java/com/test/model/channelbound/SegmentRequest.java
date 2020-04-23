package com.test.model.channelbound;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SegmentRequest {

    private String segmentId;
    private String cabinName;
    private String origin;
    private String destination;
    private String currentBookingClass;
    private String desiredBookingClass;
    private List<Passenger> passengers = new ArrayList<>();

    @ApiModelProperty(required = true, value = "segment id", example = "1")
    @Valid
    @NotNull
    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(final String segmentId) {
        this.segmentId = segmentId;
    }

    @ApiModelProperty(value = "cabin name", example = "First")
    public String getCabinName() {
        return cabinName;
    }

    public void setCabinName(final String cabinName) {
        this.cabinName = cabinName;
    }

    @ApiModelProperty(value = "origin", example = "DFW")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    @ApiModelProperty(value = "destination", example = "LHR")
    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    @ApiModelProperty(required = true, value = "Passenger's current booking class", example = "Y")
    @Valid
    @NotNull
    public String getCurrentBookingClass() {
        return currentBookingClass;
    }

    public void setCurrentBookingClass(final String currentBookingClass) {
        this.currentBookingClass = currentBookingClass;
    }

    @ApiModelProperty(required = true, value = "Passenger's desired booking class", example = "J")
    @Valid
    @NotNull
    public String getDesiredBookingClass() {
        return desiredBookingClass;
    }

    public void setDesiredBookingClass(final String desiredBookingClass) {
        this.desiredBookingClass = desiredBookingClass;
    }

    @ApiModelProperty(required = true, value = "If left out all passengers will be upgraded")
    @Valid
    @NotNull
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(final List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
