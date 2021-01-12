/**
 * ============================================================
 * Created by  - Pramoj Kumararathna
 * On          - Jan 03, 2021
 * At          - 12:12 AM
 * ============================================================
 */
package com.spacex.starlink.constellationmonitor.service;

import com.spacex.starlink.constellationmonitor.dao.ConstellationMonitorRepository;
import com.spacex.starlink.constellationmonitor.model.Satellite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConstellationMonitorService {

    @Autowired
    ConstellationMonitorRepository constellationMonitorRepository;

    List<Satellite> constellation = new ArrayList<>();

    public List<Satellite> fetchConstellation() {
        return constellation.size() > 0 ? constellation : createMockConstellation();
    }

    private List<Satellite> createMockConstellation() {

        Satellite s1 = new Satellite();
        s1.setSatelliteId(10l);
        s1.setVelocity(1234567d);
        s1.setHealthFlag(true);
        s1.setConstellationAssignFlag(true);
        constellation.add(s1);

        Satellite s2 = new Satellite();
        s2.setSatelliteId(11l);
        s2.setVelocity(7654321d);
        s2.setHealthFlag(true);
        s2.setConstellationAssignFlag(true);
        constellation.add(s2);

        return constellation;
    }

    public void addSatellite() {
        Satellite s = new Satellite();
        s.setSatelliteId(12l);
        s.setVelocity(23459725d);
        s.setHealthFlag(true);
        s.setConstellationAssignFlag(true);
        constellation.add(s);
    }

    public Satellite getById(Long id) {
        Optional opt = constellationMonitorRepository.findById(id);
        return (null != opt) ? (Satellite) opt.get() : null;
    }

    public void save(Satellite satellite) {
        if (satellite.getVelocity() < 100d) {
            satellite.setHealthFlag(false);
            satellite.setConstellationAssignFlag(false);
        } else {
            satellite.setHealthFlag(true);
        }
        constellationMonitorRepository.save(satellite);
    }

    public Iterable fetchAll(int page) {
        Iterable iterable = constellationMonitorRepository.findAll(PageRequest.of(page, 10));
        return iterable;
    }

    public void delete(Long id) {
        constellationMonitorRepository.deleteById(id);
    }

    public void assign(Long id) {
        Satellite sat = getById(id);
        sat.setConstellationAssignFlag(true);
        constellationMonitorRepository.save(sat);
    }

    public void unassign(Long id) {
        Satellite sat = getById(id);
        sat.setConstellationAssignFlag(false);
        constellationMonitorRepository.save(sat);
    }
}
