package io.github.robwin.config;

public enum ServiceEnum {
    SERVICE_D("serviceD");;

    private final String serviceName;

    ServiceEnum(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
