package com.test.model.channelbound;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ServiceErrorResponse {

    private String applicationErrorMessage;
    private String transactiondId;

    public ServiceErrorResponse(final String applicationErrorMessage, final String transactiondId) {
        this.applicationErrorMessage = applicationErrorMessage;
        this.transactiondId = transactiondId;
    }

    @ApiModelProperty(value = "Application error message indicating the reason for an unsuccessful invocation", required = true, example = "Internal Server Error")
    @NotNull
    @Valid
    public String getApplicationErrorMessage() {
        return applicationErrorMessage;
    }

    public void setApplicationErrorMessage(final String applicationErrorMessage) {
        this.applicationErrorMessage = applicationErrorMessage;
    }

    @ApiModelProperty(value = "Transaction id copied from the incoming request and sent back in the response for channel correlation", required = true, example = "5e580538-3301-11ea-978f-2e728ce88125")
    @NotNull
    @Valid
    public String getTransactiondId() {
        return transactiondId;
    }

    public void setTransactiondId(final String transactiondId) {
        this.transactiondId = transactiondId;
    }
}
