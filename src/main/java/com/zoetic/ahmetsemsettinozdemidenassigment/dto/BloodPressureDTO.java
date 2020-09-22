package com.zoetic.ahmetsemsettinozdemidenassigment.dto;

public class BloodPressureDTO {

    private Integer systolicPressure;
    private Integer diastolicPressure;

    public BloodPressureDTO() {}

    public BloodPressureDTO(Integer systolicPressure, Integer diastolicPressure) {
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
    }

    public Integer getSystolicPressure() {
        return systolicPressure;
    }

    public void setSystolicPressure(Integer systolicPressure) {
        this.systolicPressure = systolicPressure;
    }

    public Integer getDiastolicPressure() {
        return diastolicPressure;
    }

    public void setDiastolicPressure(Integer diastolicPressure) {
        this.diastolicPressure = diastolicPressure;
    }
}
