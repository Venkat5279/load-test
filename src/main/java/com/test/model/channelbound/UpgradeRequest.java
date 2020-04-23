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
public class UpgradeRequest {

    private String pnr;
    private List<SegmentRequest> segments = new ArrayList<>();

    @ApiModelProperty(required = true, value = "Passenger's record locator", example = "XYZMEA")
    @Valid
    @NotNull
    public String getPnr() {
        return pnr;
    }

    public void setPnr(final String pnr) {
        this.pnr = pnr;
    }

    @ApiModelProperty(required = true, value = "Segments information")
    @Valid
    @NotNull
    public List<SegmentRequest> getSegments() {
        return segments;
    }

    public void setSegments(final List<SegmentRequest> segments) {
        this.segments = segments;
    }
}
