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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MeasurementServiceTest {

    @InjectMocks
    private MeasurementService measurementService;

    @Mock
    private TemperatureRepository temperatureRepository;

    @Mock
    private BloodPressureRepository bloodPressureRepository;

    @Mock
    private OximeterRepository oximeterRepository;

    @Test
    public void test_given_queryDate_is_null_when_getMeasurement_executed_then_return_todays_measurements() {
        DateUtils.freeze();
        LocalDateTime now = DateUtils.now();

        // Given
        LocalDateTime startDate = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endDate = startDate.plusDays(1);

        Optional<Temperature> temperatureOptional = Optional.of(new Temperature(97.6, now));
        Optional<BloodPressure> bloodPressureOptional = Optional.of(new BloodPressure(124, 70, now));
        Optional<Oximeter> oximeterOptional = Optional.of(new Oximeter(96, 78, now));

        when(temperatureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(temperatureOptional);
        when(bloodPressureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(bloodPressureOptional);
        when(oximeterRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(oximeterOptional);

        // When
        MeasurementDTO result = measurementService.getMeasurement(null);

        // Then
        assertEquals(97.6, result.getTemperature().getTemperature(), 0.00001);
        assertEquals(124, result.getBloodPressure().getSystolicPressure(), 0.00001);
        assertEquals(70, result.getBloodPressure().getDiastolicPressure(), 0.00001);
        assertEquals(96, result.getOximeter().getSpo2(), 0.00001);
        assertEquals(78, result.getOximeter().getPulseRate(), 0.00001);

        DateUtils.unfreeze();
    }

    @Test
    public void test_given_queryDate_is_null_when_getMeasurement_executed_then_return_todays_null_measurements() {
        DateUtils.freeze();
        LocalDateTime now = DateUtils.now();

        // Given
        LocalDateTime startDate = now.withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endDate = startDate.plusDays(1);

        Optional<Temperature> temperatureOptional = Optional.empty();
        Optional<BloodPressure> bloodPressureOptional = Optional.empty();
        Optional<Oximeter> oximeterOptional = Optional.empty();

        when(temperatureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(temperatureOptional);
        when(bloodPressureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(bloodPressureOptional);
        when(oximeterRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(oximeterOptional);

        // When
        MeasurementDTO result = measurementService.getMeasurement(null);

        // Then
        assertNull(result.getTemperature().getTemperature());
        assertNull(result.getBloodPressure().getDiastolicPressure());
        assertNull(result.getBloodPressure().getSystolicPressure());
        assertNull(result.getOximeter().getSpo2());
        assertNull(result.getOximeter().getPulseRate());

        DateUtils.unfreeze();
    }

    @Test
    public void test_given_queryDate_is_yesterday_when_getMeasurement_executed_then_return_yesterdays_measurements() {
        DateUtils.freeze();
        LocalDateTime now = DateUtils.now();

        // Given
        LocalDate queryDate = now.toLocalDate().minusDays(1); // yesterday
        LocalDateTime startDate = now.with(queryDate).withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime endDate = startDate.plusDays(1);

        Optional<Temperature> temperatureOptional = Optional.of(new Temperature(12.3, now));
        Optional<BloodPressure> bloodPressureOptional = Optional.of(new BloodPressure(141, 90, now));
        Optional<Oximeter> oximeterOptional = Optional.empty();

        when(temperatureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(temperatureOptional);
        when(bloodPressureRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(bloodPressureOptional);
        when(oximeterRepository.findTopByDateBetweenOrderByDateDesc(startDate, endDate)).thenReturn(oximeterOptional);

        // When
        MeasurementDTO result = measurementService.getMeasurement(queryDate);

        // Then
        assertEquals(12.3, result.getTemperature().getTemperature(), 0.00001);
        assertEquals(141, result.getBloodPressure().getSystolicPressure(), 0.00001);
        assertEquals(90, result.getBloodPressure().getDiastolicPressure(), 0.00001);
        assertNull(result.getOximeter().getSpo2());
        assertNull(result.getOximeter().getPulseRate());

        DateUtils.unfreeze();
    }

    @Test
    public void test_given_temperature_measurements_when_addMeasurement_executed_then_add_measurements() {
        DateUtils.freeze();
        LocalDateTime now = DateUtils.now();

        // Given
        TemperatureDTO temperature = new TemperatureDTO(12.3);
        BloodPressureDTO bloodPressure = new BloodPressureDTO(124, 70);
        OximeterDTO oximeter = new OximeterDTO(98, 60);
        MeasurementDTO measurement = new MeasurementDTO(temperature, bloodPressure, oximeter);

        final ArgumentCaptor<Temperature> temperatureCaptor = ArgumentCaptor.forClass(Temperature.class);
        when(temperatureRepository.save(temperatureCaptor.capture())).thenReturn(null);
        final ArgumentCaptor<BloodPressure> bloodPressureCaptor = ArgumentCaptor.forClass(BloodPressure.class);
        when(bloodPressureRepository.save(bloodPressureCaptor.capture())).thenReturn(null);
        final ArgumentCaptor<Oximeter> oximeterCaptor = ArgumentCaptor.forClass(Oximeter.class);
        when(oximeterRepository.save(oximeterCaptor.capture())).thenReturn(null);

        // When
        measurementService.addMeasurement(measurement);

        // Then
        assertEquals(temperature.getTemperature(), temperatureCaptor.getValue().getTemperature(), 0.000001);
        assertEquals(bloodPressure.getSystolicPressure(), bloodPressureCaptor.getValue().getSystolicPressure(), 0.000001);
        assertEquals(bloodPressure.getDiastolicPressure(), bloodPressureCaptor.getValue().getDiastolicPressure(), 0.000001);
        assertEquals(oximeter.getSpo2(), oximeterCaptor.getValue().getSpo2(), 0.000001);
        assertEquals(oximeter.getPulseRate(), oximeterCaptor.getValue().getPulseRate(), 0.000001);

        DateUtils.unfreeze();
    }

    @Test
    public void test_given_no_measurements_when_addMeasurement_executed_then_do_nothing() {
        DateUtils.freeze();
        LocalDateTime now = DateUtils.now();

        // Given
        MeasurementDTO measurement = new MeasurementDTO(null, null, null);

        // When
        measurementService.addMeasurement(measurement);

        // Then
        verifyNoInteractions(temperatureRepository);
        verifyNoInteractions(bloodPressureRepository);
        verifyNoInteractions(oximeterRepository);

        DateUtils.unfreeze();
    }
}
