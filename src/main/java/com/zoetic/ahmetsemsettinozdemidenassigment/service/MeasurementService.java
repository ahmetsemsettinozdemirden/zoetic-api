package com.zoetic.ahmetsemsettinozdemidenassigment.service;

import com.zoetic.ahmetsemsettinozdemidenassigment.dto.BloodPressureDTO;
import com.zoetic.ahmetsemsettinozdemidenassigment.dto.MeasurementDTO;
import com.zoetic.ahmetsemsettinozdemidenassigment.dto.OximeterDTO;
import com.zoetic.ahmetsemsettinozdemidenassigment.dto.TemperatureDTO;
import com.zoetic.ahmetsemsettinozdemidenassigment.model.BloodPressure;
import com.zoetic.ahmetsemsettinozdemidenassigment.model.Oximeter;
import com.zoetic.ahmetsemsettinozdemidenassigment.model.Temperature;
import com.zoetic.ahmetsemsettinozdemidenassigment.repository.BloodPressureRepository;
import com.zoetic.ahmetsemsettinozdemidenassigment.repository.OximeterRepository;
import com.zoetic.ahmetsemsettinozdemidenassigment.repository.TemperatureRepository;
import com.zoetic.ahmetsemsettinozdemidenassigment.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MeasurementService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementService.class);

    private final TemperatureRepository temperatureRepository;
    private final BloodPressureRepository bloodPressureRepository;
    private final OximeterRepository oximeterRepository;

    @Autowired
    public MeasurementService(TemperatureRepository temperatureRepository,
                              BloodPressureRepository bloodPressureRepository,
                              OximeterRepository oximeterRepository) {
        this.temperatureRepository = temperatureRepository;
        this.bloodPressureRepository = bloodPressureRepository;
        this.oximeterRepository = oximeterRepository;
    }

    public MeasurementDTO getMeasurement(final LocalDate queryDate) {
        LOGGER.info("fetch measurement, date: {}", queryDate);

        // query today's measurement, if queryDate is null
        LocalDateTime date = DateUtils.now();
        if(queryDate != null) {
            date = DateUtils.now().with(queryDate);
        }

        // measurement boundaries
        LocalDateTime startDate = date.withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endDate = startDate.plusDays(1);

        // fetch data
        Optional<Temperature> temperature = temperatureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate);
        Optional<BloodPressure> bloodPressure = bloodPressureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate);
        Optional<Oximeter> oximeter = oximeterRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate);

        // convert into transfer objects
        TemperatureDTO temperatureDTO = temperature.map(value -> new TemperatureDTO(value.getTemperature())).orElse(null);
        BloodPressureDTO bloodPressureDTO = bloodPressure.map(value -> new BloodPressureDTO(value.getSystolicPressure(), value.getDiastolicPressure())).orElse(null);
        OximeterDTO oximeterDTO = oximeter.map(value -> new OximeterDTO(value.getSpo2(), value.getPulseRate())).orElse(null);
        return new MeasurementDTO(temperatureDTO, bloodPressureDTO, oximeterDTO);
    }

    public void addMeasurement(final MeasurementDTO measurementDTO) {
        final LocalDateTime now = DateUtils.now();

        final TemperatureDTO temperatureDTO = measurementDTO.getTemperature();
        if(temperatureDTO != null) {
            Temperature temperature = new Temperature(temperatureDTO.getTemperature(), now);
            temperatureRepository.save(temperature);
            LOGGER.info("temperature saved! value: {}", temperature);
        }

        final BloodPressureDTO bloodPressureDTO = measurementDTO.getBloodPressure();
        if(bloodPressureDTO != null) {
            BloodPressure bloodPressure = new BloodPressure(
                    bloodPressureDTO.getSystolicPressure(),
                    bloodPressureDTO.getDiastolicPressure(),
                    now);
            bloodPressureRepository.save(bloodPressure);
            LOGGER.info("bloodPressure saved! value: {}", bloodPressure);
        }

        final OximeterDTO oximeterDTO = measurementDTO.getOximeter();
        if(oximeterDTO != null) {
            Oximeter oximeter = new Oximeter(
                    oximeterDTO.getSpo2(),
                    oximeterDTO.getPulseRate(),
                    now);
            oximeterRepository.save(oximeter);
            LOGGER.info("oximeter saved! value: {}", oximeter);
        }
    }
}
