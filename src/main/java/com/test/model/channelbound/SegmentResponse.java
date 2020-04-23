package com.test.model.channelbound;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SegmentResponse {
    private String segmentId;
    private boolean success;
    private String statusMessage;
    private String bookingClass;

    public SegmentResponse() {
    }

    @ApiModelProperty(required = true, value = "segment id", example = "1")
    @Valid
    @NotNull
    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(final String segmentId) {
        this.segmentId = segmentId;
    }

    @ApiModelProperty(required = true, value = "Upgrade request status", example = "true")
    @Valid
    @NotNull
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    @ApiModelProperty(required = true, value = "Upgrade reservation status message", example = "Success")
    @Valid
    @NotNull
    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(final String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @ApiModelProperty(required = true, value = "Booking class", example = "Y")
    @Valid
    @NotNull
    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(final String bookingClass) {
        this.bookingClass = bookingClass;
    }

}
