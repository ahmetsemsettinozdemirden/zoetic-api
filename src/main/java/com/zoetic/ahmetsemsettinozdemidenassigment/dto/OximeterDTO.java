package com.zoetic.ahmetsemsettinozdemidenassigment.dto;

public class OximeterDTO {

    private Integer spo2;
    private Integer pulseRate;

    public OximeterDTO(){}

    public OximeterDTO(Integer spo2, Integer pulseRate) {
        this.spo2 = spo2;
        this.pulseRate = pulseRate;
    }

    public Integer getSpo2() {
        return spo2;
    }

    public void setSpo2(Integer spo2) {
        this.spo2 = spo2;
    }

    public Integer getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

}
