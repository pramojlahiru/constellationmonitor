package com.spacex.starlink.constellationmonitor.controller;

import com.spacex.starlink.constellationmonitor.model.Satellite;
import com.spacex.starlink.constellationmonitor.service.ConstellationMonitorService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ConstellationmonitorControllerTest {

    ConstellationMonitorService constellationMonitorService = Mockito.mock(ConstellationMonitorService.class);

    @Autowired
    ConstellationMonitorService constellationMonitorService2;

    @Test
    @DisplayName("Test should pass when return Constellation")
    public void fetchConstellations() {

        List<Satellite> expectedResult = constellationMonitorService.fetchConstellation();

        List<Satellite> actualResult = constellationMonitorService2.fetchConstellation();

        Assertions.assertThat(expectedResult).isEqualTo(actualResult);

    }
}