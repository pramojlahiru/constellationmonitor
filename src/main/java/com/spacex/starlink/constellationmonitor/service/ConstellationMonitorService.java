/**
 * ============================================================
 * Created by  - Pramoj Kumararathna
 * On          - Jan 03, 2021
 * At          - 12:12 AM
 * ============================================================
 */
package com.spacex.starlink.constellationmonitor.service;

import com.spacex.starlink.constellationmonitor.model.ConstellationAssign;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstellationMonitorService {

    List<ConstellationAssign> constellationAssignList = new ArrayList<>();

    public List<ConstellationAssign> fetchConstellations() {
        return constellationAssignList.size() > 0 ? constellationAssignList : createMockConstellationList();
    }

    private List<ConstellationAssign> createMockConstellationList() {

        ConstellationAssign ca1 = new ConstellationAssign();
        ca1.setConstellationAssignId(1l);
        ca1.setSatelliteId(10l);
        ca1.setLatitude(1234567d);
        ca1.setLongitude(2345678d);
        constellationAssignList.add(ca1);

        ConstellationAssign ca2 = new ConstellationAssign();
        ca2.setConstellationAssignId(2l);
        ca2.setSatelliteId(11l);
        ca2.setLatitude(7654321d);
        ca2.setLongitude(8765432d);
        constellationAssignList.add(ca2);

        return constellationAssignList;
    }

    public void addSatelliteConstellation() {
        createMockConstellationList();
    }

}
