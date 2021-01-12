/**
 * ============================================================
 * Created by  - Pramoj Kumararathna
 * On          - Jan 12, 2021
 * At          - 2:37 PM
 * ============================================================
 */
package com.spacex.starlink.constellationmonitor.dao;

import com.spacex.starlink.constellationmonitor.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstellationMonitorRepository extends JpaRepository<Satellite, Long> {

}
