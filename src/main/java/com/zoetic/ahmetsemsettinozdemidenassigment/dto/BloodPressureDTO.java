package com.zoetic.ahmetsemsettinozdemidenassigment.dto;

public class BloodPressureDTO {

    private int systolicPressure;
    private int diastolicPressure;

    public BloodPressureDTO() {}

    public BloodPressureDTO(int systolicPressure, int diastolicPressure) {
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(int systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(int diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }
}
