package com.test.model.channelbound;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TierLevelEnum {
    CONCIERGE_KEY("CONCIERGEKEY"),

    EXECUTIVE_PLATINUM("EXECUTIVE PLATINUM"),

    PLATINUM_PRO("PLATINUM PRO"),

    PLATINUM("PLATINUM"),

    GOLD("GOLD"),

    REGULAR("REGULAR"),

    BX("BX");

    private final String tierLevel;

    TierLevelEnum(final String value) {
        this.tierLevel = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return tierLevel;
    }
}
