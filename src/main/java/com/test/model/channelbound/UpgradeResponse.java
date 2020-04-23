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
public class UpgradeResponse {
    private String pnr;
    private String transactionId;
    private String errorMessage;
    private List<SegmentResponse> segments = new ArrayList<>();


    public UpgradeResponse() {
    }

    @ApiModelProperty(required = true, value = "Passenger's record locator", example = "XYZMEA")
    @Valid
    @NotNull
    public String getPnr() {
        return pnr;
    }

    public void setPnr(final String pnr) {
        this.pnr = pnr;
    }

    @ApiModelProperty(required = true, value = "Transaction Id to correlate Channel, BMX, CS & SWS calls", example = "123e4567-e89b-12d3-a456-426655440000")
    @Valid
    @NotNull
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    @ApiModelProperty(required = true, value = "Segments information")
    @Valid
    @NotNull
    public List<SegmentResponse> getSegments() {
        return segments;
    }

    public void setSegments(final List<SegmentResponse> segments) {
        this.segments = segments;
    }

    @ApiModelProperty(value = "PNR related errors", example = "PNR not found")
    @Valid
    @NotNull
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
