package com.test.model.channelbound;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passenger {

    private String passengerId;
    private String firstName;
    private String lastName;
    private String seatPreference;
    private TierLevelEnum tierLevel;

    @ApiModelProperty(value = "Passenger's id", example = "1")
    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(final String passengerId) {
        this.passengerId = passengerId;
    }

    @ApiModelProperty(value = "Passenger's first name", example = "FIRST")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @ApiModelProperty(value = "Passenger's last name", example = "LAST")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    @ApiModelProperty(value = "Passenger's seat preference", example = "A")
    public String getSeatPreference() {
        return seatPreference;
    }

    public void setSeatPreference(final String seatPreference) {
        this.seatPreference = seatPreference;
    }

    @ApiModelProperty(required = true, value = "Passenger's tier level", example = "GOLD")
    @Valid
    @NotNull
    public TierLevelEnum getTierLevel() {
        return tierLevel;
    }

    public void setTierLevel(final TierLevelEnum tierLevel) {
        this.tierLevel = tierLevel;
    }
}
