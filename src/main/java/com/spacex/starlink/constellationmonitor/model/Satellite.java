/**
 * ============================================================
 * Created by  - Pramoj Kumararathna
 * On          - Jan 03, 2021
 * At          - 12:13 AM
 * ============================================================
 */
package com.spacex.starlink.constellationmonitor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "satellite")
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "satellite_id")
    private Long satelliteId;

    @Column(name = "satellite_code")
    private String satelliteCode;

    @Column(name = "velocity")
    private Double velocity;

    @Column(name = "health")
    private boolean healthFlag;

    @Column(name = "constellation_assign")
    private boolean constellationAssignFlag;

}
