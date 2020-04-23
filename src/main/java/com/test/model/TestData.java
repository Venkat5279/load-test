package com.test.model;

public class TestData {
    private String pnr;
    private String id;
    private String classOfService;
    private String origin;
    private String destination;
    private String clientId;

    public TestData(final String pnr, final String id, final String classOfService, final String origin, final String destination, final String clientId) {
        this.pnr = pnr;
        this.id = id;
        this.classOfService = classOfService;
        this.origin = origin;
        this.destination = destination;
        this.clientId = clientId;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(final String pnr) {
        this.pnr = pnr;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getClassOfService() {
        return classOfService;
    }

    public void setClassOfService(final String classOfService) {
        this.classOfService = classOfService;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(final String clientId) {
        this.clientId = clientId;
    }
}
