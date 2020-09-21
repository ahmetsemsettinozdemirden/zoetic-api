package com.zoetic.ahmetsemsettinozdemidenassigment.controller;

import com.zoetic.ahmetsemsettinozdemidenassigment.dto.MeasurementDTO;
import com.zoetic.ahmetsemsettinozdemidenassigment.service.MeasurementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MeasurementControllerTest {

    @InjectMocks
    private MeasurementController measurementController;

    @Mock
    private MeasurementService measurementService;

    @Test
    public void test_given_dateQuery_when_getMeasurement_executed_then_return_measurements() {
        //Given
        LocalDate dateQuery = LocalDate.of(2020, 9, 21);
        MeasurementDTO measurementDTO = new MeasurementDTO();

        when(measurementService.getMeasurement(dateQuery)).thenReturn(measurementDTO);

        //When
        MeasurementDTO result = measurementController.getMeasurement(dateQuery);

        //Then
        assertEquals(measurementDTO, result);
    }

    @Test
    public void test_given_measurement_date_when_addMeasurement_executed_then_add_measurements() {
        //Given
        MeasurementDTO measurementDTO = new MeasurementDTO();

        final ArgumentCaptor<MeasurementDTO> measurementCaptor = ArgumentCaptor.forClass(MeasurementDTO.class);
        doNothing().when(measurementService).addMeasurement(measurementCaptor.capture());

        //When
        measurementController.addMeasurement(measurementDTO);

        //Then
        assertEquals(measurementCaptor.getValue(), measurementDTO);
    }

}