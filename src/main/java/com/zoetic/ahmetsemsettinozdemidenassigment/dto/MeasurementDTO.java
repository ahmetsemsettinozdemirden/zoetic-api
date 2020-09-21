package com.zoetic.ahmetsemsettinozdemidenassigment.dto;

public class MeasurementDTO {

    private TemperatureDTO temperature;
    private BloodPressureDTO bloodPressure;
    private OximeterDTO oximeter;

    public MeasurementDTO() {}

    public MeasurementDTO(TemperatureDTO temperature, BloodPressureDTO bloodPressure, OximeterDTO oximeter) {
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        this.oximeter = oximeter;
    }

    public TemperatureDTO getTemperature() {
        return temperature;
    }

    public void setTemperature(TemperatureDTO temperature) {
        this.temperature = temperature;
    }

    public BloodPressureDTO getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(BloodPressureDTO bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public OximeterDTO getOximeter() {
        return oximeter;
    }

    public void setOximeter(OximeterDTO oximeter) {
        this.oximeter = oximeter;
    }
}
