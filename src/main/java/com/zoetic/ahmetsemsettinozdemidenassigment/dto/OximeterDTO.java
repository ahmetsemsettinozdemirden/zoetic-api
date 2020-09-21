package com.zoetic.ahmetsemsettinozdemidenassigment.dto;

public class OximeterDTO {

    private int spo2;
    private int pulseRate;

    public OximeterDTO(){}

    public OximeterDTO(int spo2, int pulseRate) {
        this.spo2 = spo2;
        this.pulseRate = pulseRate;
    }

    public int getSpo2() {
        return spo2;
    }

    public void setSpo2(int spo2) {
        this.spo2 = spo2;
    }

    public int getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(int pulseRate) {
        this.pulseRate = pulseRate;
    }

}
